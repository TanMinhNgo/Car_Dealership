<%-- 
    Document   : UpdateTicketPage
    Created on : Mar 3, 2025, 5:04:35 PM
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
        %>
        <%@include file="header.jsp" %>
        <div class="flex flex-col items-center justify-center min-h-screen bg-gray-100">
            <div class="bg-white p-6 rounded-lg shadow-md w-96">
                <h1 class="text-xl font-bold text-center text-blue-600 mb-4">Update the Service Ticket</h1>

                <form action="MainServlet" method="post" class="space-y-4">
                    <input type="text" name="hours" placeholder="Enter new hours"
                           class="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none"/>

                    <input type="text" name="comment" placeholder="Enter new comment"
                           class="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none"/>

                    <input type="text" name="rate" placeholder="Enter new rate"
                           class="w-full p-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-400 focus:outline-none"/>

                    <input type="hidden" value="mecUpdateNewServiceTicket" name="action">

                    <div class="flex justify-between">
                        <input type="submit" value="Submit"
                               class="px-6 py-2 bg-blue-600 text-white font-semibold rounded-lg shadow-md 
                               hover:bg-blue-700 transition-all transform hover:scale-105 cursor-pointer"/>

                        <a href="MainServlet?action=mecDetailServicePage"
                           class="px-6 py-2 bg-gray-500 text-white font-semibold rounded-lg shadow-md 
                           hover:bg-gray-600 transition-all transform hover:scale-105">
                            Back
                        </a>
                    </div>
                </form>

                <h3 class="text-center text-red-500 mt-4">
                    <%
                        if (request.getAttribute("ERROR") != null) {
                            out.print(request.getAttribute("ERROR"));
                        } else if (request.getAttribute("SUCCESS") != null) {
                            out.print(request.getAttribute("SUCCESS"));
                        }
                    %>
                </h3>
            </div>
        </div>

        <%
            }
        %>
        
    </body>
</html>
