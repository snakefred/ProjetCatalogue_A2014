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
    <%        
        PointDiscussion pD = null;
        pD = (PointDiscussion) (request.getAttribute("pointD"));
        if (pD == null) {
            out.println("<p class=\"msg info\">Vous n'avez pas de point de discussion associé à cet ordre du jour<p>");
        } else {
            Dossier dos;
            String dosName;
            dos = null;
            dos = (new DossierDAO(Connexion.getInstance())).read(pD.getIdDossier());
            dosName = "";
            if (dos != null) {
                dosName = dos.getNom();
            }
            %>
        <form method="GET" action="ctrl.do">
        <input type="hidden" name="action" value="modifierOrdreDuJour" />
        <input type="hidden" name="apresMod" value="apresMod" />
        <input type="hidden" name="pdID" value="<%=pD.getIdPointD()%>" />
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
            <legend>Modifier un point de discussion:</legend>
            <table class="nostyle">
                <tr>
                <td style="width:150px;">Nom du point de discussion:</td>
                <td><input type="text" size="40" name="nomPD" class="input-text" maxlength="30" value="<%=pD.getNom() %>"/></td>
                </tr>
                <tr>
                <td style="width:150px;">Type:</td>
                <td><input type="text" size="40" name="typePD" class="input-text" maxlength="30" value="<%=pD.getType()%>" /></td>
                </tr>
                <tr>
                <td style="width:150px;">Nom du dossier:</td>
                <td><select name="idDossier">
                        <option value="-">-</option>
                        <% List<Dossier> listeDossier = (List<Dossier>) (request.getAttribute("listeDossier"));
                            for (int i = 0; i < listeDossier.size(); i++) {
                                String dossier;
                                if(listeDossier.get(i).getIdDossier()==pD.getIdDossier()){
                                 dossier = "<option value=" + listeDossier.get(i).getIdDossier() + " selected>" + listeDossier.get(i).getNom() + "</option>";   
                                } else {
                                 dossier = "<option value=" + listeDossier.get(i).getIdDossier() + ">" + listeDossier.get(i).getNom() + "</option>";   
                                }
                                out.println(dossier);
                            }
                        %>   
                    </select></td>
                </tr>
            </table>
        </fieldset> 
            <%}
            String compteR = null;
            compteR = pD.getCompteRendu();
            if (compteR == null) {
                compteR = "";
            }
            out.println(compteR);
                %>
        <fieldset> 
            <legend>Modifier un compte-rendu:</legend>
            <table class="nostyle">
                <tr>                
                <td><textarea rows = "10" cols="50" name="cRendu"><%=compteR%></textarea></td>
                </tr>                
                <tr>
                <td><input type="submit" class="input-submit" value="Modifier"/></td>
                </tr>
            </table>
        </fieldset> 
        <input type="hidden" value="Modifier"/> 
    </form>
                <%}%>
</div>

