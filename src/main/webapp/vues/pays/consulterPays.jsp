<%-- 
    Document   : consulterPays
    Created on : 9 sept. 2024, 12:59:06
    Author     : SIO2
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sio.paris2024.model.Athlete"%>
<%@page import="sio.paris2024.model.Pays"%>
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
		padding-top:50px;
	}
        </style>
    </head>
    <body>
      
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a  href ='../ServletPays/lister' class="navbar-brand" href=".">Système de gestion des pays</a>
			</div>
		</div>
	</nav>
    <body>
       <div class="container special">
                <%
                    ArrayList<Athlete> lesAthletes = (ArrayList)request.getAttribute("pPays");
                    
                    Pays p = (Pays)request.getAttribute("Pays");
                    
                %> 
            <h2 class="h2"><%  out.println(p.getNom());%></h2>
		<div class="table-responsive">

                <table class="table table-striped table-sm">  
                <thead>
                    <tr>             
                        <th>id</th>
                        <th>nom</th>
                        <th>prenom</th>              
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <%
                            for (Athlete a : lesAthletes)
                            {              
                                out.println("<tr><td>");
                                out.println(a.getId());
                                out.println("</td>");
                                
                                out.println("<td>");
                                out.println(a.getNom());
                                out.println("</td>");;
           
                                out.println("<td>");
                                out.println(a.getPrenom());
                                out.println("</td>");;
                            }
                        %>
                    </tr>
                </tbody>
            </table>
        </body>
         </div>
       </div>
  
</html>
