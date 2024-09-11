/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package sio.paris2024.servlet;

import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import sio.paris2024.database.DaoSport;
import sio.paris2024.form.FormSport;
import sio.paris2024.model.Athlete;
import sio.paris2024.model.Sport;

/**
 *
 * @author SIO2
 */
@WebServlet(name = "ServletSport", urlPatterns = {"/ServletSport"})
public class ServletSport extends HttpServlet {
    
    Connection cnx ;
            
    @Override
    public void init()
    {     
        ServletContext servletContext=getServletContext();
        
        System.out.println("SERVLKET CONTEXT=" + servletContext.getContextPath());
        cnx = (Connection)servletContext.getAttribute("connection"); 
        
        try {
            System.out.println("INIT SERVLET=" + cnx.getSchema());
        } catch (SQLException ex) {
            Logger.getLogger(ServletSport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServletSport</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServletSport at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String url = request.getRequestURI();  
       
        // Récup et affichage les sport
        if(url.equals("/paris2024/ServletSport/lister"))
        {              
            ArrayList<Sport> lesSports = DaoSport.getLesSports(cnx);
            request.setAttribute("sLesSports", lesSports);

           getServletContext().getRequestDispatcher("/vues/sport/listerSport.jsp").forward(request, response);
        }
        
        if(url.equals("/paris2024/ServletSport/consulter"))
        { 
            int idSport = Integer.parseInt((String)request.getParameter("idSport"));
            ArrayList<Athlete> lesAthletes = DaoSport.getLesAthletesSportById(cnx, idSport);
            request.setAttribute("sSport", lesAthletes);
            
           getServletContext().getRequestDispatcher("/vues/sport/consulterSport.jsp").forward(request, response);
        }
        
        
          if(url.equals("/paris2024/ServletSport/ajouter"))
        {                   
            ArrayList<Sport> lesSports = DaoSport.getLesSports(cnx);
            request.setAttribute("sLesSports", lesSports);
            this.getServletContext().getRequestDispatcher("/vues/sport/ajouterSport.jsp" ).forward( request, response );
        }
        
        
    }
      
     /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             
        
         FormSport form = new FormSport();
		
        /* Appel au traitement et à la validation de la requête, et récupération du bean en résultant */
        Sport spo = form.ajouterSport(request);
        
        /* Stockage du formulaire et de l'objet dans l'objet request */
        request.setAttribute( "forms", form );
        request.setAttribute( "sSport", spo );
		
        if (form.getErreurs().isEmpty()){
            Sport sportInsere =  DaoSport.addSport(cnx, spo);
            if (sportInsere != null ){
                request.setAttribute( "sSport", sportInsere );
                this.getServletContext().getRequestDispatcher("/vues/sport/consulterSport.jsp" ).forward( request, response );
            }
            else 
            {
                // Cas oùl'insertion en bdd a échoué
                //renvoyer vers une page d'erreur 
            }
           
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
