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

/**
 *
 * @author zakina
 */
public class DaoPays {
    
    Connection cnx;
    static PreparedStatement requeteSql = null;
    static ResultSet resultatRequete = null;
    
    public static ArrayList<Pays> getLesPays(Connection cnx){
        
         ArrayList<Pays> lesPays = new ArrayList<Pays>();
        try{
            requeteSql = cnx.prepareStatement("select * from pays");
            //System.out.println("REQ="+ requeteSql);
            resultatRequete = requeteSql.executeQuery();
            
            while (resultatRequete.next()){
                
                Pays p = new Pays();
                p.setId(resultatRequete.getInt("id"));
                p.setNom(resultatRequete.getString("nom"));
                p.setCode(resultatRequete.getString("code"));
                
                lesPays.add(p);
            }
           
        }
        catch (SQLException e){
            e.printStackTrace();
            System.out.println("La requête de getLespays e généré une erreur");
        }
        return lesPays;
        
    }
        public static ArrayList<Athlete> getLesAthletesPaysById(Connection cnx, int idPays){
        
        ArrayList<Athlete>  lesAthletes = new ArrayList<>();
        try{
            requeteSql = cnx.prepareStatement("select a.id as a_id, a.nom as a_nom, a.prenom as a_prenom " +
                         " from athlete a inner join pays p " +
                         " on a.pays_id = p.id " + 
                         " where p.id = ? ");
            //System.out.println("REQ="+ requeteSql);
            requeteSql.setInt(1, idPays);
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
            System.out.println("La requête de getLesPompiers e généré une erreur");
        }
        return lesAthletes;
    }
}
