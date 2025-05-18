/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.CarDAO;
import DAO.CustomerDAO;
import DAO.MechanicDAO;
import DAO.PartsDAO;
import DAO.ServiceDAO;
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
import model.Mechanic;
import model.Parts;
import model.SalePerson;
import model.Service;

/**
 *
 * @author Admin
 */
public class Sale_CreateStServlet extends HttpServlet {

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
            HttpSession s = request.getSession();
            SalePerson sale = (SalePerson) s.getAttribute("Sale");
            if(sale != null) {
                CustomerDAO custd = new CustomerDAO();
                ArrayList<Customer> listCust = custd.getCustomers();
                CarDAO card = new CarDAO();
                ArrayList<Car> listCar = card.getAllCars();
                MechanicDAO mechad = new MechanicDAO();
                ArrayList<Mechanic> listMecha = mechad.getAllMechanic();
                ServiceDAO serd = new ServiceDAO();
                ArrayList<Service> listSer = serd.getAllServices();
                PartsDAO partd = new PartsDAO();
                ArrayList<Parts> listPart = partd.getAllParts();
                if(listCust == null || listCust.isEmpty()) {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=sale_ServiceTicketPage").forward(request, response);
                } else if (listCar == null || listCar.isEmpty()) {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=sale_ServiceTicketPage").forward(request, response);
                } else if (listMecha == null || listMecha.isEmpty()) {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=sale_ServiceTicketPage").forward(request, response);
                } else if (listSer == null || listSer.isEmpty()) {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=sale_ServiceTicketPage").forward(request, response);
                } else if (listPart == null || listPart.isEmpty()) {
                    request.setAttribute("ERROR", "Something wrong. Try again!");
                    request.getRequestDispatcher("MainServlet?action=sale_ServiceTicketPage").forward(request, response);
                } else {
                    s.setAttribute("SALE_STLISTCUST", listCust);
                    s.setAttribute("SALE_STLISTCAR", listCar);
                    s.setAttribute("SALE_STLISTMECHA", listMecha);
                    s.setAttribute("SALE_STLISTSER", listSer);
                    s.setAttribute("SALE_STLISTPART", listPart);
                    response.sendRedirect("MainServlet?action=sale_createStPage");
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
