/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.PartsDAO;
import DAO.PartsUsedDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Parts;
import model.SalePerson;

/**
 *
 * @author Admin
 */
public class Sale_AddPartsUsedServlet extends HttpServlet {

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
            String partid = request.getParameter("partid");
            String number = request.getParameter("number");
            HttpSession s = request.getSession();
            SalePerson sale = (SalePerson) s.getAttribute("Sale");
            if (sale != null) {
                PartsDAO pd = new PartsDAO();
                double price = pd.getPrice(partid);
                if(price > 0) {
                    double numberPart = Double.parseDouble(number);
                    price = price * numberPart;
                    PartsUsedDAO pud = new PartsUsedDAO();
                    int result = pud.createPartsUsed(stid, partid, number, "" + price);
                    if(result > 0) {
                        request.setAttribute("SUCCESS", "Add successfully!");
                        request.getRequestDispatcher("MainServlet?action=sale_createStPage2").forward(request, response);
                    } else {
                        request.setAttribute("ERROR", "Pre-existing data!");
                        request.getRequestDispatcher("MainServlet?action=sale_createStPage2").forward(request, response);
                    }
                } else {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=sale_createStPage2").forward(request, response);
                }
            } else {
                request.setAttribute("ERROR2", "Unauthorized access!");
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
