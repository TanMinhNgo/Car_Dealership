<%-- 
    Document   : UpdateServicePage
    Created on : Mar 5, 2025, 12:33:51 AM
    Author     : Admin
--%>

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
                String serviceID = request.getParameter("serviceid");
        %>
        <%@include file="header.jsp"%>
        <div class="max-w-md mx-auto mt-10 p-6 bg-white shadow-lg rounded-lg">
            <h1 class="text-2xl font-bold text-center mb-6 text-gray-800">Update the Service</h1>

            <form action="MainServlet" method="post" class="space-y-4">
                <input type="hidden" value="<%= serviceID%>" name="id">

                <div>
                    <input type="text" name="hourlyrate" placeholder="Enter new Service's hourly rate"
                           class="w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500">
                </div>

                <div class="text-center">
                    <input type="submit" value="Submit"
                           class="px-6 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md 
                           hover:bg-blue-600 transition-all transform hover:scale-105 cursor-pointer">
                </div>

                <input type="hidden" value="mec_updateService" name="action">
            </form>

            <h3 class="text-center mt-4 text-red-500 font-medium">
                <%
                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                %>
            </h3>
        </div>

        <div class="text-center mt-6">
            <a href="MainServlet?action=mec_servicePage" 
               class="px-6 py-2 bg-gray-500 text-white font-semibold rounded-lg shadow-md 
               hover:bg-gray-600 transition-all transform hover:scale-105">
                Back
            </a>
        </div>

        <%
            }
        %>
        
    </body>
</html>
