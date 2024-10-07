/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.model;

import java.util.ArrayList;


public class Epreuve {
    private int id;
    private String nom ;
    private ArrayList<Athlete> NbAthletes ;
    
 public Epreuve(int id, String nom) {
        this.id = id;
        this.nom = nom;
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
    
    public ArrayList<Athlete> getNbAthletes() {
        return NbAthletes;
    }

    public void setLesAthletes(ArrayList<Athlete> NbAthletes) {
        this.NbAthletes = NbAthletes;
    }
    public void addAthlete(Athlete a){
        
        if (NbAthletes == null){
            NbAthletes = new ArrayList<Athlete>();
        }
        NbAthletes.add(a);
    }
}
