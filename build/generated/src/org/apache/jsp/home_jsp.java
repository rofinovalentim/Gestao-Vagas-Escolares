package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class home_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("        <style>\n");
      out.write("            body{\n");
      out.write("                background: white;\n");
      out.write("            }\n");
      out.write("            p{\n");
      out.write("                font-size: 25px;\n");
      out.write("                margin-left:  50px;\n");
      out.write("                margin-right:50px; \n");
      out.write("                text-align: justify;\n");
      out.write("            }\n");
      out.write("            .img{\n");
      out.write("                text-align: center;\n");
      out.write("            }\n");
      out.write("            #imagem{\n");
      out.write("              \n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .txt{\n");
      out.write("                font-family:  sans-serif;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("            legend{\n");
      out.write("                font-family: sans-serif;\n");
      out.write("                font-size: 30px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>  \n");
      out.write("\n");
      out.write("        <!-- <legend> Sistema de Publicacao de informacoes de vagas e informacoes escolares </legend> -->\n");
      out.write("        <table>\n");
      out.write("            <tr>\n");
      out.write("            <tr>\n");
      out.write("            <p class=\"img\"> <img id=\"imagem\" src=\"_img/vagass.png\"> </p>\n");
      out.write("        </tr>\n");
      out.write("\n");
      out.write("        <tr>\n");
      out.write("        <p> Devido ao fluxo de dados principalmente no período de matrículas tem criado transtornos\n");
      out.write("            que levam as pessoas a não conseguirem vagas para ingressar numa dada escola e porque\n");
      out.write("            não existem uma sincronia entre as escolas os cidadãos ficam desinformados de quais\n");
      out.write("            escolas existem vagas para tomarem mais opções em efectuar matricula noutra Escola.\n");
      out.write("            Nesta vertente o sistema disponibiliza informações de dados referentes a Vagas\n");
      out.write("            disponíveis nas Escolas e que os interessados possam realizar uma pré inscrição online e \n");
      out.write("            posteriormente ir solicitar a validação da respectiva matrícula com os comprovativos de pagamento </p>\n");
      out.write("    </tr>\n");
      out.write("</tr>\n");
      out.write("</table>\n");
      out.write("</body>\n");
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
