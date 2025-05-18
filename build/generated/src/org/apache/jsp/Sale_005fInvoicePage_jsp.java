package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Car;
import DAO.CarDAO;
import DAO.CustomerDAO;
import model.WishList;
import model.Customer;
import java.util.ArrayList;
import model.SalePerson;
import model.Customer;

public final class Sale_005fInvoicePage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/header.jsp");
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

            SalePerson sale = (SalePerson) session.getAttribute("Sale");
            if (sale == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        
      out.write("\n");
      out.write("         ");
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
      out.write("        <div class=\"container mx-auto p-6 min-h-screen\">\n");
      out.write("    <h1 class=\"text-3xl font-bold text-center text-black mb-6\">Customer Information</h1>\n");
      out.write("\n");
      out.write("    <div class=\"max-w-lg mx-auto bg-white p-6 shadow-lg rounded-lg\">\n");
      out.write("        <!-- Customer Selection Form -->\n");
      out.write("        <form action=\"MainServlet\" method=\"post\" class=\"space-y-4\">\n");
      out.write("            <label class=\"block text-gray-700 font-semibold\">Select Customer</label>\n");
      out.write("            <select name=\"custid\" class=\"w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-400\">\n");
      out.write("                <option value=\"\" disabled selected>-- Choose Customer --</option>\n");
      out.write("                ");

                    ArrayList<Customer> listcust = (ArrayList) session.getAttribute("LISTCUST");
                    if (listcust != null && !listcust.isEmpty()) {
                        for (Customer cust : listcust) {
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(cust.getCustid());
      out.write("\">\n");
      out.write("                    ");
      out.print( cust.getCustid());
      out.write(" - ");
      out.print(cust.getCustname());
      out.write("\n");
      out.write("                </option>\n");
      out.write("                ");

                        }
                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <input type=\"hidden\" value=\"sale_getWishlist\" name=\"action\">\n");
      out.write("            <button type=\"submit\" class=\"w-full bg-green-600 text-white px-4 py-2 rounded-lg hover:bg-green-700\">\n");
      out.write("                Get Wishlist\n");
      out.write("            </button>\n");
      out.write("        </form>\n");
      out.write("    </div>\n");
      out.write("\n");
      out.write("    <!-- Display Wishlist if Available -->\n");
      out.write("    ");

        ArrayList<WishList> wishlist = (ArrayList) session.getAttribute("WISHLIST");
        if (wishlist != null && !wishlist.isEmpty()) {
            CustomerDAO cd = new CustomerDAO();
            Customer cust = cd.findCustomerByID(wishlist.get(0).getCustid());
            if (cust != null) {
    
      out.write("\n");
      out.write("    <h2 class=\"text-xl font-semibold text-center mt-6\">Customer: ");
      out.print( cust.getCustname() );
      out.write("</h2>\n");
      out.write("\n");
      out.write("    <div class=\"max-w-2xl mx-auto bg-white p-6 shadow-lg rounded-lg mt-4\">\n");
      out.write("        <table class=\"w-full border-collapse border border-gray-300\">\n");
      out.write("            <thead>\n");
      out.write("                <tr class=\"bg-gray-200\">\n");
      out.write("                    <th class=\"border p-2\">Car ID</th>\n");
      out.write("                    <th class=\"border p-2\">Model</th>\n");
      out.write("                    <th class=\"border p-2\">Action</th>\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody>\n");
      out.write("                ");

                    ArrayList<String> listcar = wishlist.get(0).getListcar();
                    for (String carid : listcar) {
                        CarDAO card = new CarDAO();
                        Car car = card.getCar(carid);
                
      out.write("\n");
      out.write("                <tr class=\"text-center\">\n");
      out.write("                    <td class=\"border p-2\">");
      out.print( car.getCarID() );
      out.write("</td>\n");
      out.write("                    <td class=\"border p-2\">");
      out.print( car.getModel() );
      out.write("</td>\n");
      out.write("                    <td class=\"border p-2\">\n");
      out.write("                        <form action=\"MainServlet\" method=\"post\">\n");
      out.write("                            <input type=\"hidden\" name=\"carid\" value=\"");
      out.print( car.getCarID() );
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"custid\" value=\"");
      out.print( cust.getCustid() );
      out.write("\"/>\n");
      out.write("                            <input type=\"hidden\" name=\"action\" value=\"sale_createInvoice\"/>\n");
      out.write("                            <button type=\"submit\" class=\"bg-blue-600 text-white px-3 py-1 rounded-lg hover:bg-blue-700\">\n");
      out.write("                                Create Invoice\n");
      out.write("                            </button>\n");
      out.write("                        </form>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("    </div>\n");
      out.write("    ");

        } else {
    
      out.write("\n");
      out.write("    <h3 class=\"text-red-600 text-center mt-4\">This customer has not registered a wishlist.</h3>\n");
      out.write("    ");

        }
    }
    
      out.write("\n");
      out.write("\n");
      out.write("    <!-- Error / Success Messages -->\n");
      out.write("    <h3 class=\"text-center text-red-600 mt-4\">\n");
      out.write("        ");

            if (request.getAttribute("ERROR") != null) {
                out.print(request.getAttribute("ERROR"));
            } else if (request.getAttribute("SUCCESS") != null) {
                out.print(request.getAttribute("SUCCESS"));
            }
        
      out.write("\n");
      out.write("    </h3>\n");
      out.write("\n");
      out.write("    <!-- Back Button -->\n");
      out.write("    <div class=\"text-center mt-6\">\n");
      out.write("        <a href=\"MainServlet?action=salePersonPage\"\n");
      out.write("           class=\"bg-gray-600 text-white px-4 py-2 rounded-lg hover:bg-gray-700\">\n");
      out.write("            Back Home\n");
      out.write("        </a>\n");
      out.write("    </div>\n");
      out.write("</div>\n");
      out.write("\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("         \n");
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
