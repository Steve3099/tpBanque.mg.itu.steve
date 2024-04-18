/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.jsf;

import com.tpjakarta.tpbanque.mg.itu.steve.entity.CompteBancaire;
import com.tpjakarta.tpbanque.mg.itu.steve.entity.OperationBancaire;
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
@Named(value = "operations")
@ViewScoped
public class Operations implements Serializable {
    
    
    @Inject
    GestionnaireCompte gc;
    
    private Long id;
    private CompteBancaire compteBan;
    private List<OperationBancaire> listeOp;
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompteBan() {
        return compteBan;
    }

    public void setCompteBan(CompteBancaire compte) {
        this.compteBan = compte;
    }

    public List<OperationBancaire> getListeOp() {
        return compteBan.getOperations();
    }

    public void setListeOp(List<OperationBancaire> listeOp) {
        this.listeOp = listeOp;
    }
    
    /**
     * Creates a new instance of Operations
     */
    public Operations() {
    }
    
    public void loadCompte(){
        compteBan = gc.getCompteById(id);
    }
    
}
