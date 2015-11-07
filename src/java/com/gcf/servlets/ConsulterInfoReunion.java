package com.gcf.servlets;

import com.gcf.DAO.implement.DossierDAO;
import com.gcf.DAO.implement.PointDiscussionDAO;
import com.gcf.DAO.implement.ReunionDAO;
import com.gcf.modele.Catalogue;
import com.gcf.modele.Dossier;
import com.gcf.modele.PointDiscussion;
import com.gcf.modele.Reunion;
import com.gcf.util.Connexion;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Trauko
 */
public class ConsulterInfoReunion extends HttpServlet {

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

        if (request.getParameter("idReunion") != null) {
            int idReunion = Integer.parseInt(request.getParameter("idReunion"));
            int idCatalogue = (((Catalogue) (request.getSession().getAttribute("catalogueCourant"))).getNumeroCat());

            ReunionDAO rDAO = new ReunionDAO(Connexion.getInstance());
            Reunion r1 = rDAO.read(idReunion);

            request.setAttribute("reunion", r1);
            DossierDAO dDAO = new DossierDAO(Connexion.getInstance());

            List<Dossier> listeDossier = dDAO.findAll("idCatalogue", String.valueOf(idCatalogue));
            request.setAttribute("listeDossier", listeDossier);

            if (request.getParameter("ajoutPD") != null) {
                String nomPD = request.getParameter("nomPD");
                String typePD = request.getParameter("typePD");
                int idDossier = 0;
                if ("-".equals(request.getParameter("idDossier"))) {
                    idDossier = 0;
                } else {
                    idDossier = Integer.parseInt(request.getParameter("idDossier"));
                }
                PointDiscussionDAO pDAO = new PointDiscussionDAO(Connexion.getInstance());
                PointDiscussion p1 = new PointDiscussion(nomPD, typePD, "e", idDossier, idReunion, "");
                String message;
                if (!pDAO.create(p1)) {
                    message = "Error dans la création";
                    request.setAttribute("message", message);
                }
            }
            PointDiscussionDAO pDAO = new PointDiscussionDAO(Connexion.getInstance());
            List<PointDiscussion> listePD = pDAO.findAll(String.valueOf(idReunion));
            request.setAttribute("listeOrdreDuJour", listePD);
            String url = "/index.jsp?afficherPage=voirInfoReunion";
            if (request.getParameter("modifierODJ") != null) {
                url = "/index.jsp?afficherPage=remplirOrdreJour";
            }
            RequestDispatcher r = this.getServletContext().getRequestDispatcher(url);
            r.forward(request, response);
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
        processRequest(request, response);
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
        processRequest(request, response);
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
