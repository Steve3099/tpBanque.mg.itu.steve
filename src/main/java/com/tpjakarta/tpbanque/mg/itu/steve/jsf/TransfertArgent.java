/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.jsf;

import com.tpjakarta.tpbanque.mg.itu.steve.entity.CompteBancaire;
import com.tpjakarta.tpbanque.mg.itu.steve.service.GestionnaireCompte;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import java.io.Serializable;

/**
 *
 * @author Steve
 */
@Named(value = "transfertArgent")
@ViewScoped
public class TransfertArgent implements Serializable {

    private long idReceveur;
    private long idEnvoyeur;
    private int somme;

    @Inject
    GestionnaireCompte gc;

    public long getIdReceveur() {
        return idReceveur;
    }

    public void setIdReceveur(long idReceveur) {
        this.idReceveur = idReceveur;
    }

    public long getIdEnvoyeur() {
        return idEnvoyeur;
    }

    public void setIdEnvoyeur(long idEnvoyeur) {
        this.idEnvoyeur = idEnvoyeur;
    }

    public int getSomme() {
        return somme;
    }

    public void setSomme(int somme) {
        this.somme = somme;
    }

    /**
     * Creates a new instance of TransfertArgent
     */
    public TransfertArgent() {
    }

    public String transfer() {
        gc.transfert(idReceveur, idEnvoyeur, somme);
        return "listeComptes";
    }

}
