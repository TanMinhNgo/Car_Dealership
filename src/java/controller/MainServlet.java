/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ASUS
 */
public class MainServlet extends HttpServlet {

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
            String action = request.getParameter("action");
            String url = "";
            if (action == null) {
                action = "home";
            }
            switch (action) {
                case "home":
                    url = "home.html";
                    break;
                case "loginPage":
                    url = "loginPage.jsp";
                    break;
                case "custDashboard":
                    url = "Cust_DashboardPage.jsp";
                    break;
                case "login_Customer":
                    url = "Cust_LoginServlet";
                    break;
                case "login_Staff":
                    url = "Staff_LoginServlet";
                    break;
                case "Logout":
                    url = "LogoutServlet";
                    break;
                case "changeProfile":
                    url = "Cust_ChangeProfileServlet";
                    break;
                case "ChangeProfilePage":
                    url = "Cust_ChangeProfile.jsp";
                    break;
                case "Find Car":
                    url = "FindCarServlet";
                    break;
                case "carpage":
                    url = "CarPage.jsp";
                    break;
                case "invoicePage":
                    url = "Cust_InvoicePage.jsp";
                    break;
                case "custGetInvoice":
                    url = "Cust_GetInvoiceServlet";
                    break;
                case "custInvoice":
                    url = "Cust_InvoiceServlet";
                    break;
                case "Detail Car":
                    url = "Cust_DetailCarServlet";
                    break;
                case "custGetServiceTicket":
                    url = "Cust_GetServiceTicketServlet";
                    break;
                case "custDetailStPage":
                    url = "Cust_DetailServiceTicketPage.jsp";
                    break;
                case "custDetailServiceTicket":
                    url = "Cust_DetailServiceTicketServlet";
                    break;
                case "wishlistPage":
                    url = "Cust_WishListPage.jsp";
                    break;
                case "addWishlist":
                    url = "Cust_AddToWishlistServlet";
                    break;
                case "Booking":
                    url = "Cust_SaveWishlistServlet";
                    break;
                case "Remove":
                    url = "Cust_RemoveFromWishlistServlet";
                    break;
                case "mecDashboard":
                    url = "Mec_DashboardPage.jsp";
                    break;
                case "mecFindByID":
                    url = "Mec_FindTicketByIDServlet";
                    break;
                case "mecFindByDate":
                    url = "Mec_FindTicketByDateServlet";
                    break;
                case "mecDetailService":
                    url = "Mec_DetailServiceServlet";
                    break;
                case "mecDetailServicePage":
                    url = "Mec_ServiceDetailPage.jsp";
                    break;
                case "mecUpdateServiceTicket":
                    url = "Mec_UpdateServiceTicketServlet";
                    break;
                case "mecView":
                    url = "Mec_ViewServiceTicketServlet";
                    break;
                case "mecUpdateServiceTicketPage":
                    url = "Mec_UpdateServiceTicketPage.jsp";
                    break;
                case "mecUpdateServicePage":
                    url = "Mec_UpdateServicePage.jsp";
                    break;
                case "mecUpdateNewServiceTicket":
                    url = "Mec_UpdateNewStServlet";
                    break;
                case "mec_GetServices":
                    url="Mec_GetServicesServlet";
                    break;
                case "mec_servicePage":
                    url = "Mec_ServicePage.jsp";
                    break;
                case "mec_updateServicePage":
                    url = "Mec_UpdateServicePage.jsp";
                    break;
                case "mec_updateService":
                    url = "Mec_UpdateServiceServlet";
                    break;
                case "mec_deleteServicePage":
                    url = "Mec_DeleteServicePage.jsp";
                    break;
                case "mec_deleteService":
                    url = "Mec_DeleteServiceServlet";
                    break;
                case "mec_createNewServicePage":
                    url = "Mec_CreateNewServicePage.jsp";
                    break;
                case "mec_createNewService":
                    url = "Mec_CreateNewServiceServlet";
                    break;
                case "salePersonPage":
                    url = "Sale_PersonPage.jsp";
                    break;
                case "sale_customer":
                    url = "Sale_CustServlet";
                    break;
                case "sale_custPage":
                    url = "Sale_CustPage.jsp";
                    break;
                case "sale_car":
                    url = "Sale_CarServlet";
                    break;
                case "sale_carPage":
                    url = "Sale_CarPage.jsp";
                    break;
                case "sale_serviceTicket":
                    url = "Sale_ServiceTicketServlet";
                    break;
                case "sale_ServiceTicketPage":
                    url = "Sale_ServiceTicketPage.jsp";
                    break;
                case "sale_part":
                    url = "Sale_PartServlet";
                    break;
                case "sale_PartPage":
                    url = "Sale_PartPage.jsp";
                    break;
                case "sale_invoice":
                    url = "Sale_InvoiceServlet";
                    break;
                case "sale_InvoicePage":
                    url = "Sale_InvoicePage.jsp";
                    break;
                case "sale_reportPage":
                    url = "Sale_ReportPage.jsp";
                    break;
                case "sale_ReportPage":
                    url = "Sale_ReportPage.jsp";
                    break;
                case "sale_findCust":
                    url = "Sale_FindCustServlet";
                    break;
                case "sale_updateCust":
                    url = "Sale_UpdateCustServlet";
                    break;
                case "sale_updateCustPage":
                    url = "Sale_UpdateCustPage.jsp";
                    break;
                case "sale_deleteCustPage":
                    url = "Sale_DeleteCustPage.jsp";
                    break;
                case "sale_deleteCust":
                    url = "Sale_DeleteCustServlet";
                    break;
                case "sale_createCustPage":
                    url = "Sale_CreateCustPage.jsp";
                    break;
                case "sale_createCust":
                    url = "Sale_CreateCustServlet";
                    break;
                case "sale_findCar":
                    url = "Sale_FindCarServlet";
                    break;
                case "sale_updateCar":
                    url = "Sale_UpdateCarServlet";
                    break;
                case "sale_updateCarPage":
                    url = "Sale_UpdateCarPage.jsp";
                    break;
                case "sale_deleteCarPage":
                    url = "Sale_DeleteCarPage.jsp";
                    break;
                case "sale_deleteCar":
                    url = "Sale_DeleteCarServlet";
                    break;
                case "sale_createCarPage":
                    url = "Sale_CreateCarPage.jsp";
                    break;
                case "sale_createCar":
                    url = "Sale_CreateCarServlet";
                    break;
                case "sale_findPart":
                    url = "Sale_FindPartServlet";
                    break;
                case "sale_updatePart":
                    url = "Sale_UpdatePartServlet";
                    break;
                case "sale_updatePartPage":
                    url = "Sale_UpdatePartPage.jsp";
                    break;
                case "sale_deletePartPage":
                    url = "Sale_DeletePartPage.jsp";
                    break;
                case "sale_deletePart":
                    url = "Sale_DeletePartServlet";
                    break;
                case "sale_createPartPage":
                    url = "Sale_CreatePartPage.jsp";
                    break;
                case "sale_createPart":
                    url = "Sale_CreatePartServlet";
                    break;
                case "sale_getWishlist":
                    url = "Sale_GetWishlistServlet";
                    break;
                case "sale_createInvoice":
                    url = "Sale_CreateInvoiceServlet";
                    break;
                case "sale_createSt":
                    url = "Sale_CreateStServlet";
                    break;
                case "sale_createStPage":
                    url = "Sale_CreateStPage.jsp";
                    break;
                case "sale_createSt1":
                    url = "Sale_CreateSt1Servlet";
                    break;
                case "sale_createStPage1":
                    url = "Sale_CreateStPage1.jsp";
                    break;
                case "sale_addServiceMechanic":
                    url = "Sale_AddServiceMechanicServlet";
                    break;
                case "sale_justSmSt":
                    url = "Sale_JustSmStServlet";
                    break;
                case "sale_createStPage2":
                    url = "Sale_CreateStPage2.jsp";
                    break;
                case "sale_addPartsUsed":
                    url = "Sale_AddPartsUsedServlet";
                    break;
                case "sale_completeSt":
                    url = "Sale_CompleteStServlet";
                    break;
                default:
                    url = "home.html"; // Xử lý trường hợp action không hợp lệ
                    break;
            }

            request.getRequestDispatcher(url).forward(request, response);
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
