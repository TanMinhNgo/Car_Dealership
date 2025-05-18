<%-- 
    Document   : Sale_ServiceTicketPage
    Created on : Mar 9, 2025, 3:39:58 PM
    Author     : Admin
--%>

<%@page import="model.Parts"%>
<%@page import="DAO.PartsDAO"%>
<%@page import="model.PartsUsed"%>
<%@page import="DAO.PartsUsedDAO"%>
<%@page import="model.Mechanic"%>
<%@page import="DAO.MechanicDAO"%>
<%@page import="model.Service"%>
<%@page import="DAO.ServiceDAO"%>
<%@page import="model.ServiceMechanic"%>
<%@page import="DAO.ServiceMechanicDAO"%>
<%@page import="model.Car"%>
<%@page import="DAO.CarDAO"%>
<%@page import="model.Customer"%>
<%@page import="DAO.CustomerDAO"%>
<%@page import="model.ServiceTicket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.SalePerson"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealership</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="./styles/mystyle.css" />
    </head>
    <body>
        <%
            SalePerson sale = (SalePerson) session.getAttribute("Sale");
            if (sale == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6 min-h-screen mb-10">
            <h1 class="text-3xl font-bold text-center text-black mb-6">Service Ticket List</h1>

            <%
                ArrayList<ServiceTicket> listSt = (ArrayList<ServiceTicket>) session.getAttribute("SALE_LISTST");
                if (listSt != null && !listSt.isEmpty()) {
            %>

            <table class="w-full border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Service Ticket ID</th>
                        <th class="border border-gray-400 px-4 py-2">Customer Name</th>
                        <th class="border border-gray-400 px-4 py-2">Car Model</th>
                        <th class="border border-gray-400 px-4 py-2">Service Name</th>
                        <th class="border border-gray-400 px-4 py-2">Mechanic Name</th>
                        <th class="border border-gray-400 px-4 py-2">Service Price</th>
                        <th class="border border-gray-400 px-4 py-2">Parts Used</th>
                        <th class="border border-gray-400 px-4 py-2">Number of Parts</th>
                        <th class="border border-gray-400 px-4 py-2">Price of Parts</th>
                        <th class="border border-gray-400 px-4 py-2">Received Date</th>
                        <th class="border border-gray-400 px-4 py-2">Returned Date</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ServiceTicket serTic : listSt) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= serTic.getServiceTicketID()%></td>
                        <td class="border border-gray-400 px-4 py-2">
                            <%
                                CustomerDAO custd = new CustomerDAO();
                                Customer cust = custd.findCustomerByID(serTic.getCustID());
                                if (cust != null) {
                            %>
                            <p><%= cust.getCustname()%></p>
                            <%
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2">
                            <%
                                CarDAO card = new CarDAO();
                                Car car = card.getCar(serTic.getCarID());
                                if (car != null) {
                            %>
                            <p><%= car.getModel()%></p>
                            <%
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2">
                            <%
                                ServiceMechanicDAO smd = new ServiceMechanicDAO();
                                ArrayList<ServiceMechanic> listSm = smd.getServiceMechanic("" + serTic.getServiceTicketID());
                                if (listSm != null && !listSm.isEmpty()) {
                                    ServiceDAO sd = new ServiceDAO();
                                    for (ServiceMechanic serMecha : listSm) {
                                        Service ser = sd.getService("" + serMecha.getServiceID());
                            %>
                            <p style="text-align: left">-<%= ser.getServiceName()%></p> 
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2">
                            <%
                                if (listSm != null && !listSm.isEmpty()) {
                                    MechanicDAO md = new MechanicDAO();
                                    for (ServiceMechanic serMecha : listSm) {
                                        Mechanic mecha = md.getMechanic(serMecha.getMechanicID());
                            %>
                            <p><%= mecha.getName()%></p> 
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2 text-right">
                            <%
                                if (listSm != null && !listSm.isEmpty()) {
                                    for (ServiceMechanic serMecha : listSm) {
                            %>
                            <p><%= serMecha.getRate()%></p> 
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2">
                            <%
                                PartsUsedDAO pud = new PartsUsedDAO();
                                ArrayList<PartsUsed> listPu = pud.getPartsUsed("" + serTic.getServiceTicketID());
                                if (listPu != null && !listPu.isEmpty()) {
                                    PartsDAO pd = new PartsDAO();
                                    for (PartsUsed pu : listPu) {
                                        Parts part = pd.getParts("" + pu.getPartID());
                            %>
                            <p style="text-align: left">-<%= part.getPartName()%></p> 
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2 text-center">
                            <%
                                if (listPu != null && !listPu.isEmpty()) {
                                    for (PartsUsed pu : listPu) {
                            %>
                            <p><%= pu.getNumberUsed()%></p> 
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2 text-right">
                            <%
                                if (listPu != null && !listPu.isEmpty()) {
                                    for (PartsUsed pu : listPu) {
                            %>
                            <p><%= pu.getPrice()%></p>
                            <%
                                    }
                                }
                            %>
                        </td>
                        <td class="border border-gray-400 px-4 py-2 text-center"><%= serTic.getDateReceived()%></td>
                        <td class="border border-gray-400 px-4 py-2 text-center"><%= serTic.getDateReturned()%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <%
                }
            %>

            <div class="text-center mt-6">
                <a href="MainServlet?action=sale_createSt" class="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700">Create New Service Ticket</a>
            </div>

            <h3 class="text-center text-red-600 mt-4">
                <%
                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                %>
            </h3>

            <div class="text-center mt-6">
                <a href="MainServlet?action=salePersonPage" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Back Home</a>
            </div>
        </div>
        
        <%
            }
        %>
    </body>
</html>
