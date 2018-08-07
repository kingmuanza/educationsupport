/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.support.utils;

/**
 *
 * @author N9-T
 */
public class Solvabilite {
    private boolean isSolvable;
    private double montantPaye;
    private double montantDu;

    public boolean isSolvable() {
        return isSolvable;
    }

    public void setIsSolvable(boolean isSolvable) {
        this.isSolvable = isSolvable;
    }

    public double getMontantPaye() {
        return montantPaye;
    }

    public void setMontantPaye(double montantPaye) {
        this.montantPaye = montantPaye;
    }

    public double getMontantDu() {
        return montantDu;
    }

    public void setMontantDu(double montantDu) {
        this.montantDu = montantDu;
    }
    
    
}
