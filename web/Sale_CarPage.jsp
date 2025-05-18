<%-- 
    Document   : Sale_CarPage
    Created on : Mar 6, 2025, 2:38:58 PM
    Author     : Admin
--%>

<%@page import="model.Car"%>
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
        <div class="container mx-auto p-6">
            <h1 class="text-2xl font-bold text-center text-blue-600 mb-6">Car List</h1>

            <!-- Search Form -->
            <div class="flex justify-end mb-6">
                <form action="MainServlet" class="flex space-x-2">
                    <input type="text" name="serialnumber" placeholder="Enter Car's serial number"
                           class="p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"/>

                    <input type="text" name="model" placeholder="Enter Car's model"
                           class="p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"/>

                    <input type="text" name="year" placeholder="Enter Car's year"
                           class="p-2 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"/>

                    <input type="hidden" name="action" value="sale_findCar">
                    <input type="submit" value="Find Car"
                           class="px-4 py-2 bg-blue-600 text-white font-semibold rounded-md shadow-md 
                           hover:bg-blue-700 transition-all transform hover:scale-105 cursor-pointer"/>
                </form>
            </div>

            <!-- Car List Table -->
            <%
                ArrayList<Car> listCar = (ArrayList) s.getAttribute("SALE_LISTCAR");
                if (listCar != null && !listCar.isEmpty()) {
            %>
            <div class="overflow-x-auto">
                <table class="w-full border-collapse border border-gray-300 bg-white shadow-lg">
                    <thead>
                        <tr class="bg-gray-200 text-gray-700">
                            <th class="border border-gray-300 p-3">Car ID</th>
                            <th class="border border-gray-300 p-3">Serial Number</th>
                            <th class="border border-gray-300 p-3">Model</th>
                            <th class="border border-gray-300 p-3">Year</th>
                            <th class="border border-gray-300 p-3">Colour</th>
                            <th class="border border-gray-300 p-3"></th>
                            <th class="border border-gray-300 p-3"></th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Car car : listCar) {
                        %>  
                        <tr class="border border-gray-300 text-center">
                            <td class="p-3"><%= car.getCarID()%></td>
                            <td class="p-3"><%= car.getSerialNumber()%></td>
                            <td class="p-3"><%= car.getModel().toUpperCase()%></td>
                            <td class="p-3"><%= car.getYear()%></td>
                            <td class="p-3"><%= car.getColour()%></td>
                            <td class="p-3">
                                <a href="MainServlet?action=sale_updateCarPage&carid=<%= car.getCarID()%>"
                                   class="text-blue-600 hover:underline">Update</a>
                            </td>
                            <td class="p-3">
                                <a href="MainServlet?action=sale_deleteCarPage&carid=<%= car.getCarID()%>"
                                   class="text-red-600 hover:underline">Delete</a>
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

            <!-- Create New Car & Back Home -->
            <div class="flex justify-between mt-6">
                <a href="MainServlet?action=sale_createCarPage"
                   class="px-4 py-2 bg-green-600 text-white font-semibold rounded-md shadow-md 
                   hover:bg-green-700 transition-all transform hover:scale-105">
                    Create New Car
                </a>
                <a href="MainServlet?action=salePersonPage"
                   class="px-4 py-2 bg-gray-500 text-white font-semibold rounded-md shadow-md 
                   hover:bg-gray-600 transition-all transform hover:scale-105">
                    Back Home
                </a>
            </div>

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


        <%
            }
        %>
        
    </body>
</html>
