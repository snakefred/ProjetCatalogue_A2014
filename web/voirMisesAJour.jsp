<%-- 
    Document   : voirMisesAJour
    Created on : 2013-01-16, 11:35:51
    Author     : Usager
--%>
<%@page import="com.gcf.util.Connexion"%>
<%@page import="com.gcf.DAO.implement.DossierDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.gcf.modele.Reunion"%>
<%@page import="com.gcf.modele.PointDiscussion"%>
<%@page import="com.gcf.modele.Dossier"%>
<script language="JavaScript" src="./js/script.js"></script>
<script src="./js/jquery.js"></script>
<script>
$(document).ready(function(){
    $(".desc").hide();
    $(".infoModifier").hide();
    $("#modifierInfo").click(function(){
        $(".infoModifier").show();
        $(".cacherInfo").hide();
        $(this).hide();
    });
});
</script>

<%if ((request.getAttribute("dossier")==null)||(request.getAttribute("listeMAJ")==null)){
        out.println("<h3>Erreur lors de la recherche</h3>");
        out.println("<a href=\"index.jsp?afficherPage=afficherBienvenue\"><h2>Retour à la liste de dossiers</h2></a>");
        out.close();
    }
    //Dossier et liste de MAJ qu'on aura besoin.
    Dossier d = (Dossier)request.getAttribute("dossier");
    List<MiseAJour> liste = (List<MiseAJour>)request.getAttribute("listeMAJ");
    List<String> listeAuteurs = (List<String>)request.getAttribute("listeAuteurs");
%>

    <%        
        Dossier dos = null;
        dos = (Dossier) (request.getAttribute("dossier"));
        dos = (new DossierDAO(Connexion.getInstance())).read(dos.getIdDossier());
    %>
<%@page import="java.util.List"%>
<%@page import="com.gcf.modele.MiseAJour"%>
<a href="index.jsp?afficherPage=afficherBienvenue"><h2>Retour à la liste de dossiers</h2></a>
<h1>Informations du dossier <%=d.getNom()%> </h1>
<table class="nostyle">
    <form method="GET" action="ctrl.do">
        <input type="hidden" name="action" value="modifierInfoDossier" />
        <input type="hidden" name="IDDos" value="<%=d.getIdDossier()%>" />
        <tr><td>Type</td><td><%=d.getType()%></td></tr>
        <tr><td>Nom du dossier</td><td><%=d.getNom()%></td></tr>
        <tr class="cacherInfo" ><td>État</td><td><%=d.getEtat()%></td></tr>
        <tr class="infoModifier">
            <td>État</td>
            <td>
                <select name="cmbEtat">
                    <option value="actif">Actif</option>
                    <option value="ferme">Fermé</option>
                </select>
            </td>
        </tr>
        <tr><td>Nom du créateur</td><td><%=(String)request.getAttribute("nomCreateur")%></td></tr>
        <tr><td>Date de création</td><td><%=d.getDateCreation()%></td></tr>
        <%--Dans la ligne suivante, il faut changer !"null" par "null" ou ""... il faut encore tester.--%>
        <tr class="cacherInfo"><td>Date de fermeture</td><td><%=(!"null".equals(d.getDateFermeture()))?"Ce dossier n'est pas fermé.":d.getDateFermeture()%></td></tr>
        <tr class="infoModifier"><td>Date de fermeture</td><td><input name="NewDateFermeture" type="datetime-local"></td></tr>
        <tr><td><a href="#" id="modifierInfo">Modifier les informations</a></td></tr>
        <td><input type="submit" class="infoModifier input-submit" value="Enregistrer"/></td>
    </form>
</table>
  <h1>Historique du dossier</h1>  
<%
List<Reunion> listReunion = (List) request.getAttribute("listeReunion");
List<PointDiscussion> listODJ = (List) request.getAttribute("listeODJ");
String url;
out.println("<ul>");
for(int i=0;i<listReunion.size();i++){    
    out.println("<span style=\"cursor:pointer\" onclick=\"switchDisplay(\'cacher"+i+"\')\">"); 
    out.println("<li>["+listReunion.get(i).getTitre()+"] ");
    out.println(listReunion.get(i).getDate()+"</li>");
    out.println("</span>");
    out.println("<ul id=\"cacher"+i+"\" class=\"desc\">");
    for(int j=0;j<listODJ.size();j++){
        if(listODJ.get(j).getIdReunion() == listReunion.get(i).getIdReunion()){
            url = "?action=consulterODJ&pdID=" +listODJ.get(i).getIdPointD() + "&idReunion="+listReunion.get(i).getIdReunion();
           out.println("<li><a href=\""+url+"\">"+listODJ.get(j).getNom()+"</a></li>");
           out.println("<ul><li>"+listODJ.get(j).getCompteRendu()+"</li></ul>");
        }        
    }
    out.println("</ul>");
}
out.println("</ul>");
%>  
    
<h1>Mises à jour</h1>
 
    <%       
        if (liste.isEmpty()){
            out.println("<p class=\"msg warning\">Aucune mise à jour n'a été effectuée pour le dossier "+d.getNom()+".</p>");
        }else{
            for(int i=0;i<liste.size();i++){
                out.println("<table class=\"nostyle\"><tr><th>Auteur</th><td>"+listeAuteurs.get(i) +"</td><th>Date</th><td>"+liste.get(i).getDate()+"</td></tr>");
                out.println("<tr><th>Nature</th><td>"+liste.get(i).getNature()+"</td></tr></table>");
                out.println("<div class=\"col50\"><p class=\"t-justify\">"+liste.get(i).getInfo() +"</p></div><div class=\"fix\"></div>");
                if (i+1<liste.size()) out.println("<hr />");
            }
        }
    out.close();
    %>

