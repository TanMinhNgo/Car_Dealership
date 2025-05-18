<%-- 
    Document   : Sale_CreateStPage
    Created on : Mar 9, 2025, 6:43:04 PM
    Author     : Admin
--%>

<%@page import="model.ServiceTicket"%>
<%@page import="model.Mechanic"%>
<%@page import="model.Service"%>
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
                ServiceTicket newTicket = (ServiceTicket) session.getAttribute("SERVICETICKET_NEW");
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6">
            <h1 class="text-2xl font-bold text-center text-blue-600 mb-6">Add Service Mechanic</h1>

            <div class="max-w-lg mx-auto bg-white p-6 rounded-lg shadow-md">
                <form action="MainServlet" class="space-y-4">
                    <!-- Hidden Service Ticket ID -->
                    <input type="hidden" name="serviceticketid" value="<%= newTicket.getServiceTicketID()%>"/>

                    <!-- Service Selection -->
                    <div>
                        <label class="block text-gray-700 font-medium">Select Service:</label>
                        <select name="serviceid" class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none">
                            <option value="" disabled selected>-- Choose Service --</option>
                            <%
                                ArrayList<Service> listser = (ArrayList) session.getAttribute("SALE_STLISTSER");
                                if (listser != null && !listser.isEmpty()) {
                                    for (Service ser : listser) {
                            %>
                            <option value="<%= ser.getServiceID()%>"><%= ser.getServiceID()%> - <%= ser.getServiceName()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>

                    <!-- Mechanic Selection -->
                    <div>
                        <label class="block text-gray-700 font-medium">Select Mechanic:</label>
                        <select name="mechaid" class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none">
                            <option value="" disabled selected>-- Choose Mechanic --</option>
                            <%
                                ArrayList<Mechanic> listmecha = (ArrayList) session.getAttribute("SALE_STLISTMECHA");
                                if (listmecha != null && !listmecha.isEmpty()) {
                                    for (Mechanic mecha : listmecha) {
                            %>
                            <option value="<%= mecha.getId()%>"><%= mecha.getId()%> - <%= mecha.getName()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>

                    <!-- Buttons -->
                    <div class="flex justify-between">
                        <button type="submit" class="px-4 py-2 bg-blue-600 text-white font-semibold rounded-md shadow-md 
                                hover:bg-blue-700 transition-all transform hover:scale-105">
                            Add Service Mechanic
                        </button>
                        <input type="hidden" value="sale_addServiceMechanic" name="action">
                    </div>

                    <div class="flex justify-between mt-4">
                        <a href="MainServlet?action=sale_justSmSt" 
                           class="px-4 py-2 bg-green-600 text-white font-semibold rounded-md shadow-md 
                           hover:bg-green-700 transition-all transform hover:scale-105">
                            Submit
                        </a>
                        <a href="MainServlet?action=sale_createStPage2" 
                           class="px-4 py-2 bg-orange-500 text-white font-semibold rounded-md shadow-md 
                           hover:bg-orange-600 transition-all transform hover:scale-105">
                            Add Parts
                        </a>
                    </div>
                </form>

                <!-- Error or Success Message -->
                <h3 class="text-center text-red-500 mt-4">
                    <%
                        if (request.getAttribute("ERROR") != null) {
                            out.print(request.getAttribute("ERROR"));
                        } else if (request.getAttribute("SUCCESS") != null) {
                            out.print(request.getAttribute("SUCCESS"));
                        }
                    %>
                </h3>

                <br/>
                <a href="MainServlet?action=sale_createSt" 
                   class="block text-center text-gray-600 hover:text-gray-900 font-semibold mt-4">
                    ← Back
                </a>
            </div>
        </div>

        <%
            }
        %>
       
    </body>
</html>
