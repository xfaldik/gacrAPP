/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.gacr.facade;

import cz.gacr.dto.EnterpriseCreateDTO;
import cz.gacr.dto.EnterpriseDTO;
import java.util.List;

/**
 *
 * @author olda
 */
public interface EnterpriseFacade {
    /**
     * Create new Trainer
     *
     * @param t TrainerCreateDTO - information about new Trainer
     * @return ID of new Trainer.
     */
    int createEnterprise(EnterpriseCreateDTO t);

    /**
     * Delete existing Trainer
     *
     * @param trainerId ID of Trainer
     */
    void deleteEnterprise(int trainerId);

    /**
     * Gets all existing Trainers
     *
     * @return List of TrainerDTOs
     */
    List<EnterpriseDTO> getAllEnterprises();

    /**
     * Gets Bagde Able Trainers
     *
     * @return List of TrainerDTOs
     */
    public EnterpriseDTO getEnterpriseWithId(int id);
}
