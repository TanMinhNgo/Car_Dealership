<%-- 
    Document   : Sale_UpdateCustPage
    Created on : Mar 8, 2025, 12:45:41 AM
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
                String id = request.getParameter("custid");
        %>
        <%@include file="header.jsp" %>
        <div class="container mx-auto p-6 min-h-screen">
            <h1 class="text-3xl font-bold text-center text-black mb-6">Update Customer</h1>

            <div class="max-w-lg mx-auto bg-white p-6 shadow-lg rounded-lg">
                <form action="MainServlet" method="post" class="space-y-4">
                    <input type="hidden" name="custid" value="<%= id%>"/>

                    <div>
                        <label class="block text-gray-700 font-semibold">Customer Name</label>
                        <input type="text" name="custname" placeholder="Enter new name"
                               class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                    </div>

                    <div>
                        <label class="block text-gray-700 font-semibold">Phone Number</label>
                        <input type="text" name="custphone" placeholder="Enter new phone"
                               class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                    </div>

                    <div>
                        <label class="block text-gray-700 font-semibold">Gender</label>
                        <div class="flex space-x-4">
                            <label class="inline-flex items-center">
                                <input type="radio" name="custsex" value="F" checked class="form-radio text-blue-600"/>
                                <span class="ml-2">Female</span>
                            </label>
                            <label class="inline-flex items-center">
                                <input type="radio" name="custsex" value="M" class="form-radio text-blue-600"/>
                                <span class="ml-2">Male</span>
                            </label>
                        </div>
                    </div>

                    <div>
                        <label class="block text-gray-700 font-semibold">Address</label>
                        <input type="text" name="custaddress" placeholder="Enter new address"
                               class="w-full px-4 py-2 border rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-400"/>
                    </div>

                    <input type="hidden" value="sale_updateCust" name="action">

                    <div class="flex justify-between">
                        <button type="submit" class="bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700">Submit</button>
                        <a href="MainServlet?action=sale_customer" class="bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700">Back</a>
                    </div>
                </form>

                <h3 class="text-center text-red-600 mt-4">
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
