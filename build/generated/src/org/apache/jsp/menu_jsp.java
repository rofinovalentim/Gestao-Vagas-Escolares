package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import control.DistritoJpaController;
import model.Distrito;
import model.Role;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public final class menu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

List<Distrito> distritos;
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/login_style.css\" />\n");
      out.write("        <title>Menu</title>\n");
      out.write("        <style>\n");
      out.write("            a{\n");
      out.write("                font-family:sans-serif;\n");
      out.write("                font-size:14px;\n");
      out.write("                color:navy;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("                background: white;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            button{\n");
      out.write(" \n");
      out.write("            }\n");
      out.write("            .menuList {\n");
      out.write("                border: none;\n");
      out.write("                /*margin: 10px;*/\n");
      out.write("                list-style-type: none;\n");
      out.write("                width: 100%;\n");
      out.write("                margin: 0;\n");
      out.write("                padding: 0;\n");
      out.write("                overflow: auto;\n");
      out.write("\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            .menuList a {\n");
      out.write("                border-radius:0px ;\n");
      out.write("                border: none;\n");
      out.write("                margin: 2px;\n");
      out.write("                display: block;\n");
      out.write("                color: black;\n");
      out.write("                padding: 8px 16px;\n");
      out.write("                font-size: 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                background: #ffffff;\n");
      out.write("            }\n");
      out.write("            h2{\n");
      out.write("\n");
      out.write("                border-radius: 10%;\n");
      out.write("                padding: 2px;\n");
      out.write("            }\n");
      out.write("            .textbox{\n");
      out.write("                width: 80%;\n");
      out.write("                background: #2991d6;\n");
      out.write("                border: none;\n");
      out.write("                border-radius: 0px;\n");
      out.write("                padding: 5px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .search_box_button{\n");
      out.write("                background:rgb(66, 103, 178);\n");
      out.write("                padding: 10px;\n");
      out.write("                color: white;\n");
      out.write("                font-size: 18px;\n");
      out.write("                border-radius:50%;\n");
      out.write("                border: none;\n");
      out.write("                float: right;\n");
      out.write("\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\"height: 100%; background: -webkit-linear-gradient(left,#e2f6f6,#f1eeee); \" >\n");
      out.write("\n");
      out.write("        <h2 style=\"font-family:sans-serif;font-size:20px; background: #207dbb;\n");
      out.write("            border-radius:0px; color: white; margin-left: 10px; text-align: center \">MENU</h2>\n");
      out.write("        <ul>\n");
      out.write("            ");
      out.write("\n");
      out.write("            ");

                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                DistritoJpaController distritoController = new DistritoJpaController(emf);
                distritos = distritoController.findDistritoEntities();
            
      out.write("\n");
      out.write("            ");

                List<Role> rol = (List<Role>) session.getAttribute("permissoes");
                if (rol != null) {
                    if (rol.contains(new Role("VerEstudantes"))) {
            
      out.write("\n");
      out.write("            <button  class=\"menuList\">\n");
      out.write("                <li><a id=\"a1\" onclick=\"select('a1')\" href=\"listaEstudantes.jsp\" target=\"body\" >Pedidos</a></li>\n");
      out.write("            </button> <br>\n");
      out.write("\n");
      out.write("            ");

                }
                if (rol.contains(new Role("VerUsuarios"))) {
            
      out.write("\n");
      out.write("            <button class=\"menuList\">\n");
      out.write("                <li><a id=\"a2\" onclick=\"select('a2')\"   href=\"listaUsuario.jsp\" target=\"body\" >Utilizadores</a></li>\n");
      out.write("            </button>\n");
      out.write("            ");
 }
      out.write("\n");
      out.write("            ");

                if (rol.contains(new Role("VerEscolas"))) {
            
      out.write("\n");
      out.write("            <button class=\"menuList\">\n");
      out.write("                <li><a  id=\"a3\" onclick=\"select('a3')\"  href=\"listaEscola.jsp\" target=\"body\">Escolas</a></li>\n");
      out.write("            </button>\n");
      out.write("            ");
 }

            
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 } else {
      out.write("\n");
      out.write("            <button class=\"menuList\">\n");
      out.write("                <li><a id=\"a4\" onclick=\"select('a4')\"  href=\"listaEscolaCliente.jsp\" target=\"body\">Todas As Escolas</a></li>\n");
      out.write("            </button> \n");
      out.write("\n");
      out.write("            <br><P style=\"font-size: 20px\"> Procurar por distrito: </p>\n");
      out.write("            <form action=\"PesquisarPorDistrito\" target=\"body\" method=\"get\">\n");
      out.write("                <label style=\"font-size:18px\">*Distrito:</label><br>\n");
      out.write("                <select name=\"distrito\" class=\"textbox\"   style=\"\">\n");
      out.write("                    ");
for (Distrito distrito : this.distritos) {
                    
      out.write("\n");
      out.write("                    <option value=\"");
      out.print(distrito.getIdDistrito());
      out.write('"');
      out.write('>');
      out.print(distrito.getNomeDestrito());
      out.write("</option>\n");
      out.write("                    ");

                        }
                    
      out.write("\n");
      out.write("                </select>\n");
      out.write("\n");
      out.write("                <button class=\"search_box_button\"  type=\"submit\">Pesquisar</button>\n");
      out.write("\n");
      out.write("            </form>\n");
      out.write("            ");
}
      out.write("\n");
      out.write("\n");
      out.write("        </ul>\n");
      out.write("        <script>\n");
      out.write("            function select(j) {\n");
      out.write("                var anc = document.getElementsByTagName('a');\n");
      out.write("                var i;\n");
      out.write("                for (i = 0; i < anc.length; i++) {\n");
      out.write("                    anc[i].parentNode.style.backgroundColor = \"inherit\";\n");
      out.write("                    anc[i].style.color = \"white\";\n");
      out.write("                }\n");
      out.write("                var a = document.getElementById(j);\n");
      out.write("                // var a = document.getElementById(j);\n");
      out.write("                a.parentNode.style.backgroundColor = \"blue\";\n");
      out.write("                a.style.color = 'black';\n");
      out.write("                top.location.hash = a.innerHTML;\n");
      out.write("                // alert(top.location.href);\n");
      out.write("            }\n");
      out.write("            \n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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
