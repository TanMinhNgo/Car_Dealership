<%-- 
    Document   : WishListPage
    Created on : Mar 2, 2025, 12:45:34 AM
    Author     : Admin
--%>

<%@page import="model.Customer"%>
<%@page import="model.Car"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car Dealership</title>
        <script src="https://cdn.tailwindcss.com"></script>
        <link rel="stylesheet" href="./styles/mystyle.css" />
    </head>
    <body class="bg-gray-100 text-gray-900">
        <%
            Customer cust = (Customer) session.getAttribute("User");
            if (cust == null) {
                request.setAttribute("ERROR1", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        <div class="container mx-auto p-6">
            <h1 class="text-4xl font-bold text-center text-blue-600 mb-6">Car Wishlist</h1>
            <%
                ArrayList<Car> listcar = (ArrayList) session.getAttribute("WISHLIST");
                if (listcar != null && !listcar.isEmpty()) {
                    for (Car c : listcar) {
            %>
            <div class="bg-white shadow-md rounded-lg mb-6 p-4">
                <table class="table-auto w-full text-left">
                    <tbody>
                        <tr>
                            <td class="font-semibold">Car ID:</td>
                            <td class="text-gray-700"><%= c.getCarID()%></td>
                        </tr>
                        <tr>
                            <td class="font-semibold">Car Model:</td>
                            <td class="text-gray-700"><%= c.getModel().toUpperCase()%></td>
                        </tr>
                        <tr>
                            <td class="font-semibold">Serial Number:</td>
                            <td class="text-gray-700"><%= c.getSerialNumber()%></td>
                        </tr>
                        <tr>
                            <td class="font-semibold">Year:</td>
                            <td class="text-gray-700"><%= c.getYear()%></td>
                        </tr>
                    </tbody>
                </table>
                <form action="MainServlet?action=Remove&carid=<%=c.getCarID()%>" method="post" class="mt-4">
                    <button type="submit" 
                            class="bg-red-500 text-white px-4 py-2 rounded hover:bg-red-600 transition">
                        Remove
                    </button>
                </form>
            </div>
            <%
                    }
                }
            %>
            <form action="MainServlet?action=saveWishlist" class="text-center">
                <button type="submit" 
                        class="bg-green-500 text-white px-6 py-3 rounded shadow-lg hover:bg-green-600 transition" value="Booking" name="action">
                    Booking
                </button>
            </form>
            <%
                if (request.getAttribute("ERROR") != null) {
            %>
            <div class="text-red-500 font-medium text-center mt-4"><%= request.getAttribute("ERROR")%></div>
            <%
            } else if (request.getAttribute("SUCCESS") != null) {
            %>
            <div class="text-green-500 font-medium text-center mt-4"><%= request.getAttribute("SUCCESS")%></div>
            <%
                }
            %>
            <div class="text-center mt-6">
                <a href="MainServlet?action=custDashboard" class="text-blue-500 hover:underline">Back</a>
            </div>
        </div>
        <%
            }
        %>
    </body>
</html>