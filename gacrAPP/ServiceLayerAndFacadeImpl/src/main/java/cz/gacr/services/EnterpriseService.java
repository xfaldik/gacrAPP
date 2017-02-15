/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.services;

import cz.gacr.domain.Enterprise;
import cz.gacr.domain.Role;
import java.util.List;
import org.springframework.security.core.userdetails.UserDetailsService;


/**
 *
 * @author olda
 */
public interface EnterpriseService extends UserDetailsService{
    void create(Enterprise enterprise);

    Enterprise findById(int id);

    Enterprise findByEmail(String email);

    List<Enterprise> findAll();

    void delete(Enterprise enterprise);
    
    Role getRoleForEnterprise(Enterprise enterprise);
    
    boolean isAdminUser(Enterprise enterprise);
}
