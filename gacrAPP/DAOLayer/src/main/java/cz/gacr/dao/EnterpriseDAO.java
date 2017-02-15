/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.dao;

import cz.gacr.domain.Enterprise;
import java.util.List;

/**
 *
 * @author olda
 */
public interface EnterpriseDAO {
    
    /**
     * Find trainer based on its id.
     *
     * @param id of the Trainer instance.
     */
    Enterprise findById(int id);

    /**
     * Creates or updates corresponding trainer
     *
     * @param trainer instance of Trainer to create or update.
     */
    void save(Enterprise enterprise);

    /**
     * Deletes provided instance of Trainer.
     *
     * @param trainer instance of Trainer to delete.
     */
    void delete(Enterprise enterprise);

    /**
     * Find all instances of Trainer.
     *
     * @return List of Trainer instances.
     */
    List<Enterprise> findAll();

    Enterprise findByEmail(String email);
    
}
