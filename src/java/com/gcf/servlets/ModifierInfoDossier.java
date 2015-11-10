/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gcf.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gcf.DAO.implement.DossierDAO;
import com.gcf.modele.Dossier;
import com.gcf.util.Connexion;
import javax.servlet.RequestDispatcher;


/**
 *
 * @author defsv
 */
public class ModifierInfoDossier extends HttpServlet {
    
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
        PrintWriter out = response.getWriter();
        try {
            if(request.getParameter("cmbEtat") == "ferme" && request.getParameter("NewDateFermeture") != "")
            {
                if(request.getParameter("idDossier") != null) 
                {
                    DossierDAO dosDAO = new DossierDAO(Connexion.getInstance());
                    Dossier dos = dosDAO.read(request.getParameter("idDossier"));
                    dos.setEtat((String) request.getParameter("cmbEtat"));
                    dos.setDateFermeture((String) request.getParameter("NewDateFermeture"));
                    dosDAO.update(dos);
                    request.setAttribute("dossier", dos);
                    String url = "/index.jsp?afficherPage=voirMAJ";
                    RequestDispatcher r = this.getServletContext().getRequestDispatcher(url);
                    r.forward(request, response);
                }
            }
            else {
                DossierDAO dosDAO = new DossierDAO(Connexion.getInstance());
                Dossier dos = dosDAO.read(request.getParameter("idDossier"));
                
                request.setAttribute("dossier", dos);

                String url = "/index.jsp?afficherPage=afficherBienvenue";
                RequestDispatcher r = this.getServletContext().getRequestDispatcher(url);
                r.forward(request, response);
            }

        } finally {
            //out.close();
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
