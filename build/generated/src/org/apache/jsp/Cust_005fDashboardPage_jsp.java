package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Car;
import model.Invoice;
import model.ServiceTicket;
import java.util.ArrayList;
import model.Customer;

public final class Cust_005fDashboardPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/footer.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("\n");
      out.write("        <title>Car Dealership</title>\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./styles/mystyle.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Customer cust = (Customer) session.getAttribute("User");
            if (cust == null) {
                request.setAttribute("ERROR", "Unauthorized access!");
                request.getRequestDispatcher("MainController?action=loginPage").forward(request, response);
            } else {
        
      out.write("\n");
      out.write("        <div class=\"wrap\">\n");
      out.write("            <header class=\"py-3 lg:py-4 bg-white shadow-lg\">\n");
      out.write("                <div class=\"container flex justify-between items-center w-full  gap-10\">\n");
      out.write("                    <!-- Logo -->\n");
      out.write("                    <div class=\"flex-1 flex justify-center\">\n");
      out.write("                        <h1>\n");
      out.write("                            <a href=\"MainServlet?action=custDashboard\" class=\"max-w-[150px] block\">\n");
      out.write("                                <img src=\"./images/cardealer_logo.jpg\" \n");
      out.write("                                     alt=\"Car Dealer logo\"\n");
      out.write("                                     class=\"image max-w-full block object-cover\" />\n");
      out.write("                            </a>\n");
      out.write("                        </h1>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Search Form -->\n");
      out.write("                    <form action=\"MainServlet\" class=\"max-w-[500px] w-full flex relative\">\n");
      out.write("\n");
      out.write("                        <input type=\"text\" name=\"carname\" placeholder=\"Search for a car...\"\n");
      out.write("                               class=\"w-full pl-10 pr-4 py-2 border rounded-full focus:outline-none focus:border-transparent focus:ring-blue-500 focus:ring-2\">\n");
      out.write("                        <input type=\"submit\" value=\"Find Car\" \n");
      out.write("                               class=\"absolute left-[404px] flex items-center gap-6 border-black bg-black text-white rounded-[20px] border px-4 py-2 font-semibold hover:bg-white hover:text-black \" name=\"action\">\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- Navigation Links -->\n");
      out.write("                    <nav class=\"ml-auto mr-28\">\n");
      out.write("                        <ul class=\"flex items-center gap-10\">\n");
      out.write("                            <li class=\"relative after:absolute after:w-full after:scale-x-0 hover:after:scale-x-100 after:duration-300 after:bg-black after:left-0 after:bottom-0 after:h-[2px] after:transition-all\">\n");
      out.write("                                <a href=\"MainServlet?action=custDashboard\">Home</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"relative after:absolute after:w-full after:scale-x-0 hover:after:scale-x-100 after:duration-300 after:bg-black after:left-0 after:bottom-0 after:h-[2px] after:transition-all\">\n");
      out.write("                                <a href=\"MainServlet?action=custGetInvoice\">Invoices</a>\n");
      out.write("                            </li>\n");
      out.write("                            <li class=\"relative after:absolute after:w-full after:scale-x-0 hover:after:scale-x-100 after:duration-300 after:bg-black after:left-0 after:bottom-0 after:h-[2px] after:transition-all\">\n");
      out.write("                                <a href=\"MainServlet?action=custGetServiceTicket\">Service Tickets</a>\n");
      out.write("                            </li>\n");
      out.write("\n");
      out.write("                        </ul>\n");
      out.write("                    </nav>\n");
      out.write("\n");
      out.write("                    <!-- User and Cart Icons -->\n");
      out.write("                    <div class=\"flex items-center gap-6 relative\">\n");
      out.write("                        <a href=\"#\" id=\"user-icon\"\n");
      out.write("                           ><img\n");
      out.write("                                src=\"./images/ico_user.png\"\n");
      out.write("                                class=\"image size-5\"\n");
      out.write("                                alt=\"Icon User\"\n");
      out.write("                                />\n");
      out.write("                        </a>\n");
      out.write("                        <a href=\"MainServlet?action=wishlistPage\" class=\"relative\">\n");
      out.write("                            <img src=\"./images/ico_heart.png\" \n");
      out.write("                                 class=\"image size-5\" \n");
      out.write("                                 alt=\"Icon Heart\" />\n");
      out.write("                        </a>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </div>\n");
      out.write("            </header>\n");
      out.write("\n");
      out.write("            <main>\n");
      out.write("                <div class=\"container mx-auto p-6\">\n");
      out.write("\n");
      out.write("                    <h2 class=\"font-jakarta text-[30px] font-bold mb-6 text-center text-black\">\n");
      out.write("                        Welcome, ");
      out.print( cust.getCustname());
      out.write("\n");
      out.write("                    </h2>\n");
      out.write("\n");
      out.write("                    <!-- Navigation Buttons -->\n");
      out.write("                    <div class=\"flex justify-center space-x-4 mb-8\">\n");
      out.write("                        <form action=\"MainServlet\">\n");
      out.write("                            <input type=\"submit\" value=\"Logout\" name=\"action\" \n");
      out.write("                                   class=\"bg-red-600 text-gray-100 rounded px-4 py-2 hover:bg-red-700\">\n");
      out.write("                        </form>\n");
      out.write("                        <form action=\"MainServlet\">\n");
      out.write("                            <input type=\"submit\" value=\"Change Profile\"\n");
      out.write("                                   class=\"bg-yellow-500 text-gray-900 rounded px-4 py-2 hover:bg-yellow-600\">\n");
      out.write("                            <input type=\"hidden\" value=\"ChangeProfilePage\" name=\"action\">\n");
      out.write("                        </form>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <!-- Invoice Search -->\n");
      out.write("                    <form action=\"MainServlet\" method=\"post\" class=\"text-center mb-8\">\n");
      out.write("                        <input type=\"text\" name=\"invoicedate\" placeholder=\"Enter Date...\" \n");
      out.write("                               value=\"");
      out.print( (request.getParameter("FindDate") != null) ? request.getParameter("FindDate") : "");
      out.write("\" \n");
      out.write("                               class=\"border border-gray-700 bg-gray-800 rounded px-4 py-2 text-gray-300 focus:outline-none focus:ring focus:ring-green-500\">\n");
      out.write("                        <input type=\"submit\" value=\"Find\" \n");
      out.write("                               class=\"bg-green-600 text-gray-100 rounded px-4 py-2 hover:bg-green-700\" >\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"custInvoice\" >\n");
      out.write("                    </form>\n");
      out.write("                    <!-- Dashboard Header -->\n");
      out.write("                    <!--                    <h1 class=\"text-4xl font-bold text-black mb-6 text-center\">Dashboard</h1>-->\n");
      out.write("\n");
      out.write("                    <!-- Navigation Links -->\n");
      out.write("                    ");

                        ArrayList<Invoice> listInv = (ArrayList) session.getAttribute("LIST_INVOICE");
                        if (listInv != null && !listInv.isEmpty()) {
                    
      out.write("\n");
      out.write("                    <h2 class=\"text-3xl font-bold text-center text-black mb-6\">INVOICE LIST</h2>\n");
      out.write("\n");
      out.write("                    <table class=\"table-auto border-collapse border border-gray-700 w-full text-black text-center mb-8\">\n");
      out.write("                        <thead class=\"bg-gray-300\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Invoice ID</th>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Create Date</th>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Car ID</th>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Actions</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (Invoice inv : listInv) {
      out.write("\n");
      out.write("                        <form action=\"MainServlet\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print( inv.getCarid());
      out.write("\" name=\"carid\">\n");
      out.write("                            <tr class=\"hover:bg-gray-300\">\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( inv.getInvoiceid());
      out.write("</td>\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( inv.getCreatedDate());
      out.write("</td>\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( inv.getCarid());
      out.write("</td>\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">\n");
      out.write("                                    <input type=\"submit\" value=\"Detail\" class=\"bg-blue-600 text-gray-100 rounded px-4 py-2 hover:bg-blue-700\">\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"Detail Car\">\n");
      out.write("                                </td>\n");
      out.write("                        </form>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("                    ");

                        Car car = (Car) request.getAttribute("RESULT_DETAIL");
                        if (car != null) {
                    
      out.write("\n");
      out.write("                    <div class=\"bg-gray-300 text-black rounded-lg shadow-lg p-6 mb-8\">\n");
      out.write("                        <h2 class=\"text-2xl font-bold text-black mb-4 text-center\">Car Information</h2>\n");
      out.write("                        <table class=\"table-auto border-collapse border border-gray-300 w-full text-center\">\n");
      out.write("                            <thead>\n");
      out.write("                                <tr class=\"bg-gray-500\">\n");
      out.write("                                    <th class=\"border border-gray-700 px-4 py-2\">Car ID</th>\n");
      out.write("                                    <th class=\"border border-gray-700 px-4 py-2\">Model</th>\n");
      out.write("                                    <th class=\"border border-gray-700 px-4 py-2\">Year</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                <tr class=\"hover:bg-gray-400\">\n");
      out.write("                                    <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( car.getCarID());
      out.write("</td>\n");
      out.write("                                    <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( car.getModel());
      out.write("</td>\n");
      out.write("                                    <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( car.getYear());
      out.write("</td>\n");
      out.write("                                </tr>\n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                    </div>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- List Service ticket-->\n");
      out.write("                    ");

                        ArrayList<ServiceTicket> listSt = (ArrayList) session.getAttribute("LIST_SERVICETICKET");
                        if (listSt != null && !listSt.isEmpty()) {
                    
      out.write("\n");
      out.write("                    <h2 class=\"text-3xl font-bold text-center text-black mb-6\">SERVICE TICKET LIST</h2>\n");
      out.write("\n");
      out.write("                    <table class=\"table-auto border-collapse border border-gray-700 w-full text-black text-center mb-8\">\n");
      out.write("                        <thead class=\"bg-gray-300\">\n");
      out.write("                            <tr>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">ServiceTicketID</th>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Date Received</th>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Date Returned</th>\n");
      out.write("                                <th class=\"border border-gray-700 px-4 py-2\">Actions</th>\n");
      out.write("                            </tr>\n");
      out.write("                        </thead>\n");
      out.write("                        <tbody>\n");
      out.write("                            ");
 for (ServiceTicket st : listSt) {
      out.write("\n");
      out.write("                        <form action=\"MainServlet\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" value=\"");
      out.print( st.getServiceTicketID());
      out.write("\" name=\"serviceticketid\">\n");
      out.write("                            <tr class=\"hover:bg-gray-300\">\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( st.getServiceTicketID());
      out.write("</td>\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( st.getDateReceived());
      out.write("</td>\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">");
      out.print( st.getDateReturned());
      out.write("</td>\n");
      out.write("                                <td class=\"border border-gray-700 px-4 py-2\">\n");
      out.write("                                    <input type=\"submit\" value=\"Detail\" \n");
      out.write("                                           class=\"bg-blue-600 text-gray-100 rounded px-4 py-2 hover:bg-blue-700\">\n");
      out.write("                                    <input type=\"hidden\" name=\"action\" value=\"custDetailServiceTicket\">\n");
      out.write("                                </td>\n");
      out.write("                            </tr>\n");
      out.write("                        </form>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                        </tbody>\n");
      out.write("                    </table>\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!-- Error Messages -->\n");
      out.write("                    <div class=\"text-center text-red-500\">\n");
      out.write("                        ");
 if (request.getAttribute("ERROR") != null) {
                                out.print(request.getAttribute("ERROR"));
                            }
                        
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </main>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        ");
      out.write("\n");
      out.write("<style >\n");
      out.write("    html, body {\n");
      out.write("    height: 100%;\n");
      out.write("    margin: 0;\n");
      out.write("    display: flex;\n");
      out.write("    flex-direction: column;\n");
      out.write("}\n");
      out.write("\n");
      out.write("main {\n");
      out.write("    flex: 1; /* Đẩy footer xuống khi nội dung ngắn */\n");
      out.write("}\n");
      out.write("\n");
      out.write("footer {\n");
      out.write("    background: #f3f4f6; /* Màu nền nhẹ */\n");
      out.write("    text-align: center;\n");
      out.write("    padding: 20px 0;\n");
      out.write("}\n");
      out.write("\n");
      out.write("</style>\n");
      out.write("<footer class=\"bg-gray-100 py-10 mt-auto w-full\">\n");
      out.write("    <div class=\"container mx-auto grid grid-cols-1 md:grid-cols-4 gap-8 text-gray-700\">\n");
      out.write("        <!-- About Us Section -->\n");
      out.write("        <div>\n");
      out.write("            <h3 class=\"text-lg font-bold text-gray-900 mb-4\">ABOUT US</h3>\n");
      out.write("            <p class=\"text-sm leading-6\">\n");
      out.write("                We specialize in selling high-quality cars.<br />\n");
      out.write("                <span class=\"block mt-2\">Address: Hi-Tech Park, Thu Duc City, Ho Chi Minh City</span>\n");
      out.write("                <span class=\"block mt-2\">Customer Service Hotline: 0961618187</span>\n");
      out.write("                <span class=\"block mt-2\">Email: fptshop@gmail.com</span>\n");
      out.write("            </p>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- How to Buy Section -->\n");
      out.write("        <div>\n");
      out.write("            <h3 class=\"text-lg font-bold text-gray-900 mb-4\">HOW TO BUY</h3>\n");
      out.write("            <ul class=\"space-y-2\">\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Warranty Center</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Refund Policy</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Order Guide</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Contact Us</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Policies Section -->\n");
      out.write("        <div>\n");
      out.write("            <h3 class=\"text-lg font-bold text-gray-900 mb-4\">OUR POLICIES</h3>\n");
      out.write("            <ul class=\"space-y-2\">\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Privacy Policy</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Shipping Policy</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Warranty Policy</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Exchange Policy</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Follow Us Section -->\n");
      out.write("        <div>\n");
      out.write("            <h3 class=\"text-lg font-bold text-gray-900 mb-4\">FOLLOW US</h3>\n");
      out.write("            <ul class=\"space-y-2\">\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Newsletter</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Instagram</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">Facebook</a></li>\n");
      out.write("                <li><a href=\"#\" class=\"hover:text-blue-500 transition\">YouTube</a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Bottom Bar -->\n");
      out.write("    <div class=\"mt-10 border-t border-gray-300 text-center py-4 text-sm text-gray-500\">\n");
      out.write("        &copy; 2025 - All Rights Reserved.\n");
      out.write("    </div>\n");
      out.write("</footer>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
