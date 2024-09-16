<%-- 
    Document   : listerAthletes
    Created on : 14 août 2024, 12:27:51
    Author     : zakina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.model.Pays"%>
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
                Athlete a = (Athlete)request.getAttribute("pAthlete");
        %> 
                
                <table class="table table-striped table-sm">  
                    <thead>
                        <tr>             
                            <th>id</th>
                            <th>pays</th>     
                        </tr>
                    </thead>
                    <tr>
                <td>Id: </td><td><%  out.println(a.getId());%></td>
            </tr>
            <tr>
                <td>Pays : </td><td><%  out.println(a.getPays().getNom());%></td>
            </tr>
        </table>
            </div>
        </div>
    </body>
</html>