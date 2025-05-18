<%-- 
    Document   : Sale_CreateStPage
    Created on : Mar 9, 2025, 6:43:04 PM
    Author     : Admin
--%>

<%@page import="model.Car"%>
<%@page import="model.Customer"%>
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
            if (sale == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("MainServlet?action=loginPage").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6">
            <h1 class="text-2xl font-bold text-center text-blue-600 mb-6">Create New Service Ticket</h1>

            <div class="max-w-lg mx-auto bg-white p-6 rounded-lg shadow-md">
                <form action="MainServlet" class="space-y-4">
                    <!-- Customer Selection -->
                    <div>
                        <label class="block text-gray-700 font-medium">Select Customer:</label>
                        <select name="custid" class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none">
                            <option value="" disabled selected>-- Choose Customer --</option>
                            <%
                                ArrayList<Customer> listcust = (ArrayList) session.getAttribute("SALE_STLISTCUST");
                                if (listcust != null && !listcust.isEmpty()) {
                                    for (Customer cust : listcust) {
                            %>
                            <option value="<%= cust.getCustid()%>"><%= cust.getCustid()%> - <%= cust.getCustname()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>

                    <!-- Car Selection -->
                    <div>
                        <label class="block text-gray-700 font-medium">Select Car:</label>
                        <select name="carid" class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none">
                            <option value="" disabled selected>-- Choose Car --</option>
                            <%
                                ArrayList<Car> listcar = (ArrayList) session.getAttribute("SALE_STLISTCAR");
                                if (listcar != null && !listcar.isEmpty()) {
                                    for (Car car : listcar) {
                            %>
                            <option value="<%= car.getCarID()%>"><%= car.getCarID()%> - <%= car.getModel()%></option>
                            <%
                                    }
                                }
                            %>
                        </select>
                    </div>

                    <!-- Date Received -->
                    <div>
                        <label class="block text-gray-700 font-medium">Receive Date:</label>
                        <input type="date" name="datereceived" id="datereceived"
                               class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none" required/>
                    </div>

                    <!-- Date Returned -->
                    <div>
                        <label class="block text-gray-700 font-medium">Return Date:</label>
                        <input type="date" name="datereturned" id="datereturned" 
                               class="w-full p-3 border border-gray-300 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none" required/>
                    </div>

                    <!-- Buttons -->
                    <div class="flex justify-between">
                        <button type="submit" class="px-4 py-2 bg-blue-600 text-white font-semibold rounded-md shadow-md 
                                hover:bg-blue-700 transition-all transform hover:scale-105">
                            Next
                        </button>
                        <input type="hidden" value="sale_createSt1" name="action">

                        <a href="MainServlet?action=sale_serviceTicket" 
                           class="px-4 py-2 bg-gray-500 text-white font-semibold rounded-md shadow-md 
                           hover:bg-gray-600 transition-all transform hover:scale-105">
                            Cancel
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

        <!-- Script to validate dates -->
        <script>
            const dateReceived = document.getElementById("datereceived");
            const dateReturned = document.getElementById("datereturned");

            dateReturned.addEventListener("change", () => {
                const received = new Date(dateReceived.value);
                const returned = new Date(dateReturned.value);

                if (returned < received) {
                    alert("Return Date cannot be before Receive Date.");
                    dateReturned.value = ""; // Clear invalid input
                }
            });
        </script>
    </body>
</html>
