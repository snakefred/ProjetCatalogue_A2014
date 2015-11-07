<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Connexion</title>
        <link href="./style/style.css" rel="stylesheet" type="text/css" /> 
    </head>

    <body>

        <div id="all">
            <div id="form">
                <div id="entete">
                    Devenir membre
                </div>
                <hr />
                <div id="corps2">
                    <form method="POST" action="ctrl.do">
                        <table >
                            <tr>
                            <td ><label>Usager:</label></td ><td><input type="text" name="username"  maxlength="30" /></td>
                            </tr>

                            <tr>
                            <td><label>Mot de passe:</label></td><td><input type="password" name="password" maxlength="20"  /></td>
                            </tr>

                            <tr>
                            <td><label>Confirmer le mot de passe:</label></td><td><input type="password" name="cofirmPassword"   maxlength="20"/></td>
                            </tr>

                            <tr>
                            <td><label>Courriel:</label></td><td><input type="text" name="courriel" maxlength="30"  /></td>
                            </tr>
                            <tr>
                            <td>

                                <% if (request.getAttribute("reponseAjoutMembre") != null) {
                                        out.println("<strong>" + (String) request.getAttribute("reponseAjoutMembre") + "</strong>");
                                    }
                                %> 


                            </td>  <td><input type="submit" name="bOkInscription" value="S'inscrire" /></td>
                            </tr>
                            <tr>

                            <td><input type="hidden" name="action" value="inscriptionMembre" /></td>
                            </tr>

                        </table>

                    </form>
                </div>
                <div id="pied">
                </div>
            </div>
        </div>
    </body>
</html>
