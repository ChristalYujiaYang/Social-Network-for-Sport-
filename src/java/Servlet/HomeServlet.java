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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Crystal
 */
public class HomeServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    int PageNum = 1;
    int PageNumCount;
    String change = null;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        change = request.getParameter("change");
        if (change != null) {
            if (change.equals("increase")) {
                PageNum++;
            } else if (change.equals("decrease")) {
                PageNum--;
            }
        }
        EventsDB db = new EventsDB();
        List<Arandac> events = null;
        List<Arandac> rankevents = null;
        List<Arandac> joined = null;
        List<String> info = new ArrayList<String>();
        HttpSession session = request.getSession();
        Customer loginUser = (Customer) session.getAttribute("LoginUser");
        try {
            events = db.customerevents(loginUser);
            rankevents = db.rank();
            joined = db.Joined(loginUser);
            List<Arandac> pagelist = new LinkedList<Arandac>();
            PageNumCount = (events.size() / 6) + 1;
            if (PageNum > PageNumCount) {
                for (int i = (PageNumCount - 1) * 6; i < events.size(); i++) {
                    pagelist.add(events.get(i));
                }
                PageNum = PageNumCount;
            } else if (PageNum <= 0) {
                for (int i = 0; i < ((events.size()<6)?events.size():6); i++) {
                    pagelist.add(events.get(i));
                }
                PageNum = 1;
            } else if (PageNum < PageNumCount) {
                for (int i = (PageNum - 1) * 6; i < PageNum * 6; i++) {
                    pagelist.add(events.get(i));
                }
            } else if (PageNum == PageNumCount) {
                for (int i = (PageNum - 1) * 6; i < events.size(); i++) {
                    pagelist.add(events.get(i));
                }
            } else if (PageNumCount == 1) {
                for (int i = 0; i < events.size(); i++) {
                    pagelist.add(events.get(i));
                }
            }
            info.add("hi,");
            info.add(loginUser.getName());
            request.setAttribute("info", info);
            request.setAttribute("findevents", pagelist);
            request.setAttribute("rankevents", rankevents);
            request.setAttribute("joinedactivity", joined);
            request.setAttribute("get", request.getParameter("get"));
            request.setAttribute("id", request.getParameter("id"));
            request.setAttribute("PageNum", PageNum);
            System.out.println(request.getParameter("get"));
            System.out.println(request.getParameter("id"));
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
            /*if(request.getParameter("get")!=null){
                response.sendRedirect(request.getContextPath() + "/SEventServlet?id="+request.getParameter("id"));
            }
            else{
            request.getRequestDispatcher("homepage.jsp").forward(request, response);
            }*/
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("LoginServlet wrong");
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
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(HomeServlet.class.getName()).log(Level.SEVERE, null, ex);
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
