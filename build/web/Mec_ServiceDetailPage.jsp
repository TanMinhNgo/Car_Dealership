<%-- 
    Document   : ServiceMechaDetailPage
    Created on : Mar 3, 2025, 4:53:16 PM
    Author     : Admin
--%>

<%@page import="model.Mechanic"%>
<%@page import="model.Service"%>
<%@page import="DAO.ServiceDAO"%>
<%@page import="model.ServiceMechanic"%>
<%@page import="java.util.ArrayList"%>
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
            Mechanic mecha = (Mechanic) session.getAttribute("Mecha");
            if (mecha == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("MainServlet?action=loginPage").forward(request, response);
            } else {
        %>
        <%@include  file="header.jsp"%>
        <h1 class="text-2xl font-bold text-center my-4">Service Ticket List</h1>

        <%
            ArrayList<ServiceMechanic> listSm = (ArrayList<ServiceMechanic>) session.getAttribute("SERVICETICKET_DETAIL");
            if (listSm != null && !listSm.isEmpty()) {
        %>

        <div class="flex justify-center">
            <table class="border-collapse border border-gray-400 w-3/4 shadow-lg">
                <thead>
                    <tr class="bg-gray-200">
                        <th class="border border-gray-400 px-4 py-2">Service Ticket ID</th>
                        <th class="border border-gray-400 px-4 py-2">Service Name</th>
                        <th class="border border-gray-400 px-4 py-2">Hours</th>
                        <th class="border border-gray-400 px-4 py-2">Comment</th>
                        <th class="border border-gray-400 px-4 py-2">Rate</th>
                        <th class="border border-gray-400 px-4 py-2">Action</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        for (ServiceMechanic sm : listSm) {
                            ServiceDAO sd = new ServiceDAO();
                            Service ser = sd.getService("" + sm.getServiceID());
                    %>
                    <tr class="text-center bg-white hover:bg-gray-100">
                        <td class="border border-gray-400 px-4 py-2"><%= sm.getServiceTicketID()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= ser.getServiceName()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= sm.getHours()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= sm.getComment()%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= sm.getRate()%></td>
                        <td class="border border-gray-400 px-4 py-2">
                            <form action="MainServlet" method="post">
                                <input type="hidden" value="<%= sm.getServiceTicketID()%>" name="serviceticketid">
                                <input type="hidden" value="<%= sm.getServiceID()%>" name="serviceid">
                                <input type="hidden" value="mecUpdateServiceTicket" name="action">
                                <button type="submit" class="bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-600 transition">Update</button>
                            </form>
                        </td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>
        </div>
        <%
            }
        %>
        <br/>
        <div class="flex justify-center mt-6 mb-6">
            <a href="MainServlet?action=mecDashboard" 
               class="bg-blue-500 text-white px-6 py-3 rounded-lg shadow-md hover:bg-blue-600 transition duration-300 ease-in-out">
                ← Back Home
            </a>
        </div>


       
        <h3>
            <%
                if (request.getAttribute("ERROR") != null) {
                    out.print(request.getAttribute("ERROR"));
                }
            %>
        </h3>
        <br/>
        <%
            }
        %>
    </body>
</html>
