/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.Customer;

/**
 *
 * @author Admin
 */
public class Cust_RemoveFromWishlistServlet extends HttpServlet {

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
            String carid = request.getParameter("carid");
            HttpSession s = request.getSession();
            Customer user = (Customer) s.getAttribute("User");
            if(user != null) {
                ArrayList<Car> listCar = (ArrayList) s.getAttribute("WISHLIST");
                s.removeAttribute("WISHLIST");
                if(listCar != null && !listCar.isEmpty()) {
                    boolean flag = false;
                    for (int i = 0; i < listCar.size(); i++) {
                        if(carid.equalsIgnoreCase(listCar.get(i).getCarID())){
                            listCar.remove(i);
                            flag = true;
                        }
                    }     
                    if(flag == true) {
                        ArrayList<Car> listCarRemoved = listCar;
                        s.setAttribute("WISHLIST", listCarRemoved);
                        request.setAttribute("SUCCESS", "Remove successfully!");
                        request.getRequestDispatcher("MainServlet?action=wishlistPage").forward(request, response);
                    } else {
                        request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=wishlistPage").forward(request, response);
                    }
                } else {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=wishlistPage").forward(request, response);
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
