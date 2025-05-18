<%-- 
    Document   : DetailStPage
    Created on : Mar 2, 2025, 1:20:43 AM
    Author     : Admin
--%>

<%@page import="model.Customer"%>
<%@page import="DAO.ServiceTicketDAO"%>
<%@page import="model.Mechanic"%>
<%@page import="DAO.MechanicDAO"%>
<%@page import="model.Service"%>
<%@page import="DAO.ServiceDAO"%>
<%@page import="model.Parts"%>
<%@page import="DAO.PartsDAO"%>
<%@page import="model.Car"%>
<%@page import="DAO.CarDAO"%>
<%@page import="model.PartsUsed"%>
<%@page import="model.ServiceMechanic"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.ServiceTicket"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealership</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="./styles/mystyle.css" />
    </head>
    <body class="">
        <%
            Customer cust = (Customer) session.getAttribute("User");
            if (cust == null) {
                request.setAttribute("ERROR1", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <div class="max-w-6xl mx-auto bg-gray-50 p-6 rounded-lg shadow-lg mt-8 mb-10">
            <h1 class="text-2xl font-bold text-gray-700 mb-4">Service Ticket List</h1>

            <% ServiceTicket st = (ServiceTicket) session.getAttribute("SERVICETICKET");
                ArrayList<ServiceMechanic> listSm = (ArrayList<ServiceMechanic>) session.getAttribute("SERVICEMECHANIC");
                ArrayList<PartsUsed> listPu = (ArrayList<PartsUsed>) session.getAttribute("PARTSUSED");
                if (st != null && listSm != null && !listSm.isEmpty() && listPu != null && !listPu.isEmpty()) {
                    ServiceTicketDAO std = new ServiceTicketDAO();
                    CarDAO cd = new CarDAO();
                    Car car = cd.getCar(st.getCarID());
                    PartsDAO pd = new PartsDAO();
                    ArrayList<Parts> listParts = new ArrayList<>();
                    for (PartsUsed partsUsed : listPu) {
                        listParts.add(pd.getParts("" + partsUsed.getPartID()));
                    }
                    ServiceDAO sd = new ServiceDAO();
                    ArrayList<Service> listService = new ArrayList<>();
                    for (ServiceMechanic sm : listSm) {
                        listService.add(sd.getService("" + sm.getServiceID()));
                    }
                    MechanicDAO md = new MechanicDAO();
                    ArrayList<Mechanic> listMecha = new ArrayList<>();
                    for (ServiceMechanic sm : listSm) {
                        listMecha.add(md.getMechanic(sm.getMechanicID()));
                    }
            %>

            <div class="overflow-x-auto">
                <table class="min-w-full bg-white border border-gray-300 rounded-lg">
                    <thead>
                        <tr class="bg-gray-200 text-gray-700">
                            <th class="py-2 px-4 border">Car Name</th>
                            <th class="py-2 px-4 border">Service Name</th>
                            <th class="py-2 px-4 border">Mechanic Name</th>
                            <th class="py-2 px-4 border">Hours</th>
                            <th class="py-2 px-4 border">Parts Used</th>
                            <th class="py-2 px-4 border">Number Of Parts</th>
                            <th class="py-2 px-4 border">Price Of Parts Used</th>
                            <th class="py-2 px-4 border">Price Of Service Mechanic</th>
                            <th class="py-2 px-4 border">Total Price</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr class="text-center">
                            <td class="py-2 px-4 border"><%= car.getModel()%></td>
                            <td class="py-2 px-4 border">
                                <% for (Service ser : listService) {%>
                                <p style="text-align: left;">-<%= ser.getServiceName()%></p>
                                <% } %>
                            </td>
                            <td class="py-2 px-4 border">
                                <% for (Mechanic mecha : listMecha) {%>
                                <p><%= mecha.getName()%></p>
                                <% } %>
                            </td>
                            <td class="py-2 px-4 border">
                                <% for (ServiceMechanic serMecha : listSm) {%>
                                <p><%= serMecha.getHours()%></p>
                                <% } %>
                            </td>
                            <td class="py-2 px-4 border">
                                <% for (Parts par : listParts) {%>
                                <p style="text-align: left;">-<%= par.getPartName()%></p>
                                <% } %>
                            </td>
                            <td class="py-2 px-4 border">
                                <% for (PartsUsed pu : listPu) {%>
                                <p><%= pu.getNumberUsed()%></p>
                                <% } %>
                            </td>
                            <td class="py-2 px-4 border">
                                <% for (PartsUsed pu : listPu) {%>
                                <p><%= pu.getPrice()%></p>
                                <% } %>
                            </td>
                            <td class="py-2 px-4 border">
                                <% for (ServiceMechanic serMecha : listSm) {%>
                                <p><%= serMecha.getRate()%></p>
                                <% }%>
                            </td>
                            <td class="py-2 px-4 border font-bold text-green-600">
                                <%= std.getTotalPriceServiceTicket("" + st.getServiceTicketID())%>
                            </td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <% } %>

            <br/>
            <a href="MainServlet?action=custDashboard" class="mt-4 inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-lg">Back home</a>
        </div>
        <%
            }
        %>
        <%@include file="footer.jsp" %>
    </body>
</html>
