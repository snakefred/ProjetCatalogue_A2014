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
@WebServlet(name = "ModifierInfoDossier", urlPatterns = {"/ModifierInfoDossier"})
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
            if(request.getParameter("NewDateFermeture") != "")
            {
               if(request.getParameter("IDDos") != null) 
               {
                  String etat = (String) request.getParameter("cmbEtat");
                  String dateFermeture = (String) request.getParameter("NewDateFermeture");
                  String id = (String) request.getParameter("IDDos");
                  DossierDAO dosDAO = new DossierDAO(Connexion.getInstance());
                  Dossier dos = dosDAO.read(id);
                  request.setAttribute("etat",etat);
                  request.setAttribute("dateFermeture",dateFermeture);
               }
            }
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 3.2 Final//EN\">");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ModifierInfoDossier</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ModifierInfoDossier at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
            
            String url = "/index.jsp?afficherPage=voirMiseAJour";
                RequestDispatcher r = this.getServletContext().getRequestDispatcher(url);
                r.forward(request, response);
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