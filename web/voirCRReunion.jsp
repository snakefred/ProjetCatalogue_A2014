<%@page import="com.gcf.modele.PointDiscussion"%>
<%@page import="java.util.List"%>
<%@page import="com.gcf.modele.Reunion"%>
<div>
    <h1>Compte-rendu de la réunion</h1> 

    <%
        if (request.getAttribute("message") != null) {
            out.println((String) request.getAttribute("message"));
        }
        Reunion r = (Reunion) request.getAttribute("uneReunion");
        List<PointDiscussion> listePD = (List) request.getAttribute("listePD");

        out.println("<table class=\"nostyle\"><tr><td>Titre de la réunion:</td><td>" + r.getTitre() + "</td></tr><tr><td>Date:</td><td>" + r.getDate() + "</td></tr><tr><td>État:</td><td>" + r.getEtat() + "</td></tr></table>");
        out.println("<hr />");
        
        out.println("<h2>Compte-rendu</h2>");
        
        out.println("<dl>");
        for(int i= 0; i< listePD.size(); i++){
         String cr = "Aucun compte-rendu";
         if (listePD.get(i).getCompteRendu() != null){
             cr = listePD.get(i).getCompteRendu();
         }
         out.println("<dt>"+listePD.get(i).getNom()+"</dt>"); 
         out.println("<dd>"+cr+"</dd>");
        }
        out.println("</dl>");

    %>

</div>