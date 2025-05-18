<%-- 
    Document   : DeleteServicePage
    Created on : Mar 5, 2025, 3:15:41 AM
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
        <%@include  file="header.jsp"%>
        <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
            <div class="bg-white p-6 rounded-lg shadow-md text-center">
                <h1 class="text-xl font-bold text-red-600 mb-4">Are you sure you want to delete this Service?</h1>

                <form action="MainServlet" class="space-y-4">
                    <input type="hidden" value="<%= serviceID%>" name="serviceid">
                    <input type="hidden" value="mec_deleteService" name="action">

                    <div class="flex justify-center space-x-4">
                        <input type="submit" value="Sure" 
                               class="px-6 py-2 bg-red-600 text-white font-semibold rounded-lg shadow-md 
                               hover:bg-red-700 transition-all transform hover:scale-105 cursor-pointer"/>

                        <a href="MainServlet?action=mec_servicePage" 
                           class="px-6 py-2 bg-gray-500 text-white font-semibold rounded-lg shadow-md 
                           hover:bg-gray-600 transition-all transform hover:scale-105">
                            Cancel
                        </a>
                    </div>
                </form>
            </div>
        </div>

        <%
            }
        %>
      
    </body>
</html>
