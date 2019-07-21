package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.TipoUsuario;
import control.UserJpaController;
import control.RoleJpaController;
import model.Role;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import model.User;

public final class cadastrarAdministrador_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

List<User> userList;
            List<TipoUsuario> tipoUser;
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
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/login_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/cadastrarAdministrador.css\" />\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .login-box{\n");
      out.write("                top: 20%;\n");
      out.write("                left: 50%;\n");
      out.write("                width: 95%;\n");
      out.write("                height: 400px;\n");
      out.write("                background: white; /*rgb(233, 235, 238); */\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .login-box h2{\n");
      out.write("                /* text-decoration: none;\n");
      out.write("                 font-family:  sans-serif;\n");
      out.write("                 color: white;\n");
      out.write("                 float: left;\n");
      out.write("                 font-size: 40px;\n");
      out.write("                 border-bottom: 6px solid white #4caf50*/;\n");
      out.write("                margin-bottom: 20px;\n");
      out.write("                text-align: center;\n");
      out.write("                border-radius: 20%;\n");
      out.write("                /* padding: 13px 0;*/\n");
      out.write("            }\n");
      out.write("            legend{\n");
      out.write("                text-align:  center;\n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                float: right;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function validar() {\n");
      out.write("\n");
      out.write("\n");
      out.write("                if (formuser.senha.value != formuser.tsenha.value) {\n");
      out.write("                    alert('CONFIRME A PALAVRA PASSE E TENTE NOVAMENTE');\n");
      out.write("                    formuser.tsenha.focus();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <title>Cadastrar Administrador</title>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            userList = new UserJpaController(emf).findUserEntities();

        
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"CadastrarUsuario\" name=\"formuser\" method=\"GET\">\n");
      out.write("            <div class=\"login-box\">\n");
      out.write("\n");
      out.write("                <legend> <h2 style=\"color: black\">Cadastrar Administrador</h2></legend>\n");
      out.write("                \n");
      out.write("\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td class=\"textbox\">&#128100</td><td><input class=\" textbox\" type=\"text\" size=\"200\" required value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.userName}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"  name=\"username\"  id=\"cnome\" placeholder=\"Novo usuario\"/></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                \n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>&#128273</td><td><input type=\"password\" required=\"\" size=\"200\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"senha\"   placeholder=\"Senha\"/></td>  \n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>&#128273</td><td><input type=\"password\" required=\"\" size=\"200\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.password}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"tsenha\"  placeholder=\"Confirmar senha\"/><td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>&#64</td><td> <input type=\"email\" required=\"\" size=\"200\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${user.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" name=\"email\"  placeholder=\"E-mail\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                </div>\n");
      out.write("                \n");
      out.write("                        <select class=\"textbox\" name=\"tipo\">\n");
      out.write("                        <option >Administrador</option>\n");
      out.write("                        <option>SuperAdministrador</option>\n");
      out.write("                    </select>\n");
      out.write("                \n");
      out.write("                <button type=\"submit\" class=\"btn\" onclick=\"return validar()\">Adicionar </button>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("\n");
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
