<%@page import="com.gcf.modele.Membre"%>
<%@page import="com.gcf.modele.Catalogue"%>
<%@page import="com.gcf.modele.Operation"%>
<%@page import="com.gcf.util.Connexion"%>
<%@page import="com.gcf.DAO.implement.PermissionDAO"%>
<%@page import="com.gcf.modele.Permission"%>
<%@page import="com.gcf.modele.Dossier"%>
<%@page import="com.gcf.DAO.implement.DossierDAO"%>
<%@page import="com.gcf.modele.PointDiscussion"%>
<%@page import="java.util.List"%>
<%@page import="com.gcf.modele.Reunion"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div>
    <h1>Information de la réunion</h1>
    <%
        Reunion r = ((Reunion) (request.getAttribute("reunion")));
        out.println("<table class=\"nostyle\"><tr><td>Titre de la réunion:</td><td>" + r.getTitre() + "</td></tr><tr><td>Date:</td><td>" + r.getDate() + "</td></tr><tr><td>Etat:</td><td>" + r.getEtat() + "</td></tr></table>");
        out.println("<hr />");

    %>
    <h1>Information de l'ordre du jour</h1>
    <%        PointDiscussion pD = null;
        pD = (PointDiscussion) (request.getAttribute("pointD"));
        if (pD == null) {
            out.println("<p class=\"msg info\">Vous n'avez pas de point de discussion associé à cet ordre du jour<p>");
        } else {
            Dossier dos;
            String dosName;
            out.println("<table id=\"ordreDujour\" >");
            out.println("<tr class=\"t-center\"><th>Sujet</th><th>Type</th><th>Dossier</th></tr>");
            dos = null;
            dos = (new DossierDAO(Connexion.getInstance())).read(pD.getIdDossier());
            dosName = "";
            if (dos != null) {
                dosName = dos.getNom();
            }
            out.println("<td>" + pD.getNom()
                    + "</td><td>" + pD.getType()
                    + "</td><td>" + dosName
                    + "</td></tr>");
            out.println("</table>");

            String compteR = null;
            compteR = pD.getCompteRendu();
            if (compteR != null) { 
                %>
                <fieldset> 
            <legend>Compte-rendu:</legend>
            <p><%=compteR%></p>
                </fieldset>                
                <%
            }
            //Si la personne a les droits d'admin afficher
            int idCatalogue = (((Catalogue) (request.getSession().getAttribute("catalogueCourant"))).getNumeroCat());
            int idCreateur = (((Membre) (request.getSession().getAttribute("connecte"))).getNumero());
            Permission perm = (new PermissionDAO(Connexion.getInstance())).read(idCatalogue, idCreateur);

            if (((perm.getValeurPermission() & Operation.creerPointDiscussion) == Operation.creerPointDiscussion) && (!r.getEtat().equals("Ferme"))) {
        
            out.println("<p><form method=\"POST\" action=\"ctrl.do\">");
            out.println("<input type=\"submit\" value=\"Modifier\">");
            out.println("<input type=\"hidden\" name=\"action\" value=\"modifierOrdreDuJour\">");
            out.println("<input type=\"hidden\" name=\"pdID\" value=\""+pD.getIdPointD()+"\">");
            out.println("<input type=\"hidden\" name=\"avantMod\" value=\"avantMod\">");
            out.println("<input type=\"hidden\" name=\"idReunion\" value=\""+((Reunion) request.getAttribute("reunion")).getIdReunion()+"\"/>");
            out.println("</form></p>");
            }

            if (compteR == null) {
    %>
    <form method="GET" action="ctrl.do">
        <input type="hidden" name="action" value="ajouterCR" />
        <input type="hidden" name="ajoutCR" value="<%=pD.getIdPointD()%>" />
        <input type="hidden" name="idReunion" value="<%=((Reunion) request.getAttribute("reunion")).getIdReunion()%>" />
        <% if (request.getAttribute("message") != null) {
                out.println("<p class=\"" + (String) (request.getAttribute("typeMessage")) + "\">" + (String) (request.getAttribute("message")) + "</p>");
            }
            if (((perm.getValeurPermission() & Operation.creerPointDiscussion) == Operation.creerPointDiscussion) && (!r.getEtat().equals("Ferme"))) {
        %>

        <fieldset> 
            <legend>Ajouter un compte-rendu:</legend>
            <table class="nostyle">
                <tr>                
                <td><textarea rows = "10" cols="50" name="cRendu"></textarea></td>
                </tr>                
                <tr>
                <td><input type="submit" class="input-submit" value="Ajouter"/></td>
                </tr>
            </table>
        </fieldset> 
        <input type="hidden" value="Ajouter"/>
    </form>

    <%}
            //fin  
            }
        }

    %>   
</div>
