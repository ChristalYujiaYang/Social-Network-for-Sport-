/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Bean.*;
import Dao.AddCustomer;
import Dao.CustomerDAOImpl;
import java.util.ArrayList;
import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author wyh1
 */
public class RegisterServlet extends HttpServlet {

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
        response.setContentType("text/html");
        /*response.setCharacterEncoding("GBK");
        request.setCharacterEncoding("GBK");

        SmartUpload su = new SmartUpload();
        // get pageContext object  
        su.initialize(this.getServletConfig(), request, response);*/
        String name = request.getParameter("txtName");
        
        String email = request.getParameter("txtEmail");
        String password = request.getParameter("txtPassword");
        String age = request.getParameter("select");
        String phone = request.getParameter("txtPhone");
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
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);
        customer.setAge(age);
        customer.setPhone(phone);
        customer.setBasketball(interest[0]);
        customer.setBaseball(interest[1]);
        customer.setSwimming(interest[2]);
        customer.setFootball(interest[3]);
        customer.setJogging(interest[4]);
        customer.setSoccer(interest[5]);
        List<String> info = new ArrayList<String>();
        try {
            CustomerDAOImpl user = new CustomerDAOImpl();
            if (user.findCustomer(customer)) {
                info.add("Sorry, this user has already exist.");
                request.setAttribute("info", info);
                request.getRequestDispatcher("register.jsp").forward(request, response);
            } else {
                String i;
                AddCustomer ac = new AddCustomer();
                i = ac.addC(customer);
                info.add(i);
                request.setAttribute("info", info);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e);
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
        doGet(request, response);
    }
}
