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
    <h1>Information de la Réunion</h1>
    <%
        Reunion r = ((Reunion) (request.getAttribute("reunion")));
        out.println("<table class=\"nostyle\"><tr><td>Titre de la réunion:</td><td>" + r.getTitre() + "</td></tr><tr><td>Date:</td><td>" + r.getDate() + "</td></tr><tr><td>État:</td><td>" + r.getEtat() + "</td></tr></table>");
        out.println("<hr />");

    %>
    <h1>Ordres du jour</h1>
    <%        List<PointDiscussion> listePD = (List<PointDiscussion>) (request.getAttribute("listeOrdreDuJour"));
        if (listePD.isEmpty()) {
            out.println("<p class=\"msg info\">Vous n'avez pas de point de discussion associé à cet ordre du jour<p>");
        } else {
            Dossier dos;
            String dosName;
            String url;
            out.println("<form method=\"POST\" action=\"ctrl.do\" >");
            out.println("<input type=\"hidden\" name=\"action\" value=\"consulterInfoReunion\" >");
            out.println("<input type=\"hidden\" name=\"idReunion\" value=" + r.getIdReunion() + " >");
            out.println("<input type=\"hidden\" name=\"modifierODJ\" value=\"lol\" >");

            out.println("</form>");
            out.println("<table id=\"ordreDujour\" >");
            out.println("<tr class=\"t-center\"><th>Sujet</th><th>Type</th><th>Dossier</th></tr>");
            for (int i = 0; i < listePD.size(); i++) {
                dos = null;
                dos = (new DossierDAO(Connexion.getInstance())).read(listePD.get(i).getIdDossier());
                dosName = "";
                if (dos != null) {
                    dosName = dos.getNom();
                }
                url = "?action=consulterODJ&pdID=" + listePD.get(i).getIdPointD() + "&idReunion=" + r.getIdReunion();
                out.println("<td><a href=\"" + url + "\">" + listePD.get(i).getNom()
                        + "</a></td><td>" + listePD.get(i).getType()
                        + "</td><td>" + dosName
                        + "</td></tr>");
            }
            out.println("</table>");
        }
    %>

    <p><a href="ctrl.do?action=voirCRReunion&idReunion=<%=r.getIdReunion()%>">Afficher le compte-rendu de la réunion</a></p>

    
    <form method="GET" action="ctrl.do">
        <input type="hidden" name="action" value="consulterInfoReunion" />
        <input type="hidden" name="ajoutPD" value="Mierda" />
        <input type="hidden" name="idReunion" value="<%=((Reunion) request.getAttribute("reunion")).getIdReunion()%>" />
        <% if (request.getAttribute("message") != null) {
                out.println("<p class=\"" + (String) (request.getAttribute("typeMessage")) + "\">" + (String) (request.getAttribute("message")) + "</p>");
            }
            int idCatalogue = (((Catalogue) (request.getSession().getAttribute("catalogueCourant"))).getNumeroCat());
            int idCreateur = (((Membre) (request.getSession().getAttribute("connecte"))).getNumero());
            Permission perm = (new PermissionDAO(Connexion.getInstance())).read(idCatalogue, idCreateur);

            if (((perm.getValeurPermission() & Operation.creerPointDiscussion) == Operation.creerPointDiscussion) && (!r.getEtat().equals("Ferme"))) {
        %>

        <fieldset> 
            <legend>Ajouter un point de discussion:</legend>
            <table class="nostyle">
                <tr>
                <td style="width:150px;">Nom du point de discussion:</td>
                <td><input type="text" size="40" name="nomPD" maxlength="30" class="input-text" /></td>
                </tr>
                <tr>
                <td style="width:150px;">Type:</td>
                <td><input type="text" size="40" name="typePD" maxlength="30" class="input-text" /></td>
                </tr>
                <tr>
                <td style="width:150px;">Nom du dossier:</td>
                <td><select name="idDossier">
                        <option value="-">-</option>
                        <% List<Dossier> listeDossier = (List<Dossier>) (request.getAttribute("listeDossier"));
                            for (int i = 0; i < listeDossier.size(); i++) {
                                out.println("<option value=" + listeDossier.get(i).getIdDossier() + " >" + listeDossier.get(i).getNom() + "</option>");
                            }
                        %>   
                    </select></td>
                </tr>
                <tr>

                <td><input type="submit" class="input-submit" value="Ajouter"/></td>
                </tr>
            </table>
        </fieldset> 
    </form>
    <%}%>
</div>
