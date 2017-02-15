/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.dao;


import cz.gacr.domain.Enterprise;
import cz.gacr.utils.DaoLayerException;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 *
 * @author olda
 */
@Repository
public class EnterpriseDAOimpl implements EnterpriseDAO{
    
    
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Enterprise findById(int id) {

        try {
            return entityManager.find(Enterprise.class, id);
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }

    @Override
    public void save(Enterprise enterprise) {
            if (findById(enterprise.getId()) != null) {
            try {
                entityManager.merge(enterprise);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        } else {
            try {
                entityManager.persist(enterprise);
            } catch (Exception e) {
                throw new DaoLayerException(e.getMessage());
            }
        }

    }

    @Override
    public void delete(Enterprise enterprise) {
        try {
            entityManager.remove(findById(enterprise.getId()));
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public List<Enterprise> findAll() {
            
        try {
            return entityManager.createQuery("select e from Enterprise e", Enterprise.class).getResultList();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }

    }

    @Override
    public Enterprise findByEmail(String email) {

         try {
            return entityManager.createQuery("select e from Enterprise e where e.email = ?1", Enterprise.class).setParameter(1, email).getSingleResult();
        } catch (Exception e) {
            throw new DaoLayerException(e.getMessage());
        }
    }
    
    
}
