/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.model;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author zakina
 */
public class Athlete {
    
    private int id;
    private String nom ;
    private String prenom;
    private LocalDate datenaiss;
    private Pays pays ;
    private Sport sport;
    private ArrayList<Epreuve> lesEpreuves ;

    public Athlete() {
    }

    public Athlete(int id, String nom, String prenom, LocalDate datenaiss) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaiss = datenaiss;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDatenaiss() {
        return datenaiss;
    }

    public void setDatenaiss(LocalDate datenaiss) {
        this.datenaiss = datenaiss;
    }

    public Sport getSport() {
        return sport;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }
    
     public ArrayList<Epreuve> getLesEpreuves() {
        return lesEpreuves;
    }

    public void setLesEpreuves(ArrayList<Epreuve> lesEpreuves){
        this.lesEpreuves = lesEpreuves;
    }
   
    public void addEpreuve(Epreuve e){
        
        if (lesEpreuves == null){
            lesEpreuves = new ArrayList<Epreuve>();
        }
        lesEpreuves.add(e);
    }
    public int getNbEpreuves(){
        return lesEpreuves.size();
    }
}
