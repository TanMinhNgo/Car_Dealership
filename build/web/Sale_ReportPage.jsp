<%-- 
    Document   : Sale_ReportPage
    Created on : Mar 10, 2025, 12:28:34 AM
    Author     : Admin
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="mylib.DBUtils"%>
<%@page import="java.sql.Connection"%>
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
        <div class="container mx-auto p-6 min-h-screen mb-[500px]">
            <h1 class="text-3xl font-bold text-center text-black mb-6">Report List</h1>

            <!-- Car Sales Statistics by Year -->
            <h2 class="text-2xl font-semibold text-black mb-4">1. Car Sales Statistics by Year</h2>
            <table class="w-full border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Year</th>
                        <th class="border border-gray-400 px-4 py-2">Cars Sold</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        Connection cn = DBUtils.getConnection();
                        if (cn != null) {
                            String sql1 = "SELECT YEAR(invoiceDate) AS Year, COUNT(*) AS CarsSold FROM SalesInvoice GROUP BY YEAR(invoiceDate) ORDER BY Year";
                            PreparedStatement ps1 = cn.prepareStatement(sql1);
                            ResultSet rs1 = ps1.executeQuery();
                            while (rs1.next()) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= rs1.getInt("Year")%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= rs1.getInt("CarsSold")%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>

            <!-- Car Sales Revenue by Year -->
            <h2 class="text-2xl font-semibold text-black mt-6 mb-4">2. Car Sales Revenue by Year</h2>
            <table class="w-full border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Year</th>
                        <th class="border border-gray-400 px-4 py-2">Total Revenue</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String sql2 = "SELECT YEAR(si.invoiceDate) AS Year, SUM(c.price) AS TotalRevenue FROM SalesInvoice si JOIN Cars c ON si.carID = c.carID GROUP BY YEAR(si.invoiceDate) ORDER BY Year";
                        PreparedStatement ps2 = cn.prepareStatement(sql2);
                        ResultSet rs2 = ps2.executeQuery();
                        while (rs2.next()) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= rs2.getInt("Year")%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= rs2.getString("TotalRevenue")%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <!-- Best-Selling Car Models -->
            <h2 class="text-2xl font-semibold text-black mt-6 mb-4">3. Best-Selling Car Models</h2>
            <table class="w-full border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Model</th>
                        <th class="border border-gray-400 px-4 py-2">Units Sold</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String sql3 = "SELECT TOP 3 c.model AS CarModel, COUNT(si.carID) AS CarsSold FROM SalesInvoice si JOIN Cars c ON si.carID = c.carID GROUP BY c.model ORDER BY CarsSold DESC";
                        PreparedStatement ps3 = cn.prepareStatement(sql3);
                        ResultSet rs3 = ps3.executeQuery();
                        while (rs3.next()) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= rs3.getString("CarModel")%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= rs3.getInt("CarsSold")%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <!-- Most Used Spare Parts -->
            <h2 class="text-2xl font-semibold text-black mt-6 mb-4">4. Most Used Spare Parts</h2>
            <table class="w-full border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Part Name</th>
                        <th class="border border-gray-400 px-4 py-2">Times Used</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String sql4 = "SELECT TOP 3 p.partName, COUNT(pu.partID) AS TimesUsed FROM PartsUsed pu JOIN Parts p ON pu.partID = p.partID GROUP BY p.partName ORDER BY TimesUsed DESC";
                        PreparedStatement ps4 = cn.prepareStatement(sql4);
                        ResultSet rs4 = ps4.executeQuery();
                        while (rs4.next()) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= rs4.getString("partName")%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= rs4.getInt("TimesUsed")%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <!-- Top 3 Mechanics with the Most Repairs -->
            <h2 class="text-2xl font-semibold text-black mt-6 mb-4">5. Top 3 Mechanics with the Most Repairs</h2>
            <table class="w-full border border-gray-400 text-center">
                <thead class="bg-gray-300">
                    <tr>
                        <th class="border border-gray-400 px-4 py-2">Mechanic Name</th>
                        <th class="border border-gray-400 px-4 py-2">Repairs Assigned</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        String sql5 = "SELECT TOP 3 m.mechanicName, COUNT(sm.serviceTicketID) AS RepairsAssigned FROM ServiceMehanic sm JOIN Mechanic m ON sm.mechanicID = m.mechanicID GROUP BY m.mechanicName ORDER BY RepairsAssigned DESC";
                        PreparedStatement ps5 = cn.prepareStatement(sql5);
                        ResultSet rs5 = ps5.executeQuery();
                        while (rs5.next()) {
                    %>
                    <tr class="hover:bg-gray-200">
                        <td class="border border-gray-400 px-4 py-2"><%= rs5.getString("mechanicName")%></td>
                        <td class="border border-gray-400 px-4 py-2"><%= rs5.getInt("RepairsAssigned")%></td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <!-- Back Button -->
            <div class="text-center mt-6">
                <a href="MainServlet?action=salePersonPage" class="bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700">Back home</a>
            </div>
        </div>

        <%
            }
        %>
        
    </body>
</html>
