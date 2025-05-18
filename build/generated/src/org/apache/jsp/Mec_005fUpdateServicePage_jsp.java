package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Mechanic;
import model.Customer;

public final class Mec_005fUpdateServicePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/header.jsp");
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <script src=\"https://cdn.tailwindcss.com\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"./styles/mystyle.css\" />\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            Mechanic mecha = (Mechanic) session.getAttribute("Mecha");
            if (mecha == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
                String serviceID = request.getParameter("serviceid");
        
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<header class=\"py-3 lg:py-3 bg-white shadow-lg\">\n");
      out.write("    <div class=\"container flex justify-between items-center w-full\">\n");
      out.write("        <!-- Logo -->\n");
      out.write("        <div class=\"flex-1 flex justify-center\">\n");
      out.write("            <h1>\n");
      out.write("                <a href=\"MainServlet?action=home\" class=\"max-w-[150px] block\">\n");
      out.write("                    <img src=\"./images/cardealer_logo.jpg\" \n");
      out.write("                         alt=\"Car Dealer logo\"\n");
      out.write("                         class=\"image max-w-full block object-cover\" />\n");
      out.write("                </a>\n");
      out.write("            </h1>\n");
      out.write("        </div>\n");
      out.write("        \n");
      out.write("    </div>\n");
      out.write("    \n");
      out.write("</header>");
      out.write("\n");
      out.write("        <div class=\"max-w-md mx-auto mt-10 p-6 bg-white shadow-lg rounded-lg\">\n");
      out.write("            <h1 class=\"text-2xl font-bold text-center mb-6 text-gray-800\">Update the Service</h1>\n");
      out.write("\n");
      out.write("            <form action=\"MainServlet\" method=\"post\" class=\"space-y-4\">\n");
      out.write("                <input type=\"hidden\" value=\"");
      out.print( serviceID);
      out.write("\" name=\"id\">\n");
      out.write("\n");
      out.write("                <div>\n");
      out.write("                    <input type=\"text\" name=\"hourlyrate\" placeholder=\"Enter new Service's hourly rate\"\n");
      out.write("                           class=\"w-full px-4 py-2 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-blue-500\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <div class=\"text-center\">\n");
      out.write("                    <input type=\"submit\" value=\"Submit\"\n");
      out.write("                           class=\"px-6 py-2 bg-blue-500 text-white font-semibold rounded-lg shadow-md \n");
      out.write("                           hover:bg-blue-600 transition-all transform hover:scale-105 cursor-pointer\">\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <input type=\"hidden\" value=\"mec_updateService\" name=\"action\">\n");
      out.write("            </form>\n");
      out.write("\n");
      out.write("            <h3 class=\"text-center mt-4 text-red-500 font-medium\">\n");
      out.write("                ");

                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                
      out.write("\n");
      out.write("            </h3>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"text-center mt-6\">\n");
      out.write("            <a href=\"MainServlet?action=mec_servicePage\" \n");
      out.write("               class=\"px-6 py-2 bg-gray-500 text-white font-semibold rounded-lg shadow-md \n");
      out.write("               hover:bg-gray-600 transition-all transform hover:scale-105\">\n");
      out.write("                Back\n");
      out.write("            </a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
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
