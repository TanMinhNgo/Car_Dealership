/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.MechanicDAO;
import DAO.SalePersonDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Mechanic;
import model.SalePerson;

/**
 *
 * @author Admin
 */
public class Staff_LoginServlet extends HttpServlet {

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
            request.setCharacterEncoding("utf-8");
            String name = request.getParameter("staffname");
            if(name != null){
                SalePersonDAO sd = new SalePersonDAO();
                SalePerson sale = sd.checkLogin(name);
                if(sale == null){
                    MechanicDAO md = new MechanicDAO();
                    Mechanic mecha = md.checkLogin(name);
                    if(mecha == null){
                        request.setAttribute("ERROR2", "Login fail. Try again!");
                        request.getRequestDispatcher("loginPage.jsp").forward(request, response);
                    }
                    else{
                        HttpSession s=request.getSession(true);
                        s.setAttribute("Mecha", mecha);
                        response.sendRedirect("MainServlet?action=mecDashboard");
                    }
                }
                else{
                   HttpSession s = request.getSession(true);
                   s.setAttribute("Sale", sale);
                   response.sendRedirect("MainServlet?action=salePersonPage");
                }
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
