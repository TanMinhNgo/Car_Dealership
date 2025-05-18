package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Customer;
import java.util.ArrayList;
import model.SalePerson;

public final class Sale_005fCustPage_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

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
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");

            SalePerson sale = (SalePerson) session.getAttribute("Sale");
            HttpSession s = request.getSession();
            if (sale == null) {
                request.setAttribute("ERROR2", "Unauthorized access!");
                request.getRequestDispatcher("loginPage.jsp").forward(request, response);
            } else {
        
      out.write("\n");
      out.write("        <h1>Danh sach Khanh hang</h1>\n");
      out.write("        <p align=\"right\">\n");
      out.write("            <form action=\"Sale_FindCustServlet\">\n");
      out.write("                <input type=\"text\" name=\"custname\" placeholder=\"Enter Customer's name\"/>\n");
      out.write("                <input type=\"submit\" value=\"Find customer\"/>\n");
      out.write("<!--                <input type=\"hidden\" value=\"sale_findCust\" name=\"action\">-->\n");
      out.write("            </form>\n");
      out.write("        \n");
      out.write("        </p>\n");
      out.write("        ");

            ArrayList<Customer> listCust = (ArrayList) s.getAttribute("SALE_LISTCUST");
            if (listCust != null && !listCust.isEmpty()) {
        
      out.write("\n");
      out.write("        <table border=\"1\" cellspacing=\"0\">\n");
      out.write("            <tr>\n");
      out.write("                <th>Customer_ID</th>\n");
      out.write("                <th>Customer_Name</th>\n");
      out.write("                <th>Customer_Phone</th>\n");
      out.write("                <th>Sex</th>\n");
      out.write("                <th>Customer_Address</th>\n");
      out.write("                <th></th>\n");
      out.write("                <th></th>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            ");

                for(Customer cust : listCust) {
            
      out.write("  \n");
      out.write("            <tr>\n");
      out.write("                <td>");
      out.print( cust.getCustid() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cust.getCustname() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cust.getPhone() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cust.getSex() );
      out.write("</td>\n");
      out.write("                <td>");
      out.print( cust.getCustaddress() );
      out.write("</td>\n");
      out.write("                <td><a href=\"Sale_UpdateCustPage.jsp?custid=");
      out.print( cust.getCustid() );
      out.write("\">Update</a></td>\n");
      out.write("                <td><a href=\"Sale_DeleteCustPage.jsp?custid=");
      out.print( cust.getCustid() );
      out.write("\">Delete</a></td>\n");
      out.write("            </tr>\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("        </table>\n");
      out.write("        ");

            }
        
      out.write("\n");
      out.write("        \n");
      out.write("        <p><a href=\"Sale_CreateCustPage.jsp\">Create new Customer</a></p>\n");
      out.write("        <h3>\n");
      out.write("            ");

                if (request.getAttribute("ERROR") != null) {
                    out.print(request.getAttribute("ERROR"));
                } else if(request.getAttribute("SUCCESS") != null) {
                    out.print(request.getAttribute("SUCCESS"));
                }
            
      out.write("\n");
      out.write("        </h3>\n");
      out.write("        <br/>\n");
      out.write("        <a href=\"SalePersonPage.jsp\">Back home</a>\n");
      out.write("        \n");
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
