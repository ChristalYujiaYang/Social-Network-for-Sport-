/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Customer;
import Dao.UserDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

/**
 *
 * @author Crystal
 */
public class JoinServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, ParseException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String refer = request.getHeader("referer");
        String arandacid = new String(request.getParameter("arandacid").getBytes("ISO8859_1"), "utf-8");
        int id = Integer.parseInt(arandacid);
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Customer loginUser = (Customer) session.getAttribute("LoginUser");
        if (session.getAttribute("LoginUser") == null) {
            out.print("<script>alert('Please log in first!');</script>");
        } else {
            UserDB dao = new UserDB();
            if (dao.Getnum(id) == dao.Getmax(id)) {
                out.print("<script>alert('The number has reached the ceiling!');location='homepage.jsp';</script>");
            } else {
                if (dao.Getarandac(loginUser.getUserid(), id)) {
                    JOptionPane.showMessageDialog(null, "You have already joined this activity!");
                } else {
                    dao.JoinActivity(loginUser.getUserid(), id);
                    JOptionPane.showMessageDialog(null, "Success!");
                }
                if (dao.Getnum(id) == dao.Getmin(id)) {
                    dao.SendMail(id);
                } else {
                }
                response.sendRedirect(refer);
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
            Logger.getLogger(JoinServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JoinServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JoinServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(JoinServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JoinServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(JoinServlet.class.getName()).log(Level.SEVERE, null, ex);
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
