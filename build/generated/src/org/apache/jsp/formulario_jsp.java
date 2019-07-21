package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.EscolaJpaController;
import javax.persistence.EntityManagerFactory;
import model.Escola;
import java.util.List;

public final class formulario_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

Escola escola;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <title>Pré-inscrição</title>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/formulario_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/login_style.css\" />\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            .login-box{\n");
      out.write("                width: 90%;\n");
      out.write("                top: 80%;\n");
      out.write("                left: 50%;\n");
      out.write("                background: white; \n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background:white;\n");
      out.write("            }\n");
      out.write("            label{\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            legend{\n");
      out.write("                color: black;\n");
      out.write("                border-bottom: 1px solid #4caf50;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            escola = (Escola) request.getAttribute("escola");
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");

            // escola= new EscolaJpaController(emf).findEscola(Integer.parseInt(request.getParameter("ide")));

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <form action=\"AdicionarEstudante\">\n");
      out.write("\n");
      out.write("            <div class=\"login-box\">\n");
      out.write("                <span class=\"close\">&times;</span>\n");
      out.write("                <legend> Pré-inscrição</legend><br><br><br><br><br>\n");
      out.write("                <label>*Nome Completo:</label>\n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <input class=\"input_inscricao\" type=\"text\" required=\"\" name=\"nome\"  placeholder=\"Nome completo\">\n");
      out.write("                </div>\n");
      out.write("                <label>*E-mail:</label>\n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <input class=\"input_inscricao\" type=\"text\" required=\"\" name=\"email\" placeholder=\"email\">\n");
      out.write("                </div>\n");
      out.write("                <label>*Numero de BI:</label>\n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <input class=\"input_inscricao\" type=\"text\" required=\"\" name=\"nr_bi\" placeholder=\"Numero de BI\">\n");
      out.write("                </div> \n");
      out.write("                <label>*Telefone:</label>\n");
      out.write("                <div class=\"textbox\">\n");
      out.write("                    <input class=\"input_inscricao\" type=\"tel\" required=\"\" name=\"telefone\" placeholder=\"Telefone\">\n");
      out.write("                </div> \n");
      out.write("                <label>*Genero:</label>\n");
      out.write("                <select name=\"genero\" class=\"textbox\">\n");
      out.write("                    <option>Masculino</option>\n");
      out.write("                    <option>Femenino</option>\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <br><label>*Data de Nascimento:</label><br>\n");
      out.write("\n");
      out.write("                <input class=\" textbox\" style=\" width: 20%\" type=\"date\" required=\"\" name=\"dataNasc\"><br>\n");
      out.write("\n");
      out.write("\n");
      out.write("                <!--  <label>*Escola: </label> <br>          \n");
      out.write("                  <select class=\"textbox\" name=\"escola\" readonly style=\"background:  #207dbb;color: white \" >  \n");
      out.write("                      <option readonly value=\"< %=escola.getIdEscola()%>\"> < %=escola.getNomeEscola()%></option>\n");
      out.write("                  </select>\n");
      out.write("  \n");
      out.write("  \n");
      out.write("                   \n");
      out.write("  \n");
      out.write("  \n");
      out.write("                  <label>*Classe:</label> <br>\n");
      out.write("                  <input type=\"text\" style=\" width: 15%; background:  #207dbb;color: white \" name=\"classe\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vaga}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly=\"\"> <br>\n");
      out.write("                -->\n");
      out.write("\n");
      out.write("                <button type=\"submit\" class=\"btn\">Enviar</button>\n");
      out.write("\n");
      out.write("            </div> \n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <script>\n");
      out.write("            var span = document.getElementsByClassName(\"close\")[0];\n");
      out.write("            span.onclick = function () {\n");
      out.write("                document.getElementById('cadastroUser').style.display = \"none\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
