/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.tpjakarta.tpbanque.mg.itu.steve.service;

import com.tpjakarta.tpbanque.mg.itu.steve.entity.CompteBancaire;
import jakarta.annotation.sql.DataSourceDefinition;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import java.util.List;

/**
 *
 * @author Steve
 */
@Named(value = "gestionnaireCompte")
@DataSourceDefinition(
        className = "com.mysql.cj.jdbc.MysqlDataSource",
        name = "java:app/jdbc/banque",
        serverName = "localhost",
        portNumber = 3306,
        user = "root", // nom et
        password = "root", // mot de passe que vous avez donnés lors de la création de la base de données
        databaseName = "banque",
        properties = {
            "useSSL=false",
            "allowPublicKeyRetrieval=true",
            "driverClass=com.mysql.cj.jdbc.Driver"
        }
)
@ApplicationScoped
public class GestionnaireCompte {
    
    @PersistenceContext(unitName = "banquePU")
    private EntityManager em;

    /**
     * Creates a new instance of GestionnaireCompte
     */
    public GestionnaireCompte() {
    }
    
    @Transactional
    public void creerCompte(CompteBancaire c) {
        em.persist(c);
    }
    
    public List<CompteBancaire> getAllComptes() {
        Query query = em.createNamedQuery("CompteBancaire.findAll");
        return query.getResultList();
    }
    
    public int compte() {
        return getAllComptes().size();
    }
    
    public CompteBancaire getCompteById(long id) {
        return em.find(CompteBancaire.class, id);
    }
    
    @Transactional
    public void transfert(long idReceveur, long idEnvoyeur, int somme) {
        CompteBancaire envoyeur = this.getCompteById(idEnvoyeur);
        CompteBancaire receveur = this.getCompteById(idReceveur);
        
        envoyeur = em.merge(envoyeur);
        receveur = em.merge(receveur);
        
        envoyeur.setSolde(envoyeur.getSolde() - somme);
        receveur.setSolde(receveur.getSolde() + somme);
        
    }
    
    @Transactional
    public void ajoutCompte(String nom, int solde) {
        CompteBancaire b = new CompteBancaire(nom, solde);
        em.persist(b);
    }
    
    @Transactional
    public void deposer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.deposer(montant);
        em.merge(compteBancaire);
    }
    
    @Transactional
    public void retirer(CompteBancaire compteBancaire, int montant) {
        compteBancaire.retirer(montant);
        em.merge(compteBancaire);
    }
    
    @Transactional
    public void supprimer(CompteBancaire cb) {
        em.remove(em.merge(cb));
    }
    
    @Transactional
    public void updateCompte(CompteBancaire compte) {
        em.merge(compte);
    }
    
}
