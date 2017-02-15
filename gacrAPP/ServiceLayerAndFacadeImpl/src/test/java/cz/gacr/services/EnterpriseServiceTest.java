/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.services;

import cz.gacr.dao.EnterpriseDAO;
import cz.gacr.domain.Enterprise;
import cz.gacr.service.config.ServiceConfiguration;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.service.spi.ServiceException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author olda
 */

@ContextConfiguration(classes = ServiceConfiguration.class)
public class EnterpriseServiceTest extends AbstractTestNGSpringContextTests{
    
    @Mock
    private EnterpriseDAO enterpriseDao;
    
    
    @Autowired
    @InjectMocks
    private EnterpriseService enterpriseService;
    
    
    private Enterprise enterprise;
    
    @BeforeClass
    public void setup() throws ServiceException {
        MockitoAnnotations.initMocks(this);
        enterprise = new Enterprise("Brock", "brock@kanto.jp", "mojeheslo");

        enterpriseService.create(enterprise);
    }
    
    @Test
    public void testFindAll() {
        when(enterpriseDao.findAll()).thenReturn(new ArrayList<>(createTrainersTeam().values()));
        assertEquals(enterpriseService.findAll().size(), 2);
    }

    @Test
    public void testFindById() {
        when(enterpriseDao.findById(1)).thenReturn(createTrainersTeam().get("firma2"));
        assertEquals(enterpriseService.findById(1), new Enterprise("firma2", "brooock@kanto.jk", "mojeoheslo"));
    }
    
    private Map<String, Enterprise> createTrainersTeam() {
        Map<String, Enterprise> team = new HashMap<>();
        team.put("firma1", new Enterprise("firma1", "brooock@kanto.jp", "mojeooheslo"));
        team.put("firma2", new Enterprise("firma2", "brooock@kanto.jk", "mojeoheslo"));
        return team;
    }
    
    
}
