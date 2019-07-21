package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import model.Role;
import java.util.List;
import model.User;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<link rel=\"stylesheet\" href=\"css/style.css\">\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/login_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/modal.css\" />\n");
      out.write("        <title>Pagina Principal</title>\n");
      out.write("        <script>\n");
      out.write("            function info() {\n");
      out.write("                document.getElementById('myModal').style.display = \"block\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function fecharInfo() {\n");
      out.write("                alert('sdfsdf');\n");
      out.write("                //modal.style.display = \"block\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var span = document.getElementsByClassName(\"close\")[0];\n");
      out.write("            span.onclick = function () {\n");
      out.write("                document.getElementById('myModal').style.display = \"none\";\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (event.target == document.getElementById('myModal')) {\n");
      out.write("                    document.getElementById('myModal').style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("\n");
      out.write("            function validar() {\n");
      out.write("                if (formu.s1.value != formu.s2.value) {\n");
      out.write("                    alert('Por favor confirme a senha');\n");
      out.write("                    formu.s2.scrollIntoView();\n");
      out.write("                    return false;\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <style>\n");
      out.write("\n");
      out.write("            #footer{\n");
      out.write("                top:100px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            #header ul{\n");
      out.write("                list-style: none;\n");
      out.write("                text-transform: uppercase;\n");
      out.write("                position: relative;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            body{\n");
      out.write("\n");
      out.write("                background: rgb(233, 235, 238);\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .link_menu{\n");
      out.write("                margin: 5px;\n");
      out.write("                background:  #207dbb;\n");
      out.write("                border: none; \n");
      out.write("            }\n");
      out.write("            .enter_sair{\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            li{\n");
      out.write("                font-family:  sans-serif;\n");
      out.write("                padding: 10px;\n");
      out.write("                margin-left: 10px;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                display: inline-block;\n");
      out.write("            }\n");
      out.write("            a{\n");
      out.write("                font-size: 20px;\n");
      out.write("                text-decoration: none;\n");
      out.write("                border-radius: 10px;\n");
      out.write("                color: white;\n");
      out.write("            }\n");
      out.write("            .corpo1{\n");
      out.write("                height: 535px;\n");
      out.write("                border-left: 2px solid #f1eeee;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .menu1{\n");
      out.write("                height: 535px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .click{\n");
      out.write("                color:  #000;\n");
      out.write("\n");
      out.write("                padding: 10px;\n");
      out.write("                border-radius: 50%;\n");
      out.write("                margin: 5px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            label{\n");
      out.write("                color: black;\n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                background:  #207dbb;\n");
      out.write("            }\n");
      out.write("            .click{\n");
      out.write("                position: absolute;\n");
      out.write("                float: right;\n");
      out.write("                left: 83%;\n");
      out.write("            }\n");
      out.write("            #header{\n");
      out.write("                height: 70px;\n");
      out.write("                background: white;\n");
      out.write("                border-bottom: 2px solid #f1eeee;\n");
      out.write("            }\n");
      out.write("            #footer{\n");
      out.write("                height: 20px;\n");
      out.write("            }\n");
      out.write("            .modal-content{\n");
      out.write("                background: #f2f2f2;\n");
      out.write("                border:  none;\n");
      out.write("                color: black;\n");
      out.write("                left: 40%;\n");
      out.write("                height: 170px;\n");
      out.write("                width: 200px;\n");
      out.write("                top: -7%;\n");
      out.write("            }\n");
      out.write("            .modal{\n");
      out.write("                background-color: rgba(0,0,0,0); /* Black w/ opacity */;\n");
      out.write("            }\n");
      out.write("            .btn{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\" background: white\" >\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"header\" style=\" ;/* -webkit-linear-gradient(left,#e2f6f6,#f1eeee); */\">\n");
      out.write("\n");
      out.write("            <ul>\n");
      out.write("                <button class=\"link_menu\"><li><a  href=\"index.jsp\" target=\"my_frame\">Pagina Inicial</a></li></button>\n");
      out.write("                <!-- <button class=\"link_menu\"><li><a  href=\"http://www.mined.gov.mz/Pages/Home.aspx\" target=\"blanck\">Educação</a></li></button> -->\n");
      out.write("\n");
      out.write("                ");

                    List<Role> rol = (List<Role>) session.getAttribute("permissoes");
                    if (rol == null) {
                
      out.write("\n");
      out.write("                <button class=\"link_menu\" style=\" background: none; position: absolute;left: 92%;\"><li><a   style=\" color: black\" href=\"login.jsp\">Entrar</a></li></button>\n");
      out.write("                        ");

                        } else {

                        
      out.write("\n");
      out.write("                <label class=\"click\" onclick=\"info();\">\t&#128100");
      out.print( ((User) session.getAttribute("user")).getUserName());
      out.write("</label>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("            </ul>\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"myModal\" class=\"modal\">\n");
      out.write("            <!-- Modal content -->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <span class=\"close\">&times;</span>\n");
      out.write("\n");
      out.write("                ");
 if ((User) session.getAttribute("user") != null) {
      out.write("\n");
      out.write("                <p>User: \n");
      out.write("                    ");
      out.print( ((User) session.getAttribute("user")).getUserName().toLowerCase());
      out.write(" </p>\n");
      out.write("                <p> Tipo</p>\n");
      out.write("\n");
      out.write("                <option style=\" font-size:  20px\"> \n");
      out.write("                    ");
      out.print( ((User) session.getAttribute("user")).getIdTipo().getDescricao());
      out.write("\n");
      out.write("                </option>\n");
      out.write("\n");
      out.write("                <a class=\" btn\"  style=\" font-size: 20px;\" href=\"terminarSessao.jsp\">Sair</a>\n");
      out.write("                ");
 }
      out.write("\n");
      out.write("\n");
      out.write("            </div>                  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div>\n");
      out.write("            <iframe class=\"menu1\" frameborder=\"none\" name=\"menu\" width=\"18%\" height=\"500px\"  src=\"menu.jsp\"></iframe>\n");
      out.write("                ");
 if ((User) session.getAttribute("user") != null) {
      out.write("\n");
      out.write("            <iframe class=\"corpo1\"  frameborder=\"none\" name=\"body\" width=\"77%\" height=\"500px\"  src=\"listaEstudantes.jsp\"></iframe>\n");
      out.write("                ");
} else {  
      out.write("\n");
      out.write("            <iframe class=\"corpo1\"  frameborder=\"none\" name=\"body\" width=\"77%\" height=\"500px\"  src=\"home.jsp\"></iframe>\n");
      out.write("                ");
}
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div align=\"center\" style=\" background: #f1eeee;\" id=\"footer\">\n");
      out.write("            <p>Copyright &copy; 2018 </p>\n");
      out.write("        </div>\n");
      out.write("    </body>\n");
      out.write("    <script>\n");
      out.write("\n");
      out.write("        function select(j) {\n");
      out.write("            var anc = document.getElementsByTagName('a');\n");
      out.write("            var i;\n");
      out.write("            for (i = 0; i < anc.length; i++) {\n");
      out.write("                anc[i].parentNode.style.backgroundColor = \"inherit\";\n");
      out.write("                anc[i].style.color = \"white\";\n");
      out.write("            }\n");
      out.write("            var a = document.getElementById(j);\n");
      out.write("            // var a = document.getElementById(j);\n");
      out.write("            a.parentNode.style.backgroundColor = \"blue\";\n");
      out.write("            a.style.color = 'black';\n");
      out.write("            top.location.hash = a.innerHTML;\n");
      out.write("            // alert(top.location.href);\n");
      out.write("        }\n");
      out.write("        function info() {\n");
      out.write("            //modal.style.display = \"block\";\n");
      out.write("            document.getElementById('myModal').style.display = \"block\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        function fecharInfo() {\n");
      out.write("            alert('sdfsdf');\n");
      out.write("            //modal.style.display = \"block\";\n");
      out.write("        }\n");
      out.write("\n");
      out.write("        var span = document.getElementsByClassName(\"close\")[0];\n");
      out.write("        span.onclick = function () {\n");
      out.write("            document.getElementById('myModal').style.display = \"none\";\n");
      out.write("        }\n");
      out.write("        window.onclick = function (event) {\n");
      out.write("            if (event.target == document.getElementById('myModal')) {\n");
      out.write("                document.getElementById('myModal').style.display = \"none\";\n");
      out.write("            }\n");
      out.write("        };\n");
      out.write("\n");
      out.write("        function validar() {\n");
      out.write("            if (formu.senha.value != formu.confirm.value) {\n");
      out.write("                alert('Por favor confirme a senha');\n");
      out.write("                formu.confirm.scrollIntoView();\n");
      out.write("                return false;\n");
      out.write("            }\n");
      out.write("        }\n");
      out.write("    </script>\n");
      out.write("\n");
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
