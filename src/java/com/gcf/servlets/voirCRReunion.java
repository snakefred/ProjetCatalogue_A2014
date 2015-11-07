package com.gcf.servlets;

import com.gcf.DAO.implement.PointDiscussionDAO;
import com.gcf.DAO.implement.ReunionDAO;
import com.gcf.modele.PointDiscussion;
import com.gcf.modele.Reunion;
import com.gcf.util.Connexion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class voirCRReunion extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        int idReunion = Integer.parseInt(request.getParameter("idReunion"));
        
        ReunionDAO rDAO = new ReunionDAO(Connexion.getInstance());
        Reunion r = rDAO.read(idReunion);
        
        PointDiscussionDAO pdDAO = new PointDiscussionDAO(Connexion.getInstance());
        List<PointDiscussion> listePD = pdDAO.findAll(String.valueOf(idReunion));
        
        request.setAttribute("listePD", listePD);
        request.setAttribute("uneReunion", r);
        
                        String url = "/index.jsp?afficherPage=voirCRReunion";
                RequestDispatcher rd = this.getServletContext().getRequestDispatcher(url);
                rd.forward(request, response);
        
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
