package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Customer;
import DAO.ServiceTicketDAO;
import model.Mechanic;
import DAO.MechanicDAO;
import model.Service;
import DAO.ServiceDAO;
import model.Parts;
import DAO.PartsDAO;
import model.Car;
import DAO.CarDAO;
import model.PartsUsed;
import model.ServiceMechanic;
import java.util.ArrayList;
import model.ServiceTicket;
import model.Customer;

public final class Cust_005fDetailServiceTicketPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
      out.write("    <body class=\"\">\n");
      out.write("        ");

            Customer cust = (Customer) session.getAttribute("User");
            if (cust == null) {
                request.setAttribute("ERROR1", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        
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
      out.write("        <div class=\"max-w-6xl mx-auto bg-gray-50 p-6 rounded-lg shadow-lg mt-8 mb-10\">\n");
      out.write("            <h1 class=\"text-2xl font-bold text-gray-700 mb-4\">Danh sách chi tiết Service Ticket</h1>\n");
      out.write("\n");
      out.write("            ");
 ServiceTicket st = (ServiceTicket) session.getAttribute("SERVICETICKET");
                ArrayList<ServiceMechanic> listSm = (ArrayList<ServiceMechanic>) session.getAttribute("SERVICEMECHANIC");
                ArrayList<PartsUsed> listPu = (ArrayList<PartsUsed>) session.getAttribute("PARTSUSED");
                if (st != null && listSm != null && !listSm.isEmpty() && listPu != null && !listPu.isEmpty()) {
                    ServiceTicketDAO std = new ServiceTicketDAO();
                    CarDAO cd = new CarDAO();
                    Car car = cd.getCar(st.getCarID());
                    PartsDAO pd = new PartsDAO();
                    ArrayList<Parts> listParts = new ArrayList<>();
                    for (PartsUsed partsUsed : listPu) {
                        listParts.add(pd.getParts("" + partsUsed.getPartID()));
                    }
                    ServiceDAO sd = new ServiceDAO();
                    ArrayList<Service> listService = new ArrayList<>();
                    for (ServiceMechanic sm : listSm) {
                        listService.add(sd.getService("" + sm.getServiceID()));
                    }
                    MechanicDAO md = new MechanicDAO();
                    ArrayList<Mechanic> listMecha = new ArrayList<>();
                    for (ServiceMechanic sm : listSm) {
                        listMecha.add(md.getMechanic(sm.getMechanicID()));
                    }
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"overflow-x-auto\">\n");
      out.write("                <table class=\"min-w-full bg-white border border-gray-300 rounded-lg\">\n");
      out.write("                    <thead>\n");
      out.write("                        <tr class=\"bg-gray-200 text-gray-700\">\n");
      out.write("                            <th class=\"py-2 px-4 border\">Car Name</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Service Name</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Mechanic Name</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Hours</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Parts Used</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Number Of Parts</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Price Of Parts Used</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Price Of Service Mechanic</th>\n");
      out.write("                            <th class=\"py-2 px-4 border\">Total Price</th>\n");
      out.write("                        </tr>\n");
      out.write("                    </thead>\n");
      out.write("                    <tbody>\n");
      out.write("                        <tr class=\"text-center\">\n");
      out.write("                            <td class=\"py-2 px-4 border\">");
      out.print( car.getModel());
      out.write("</td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (Service ser : listService) {
      out.write("\n");
      out.write("                                <p style=\"text-align: left;\">-");
      out.print( ser.getServiceName());
      out.write("</p>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (Mechanic mecha : listMecha) {
      out.write("\n");
      out.write("                                <p>");
      out.print( mecha.getName());
      out.write("</p>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (ServiceMechanic serMecha : listSm) {
      out.write("\n");
      out.write("                                <p>");
      out.print( serMecha.getHours());
      out.write("</p>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (Parts par : listParts) {
      out.write("\n");
      out.write("                                <p style=\"text-align: left;\">-");
      out.print( par.getPartName());
      out.write("</p>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (PartsUsed pu : listPu) {
      out.write("\n");
      out.write("                                <p>");
      out.print( pu.getNumberUsed());
      out.write("</p>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (PartsUsed pu : listPu) {
      out.write("\n");
      out.write("                                <p>");
      out.print( pu.getPrice());
      out.write("</p>\n");
      out.write("                                ");
 } 
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border\">\n");
      out.write("                                ");
 for (ServiceMechanic serMecha : listSm) {
      out.write("\n");
      out.write("                                <p>");
      out.print( serMecha.getRate());
      out.write("</p>\n");
      out.write("                                ");
 }
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                            <td class=\"py-2 px-4 border font-bold text-green-600\">\n");
      out.write("                                ");
      out.print( std.getTotalPriceServiceTicket("" + st.getServiceTicketID()));
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </tbody>\n");
      out.write("                </table>\n");
      out.write("            </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("            <br/>\n");
      out.write("            <a href=\"MainServlet?action=custDashboard\" class=\"mt-4 inline-block bg-blue-500 hover:bg-blue-600 text-white font-bold py-2 px-4 rounded-lg\">Back home</a>\n");
      out.write("        </div>\n");
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
