/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Arandac;
import Bean.Customer;
import Dao.EventsDB;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author wyh1
 */
public class JumpServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException {
        HttpSession session = request.getSession();
        Customer loginUser = (Customer) session.getAttribute("LoginUser");
        int id = Integer.parseInt(request.getParameter("id"));
        Arandac sevent = new Arandac();
        sevent.setArandacid(id);
        Arandac findevent = null;
        EventsDB dao = new EventsDB();
        try {
            findevent = dao.findevent(sevent);
            if (loginUser == null) {
                if (findevent.getDate() == null) {
                    request.setAttribute("get", "comment");
                    request.setAttribute("id", id);
                } else {
                    request.setAttribute("get", "activity");
                    request.setAttribute("id", id);
                }
                request.getRequestDispatcher("items.jsp").forward(request, response);
            } else {
                if (findevent.getDate() == null) {
                    request.setAttribute("get", "comment");
                    request.setAttribute("id", id);
                } else {
                    request.setAttribute("get", "activity");
                    request.setAttribute("id", id);
                }
                response.sendRedirect(request.getContextPath() + "/HomeServlet?id="+request.getAttribute("id")+"&get="+request.getAttribute("get"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("seventservlet wrong");
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
            Logger.getLogger(JumpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JumpServlet.class.getName()).log(Level.SEVERE, null, ex);
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
