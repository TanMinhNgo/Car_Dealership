<%-- 
    Document   : Sale_PartPage
    Created on : Mar 6, 2025, 2:54:17 PM
    Author     : Admin
--%>

<%@page import="model.Parts"%>
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
            HttpSession s = request.getSession();
            if (sale == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <div class="flex justify-center items-center min-h-screen bg-gray-100 mb-5">
        <div class="bg-white p-6 rounded-lg shadow-lg w-full max-w-4xl">
            <h1 class="text-2xl font-bold text-gray-800 mb-4 text-center">Parts List</h1>

            <!-- Search Form -->
            <form action="MainServlet" method="get" class="mb-4 flex gap-3">
                <input type="text" name="partname" placeholder="Enter Part's name" class="w-full p-2 border rounded-lg"/>
                <input type="submit" value="Find Part" class="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition"/>
                <input type="hidden" value="sale_findPart" name="action">
            </form>

            <!-- Parts Table -->
            <%
                ArrayList<Parts> listParts = (ArrayList) s.getAttribute("SALE_LISTPARTS");
                if (listParts != null && !listParts.isEmpty()) {
            %>
            <div class="overflow-x-auto">
                <table class="w-full border-collapse border border-gray-300 bg-white shadow-md rounded-lg">
                    <thead class="bg-gray-200">
                        <tr>
                            <th class="border border-gray-300 px-4 py-2">Part ID</th>
                            <th class="border border-gray-300 px-4 py-2">Part Name</th>
                            <th class="border border-gray-300 px-4 py-2 text-right">Purchase Price</th>
                            <th class="border border-gray-300 px-4 py-2 text-right">Retail Price</th>
                            <th class="border border-gray-300 px-4 py-2">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Parts part : listParts) {
                        %>  
                        <tr class="hover:bg-gray-100">
                            <td class="border border-gray-300 px-4 py-2"><%= part.getPartID()%></td>
                            <td class="border border-gray-300 px-4 py-2"><%= part.getPartName()%></td>
                            <td class="border border-gray-300 px-4 py-2 text-right"><%= part.getPurchasePrice()%></td>
                            <td class="border border-gray-300 px-4 py-2 text-right"><%= part.getRetailPrice()%></td>
                            <td class="border border-gray-300 px-4 py-2 text-center">
                                <a href="MainServlet?action=sale_updatePartPage&partid=<%= part.getPartID()%>" class="text-blue-600 hover:underline">Update</a> | 
                                <a href="MainServlet?action=sale_deletePartPage&partid=<%= part.getPartID()%>" class="text-red-600 hover:underline">Delete</a>
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

            <!-- Create New Part -->
            <p class="mt-4">
                <a href="MainServlet?action=sale_createPartPage" class="px-4 py-2 bg-green-600 text-white rounded-lg hover:bg-green-700 transition">Create New Part</a>
            </p>

            <!-- Error or Success Message -->
            <h3 class="mt-4 text-red-500">
                <%
                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                %>
            </h3>

            <!-- Back Home -->
            <a href="MainServlet?action=salePersonPage" class="block text-center mt-6 px-4 py-2 bg-gray-500 text-white rounded-lg hover:bg-gray-600 transition">
                Back to Home
            </a>
        </div> 
            </div>
        <%
            }
        %>
       
    </body>
</html>
