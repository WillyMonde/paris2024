/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.model;

import java.util.ArrayList;

/**
 *
 * @author zakina
 */
public class Pays {
    private int id;
    private String nom ;
    private ArrayList<Athlete> lesAthletes ;
    private String code ;

    public Pays() {
    }

    public Pays(int id, String code, String nom) {
        this.id = id;
        this.code = code;
        this.nom = nom;
    }

    public Pays(int id) {
        this.id = id;
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

    public ArrayList<Athlete> getLesAthletes() {
        return lesAthletes;
    }

    public void setLesAthletes(ArrayList<Athlete> lesAthletes) {
        this.lesAthletes = lesAthletes;
    }
    
    public void addAthlete(Athlete a){
        
        if (lesAthletes == null){
            lesAthletes = new ArrayList<Athlete>();
        }
        lesAthletes.add(a);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    
}
