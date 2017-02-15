/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.utils;

import java.net.URL;
import java.net.URLClassLoader;

/**
 *
 * @author olda
 */
public class GacrRunner {

public static void main(String[] args) {
    ClassLoader cl = ClassLoader.getSystemClassLoader();

        URL[] urls = ((URLClassLoader)cl).getURLs();

        for(URL url: urls){
        	System.out.println(url.getFile());
        }
    
    }    
}
