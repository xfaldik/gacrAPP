/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.facade;

import cz.gacr.domain.Enterprise;
import cz.gacr.dto.EnterpriseCreateDTO;
import cz.gacr.dto.EnterpriseDTO;
import cz.gacr.services.BeanMappingService;
import cz.gacr.services.EnterpriseService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author olda
 */
public class EnterpriseFacadeImpl implements EnterpriseFacade{

    @Autowired
    private BeanMappingService beanMappingService;
    
    @Autowired
    private EnterpriseService enterpriseService;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Override
    public int createEnterprise(EnterpriseCreateDTO t) {

        String encodedPassword = passwordEncoder.encode(t.getPassword());
        Enterprise newEnterprise = new Enterprise(t.getNameEnterprise(), t.getEmail(), encodedPassword);
        enterpriseService.create(newEnterprise);
        return newEnterprise.getId();
    
    }

    @Override
    public void deleteEnterprise(int entepriseId) {
        enterpriseService.delete(enterpriseService.findById(entepriseId));    }

    @Override
    public List<EnterpriseDTO> getAllEnterprises() {

        return beanMappingService.mapTo(enterpriseService.findAll(), EnterpriseDTO.class);
    }

  
    
    @Override
    public EnterpriseDTO getEnterpriseWithId(int id) {
        return beanMappingService.mapTo(enterpriseService.findById(id), EnterpriseDTO.class);
    
    }

    
    
}
