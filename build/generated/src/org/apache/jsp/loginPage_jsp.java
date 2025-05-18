package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class loginPage_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>LOGIN PAGE</title>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"styles/style.css\"/>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css\" integrity=\"sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\"/>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        <div class=\"container\" id=\"container\">\n");
      out.write("            <div class=\"form-container staff-container\">\n");
      out.write("                <form action=\"MainServlet\" accept-charset=\"utf-8\" method=\"post\">\n");
      out.write("                    <h1>Staff login here.</h1>\n");
      out.write("                    <div class=\"form-control\">\n");
      out.write("                        <input type=\"text\" name=\"staffname\" placeholder=\"Name\" />\n");
      out.write("                    </div>\n");
      out.write("                    <input class=\"input\" type=\"submit\" value=\"Login\" style=\"\n");
      out.write("                           position: relative;\n");
      out.write("                           border-radius: 20px;\n");
      out.write("                           border: 1px solid #4bb6b7;\n");
      out.write("                           background-color: #4bb6b7;\n");
      out.write("                           color: #fff;\n");
      out.write("                           font-size: 15px;\n");
      out.write("                           font-weight: 700;\n");
      out.write("                           margin: 20px;\n");
      out.write("                           padding: 12px 80px;\n");
      out.write("                           letter-spacing: 1px;\n");
      out.write("                           text-transform: capitalize;\n");
      out.write("                           transition: 0.3s ease-in-out;\n");
      out.write("                           cursor: pointer;\"/>\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"login_Staff\">\n");
      out.write("                    <h4>\n");
      out.write("                        ");

                            if (request.getAttribute("ERROR2") != null) {
                                out.print(request.getAttribute("ERROR2"));
                            }
                        
      out.write("\n");
      out.write("                    </h4>\n");
      out.write("                    <span>or use your account</span>\n");
      out.write("                    <div class=\"social-container\">\n");
      out.write("                        <a href=\"#\" class=\"social\"\n");
      out.write("                           ><i class=\"fa-brands fa-facebook-f\"></i\n");
      out.write("                            ></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fa-brands fa-google\"></i></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fa-brands fa-tiktok\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"form-container cust-container\">\n");
      out.write("                <form action=\"MainServlet\" accept-charset=\"utf-8\">\n");
      out.write("                    \n");
      out.write("                    <h1>Customer login here.</h1>\n");
      out.write("                    <div class=\"form-control2\">\n");
      out.write("                        <input type=\"text\" name=\"custname\" placeholder=\"Enter your name...\" />\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-control2\">\n");
      out.write("                        <input type=\"text\" name=\"custphone\" placeholder=\"Enter your phone...\" />\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <input class=\"input\" type=\"submit\" value=\"Login\" style=\"\n");
      out.write("                           position: relative;\n");
      out.write("                           border-radius: 20px;\n");
      out.write("                           border: 1px solid #4bb6b7;\n");
      out.write("                           background-color: #4bb6b7;\n");
      out.write("                           color: #fff;\n");
      out.write("                           font-size: 15px;\n");
      out.write("                           font-weight: 700;\n");
      out.write("                           margin: 20px;\n");
      out.write("                           padding: 12px 80px;\n");
      out.write("                           letter-spacing: 1px;\n");
      out.write("                           text-transform: capitalize;\n");
      out.write("                           transition: 0.3s ease-in-out;\n");
      out.write("                           cursor: pointer;\"/>\n");
      out.write("                    <input type=\"hidden\" name=\"action\" value=\"login_Customer\" />\n");
      out.write("                    <h4>\n");
      out.write("                        ");

                            if (request.getAttribute("ERROR1") != null) {
                                out.print(request.getAttribute("ERROR1"));
                            }
                        
      out.write("\n");
      out.write("                    </h4>\n");
      out.write("                    <span>Or use your account</span>\n");
      out.write("                    <div class=\"social-container\">\n");
      out.write("                        <a href=\"#\" class=\"social\"\n");
      out.write("                           ><i class=\"fa-brands fa-facebook-f\"></i\n");
      out.write("                            ></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fa-brands fa-google\"></i></a>\n");
      out.write("                        <a href=\"#\" class=\"social\"><i class=\"fa-brands fa-tiktok\"></i></a>\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"overlay-container\">\n");
      out.write("                <div class=\"overlay\">\n");
      out.write("                    <div class=\"overlay-panel overlay-left\">\n");
      out.write("                        <h1 class=\"title\">\n");
      out.write("                            Hello <br />\n");
      out.write("                            staffs\n");
      out.write("                        </h1>\n");
      out.write("                        <p>If you are not staff, login here!</p>\n");
      out.write("                        <button class=\"ghost\" id=\"customerlogin\">\n");
      out.write("                            Customer login\n");
      out.write("                            <i class=\"fa-solid fa-arrow-left\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <div class=\"overlay-panel overlay-right\">\n");
      out.write("                        <h1 class=\"title\">\n");
      out.write("                            Start your <br />\n");
      out.write("                            journey now\n");
      out.write("                        </h1>\n");
      out.write("                        <p>\n");
      out.write("                            If you are staff, login here!\n");
      out.write("                        </p>\n");
      out.write("                        <button class=\"ghost\" id=\"stafflogin\">\n");
      out.write("                            Staff login\n");
      out.write("                            <i class=\"fa-solid fa-arrow-right\"></i>\n");
      out.write("                        </button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script>\n");
      out.write("            window.addEventListener(\"load\", function () {\n");
      out.write("                let message = localStorage.getItem(\"logoutMessage\");\n");
      out.write("                if (message) {\n");
      out.write("                    alert(message);\n");
      out.write("                    localStorage.removeItem(\"logoutMessage\");\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write(" \n");
      out.write("        <script src=\"./stylejs/effect.js\"></script>\n");
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
