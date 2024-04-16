/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.jsf;

import com.tpjakarta.tpbanque.mg.itu.steve.entity.CompteBancaire;
import com.tpjakarta.tpbanque.mg.itu.steve.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 *
 * @author Steve
 */
@Named(value = "modification")
@RequestScoped
public class Modification {
    
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    private String nom;
    private int solde;
    private CompteBancaire compte;

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }
    @Inject
    private GestionnaireCompte gestionnaireCompte;

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
     * Creates a new instance of Modification
     */
    public Modification() {
    }
    
    public void loadCompte() {
        compte = gestionnaireCompte.getCompteById(id);
        this.nom = compte.getNom();
        this.solde = compte.getSolde();
    }
    
    public String modif(){
        compte = gestionnaireCompte.getCompteById(id);
        compte.setNom(nom);
        compte.setSolde(solde);
        gestionnaireCompte.updateCompte(compte);
        return "listeComptes";
    }
    
}
