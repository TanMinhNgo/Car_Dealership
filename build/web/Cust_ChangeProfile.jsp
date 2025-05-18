<%-- 
    Document   : ChangeProfile
    Created on : Mar 2, 2025, 7:04:04 PM
    Author     : Admin
--%>

<%@page import="model.Customer"%>
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
            Customer cust = (Customer) session.getAttribute("User");
            if (cust == null) {
                request.setAttribute("ERROR1", "Unauthorized access!");
                request.getRequestDispatcher("MainServlet?action=loginPage").forward(request, response);
            } else {
        %>
        <%@include file="header.jsp" %>
        
        <h1 class="text-3xl font-bold text-center text-gray-800 mb-6">Change your profile</h1>
        <form action="MainServlet" method="post" accept-charset="utf-8"  class="bg-gray-300 text-black p-6 rounded-lg shadow-lg max-w-lg mx-auto">
            <p class="mb-4">
                <input type="text" name="custname" placeholder="Enter new name"
                       class="w-full px-4 py-2 border border-gray-700 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                       /></p>
            <p class="mb-4">
                <input type="text" name="custphone" placeholder="Enter new phone"
                       class="w-full px-4 py-2 border border-gray-700 rounded focus:outline-none focus:ring-2 focus:ring-blue-500"
                       /></p>
            <label class="inline-flex items-center">
                <input type="radio" name="custsex" value="F" checked 
                       class="text-blue-500 focus:ring focus:ring-blue-500">
                <span class="ml-2">Female</span>
            </label>
            <label class="inline-flex items-center ml-6">
                <input type="radio" name="custsex" value="M" 
                       class="text-blue-500 focus:ring focus:ring-blue-500">
                <span class="ml-2">Male</span>
            </label>

            <input type="text" name="custaddress" placeholder="Enter new address"
                   class="w-full px-4 py-2 border border-gray-700 rounded focus:outline-none focus:ring-2 focus:ring-blue-500">
            </p>
            <p>
                <input type="submit" value="Change Profile"
                       class="mt-10 w-full bg-blue-600 text-gray-100 px-4 py-2 rounded hover:bg-blue-700 transition">
                <input type="hidden" name="action" value="changeProfile">
            </p>
        </form>
        <h3 class="text-center text-red-500 mt-4 text-2xl">
            <%
                if (request.getAttribute("ERROR") != null) {
                    out.print(request.getAttribute("ERROR"));
                } else if (request.getAttribute("SUCCESS") != null) {
                    out.print(request.getAttribute("SUCCESS"));
                }
            %>
        </h3>
        <br/>
        <form action="MainServlet" class="text-center mt-6 mb-5">
            <input type="submit" value="Back" 
                   class="bg-gray-700 text-white px-6 py-2 rounded shadow-lg hover:bg-gray-600 transition duration-300 ease-in-out">
            <input type="hidden" value="custDashboard" name="action">
        </form>

        <%
            }
        %>
        
        <%@include file="footer.jsp" %>
    </body>
</html>
