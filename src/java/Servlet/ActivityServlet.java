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
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class ActivityServlet extends HttpServlet {

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
        String title = new String(request.getParameter("txtTitle").getBytes("ISO8859_1"), "utf-8");
        String content = new String(request.getParameter("txtContent").getBytes("ISO8859_1"), "utf-8");
        String peoplemax = new String(request.getParameter("txtMax").getBytes("ISO8859_1"), "utf-8");
        String peoplemin = new String(request.getParameter("txtMin").getBytes("ISO8859_1"), "utf-8");
        String date = new String(request.getParameter("txtDate").getBytes("ISO8859_1"), "utf-8");
        String place = new String(request.getParameter("txtPlace").getBytes("ISO8859_1"), "utf-8");
        String type = new String(request.getParameter("select").getBytes("ISO8859_1"), "utf-8");
        int max = Integer.parseInt(peoplemax);
        int min = Integer.parseInt(peoplemin);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date timeDate = null;
        timeDate = sdf.parse(date);
        java.sql.Date Date = new java.sql.Date(timeDate.getTime());
        HttpSession session = request.getSession();
        Customer loginUser = (Customer) session.getAttribute("LoginUser");
        Arandac activity = new Arandac();
        activity.setTitle(title);
        activity.setText(content);
        activity.setPeoplemax(max);
        activity.setPeoplemin(min);
        activity.setDate(Date);
        activity.setPlace(place);
        activity.setType(type);
        activity.setAuthor(loginUser.getName());
        EventsDB dao = new EventsDB();
        dao.addActivity(activity);
        JOptionPane.showMessageDialog(null, "Success!");
        response.sendRedirect(request.getContextPath() + "/InitialServlet");
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
            Logger.getLogger(ActivityServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActivityServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActivityServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(ActivityServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(ActivityServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ActivityServlet.class.getName()).log(Level.SEVERE, null, ex);
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
