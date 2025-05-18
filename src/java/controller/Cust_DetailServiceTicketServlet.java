/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PartsUsedDAO;
import DAO.ServiceMechanicDAO;
import DAO.ServiceTicketDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;
import model.PartsUsed;
import model.ServiceMechanic;
import model.ServiceTicket;

/**
 *
 * @author Admin
 */
public class Cust_DetailServiceTicketServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String stid = request.getParameter("serviceticketid");
            HttpSession s = request.getSession();
            Customer user = (Customer) s.getAttribute("User");
            if (user != null) {
                ServiceTicketDAO std = new ServiceTicketDAO();
                ServiceTicket st = std.getDetailServiceTicket("" + user.getCustid(), stid);
                if (st != null) {
                    ServiceMechanicDAO smd = new ServiceMechanicDAO();
                    ArrayList<ServiceMechanic> sm = smd.getServiceMechanic(stid);
                    PartsUsedDAO pud = new PartsUsedDAO();
                    ArrayList<PartsUsed> pu = pud.getPartsUsed(stid);
                    if (sm == null || sm.isEmpty()) {
                        request.setAttribute("ERROR", "Something wrong sm. Try again!");
                        request.getRequestDispatcher("MainServlet?action=custDashboard").forward(request, response);
                    } else if (pu == null || pu.isEmpty()) {
                        request.setAttribute("ERROR", "Something wrong pu. Try again!");
                        request.getRequestDispatcher("MainServlet?action=custDashboard").forward(request, response);
                    } else {
                        s.setAttribute("SERVICETICKET", st);
                        s.setAttribute("SERVICEMECHANIC", sm);
                        s.setAttribute("PARTSUSED", pu);
                        response.sendRedirect("MainServlet?action=custDetailStPage");
                    }
                } else {
                    request.setAttribute("ERROR", "Something wrong st. Try again!");
                    request.getRequestDispatcher("MainServlet?action=custDashboard").forward(request, response);
                }
            } else {
                request.setAttribute("ERROR1", "Unauthorized access!");
                request.getRequestDispatcher("MainServlet?action=loginPage").forward(request, response);
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
