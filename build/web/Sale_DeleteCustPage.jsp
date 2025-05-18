<%-- 
    Document   : Sale_DeleteCustPage
    Created on : Mar 8, 2025, 8:30:03 PM
    Author     : Admin
--%>

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
                String id = request.getParameter("custid");
        %>
        <%@include file="header.jsp" %>
        <div class="bg-white p-6 rounded-lg shadow-lg text-center">
            <h1 class="text-2xl font-bold text-red-600 mb-4">Are you sure you want to delete this Customer?</h1>
            <p class="text-gray-700 mb-6">This action cannot be undone.</p>

            <form action="MainServlet" method="post">
                <input type="hidden" value="<%= id%>" name="custid">
                <input type="hidden" value="sale_deleteCust" name="action">

                <div class="flex justify-center gap-4">
                    <button type="submit" class="px-4 py-2 bg-red-600 text-white rounded-lg hover:bg-red-700 transition">
                        Yes, Delete
                    </button>
                    <a href="MainServlet?action=sale_custPage" class="px-4 py-2 bg-gray-300 text-gray-700 rounded-lg hover:bg-gray-400 transition">
                        Cancel
                    </a>
                </div>
            </form>
        </div>
        <%
            }
        %>
       
    </body>
</html>
