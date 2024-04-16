/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.jsf;

import com.tpjakarta.tpbanque.mg.itu.steve.entity.CompteBancaire;
import com.tpjakarta.tpbanque.mg.itu.steve.jsf.util.Util;
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

    private String error = "";

    @Inject
    GestionnaireCompte gc;

    public String getError() {
        return error;
    }

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
        String erreur= "";
        if (gc.getCompteById(idReceveur) == null) {
            erreur += "pas de compte avec l'id du receveur";
        }
        if (gc.getCompteById(idEnvoyeur) == null) {
            erreur += ", pas de compte avec l'id de l'envoyeur";
        }
        if (gc.getCompteById(idEnvoyeur) != null && gc.getCompteById(idEnvoyeur).getSolde() < somme) {
            erreur += ", solde de l'envoyeur insufisant";
        }
        if(gc.getCompteById(idEnvoyeur) != null  && gc.getCompteById(idReceveur) != null && idEnvoyeur == idReceveur){
            erreur +=", l'envoyeur et le receveur doivent être different";
        }
        if (erreur != "") {
            error = erreur;
            return null;
        }

        gc.transfert(idReceveur, idEnvoyeur, somme);
        Util.addFlashInfoMessage("Transfert correctement effectué");
        return "listeComptes?faces-redirect=true";
    }

}
