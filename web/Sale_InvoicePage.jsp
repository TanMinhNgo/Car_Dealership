<%-- 
    Document   : Sale_InvoicePage
    Created on : Mar 8, 2025, 10:02:29 PM
    Author     : Admin
--%>

<%@page import="model.Car"%>
<%@page import="DAO.CarDAO"%>
<%@page import="DAO.CustomerDAO"%>
<%@page import="model.WishList"%>
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
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
         <%@include file="header.jsp" %>
        <div class="container mx-auto p-6 min-h-screen">
    <h1 class="text-3xl font-bold text-center text-black mb-6">Customer Information</h1>

    <div class="max-w-lg mx-auto bg-white p-6 shadow-lg rounded-lg">
        <!-- Customer Selection Form -->
        <form action="MainServlet" method="post" class="space-y-4">
            <label class="block text-gray-700 font-semibold">Select Customer</label>
            <select name="custid" class="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400">
                <option value="" disabled selected>-- Choose Customer --</option>
                <%
                    ArrayList<Customer> listcust = (ArrayList) session.getAttribute("LISTCUST");
                    if (listcust != null && !listcust.isEmpty()) {
                        for (Customer cust : listcust) {
                %>
                <option value="<%=cust.getCustid()%>">
                    <%= cust.getCustid()%> - <%=cust.getCustname()%>
                </option>
                <%
                        }
                    }
                %>
            </select>

            <input type="hidden" value="sale_getWishlist" name="action">
            <button type="submit" class="w-full bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700">
                Get Wishlist
            </button>
        </form>
    </div>

    <!-- Display Wishlist if Available -->
    <%
        ArrayList<WishList> wishlist = (ArrayList) session.getAttribute("WISHLIST");
        if (wishlist != null && !wishlist.isEmpty()) {
            CustomerDAO cd = new CustomerDAO();
            Customer cust = cd.findCustomerByID(wishlist.get(0).getCustid());
            if (cust != null) {
    %>
    <h2 class="text-xl font-semibold text-center mt-6">Customer: <%= cust.getCustname() %></h2>

    <div class="max-w-2xl mx-auto bg-white p-6 shadow-lg rounded-lg mt-4">
        <table class="w-full border-collapse border border-gray-300">
            <thead>
                <tr class="bg-gray-200">
                    <th class="border p-2">Car ID</th>
                    <th class="border p-2">Model</th>
                    <th class="border p-2">Action</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<String> listcar = wishlist.get(0).getListcar();
                    for (String carid : listcar) {
                        CarDAO card = new CarDAO();
                        Car car = card.getCar(carid);
                %>
                <tr class="text-center">
                    <td class="border p-2"><%= car.getCarID() %></td>
                    <td class="border p-2"><%= car.getModel() %></td>
                    <td class="border p-2">
                        <form action="MainServlet" method="post">
                            <input type="hidden" name="carid" value="<%= car.getCarID() %>"/>
                            <input type="hidden" name="custid" value="<%= cust.getCustid() %>"/>
                            <input type="hidden" name="action" value="sale_createInvoice"/>
                            <button type="submit" class="bg-blue-600 text-white px-3 py-1 rounded-lg hover:bg-blue-700">
                                Create Invoice
                            </button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
    <%
        } else {
    %>
    <h3 class="text-red-600 text-center mt-4">This customer has not registered a wishlist.</h3>
    <%
        }
    }
    %>

    <!-- Error / Success Messages -->
    <h3 class="text-center text-red-600 mt-4">
        <%
            if (request.getAttribute("ERROR") != null) {
                out.print(request.getAttribute("ERROR"));
            } else if (request.getAttribute("SUCCESS") != null) {
                out.print(request.getAttribute("SUCCESS"));
            }
        %>
    </h3>

    <!-- Back Button -->
    <div class="text-center mt-6">
        <a href="MainServlet?action=salePersonPage"
           class="bg-gray-600 text-white px-4 py-2 rounded-lg hover:bg-gray-700">
            Back Home
        </a>
    </div>
</div>

        <%
            }
        %>
         
    </body>
</html>
