package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Parts;
import DAO.PartsDAO;
import model.PartsUsed;
import DAO.PartsUsedDAO;
import model.Mechanic;
import DAO.MechanicDAO;
import model.Service;
import DAO.ServiceDAO;
import model.ServiceMechanic;
import DAO.ServiceMechanicDAO;
import model.Car;
import DAO.CarDAO;
import model.Customer;
import DAO.CustomerDAO;
import model.ServiceTicket;
import java.util.ArrayList;
import model.SalePerson;
import model.Customer;

public final class Sale_005fServiceTicketPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <div class=\"container mx-auto p-6 min-h-screen mb-10\">\n");
      out.write("            <h1 class=\"text-3xl font-bold text-center text-black mb-6\">Service Ticket List</h1>\n");
      out.write("\n");
      out.write("            ");

                ArrayList<ServiceTicket> listSt = (ArrayList<ServiceTicket>) session.getAttribute("SALE_LISTST");
                if (listSt != null && !listSt.isEmpty()) {
            
      out.write("\n");
      out.write("\n");
      out.write("            <table class=\"w-full border border-gray-400 text-center\">\n");
      out.write("                <thead class=\"bg-gray-300\">\n");
      out.write("                    <tr>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Service Ticket ID</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Customer Name</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Car Model</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Service Name</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Mechanic Name</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Service Price</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Parts Used</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Number of Parts</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Price of Parts</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Received Date</th>\n");
      out.write("                        <th class=\"border border-gray-400 px-4 py-2\">Returned Date</th>\n");
      out.write("                    </tr>\n");
      out.write("                </thead>\n");
      out.write("                <tbody>\n");
      out.write("                    ");

                        for (ServiceTicket serTic : listSt) {
                    
      out.write("\n");
      out.write("                    <tr class=\"hover:bg-gray-200\">\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2\">");
      out.print( serTic.getServiceTicketID());
      out.write("</td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2\">\n");
      out.write("                            ");

                                CustomerDAO custd = new CustomerDAO();
                                Customer cust = custd.findCustomerByID(serTic.getCustID());
                                if (cust != null) {
                            
      out.write("\n");
      out.write("                            ");
      out.print( cust.getCustname());
      out.write("\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2\">\n");
      out.write("                            ");

                                CarDAO card = new CarDAO();
                                Car car = card.getCar(serTic.getCarID());
                                if (car != null) {
                            
      out.write("\n");
      out.write("                            ");
      out.print( car.getModel());
      out.write("\n");
      out.write("                            ");

                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2\">\n");
      out.write("                            ");

                                ServiceMechanicDAO smd = new ServiceMechanicDAO();
                                ArrayList<ServiceMechanic> listSm = smd.getServiceMechanic("" + serTic.getServiceTicketID());
                                if (listSm != null && !listSm.isEmpty()) {
                                    ServiceDAO sd = new ServiceDAO();
                                    for (ServiceMechanic serMecha : listSm) {
                                        Service ser = sd.getService("" + serMecha.getServiceID());
                            
      out.write("\n");
      out.write("                            ");
      out.print( ser.getServiceName());
      out.write(" <br/>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2\">\n");
      out.write("                            ");

                                if (listSm != null && !listSm.isEmpty()) {
                                    MechanicDAO md = new MechanicDAO();
                                    for (ServiceMechanic serMecha : listSm) {
                                        Mechanic mecha = md.getMechanic(serMecha.getMechanicID());
                            
      out.write("\n");
      out.write("                            ");
      out.print( mecha.getName());
      out.write(" <br/>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2 text-right\">\n");
      out.write("                            ");

                                if (listSm != null && !listSm.isEmpty()) {
                                    for (ServiceMechanic serMecha : listSm) {
                            
      out.write("\n");
      out.write("                            ");
      out.print( serMecha.getRate());
      out.write(" <br/>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2\">\n");
      out.write("                            ");

                                PartsUsedDAO pud = new PartsUsedDAO();
                                ArrayList<PartsUsed> listPu = pud.getPartsUsed("" + serTic.getServiceTicketID());
                                if (listPu != null && !listPu.isEmpty()) {
                                    PartsDAO pd = new PartsDAO();
                                    for (PartsUsed pu : listPu) {
                                        Parts part = pd.getParts("" + pu.getPartID());
                            
      out.write("\n");
      out.write("                            ");
      out.print( part.getPartName());
      out.write(" <br/>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2 text-center\">\n");
      out.write("                            ");

                                if (listPu != null && !listPu.isEmpty()) {
                                    for (PartsUsed pu : listPu) {
                            
      out.write("\n");
      out.write("                            ");
      out.print( pu.getNumberUsed());
      out.write(" <br/>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2 text-right\">\n");
      out.write("                            ");

                                if (listPu != null && !listPu.isEmpty()) {
                                    for (PartsUsed pu : listPu) {
                            
      out.write("\n");
      out.write("                            ");
      out.print( pu.getPrice());
      out.write(" <br/>\n");
      out.write("                            ");

                                    }
                                }
                            
      out.write("\n");
      out.write("                        </td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2 text-center\">");
      out.print( serTic.getDateReceived());
      out.write("</td>\n");
      out.write("                        <td class=\"border border-gray-400 px-4 py-2 text-center\">");
      out.print( serTic.getDateReturned());
      out.write("</td>\n");
      out.write("                    </tr>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </tbody>\n");
      out.write("            </table>\n");
      out.write("\n");
      out.write("            ");

                }
            
      out.write("\n");
      out.write("\n");
      out.write("            <div class=\"text-center mt-6\">\n");
      out.write("                <a href=\"MainServlet?action=sale_createSt\" class=\"bg-green-600 text-white px-4 py-2 rounded hover:bg-green-700\">Create New Service Ticket</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <h3 class=\"text-center text-red-600 mt-4\">\n");
      out.write("                ");

                    if (request.getAttribute("ERROR") != null) {
                        out.print(request.getAttribute("ERROR"));
                    } else if (request.getAttribute("SUCCESS") != null) {
                        out.print(request.getAttribute("SUCCESS"));
                    }
                
      out.write("\n");
      out.write("            </h3>\n");
      out.write("\n");
      out.write("            <div class=\"text-center mt-6\">\n");
      out.write("                <a href=\"MainServlet?action=salePersonPage\" class=\"bg-blue-600 text-white px-4 py-2 rounded hover:bg-blue-700\">Back Home</a>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
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
