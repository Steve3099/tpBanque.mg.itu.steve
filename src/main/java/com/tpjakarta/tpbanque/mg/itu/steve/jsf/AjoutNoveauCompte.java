/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.jsf;

import com.tpjakarta.tpbanque.mg.itu.steve.jsf.util.Util;
import com.tpjakarta.tpbanque.mg.itu.steve.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 *
 * @author Steve
 */
@Named(value = "ajoutNoveauCompte")
@RequestScoped
public class AjoutNoveauCompte {
    
    private String nom;
    private int solde;
    
    @Inject
    GestionnaireCompte gc;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    /**
     * Creates a new instance of AjoutNoveauCompte
     */
    public AjoutNoveauCompte() {
    }
    
    public String ajoutCompte(){
        
        gc.ajoutCompte(nom, solde);
        Util.addFlashInfoMessage("Nouveau compte ajouter avec succes");
        return "listeComptes";
    }
}
