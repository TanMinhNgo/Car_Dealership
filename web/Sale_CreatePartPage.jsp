<%-- 
    Document   : Sale_CreatePartPage
    Created on : Mar 7, 2025, 10:19:00 PM
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
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6">
            <h1 class="text-2xl font-bold text-center text-blue-600 mb-6">Create New Part</h1>

            <div class="max-w-lg mx-auto bg-white p-6 rounded-lg shadow-md">
                <form action="Sale_CreatePartServlet" method="post" class="space-y-4">
                    <div>
                        <input type="text" name="partname" placeholder="Enter Part's name"
                               class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"
                               required/>
                    </div>

                    <div>
                        <input type="text" name="partpurchaseprice" placeholder="Enter Part's purchase price"
                               class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"
                               required/>
                    </div>

                    <div>
                        <input type="text" name="partretailprice" placeholder="Enter Part's retail price"
                               class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"
                               required/>
                    </div>

                    <div class="flex justify-between">
                        <button type="submit"
                                class="px-4 py-2 bg-blue-600 text-white font-semibold rounded-md shadow-md 
                                hover:bg-blue-700 transition-all transform hover:scale-105">
                            Submit
                        </button>

                        <a href="MainServlet?action=sale_part"
                           class="px-4 py-2 bg-gray-500 text-white font-semibold rounded-md shadow-md 
                           hover:bg-gray-600 transition-all transform hover:scale-105">
                            Back
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
            </div>
        </div>

        <%
            }
        %>
        
    </body>
</html>
