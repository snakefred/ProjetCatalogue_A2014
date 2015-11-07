/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.servlets;

import com.gcf.DAO.implement.DossierDAO;
import com.gcf.DAO.implement.PointDiscussionDAO;
import com.gcf.DAO.implement.ReunionDAO;
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
 * @author Alain
 */
public class modifierOrdreDuJour extends HttpServlet {

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
        response.setCharacterEncoding("UTF-8");
        try {
            if (request.getParameter("avantMod") != null) {
                if (request.getParameter("pdID") != null) {
                    String id = (String) request.getParameter("pdID");
                    PointDiscussionDAO pdDAO = new PointDiscussionDAO(Connexion.getInstance());
                    PointDiscussion pd = pdDAO.read(id);
                    request.setAttribute("pointD", pd);

                    String idR = (String) request.getParameter("idReunion");
                    ReunionDAO rDAO = new ReunionDAO(Connexion.getInstance());
                    Reunion re = rDAO.read(idR);

                    request.setAttribute("reunion", re);
                    
                    DossierDAO dDAO = new DossierDAO(Connexion.getInstance());                    
                    List<Dossier> listD = dDAO.findAll();
                    
                    request.setAttribute("listeDossier", listD);

                    String url = "/index.jsp?afficherPage=modifierODJ";
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher(url);
                    r.forward(request, response);
                }
            } else if (request.getParameter("apresMod") != null) {
                if (request.getParameter("pdID") != null) {
                    String id = (String) request.getParameter("pdID");
                    PointDiscussionDAO pdDAO = new PointDiscussionDAO(Connexion.getInstance());
                    PointDiscussion pd = pdDAO.read(id);

                    pd.setCompteRendu((String) request.getParameter("cRendu"));
                    pd.setNom((String) request.getParameter("nomPD"));
                    pd.setType((String) request.getParameter("typePD"));
                    pd.setIdDossier(Integer.parseInt(request.getParameter("idDossier")));
                    pdDAO.update(pd);
                    request.setAttribute("pointD", pd);

                }

                String idR = (String) request.getParameter("idReunion");
                ReunionDAO rDAO = new ReunionDAO(Connexion.getInstance());
                Reunion re = rDAO.read(idR);

                request.setAttribute("reunion", re);

                String url = "/index.jsp?afficherPage=voirOrdreDuJour";
                RequestDispatcher r = this.getServletContext().getRequestDispatcher(url);
                r.forward(request, response);
            }
        } finally {

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
