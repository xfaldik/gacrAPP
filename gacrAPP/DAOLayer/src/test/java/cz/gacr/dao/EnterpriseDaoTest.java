/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.dao;

import cz.gacr.domain.Enterprise;
import cz.gacr.utils.DatabaseConfig;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.Test;

import static org.junit.Assert.*;

/**
 *
 * @author olda
 */
@ContextConfiguration(classes = DatabaseConfig.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class EnterpriseDaoTest extends AbstractTestNGSpringContextTests{
    
    @Autowired
    private EnterpriseDAO enterpriseDao;
    
    @Test
    public void testSave() {
        Enterprise enterprise = new Enterprise("Brock", "brock@kanto.jp", "mojeheslo");

        enterpriseDao.save(enterprise);

        Enterprise result = enterpriseDao.findById(enterprise.getId());
        assertEquals(enterprise, result);

        enterprise.setEmail("karik@kares.sk");
        enterpriseDao.save(enterprise);

        Enterprise resultUpdate = enterpriseDao.findById(enterprise.getId());
        assertEquals("karik@kares.sk", resultUpdate.getEmail());

    }
    
    @Test
    public void testDelete() {
        Enterprise enterprise = new Enterprise("Brock", "brock@kanto.jp", "mojeheslo");

        enterpriseDao.save(enterprise);
        enterpriseDao.delete(enterprise);

        assertEquals(0, enterpriseDao.findAll().size());
    }

    @Test
    public void testFindAll() {
        Enterprise enterprise = new Enterprise("Brock", "brock@kanto.jp", "mojeheslo");

        enterpriseDao.save(enterprise);

        assertEquals(1, enterpriseDao.findAll().size());
    }
}
