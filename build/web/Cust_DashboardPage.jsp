<%@page import="model.Car"%>
<%@page import="model.Invoice"%>
<%@page import="model.ServiceTicket"%>
<%@page import="java.util.ArrayList"%>
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
                request.setAttribute("ERROR", "Unauthorized access!");
                request.getRequestDispatcher("MainController?action=loginPage").forward(request, response);
            } else {
        %>
        <div class="wrap">
            <header class="py-3 lg:py-4 bg-white shadow-lg">
                <div class="container flex justify-between items-center w-full  gap-10">
                    <!-- Logo -->
                    <div class="flex-1 flex justify-center">
                        <h1>
                            <a href="MainServlet?action=custDashboard" class="max-w-[150px] block">
                                <img src="./images/cardealer_logo.jpg" 
                                     alt="Car Dealer logo"
                                     class="image max-w-full block object-cover" />
                            </a>
                        </h1>
                    </div>

                    <!-- Search Form -->
                    <form action="MainServlet" class="max-w-[500px] w-full flex relative">

                        <input type="text" name="carname" placeholder="Search for a car..."
                               class="w-full pl-10 pr-4 py-2 border rounded-full focus:outline-none focus:border-transparent focus:ring-blue-500 focus:ring-2">
                        <input type="submit" value="Find Car" 
                               class="absolute left-[404px] flex items-center gap-6 border-black bg-black text-white rounded-[20px] border px-4 py-2 font-semibold hover:bg-white hover:text-black " name="action">
                    </form>


                  
                    <nav class="ml-auto mr-28">
                        <ul class="flex items-center gap-10">
                            <li class="relative after:absolute after:w-full after:scale-x-0 hover:after:scale-x-100 after:duration-300 after:bg-black after:left-0 after:bottom-0 after:h-[2px] after:transition-all">
                                <a href="MainServlet?action=custDashboard">Home</a>
                            </li>
                            <li class="relative after:absolute after:w-full after:scale-x-0 hover:after:scale-x-100 after:duration-300 after:bg-black after:left-0 after:bottom-0 after:h-[2px] after:transition-all">
                                <a href="MainServlet?action=custGetInvoice">Invoices</a>
                            </li>
                            <li class="relative after:absolute after:w-full after:scale-x-0 hover:after:scale-x-100 after:duration-300 after:bg-black after:left-0 after:bottom-0 after:h-[2px] after:transition-all">
                                <a href="MainServlet?action=custGetServiceTicket">Service Tickets</a>
                            </li>

                        </ul>
                    </nav>

                    <!-- User and Cart Icons -->
                    <div class="flex items-center gap-6 relative">
                        <a href="#" id="user-icon"
                           ><img
                                src="./images/ico_user.png"
                                class="image size-5"
                                alt="Icon User"
                                />
                        </a>
                        <a href="MainServlet?action=wishlistPage" class="relative">
                            <img src="./images/ico_heart.png" 
                                 class="image size-5" 
                                 alt="Icon Heart" />
                        </a>
                    </div>

                </div>
            </header>

            <main>
                <div class="container mx-auto p-6">

                    <h2 class="font-jakarta text-[30px] font-bold mb-6 text-center text-black">
                        Welcome, <%= cust.getCustname()%>
                    </h2>

                    <!-- Navigation Buttons -->
                    <div class="flex justify-center space-x-4 mb-8">
                        <form action="MainServlet">
                            <input type="submit" value="Logout" name="action" 
                                   class="bg-red-600 text-gray-100 rounded px-4 py-2 hover:bg-red-700">
                        </form>
                        <form action="MainServlet">
                            <input type="submit" value="Change Profile"
                                   class="bg-yellow-500 text-gray-900 rounded px-4 py-2 hover:bg-yellow-600">
                            <input type="hidden" value="ChangeProfilePage" name="action">
                        </form>
                    </div>

                    <!-- Invoice Search -->
                    <form action="MainServlet" method="post" class="text-center mb-8">
                        <input type="text" name="invoicedate" placeholder="Enter Date..." 
                               value="<%= (request.getParameter("FindDate") != null) ? request.getParameter("FindDate") : ""%>" 
                               class="border border-gray-700 bg-gray-800 rounded px-4 py-2 text-gray-300 focus:outline-none focus:ring focus:ring-green-500">
                        <input type="submit" value="Find" 
                               class="bg-green-600 text-gray-100 rounded px-4 py-2 hover:bg-green-700" >
                        <input type="hidden" name="action" value="custInvoice" >
                    </form>
                    <!-- Dashboard Header -->
                    <!--                    <h1 class="text-4xl font-bold text-black mb-6 text-center">Dashboard</h1>-->

                    <!-- Navigation Links -->
                    <%
                        ArrayList<Invoice> listInv = (ArrayList) session.getAttribute("LIST_INVOICE");
                        if (listInv != null && !listInv.isEmpty()) {
                    %>
                    <h2 class="text-3xl font-bold text-center text-black mb-6">INVOICE LIST</h2>

                    <table class="table-auto border-collapse border border-gray-700 w-full text-black text-center mb-8">
                        <thead class="bg-gray-300">
                            <tr>
                                <th class="border border-gray-700 px-4 py-2">Invoice ID</th>
                                <th class="border border-gray-700 px-4 py-2">Create Date</th>
                                <th class="border border-gray-700 px-4 py-2">Car ID</th>
                                <th class="border border-gray-700 px-4 py-2">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (Invoice inv : listInv) {%>
                        <form action="MainServlet" method="post">
                            <input type="hidden" value="<%= inv.getCarid()%>" name="carid">
                            <tr class="hover:bg-gray-300">
                                <td class="border border-gray-700 px-4 py-2"><%= inv.getInvoiceid()%></td>
                                <td class="border border-gray-700 px-4 py-2"><%= inv.getCreatedDate()%></td>
                                <td class="border border-gray-700 px-4 py-2"><%= inv.getCarid()%></td>
                                <td class="border border-gray-700 px-4 py-2">
                                    <input type="submit" value="Detail" class="bg-blue-600 text-gray-100 rounded px-4 py-2 hover:bg-blue-700">
                                    <input type="hidden" name="action" value="Detail Car">
                                </td>
                        </form>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                    <% }%>

                    <%
                        Car car = (Car) request.getAttribute("RESULT_DETAIL");
                        if (car != null) {
                    %>
                    <div class="bg-gray-300 text-black rounded-lg shadow-lg p-6 mb-8">
                        <h2 class="text-2xl font-bold text-black mb-4 text-center">Car Information</h2>
                        <table class="table-auto border-collapse border border-gray-300 w-full text-center">
                            <thead>
                                <tr class="bg-gray-500">
                                    <th class="border border-gray-700 px-4 py-2">Car ID</th>
                                    <th class="border border-gray-700 px-4 py-2">Model</th>
                                    <th class="border border-gray-700 px-4 py-2">Year</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr class="hover:bg-gray-400">
                                    <td class="border border-gray-700 px-4 py-2"><%= car.getCarID()%></td>
                                    <td class="border border-gray-700 px-4 py-2"><%= car.getModel()%></td>
                                    <td class="border border-gray-700 px-4 py-2"><%= car.getYear()%></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <% } %>

                    <!-- List Service ticket-->
                    <%
                        ArrayList<ServiceTicket> listSt = (ArrayList) session.getAttribute("LIST_SERVICETICKET");
                        if (listSt != null && !listSt.isEmpty()) {
                    %>
                    <h2 class="text-3xl font-bold text-center text-black mb-6">SERVICE TICKET LIST</h2>

                    <table class="table-auto border-collapse border border-gray-700 w-full text-black text-center mb-8">
                        <thead class="bg-gray-300">
                            <tr>
                                <th class="border border-gray-700 px-4 py-2">ServiceTicketID</th>
                                <th class="border border-gray-700 px-4 py-2">Date Received</th>
                                <th class="border border-gray-700 px-4 py-2">Date Returned</th>
                                <th class="border border-gray-700 px-4 py-2">Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <% for (ServiceTicket st : listSt) {%>
                        <form action="MainServlet" method="post">
                            <input type="hidden" value="<%= st.getServiceTicketID()%>" name="serviceticketid">
                            <tr class="hover:bg-gray-300">
                                <td class="border border-gray-700 px-4 py-2"><%= st.getServiceTicketID()%></td>
                                <td class="border border-gray-700 px-4 py-2"><%= st.getDateReceived()%></td>
                                <td class="border border-gray-700 px-4 py-2"><%= st.getDateReturned()%></td>
                                <td class="border border-gray-700 px-4 py-2">
                                    <input type="submit" value="Detail" 
                                           class="bg-blue-600 text-gray-100 rounded px-4 py-2 hover:bg-blue-700">
                                    <input type="hidden" name="action" value="custDetailServiceTicket">
                                </td>
                            </tr>
                        </form>
                        <% } %>
                        </tbody>
                    </table>
                    <% } %>



                    <!-- Error Messages -->
                    <div class="text-center text-red-500">
                        <% if (request.getAttribute("ERROR") != null) {
                                out.print(request.getAttribute("ERROR"));
                            }
                        %>
                    </div>
                </div>
            </main>

        </div>
        <%@include  file="footer.jsp"%>
        <%
            }
        %>
    </body>
</html>
