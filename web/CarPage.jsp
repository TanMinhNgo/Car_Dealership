<%@page import="model.Customer"%>
<%@page import="model.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealership</title>
        <!-- Thêm Tailwind CSS -->
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="./styles/mystyle.css" />
    </head>
    <body class="bg-white text-gray-800 font-sans">
        <%
            Customer cust = (Customer) session.getAttribute("User");
            if (cust == null) {
                request.setAttribute("ERROR1", "Unauthorized access!!");
                request.getRequestDispatcher("MainServlet?action=loginPage").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <h1 class="text-3xl font-bold text-center my-6 text-gray-800">🚗 Car Information You Searched For</h1>

        <div class="container mx-auto px-4">
            <%
                ArrayList<Car> list = (ArrayList<Car>) session.getAttribute("LIST_CAR");
                if (list != null && !list.isEmpty()) {
            %>

            <!-- Grid Layout -->
            <div class="flex justify-center">
                <div class="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-3 gap-6">
                    <%
                        for (Car c : list) {
                    %>
                    <div class="border border-gray-300 p-4 rounded-lg shadow-lg bg-white transition transform hover:scale-105">
                        <h2 class="text-lg font-semibold text-gray-800 mb-2">🚘 Model: <%= c.getModel().toUpperCase()%></h2>
                        <p class="text-gray-600 mb-2">
                            <span class="font-medium">🔑 Car ID:</span> <%= c.getCarID()%>
                        </p>

                        <!-- Wishlist Button -->
                        <a href="MainServlet?action=addWishlist&carid=<%= c.getCarID()%>" 
                           class="flex justify-center inline-block px-4 py-2 bg-green-500 text-white rounded-md hover:bg-green-600 transition">
                            ❤ Add to Wishlist
                        </a>
                    </div>
                    <%
                        }
                    %>
                </div>
            </div>
            <%
            } else {
            %>
            <p class="text-center text-gray-500 text-lg mt-4">❌ No cars found.</p>
            <%
                }
            %>
        </div>

        <!-- Back Home Button -->
        <div class="text-center mt-8 mb-5">
            <a href="MainServlet?action=custDashboard" 
               class="px-6 py-3 bg-blue-600 text-white text-lg font-semibold rounded-md hover:bg-blue-700 transition shadow-md">
                ⬅️ Back to Home
            </a>
        </div>


        <%
            }
        %>
        <%@include file="footer.jsp" %>
    </body>
</html>
