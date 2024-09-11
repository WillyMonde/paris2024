<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.model.Sport"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PARIS 2024</title>
        <link rel="stylesheet"
            href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
            integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
            crossorigin="anonymous">
        
        <title>Paris 2024</title>

        <style>
            body {
                padding-top: 50px;
            }
            .special {
                padding-top: 50px;
            }
        </style>
    </head>
    <body>
        <nav class="navbar navbar-inverse navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a href='../ServletSport/lister' class="navbar-brand">Système de gestion des sports</a>
                </div>
            </div>
        </nav>
        
        <div class="container special">
            <h2 class="h2">Liste des athlètes de ce sport</h2>
            <div class="table-responsive">
                <%
                    ArrayList<Athlete> lesAthletes = (ArrayList<Athlete>) request.getAttribute("lesAthletes");
                %> 
                
                <table class="table table-striped table-sm">  
                    <thead>
                        <tr>             
                            <th>id</th>
                            <th>nom</th>
                            <th>prénom</th>              
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            if (lesAthletes != null && !lesAthletes.isEmpty()) {
                                for (Athlete a : lesAthletes) {              
                                    out.println("<tr><td>" + a.getId() + "</td>");
                                    out.println("<td>" + a.getNom() + "</td>");
                                    out.println("<td>" + a.getPrenom() + "</td></tr>");
                                }
                            } else {
                                out.println("<tr><td colspan='3'>Aucun athlète trouvé pour ce sport.</td></tr>");
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
