/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.services;

import cz.gacr.dao.EnterpriseDAO;
import cz.gacr.domain.Enterprise;
import cz.gacr.domain.Role;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author olda
 */
@Service
public class EnterpriseServiceImpl implements EnterpriseService{

    @Autowired
    private EnterpriseDAO enterpriseDao;
    
    @Override
    public void create(Enterprise enterprise) {
            enterpriseDao.save(enterprise);
    }

    @Override
    public Enterprise findById(int id) {

            return enterpriseDao.findById(id);
    }
    
    

    @Override
    public Enterprise findByEmail(String email) {

        return enterpriseDao.findByEmail(email);
    }

    @Override
    public List<Enterprise> findAll() {

        return enterpriseDao.findAll();
    }

    @Override
    public void delete(Enterprise enterprise) {

        enterpriseDao.delete(enterprise);
    }
    
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Enterprise enterprise = enterpriseDao.findByEmail(s);

        List<GrantedAuthority> auths = new ArrayList<>();
        auths.add(new SimpleGrantedAuthority(getRoleForEnterprise(enterprise).toString()));

        return buildUserForAuthentication(enterprise, auths);
    }

    private User buildUserForAuthentication(Enterprise enterprise, List<GrantedAuthority> authorities) {
        return new User(enterprise.getEmail(), enterprise.getPassword(), authorities);
    }
    
    @Override
    public Role getRoleForEnterprise(Enterprise enterprise) {
        if (isAdminUser(enterprise)) return Role.ROLE_ADMIN;
        return Role.ROLE_ENTERPRISE;
    }

    @Override
    public boolean isAdminUser(Enterprise enterprise) {
        return false;
    
    }
    
}
