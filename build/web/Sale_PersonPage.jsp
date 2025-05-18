<%-- 
    Document   : SalePersonPage
    Created on : Mar 5, 2025, 10:28:52 PM
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
                request.getRequestDispatcher("MainServlet?action=loginPage").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6 min-h-screen">
            <!-- Tiêu đề & Đăng xuất -->
            <h2 class="text-3xl font-bold text-center text-black mb-6">Welcome <%= sale.getName()%></h2>

            <div class="flex justify-center mb-6">
                <a href="MainServlet?action=Logout" class="bg-red-600 text-white px-4 py-2 rounded hover:bg-red-700">Logout</a>
            </div>

            <!-- Dashboard -->
            <h1 class="text-2xl font-bold text-center text-black mb-6">DASHBOARD</h1>

            <ul class="grid grid-cols-3 gap-4 text-center text-lg">
                <li><a href="MainServlet?action=sale_customer" class="block bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Customer</a></li>
                <li><a href="MainServlet?action=sale_car" class="block bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Car</a></li>
                <li><a href="MainServlet?action=sale_serviceTicket" class="block bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Service Ticket</a></li>
                <li><a href="MainServlet?action=sale_part" class="block bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Part</a></li>
                <li><a href="MainServlet?action=sale_invoice" class="block bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Create Invoice</a></li>
                <li><a href="MainServlet?action=sale_reportPage" class="block bg-blue-500 text-white px-4 py-2 rounded hover:bg-blue-700">Report</a></li>
            </ul>

            <!-- Hiển thị thông báo lỗi -->
            <h3 class="text-center text-red-500 mt-6">
                <%
                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    }
                %>
            </h3>

        </div>


        <%
            }
        %>
        
    </body>
</html>
