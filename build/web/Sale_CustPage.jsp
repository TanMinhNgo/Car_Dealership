<%-- 
    Document   : Sale_CustPage
    Created on : Mar 6, 2025, 12:41:35 PM
    Author     : Admin
--%>

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
            HttpSession s = request.getSession();
            if (sale == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6">
            <h1 class="text-2xl font-bold text-center text-blue-600 mb-6">Customer List</h1>

            <!-- Form tìm kiếm -->
            <div class="flex justify-end mb-4">
                <form action="MainServlet" class="flex space-x-2">
                    <input type="text" name="custname" placeholder="Enter Customer's name"
                           class="border border-gray-300 p-2 rounded-md focus:ring-2 focus:ring-blue-400 focus:outline-none"/>
                    <input type="submit" value="Find customer"
                           class="px-4 py-2 bg-blue-600 text-white font-semibold rounded-md shadow-md hover:bg-blue-700 transition-all"/>
                    <input type="hidden" value="sale_findCust" name="action">
                </form>
            </div>

            <!-- Bảng danh sách khách hàng -->
            <%
                ArrayList<Customer> listCust = (ArrayList) s.getAttribute("SALE_LISTCUST");
                if (listCust != null && !listCust.isEmpty()) {
            %>
            <div class="overflow-x-auto">
                <table class="min-w-full bg-white shadow-md rounded-lg overflow-hidden">
                    <thead class="bg-blue-500 text-white">
                        <tr>
                            <th class="px-4 py-2">Customer ID</th>
                            <th class="px-4 py-2">Name</th>
                            <th class="px-4 py-2">Phone</th>
                            <th class="px-4 py-2">Sex</th>
                            <th class="px-4 py-2">Address</th>
                            <th class="px-4 py-2">Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            for (Customer cust : listCust) {
                        %>  
                        <tr class="border-b hover:bg-gray-100 text-center">
                            <td class="px-4 py-2"><%= cust.getCustid()%></td>
                            <td class="px-4 py-2"><%= cust.getCustname()%></td>
                            <td class="px-4 py-2"><%= cust.getPhone()%></td>
                            <td class="px-4 py-2"><%= cust.getSex()%></td>
                            <td class="px-4 py-2"><%= cust.getCustaddress()%></td>
                            <td class="px-4 py-2 space-x-2">
                                <a href="MainServlet?action=sale_updateCustPage&custid=<%= cust.getCustid()%>"
                                   class="px-3 py-1 bg-yellow-500 text-white rounded-md shadow-md hover:bg-yellow-600 transition-all">
                                    Update
                                </a>
                                <a href="MainServlet?action=sale_deleteCustPage&custid=<%= cust.getCustid()%>"
                                   class="px-3 py-1 bg-red-500 text-white rounded-md shadow-md hover:bg-red-600 transition-all">
                                    Delete
                                </a>
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

            <!-- Nút thêm khách hàng -->
            <div class="mt-6 flex justify-center">
                <a href="MainServlet?action=sale_createCustPage"
                   class="px-4 py-2 bg-green-600 text-white font-semibold rounded-md shadow-md hover:bg-green-700 transition-all">
                    Create new Customer
                </a>
            </div>

            <!-- Hiển thị thông báo lỗi hoặc thành công -->
            <h3 class="text-center text-red-500 mt-4">
                <%
                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                %>
            </h3>

            <!-- Nút quay về -->
            <div class="mt-6 text-center">
                <a href="MainServlet?action=salePersonPage"
                   class="text-gray-600 hover:text-gray-900 font-semibold">
                    ← Back home
                </a>
            </div>
        </div>

        <%
            }
        %>
       
    </body>
</html>
