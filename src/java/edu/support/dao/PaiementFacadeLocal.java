/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Paiement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface PaiementFacadeLocal {

    void create(Paiement paiement);

    void edit(Paiement paiement);

    void remove(Paiement paiement);

    Paiement find(Object id);

    List<Paiement> findAll();

    List<Paiement> findRange(int[] range);

    int count();
    
}
