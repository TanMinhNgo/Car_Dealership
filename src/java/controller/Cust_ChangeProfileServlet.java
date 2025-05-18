/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CustomerDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Customer;

/**
 *
 * @author Admin
 */
public class Cust_ChangeProfileServlet extends HttpServlet {

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
            String name = request.getParameter("custname");
            String phone = request.getParameter("custphone");
            String sex = request.getParameter("custsex");
            String address = request.getParameter("custaddress");
            HttpSession s = request.getSession();
            Customer user = (Customer) s.getAttribute("User");
            if (user != null) {
                if(name == null || name.isEmpty()) {
                    name = user.getCustname();
                }
                if(phone == null || phone.isEmpty()) {
                    phone = user.getPhone();
                }
                if(sex == null || sex.isEmpty()) {
                    sex = user.getSex();
                }
                if(address == null || address.isEmpty()) {
                    address = user.getCustaddress();
                }
                CustomerDAO cd = new CustomerDAO();
                int result = cd.changeProfile(user.getCustid(), name, phone, sex, address);
                if (result > 0) {
                    user.setCustname(name);
                    user.setPhone(phone);
                    user.setSex(sex);
                    user.setCustaddress(address);
                    s.setAttribute("User", user);
                    request.setAttribute("SUCCESS", "Change successfully");
                    request.getRequestDispatcher("MainServlet?action=ChangeProfilePage").forward(request, response);
                    
                } else {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=ChangeProfilePage").forward(request, response);
                    
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
