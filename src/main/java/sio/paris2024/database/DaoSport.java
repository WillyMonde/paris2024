/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sio.paris2024.database;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import static sio.paris2024.database.DaoAthlete.requeteSql;
import static sio.paris2024.database.DaoAthlete.resultatRequete;
import static sio.paris2024.database.DaoPays.requeteSql;
import static sio.paris2024.database.DaoPays.resultatRequete;
import sio.paris2024.model.Athlete;
import sio.paris2024.model.Pays;
import sio.paris2024.model.Sport;

/**
 *
 */
public class DaoSport {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Sport> getLesSports(Connection cnx){
        
         ArrayList<Sport> lesSports = new ArrayList<Sport>();
        try{
            requeteSql = cnx.prepareStatement("select * from sport");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Sport s = new Sport();
                s.setId(resultatRequete.getInt("id"));
                s.setNom(resultatRequete.getString("nom"));
                
                lesSports.add(s);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesSports e généré une erreur");
        }
        return lesSports;
        
    }
        public static ArrayList<Athlete> getLesAthletesSportById(Connection cnx, int idSport){
        
        ArrayList<Athlete>  lesAthletes = new ArrayList<>();
        try{
            requeteSql = cnx.prepareStatement("select a.id as a_id, a.nom as a_nom, a.prenom as a_prenom " +
                         " from athlete a inner join sport s " +
                         " on a.sport_id = s.id " + 
                         " where s.id = ? ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idSport);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){

                   Athlete a = new Athlete();
                   a.setId(resultatRequete.getInt("a_id"));
                   a.setNom(resultatRequete.getString("a_nom"));
                   a.setPrenom(resultatRequete.getString("a_prenom"));
                   lesAthletes.add(a);
                               
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLesAthletes e généré une erreur");
        }
        return lesAthletes;
    }
}
