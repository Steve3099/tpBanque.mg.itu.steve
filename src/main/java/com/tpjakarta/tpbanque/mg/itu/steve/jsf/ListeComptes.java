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
import java.util.List;

/**
 *
 * @author Steve
 */
@Named(value = "listeComptes")
@ViewScoped
public class ListeComptes implements Serializable {
    
    @Inject
    GestionnaireCompte gc;
    
    private List<CompteBancaire> listeCompte;

    /**
     * Creates a new instance of ListeComptes
     */
    public ListeComptes() {
        
    }
    
    public List<CompteBancaire> getAllComptes(){
        if (listeCompte == null){
            listeCompte =  gc.getAllComptes();
        }
        return listeCompte;
    }
    
    public String supprimerCompte(CompteBancaire cb){
        //CompteBancaire cb = gc.getCompteById(id);
        gc.supprimer(cb);
        Util.addFlashInfoMessage("suppression effectué");
        return "listeComptes";
    }
    
    public String goToModif(Long id){
        return "formModif?id="+id.toString()+"&amp;faces-redirect=true";
    }
    
}
