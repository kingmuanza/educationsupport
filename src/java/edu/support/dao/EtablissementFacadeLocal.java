/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.dao;

import edu.support.entities.Etablissement;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author N9-T
 */
@Local
public interface EtablissementFacadeLocal {

    void create(Etablissement etablissement);

    void edit(Etablissement etablissement);

    void remove(Etablissement etablissement);

    Etablissement find(Object id);

    List<Etablissement> findAll();

    List<Etablissement> findRange(int[] range);

    int count();
    
}
