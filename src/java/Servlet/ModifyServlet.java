/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.Customer;
import Dao.CustomerDAOImpl;
import Dao.UserDB;
import java.io.IOException;
import java.sql.SQLException;
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
public class ModifyServlet extends HttpServlet {

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
            throws ServletException, IOException, SQLException, ClassNotFoundException, Exception {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        String refer = request.getHeader("referer");
        HttpSession session = request.getSession();
        Customer loginUser = (Customer) session.getAttribute("LoginUser");
        int userid = loginUser.getUserid();
        String username = new String(request.getParameter("txtName").getBytes("ISO8859_1"), "utf-8");
        String email = new String(request.getParameter("txtEmail").getBytes("ISO8859_1"), "utf-8");
        String password = new String(request.getParameter("txtPassword").getBytes("ISO8859_1"), "utf-8");
        String[] interests = request.getParameterValues("love");
        String[] allinterests = {"basketball", "baseball", "swimming", "football", "jogging", "soccer"};
        int[] interest = {0, 0, 0, 0, 0, 0};
        for (int j = 0; j < allinterests.length; j++) {
            for (int k = 0; k < interests.length; k++) {
                if (allinterests[j].equals(interests[k])) {
                    interest[j] = 1;
                }
            }
        }
        String age = new String(request.getParameter("select").getBytes("ISO8859_1"), "utf-8");
        String phonenumber = new String(request.getParameter("txtPhone").getBytes("ISO8859_1"), "utf-8");

        Customer user = new Customer();
        user.setUserid(userid);
        user.setName(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setAge(age);
        user.setPhone(phonenumber);
        user.setBasketball(interest[0]);
        user.setBaseball(interest[1]);
        user.setSwimming(interest[2]);
        user.setFootball(interest[3]);
        user.setJogging(interest[4]);
        user.setSoccer(interest[5]);
        CustomerDAOImpl customer = new CustomerDAOImpl();
        UserDB dao = new UserDB();
        dao.usermodify(user);
        session.setAttribute("LoginUser", user);
        JOptionPane.showMessageDialog(null, "Success,please refresh the web page!");
        response.sendRedirect(refer);
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
        } catch (SQLException ex) {
            Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(ModifyServlet.class.getName()).log(Level.SEVERE, null, ex);
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
