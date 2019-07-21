package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.DistritoJpaController;
import javax.persistence.EntityManagerFactory;
import model.Distrito;
import java.util.List;
import model.Escola;

public final class cadastrarEscola_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

List<Distrito> distritoList;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/login_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/cadastrarAdministrador.css\" />\n");
      out.write("        <title>Cadastrar Escola</title>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            body{\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("            .login-box{\n");
      out.write("                top: 500%;\n");
      out.write("                left: 50%;\n");
      out.write("                width: 95%;\n");
      out.write("                height: auto;\n");
      out.write("                background: white; /*rgb(233, 235, 238); */\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .textboxv{\n");
      out.write("                margin-left: 50px;\n");
      out.write("                border: none;\n");
      out.write("                width: 60%;\n");
      out.write("                overflow: hidden;\n");
      out.write("                font-size: 20px;\n");
      out.write("                padding: 8px 0;\n");
      out.write("                margin: 8px 0;\n");
      out.write("                background: white;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                border-bottom: 3px solid #4caf50;\n");
      out.write("\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            input{\n");
      out.write("                border:none;\n");
      out.write("                outline: none;\n");
      out.write("                background: none;\n");
      out.write("                color: black;\n");
      out.write("                font-size: 18px;\n");
      out.write("                width: 90%;\n");
      out.write("                float: left;\n");
      out.write("                margin: 0 10px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .classes{\n");
      out.write("                background:  #207dbb;\n");
      out.write("                padding: 20px 30px;\n");
      out.write("                border-radius: 10px; \n");
      out.write("                align-content: center;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .classes label{\n");
      out.write("                color: #f2f2f2;\n");
      out.write("            }\n");
      out.write("            h1{\n");
      out.write("                border: none;\n");
      out.write("                padding: 10px;\n");
      out.write("                text-align: left;\n");
      out.write("                text-decoration: none;\n");
      out.write("                font-size: 20px;\n");
      out.write("                font-family:  sans-serif;\n");
      out.write("\n");
      out.write("                padding: 10px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            label{\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\" background: white\">\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");

            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            distritoList = new DistritoJpaController(emf).findDistritoEntities();

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\" login-box\">\n");
      out.write("        <form action=\"CadastrarEscola\" method=\"get\">\n");
      out.write("\n");
      out.write("\n");
      out.write("            <label> <h2 style=\"color: black\">Cadastrar Administrador</h2></label>\n");
      out.write("\n");
      out.write("            <span class=\"close\">&times;</span>\n");
      out.write("\n");
      out.write("            <input type=\"hidden\"  name=\"ide\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${escola.idEscola}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("            <label>*Nome da Escola:</label>\n");
      out.write("            <input class=\" textbox\" type=\"text\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${escola.nomeEscola}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Insira o nome da Escola\" name=\"nomeEscola\">\n");
      out.write("\n");
      out.write("            <label>*Endereco:</label>\n");
      out.write("            <input class=\" textbox\" type=\"text\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${escola.endereco}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Endereco\" name=\"endereco\" >\n");
      out.write("\n");
      out.write("            <label>*Distrito: </label>\n");
      out.write("            <select name=\"distrito\" required=\"\" class=\"textbox\">\n");
      out.write("                ");
 for (int i = 0; i < distritoList.size(); i++) {
                
      out.write("\n");
      out.write("                <option value=\"");
      out.print(distritoList.get(i).getIdDistrito());
      out.write('"');
      out.write('>');
      out.print(distritoList.get(i).getNomeDestrito());
      out.write("</option>\n");
      out.write("                ");

                    }
                
      out.write("\n");
      out.write("            </select>\n");
      out.write("\n");
      out.write("            <label>*Telefone:</label>\n");
      out.write("            <input class=\"textbox\" type=\"tel\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${escola.telefone}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Telefone\" name=\"tel\" >\n");
      out.write("            <label>*Email:</label>\n");
      out.write("            <input class=\"textbox\" type=\"email\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${escola.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"Email\" name=\"email\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            <label style=\"text-align: center; color:  #003300\">*Vagas Nas Classes:</label><br>\n");
      out.write("             \n");
      out.write("                         <label>*8 Classe:</label>\n");
      out.write(" \n");
      out.write("                         <input class=\"textboxv\" type=\"number\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vaga1.nrVagas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"8 classe\" name=\"8classe\" min=\"0\">\n");
      out.write(" \n");
      out.write("                     \n");
      out.write("                         <label>*9 Classe:</label>\n");
      out.write(" \n");
      out.write("                         <input class=\"textboxv\" type=\"number\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vaga2.nrVagas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"9 classe\" name=\"9classe\" min=\"0\">\n");
      out.write(" \n");
      out.write("                \n");
      out.write("                         <label>*10 Classe:</label>\n");
      out.write(" \n");
      out.write("                         <input class=\"textboxv\" type=\"number\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vaga3.nrVagas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"10 classe\" name=\"10classe\" min=\"0\">\n");
      out.write(" \n");
      out.write("                     \n");
      out.write("                         <label>*11 Classe:</label>\n");
      out.write(" \n");
      out.write("                         <input class=\" textboxv\" type=\"number\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vaga4.nrVagas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"11 classe\" name=\"11classe\" min=\"0\">\n");
      out.write(" \n");
      out.write("                  \n");
      out.write("                         <label>*12 Classe:</label>\n");
      out.write(" \n");
      out.write("                         <input class=\"textboxv\" type=\"number\" required=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vaga5.nrVagas}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" placeholder=\"12 classe\" name=\"12classe\" min=\"0\">\n");
      out.write(" \n");
      out.write("              \n");
      out.write("\n");
      out.write("            <button type=\"submit\" class=\"btn\" >Adicionar </button>\n");
      out.write("            <button type=\"reset\" class=\"reset\" >Cancelar</button>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var span = document.getElementsByClassName(\"close\")[0];\n");
      out.write("            span.onclick = function () {\n");
      out.write("                document.getElementById('cadastroEscola').style.display = \"none\";\n");
      out.write("            }\n");
      out.write("        </script>\n");
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
