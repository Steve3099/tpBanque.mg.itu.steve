/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.config;

import com.tpjakarta.tpbanque.mg.itu.steve.entity.CompteBancaire;
import com.tpjakarta.tpbanque.mg.itu.steve.service.GestionnaireCompte;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.Initialized;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import jakarta.transaction.Transactional;

/**
 *
 * @author Steve
 */
@Named(value = "init")
@ApplicationScoped
public class Init {

    @Inject
    GestionnaireCompte gc;

    /**
     * Creates a new instance of Init
     */
    public Init() {
    }

    @Transactional
    public void createCompteBancaire(
            @Observes
            @Initialized(ApplicationScoped.class) ServletContext context) {
        if (gc.compte() == 0) {
            CompteBancaire cb = new CompteBancaire("John Lennon", 150000);
            gc.creerCompte(cb);
            cb = new CompteBancaire("Paul McCartney", 950000);
            gc.creerCompte(cb);
            cb = new CompteBancaire("Ringo Starr", 20000);
            gc.creerCompte(cb);
            cb = new CompteBancaire("Georges Harrisson", 100000);
            gc.creerCompte(cb);
        }

    }

}
