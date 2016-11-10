/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Comment;
import Bean.Customer;
import Dao.CommentDB;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CommentServlet extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        String refer = request.getHeader("referer");
        String title = new String(request.getParameter("txtTitle").getBytes("ISO8859_1"), "utf-8");
        String content = new String(request.getParameter("txtContent").getBytes("ISO8859_1"), "utf-8");
        String arandacid = new String(request.getParameter("arandacid").getBytes("ISO8859_1"), "utf-8");
        int id = Integer.parseInt(arandacid);
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        Customer loginUser = (Customer) session.getAttribute("LoginUser");
        if (session.getAttribute("LoginUser") == null) {
            out.print("<script>alert('Please log in first!');</script>");
        } else {
            Date now = new Date();
            DateFormat d1 = DateFormat.getDateInstance();
            String str1 = d1.format(now);
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date timeDate = null;
            timeDate = sdf.parse(str1);
            java.sql.Date Date = new java.sql.Date(timeDate.getTime());
            Comment comment = new Comment();
            comment.setArandacid(id);
            comment.setTitle(title);
            comment.setText(content);
            comment.setDate(Date);
            comment.setName(loginUser.getName());
            CommentDB dao = new CommentDB();
            dao.addComment(comment);
            JOptionPane.showMessageDialog(null, "Success!");
            response.sendRedirect(refer);
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
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(CommentServlet.class.getName()).log(Level.SEVERE, null, ex);
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
