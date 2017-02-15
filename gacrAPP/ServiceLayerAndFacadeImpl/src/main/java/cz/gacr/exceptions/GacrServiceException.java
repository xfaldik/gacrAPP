/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.exceptions;

/**
 *
 * @author olda
 */
public class GacrServiceException extends RuntimeException{
    
    public GacrServiceException() {
        super();
    }

    public GacrServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public GacrServiceException(String message) {
        super(message);
    }
    
}
