/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CarDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Car;
import model.SalePerson;

/**
 *
 * @author Admin
 */
public class Sale_UpdateCarServlet extends HttpServlet {

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
            String id = request.getParameter("carid");
            String serialnumber = request.getParameter("carserialnumber");
            String model = request.getParameter("carmodel");
            String year = request.getParameter("caryear");
            String colour = request.getParameter("carcolour");
            HttpSession s = request.getSession();
            SalePerson sale = (SalePerson) s.getAttribute("Sale");
            if (sale != null) {
                CarDAO cd = new CarDAO();
                Car car = cd.getCar(id);
                if (serialnumber == null || serialnumber.isEmpty()) {
                    serialnumber = car.getSerialNumber();
                }
                if (model == null || model.isEmpty()) {
                    model = car.getModel();
                }
                if (year == null || year.isEmpty()) {
                    year = "" + car.getYear();
                }
                if (colour == null || colour.isEmpty()) {
                    colour = car.getColour();
                }
                int result = cd.updateCar(car.getCarID(), serialnumber, model, year, colour);
                if (result > 0) {
                    ArrayList<Car> listCar = cd.getAllCars();
                    if (listCar != null && !listCar.isEmpty()) {
                        s.setAttribute("SALE_LISTCAR", listCar);
                    }
                    request.setAttribute("SUCCESS", "Update successfully");
                    request.getRequestDispatcher("MainServlet?action=sale_updateCarPage").forward(request, response);
                } else {
                    request.setAttribute("ERROR", "Data duplication!");
                    request.getRequestDispatcher("MainServlet?action=sale_updateCarPage").forward(request, response);
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
