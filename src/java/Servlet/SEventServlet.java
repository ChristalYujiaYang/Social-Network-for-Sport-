/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Dao.EventsDB;
import Bean.Arandac;
import Bean.Comment;
import Dao.CommentDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Crystal
 */
public class SEventServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        if ("".equals(request.getParameter("id")) | "null".equals(request.getParameter("id"))) {
            response.sendRedirect(request.getContextPath() + "/InitialServlet");
        } else {
            Object id1 = request.getParameter("id");
            int id = Integer.parseInt(String.valueOf(id1));
            Arandac sevent = new Arandac();
            sevent.setArandacid(id);
            EventsDB dao = new EventsDB();
            Arandac findevent = null;
            try {
                findevent = dao.findevent(sevent);
                dao.Addclick(sevent);
                request.setAttribute("findevent", findevent);
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("Seventservlet wrong");
            }
            CommentDB db = new CommentDB();
            List<Comment> comments = null;
            try {
                comments = db.Comments(id);
                request.setAttribute("comment", comments);
                if (findevent.getDate() == null) {
                    request.getRequestDispatcher("comment.jsp").forward(request, response);
                } else {
                    request.getRequestDispatcher("activity.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                System.out.println("seventservlet wrong");
            }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SEventServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SEventServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SEventServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SEventServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
