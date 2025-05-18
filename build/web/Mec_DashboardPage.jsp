<%-- 
    Document   : MechanicPage
    Created on : Mar 2, 2025, 11:47:46 PM
    Author     : Admin
--%>

<%@page import="model.Service"%>
<%@page import="DAO.ServiceDAO"%>
<%@page import="model.ServiceMechanic"%>
<%@page import="model.ServiceTicket"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Mechanic"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealership</title>
        <link rel="stylesheet" href="page.css"/>
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="./styles/mystyle.css"/>
    </head>
    <body>
        
        <%
            Mechanic mecha = (Mechanic) session.getAttribute("Mecha");
            if (mecha == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        
        <%@include  file="header.jsp"%>
        <div class="container mx-auto p-6 min-h-screen">
    
            <h2 class="text-3xl font-bold text-center text-black mb-6">Welcome <%= mecha.getName()%></h2>

            <div class="flex justify-center space-x-4 mb-8">
                <a href="MainServlet?action=Logout" class="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700">Logout</a>
            </div>

            <h1 class="text-2xl font-bold text-center text-black mb-6">Search Service Ticket</h1>

            <div class="flex justify-center space-x-4 mb-4">
                <label class="flex items-center space-x-2">
                    <input type="radio" name="role" value="id" onclick="showSearch('id')" class="mr-2"> <span>ID</span>
                </label>
                <label class="flex items-center space-x-2">
                    <input type="radio" name="role" value="date" onclick="showSearch('date')" class="mr-2"> <span>Date</span>
                </label>
            </div>

            <div id="searchbyid" class="hidden text-center">
                <form action="MainServlet?action=mecFindByID" method="post" class="space-y-2">
                    <input type="text" name="custid" placeholder="Enter Customer's ID" class="border border-gray-400 px-4 py-2 rounded w-64"/><br/>
                    <input type="text" name="carid" placeholder="Enter Car's ID" class="border border-gray-400 px-4 py-2 rounded w-64"/>
                    </br>
                    <input type="submit" value="Find" class="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700"/>
                </form>
            </div>

            <div id="searchbydate" class="hidden text-center">
                <form action="MainServlet?action=mecFindByDate" method="post" class="space-y-2">
                    <input type="text" name="date" placeholder="Enter date" class="border border-gray-400 px-4 py-2 rounded w-64"/>
                    <input type="submit" value="Find" class="bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700"/>
                </form>
            </div>

            <h1 class="text-2xl font-bold text-center text-black mb-6">DASHBOARD</h1>
            <ul class="flex justify-center space-x-6 text-lg">
                <li><a href="MainServlet?action=mecView" class="text-blue-600 hover:text-blue-800">Service tickets</a></li>
                <li><a href="MainServlet?action=mec_GetServices" class="text-blue-600 hover:text-blue-800">Service</a></li>
            </ul>

            <%
                ArrayList<ServiceTicket> listSt = (ArrayList<ServiceTicket>) session.getAttribute("LIST_SERVICETICKET");
                if (listSt != null && !listSt.isEmpty()) {
            %>
            <h2 class="text-2xl font-bold text-center text-black my-6">Service Ticket List</h2>

            <table class="w-full border-collapse border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Service Ticket ID</th>
                        <th class="border border-gray-400 px-4 py-2">Customer ID</th>
                        <th class="border border-gray-400 px-4 py-2">Car ID</th>
                        <th class="border border-gray-400 px-4 py-2">Date Received</th>
                        <th class="border border-gray-400 px-4 py-2">Date Returned</th>
                        <th class="border border-gray-400 px-4 py-2">Actions</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ServiceTicket st : listSt) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= st.getServiceTicketID()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= st.getCustID()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= st.getCarID()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= st.getDateReceived()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= st.getDateReturned()%></td>
                        <td class="border border-gray-400 px-4 py-2">
                            <form action="MainServlet" method="post">
                                <input type="hidden" value="<%= st.getServiceTicketID()%>" name="serviceticketid">    
                                <input type="submit" value="Detail" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">
                                <input type="hidden" value="mecDetailService" name="action">
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
            <%
                }
            %>
        </div>

        
        <h3>
            <%
                if (request.getAttribute("ERROR") != null) {
                    out.print(request.getAttribute("ERROR"));
                }
            %>
        </h3>
        
        <%
            }
        %>
        
        <script src="./stylejs/effect.js"></script>
    </body>
</html>
