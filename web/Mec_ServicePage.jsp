<%-- 
    Document   : ServicePage
    Created on : Mar 4, 2025, 11:12:35 PM
    Author     : Admin
--%>

<%@page import="model.Service"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Mechanic"%>
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
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        <%@include  file="header.jsp"%>
        <h1 class="text-3xl font-bold text-center my-6 text-gray-800 uppercase tracking-wide">
            Service List
        </h1>

        <div class="container mx-auto px-4">
            <%
                ArrayList<Service> listS = (ArrayList<Service>) session.getAttribute("LIST_SERVICE");
                if (listS != null && !listS.isEmpty()) {
            %>

            <div class="overflow-x-auto">
                <table class="w-full border border-gray-300 shadow-lg rounded-lg overflow-hidden">
                    <thead class="bg-blue-500 text-white">
                        <tr>
                            <th class="py-3 px-6 text-left">Service ID</th>
                            <th class="py-3 px-6 text-left">Service Name</th>
                            <th class="py-3 px-6 text-left">Hourly Rate</th>
                            <th class="py-3 px-6 text-center">Actions</th>
                        </tr>
                    </thead>
                    <tbody class="bg-white text-gray-700">
                        <%
                            for (Service s : listS) {
                        %>  
                        <tr class="border-b border-gray-300 hover:bg-gray-100 transition">
                            <td class="py-3 px-6"><%= s.getServiceID()%></td>
                            <td class="py-3 px-6 font-medium"><%= s.getServiceName()%></td>
                            <td class="py-3 px-6 text-green-600 font-semibold">$<%= s.getHourlyRate()%>/hr</td>
                            <td class="py-3 px-6 flex justify-center space-x-4">
                                <a href="MainServlet?action=mec_updateServicePage&serviceid=<%= s.getServiceID()%>" 
                                   class="px-4 py-2 bg-yellow-500 text-white rounded-lg hover:bg-yellow-600 transition">
                                    Update
                                </a>
                                <a href="MainServlet?action=mec_deleteServicePage&serviceid=<%= s.getServiceID()%>" 
                                   class="px-4 py-2 bg-red-500 text-white rounded-lg hover:bg-red-600 transition">
                                    Delete
                                </a>
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

            <div class="text-center mt-8">
                <a href="MainServlet?action=mec_createNewServicePage" 
                   class="px-6 py-2 bg-green-500 text-white text-[20px] rounded-lg shadow-lg hover:bg-green-600 transition-all transform hover:scale-105">
                    + Create New Service
                </a>
            </div>

            <h3 class="text-center text-red-500 mt-4 font-semibold text-lg">
                <%
                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                %>
            </h3>
        </div>

        <br/>
        <div class="text-center mt-8 mb-5">
            <a href="MainServlet?action=mecDashboard" 
               class="px-6 py-3 bg-blue-500 text-white font-semibold rounded-lg shadow-lg 
              hover:bg-blue-600 transition-all transform hover:scale-105">
                ⬅ Back Home
            </a>
        </div>

        <%
            }
        %>
        
    </body>
</html>
