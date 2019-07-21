package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import control.VagasJpaController;
import model.Vagas;
import model.User;
import control.EscolaJpaController;
import javax.persistence.EntityManagerFactory;
import model.Escola;
import java.util.List;

public final class listaEscolaCliente_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

List<Escola> escolas;
            List<Vagas> vagas;
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/listaEstudantes_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/search-box.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/modal.css\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("            td a{\n");
      out.write("                color:white;\n");
      out.write("                background: #00adee;  \n");
      out.write("                padding: 5px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            tr{\n");
      out.write("                background-color: white;\n");
      out.write("            }\n");
      out.write("            table{\n");
      out.write("                position: relative;\n");
      out.write("                top: -10px;\n");
      out.write("            }\n");
      out.write("            td{\n");
      out.write("                font-family:  sans-serif;\n");
      out.write("            }\n");
      out.write("            td  a:hover{\n");
      out.write("                background: yellowgreen;\n");
      out.write("            } \n");
      out.write("            tr{\n");
      out.write("                width: 100%;\n");
      out.write("            }\n");
      out.write("            #escola{\n");
      out.write("                width: 500px;\n");
      out.write("                height: 300px;\n");
      out.write("            }\n");
      out.write("            #seta{\n");
      out.write("                width: 20px;\n");
      out.write("                height: 20px;\n");
      out.write("\n");
      out.write("            }\n");
      out.write("            .modal-content{\n");
      out.write("                background:  #f2f2f2;\n");
      out.write("                height: 20px;\n");
      out.write("\n");
      out.write("                border-radius: 10px;\n");
      out.write("            }\n");
      out.write("            .modal-content p{\n");
      out.write("                font-family:  sans-serif;\n");
      out.write("                font-size: 20px;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .yes{\n");
      out.write("                float: left;\n");
      out.write("                border: none;\n");
      out.write("                background:  red;\n");
      out.write("                font-size: 20px;\n");
      out.write("                font-family: sans-serif;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                color: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("            .no{\n");
      out.write("                float: right;\n");
      out.write("                border: none;\n");
      out.write("                background: #00adee;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                font-size: 20px;\n");
      out.write("                font-family: sans-serif;\n");
      out.write("                color: white;\n");
      out.write("                cursor: pointer;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("        <title>Lista de Escolas</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"search_box\">\n");
      out.write("            <form action=\"PesquisarEscola\">\n");
      out.write("                <input type=\"hidden\" value=\"1\" name=\"tipo\">\n");
      out.write("                <input class=\"search_box_input\" type=\"search\" name=\"pesquisa\" placeholder=\"Nome Da Escola...\">\n");
      out.write("                <button class=\"search_box_button\" type=\"submit\">&#128269</button>\n");
      out.write("            </form>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"sucessoModal\" class=\"modal\">\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <b style=\" font-family:  sans-serif; font-size: 20px\">Enviada com sucesso!</b>\n");
      out.write("                <button class=\"no\" onclick=\"fechar()\">Ok</button>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");

            if (request.getAttribute("verificar") != null) {
        
      out.write("\n");
      out.write("        <script>\n");
      out.write("            document.getElementById(\"sucessoModal\").style.display = 'block';\n");
      out.write("        </script>\n");
      out.write("        ");
}
      out.write(" \n");
      out.write("\n");
      out.write("        <h2>Lista de Escolas</h2> <br>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");


            List<Escola> userList = (List<Escola>) request.getAttribute("escolas");
            if (userList != null && !userList.isEmpty()) {
                escolas = userList;
            } else {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                EscolaJpaController escolaController = new EscolaJpaController(emf);
                escolas = escolaController.findEscolaEntities();

                VagasJpaController vagasController = new VagasJpaController(emf);
                vagas = vagasController.findVagasEntities();
            }

        
      out.write("\n");
      out.write("\n");
      out.write("        <table style=\"width:100%  \" >\n");
      out.write("\n");
      out.write("            <tbody>\n");
      out.write("                ");
 for (Escola escola : this.escolas) {
                        ArrayList<Vagas> vagaList = new ArrayList<Vagas>();
                
      out.write("\n");
      out.write("                <tr>\n");
      out.write("\n");
      out.write("                    <td style=\"\"> <img id=\"escola\" src=\"_img/escola.jpg\"> </td>\n");
      out.write("                    <td class=\"escola\" style=\" text-align: left; font-size: 20px;\">\n");
      out.write("                        <b>Nome da Escola:</b> ");
      out.print(escola.getNomeEscola());
      out.write("<br>\n");
      out.write("                        <b>Provincia: </b>");
      out.print( escola.getIddistrito().getProvincia());
      out.write("<br>\n");
      out.write("                        <b>Distrito: </b>");
      out.print( escola.getIddistrito().getNomeDestrito());
      out.write("<br>\n");
      out.write("                        <b>Endereço: </b> ");
      out.print( escola.getEndereco());
      out.write(" \n");
      out.write("\n");
      out.write("                        <b><p style=\" text-align: center; font-size: 22px; border-bottom: 1px solid black\"> Contactos</p> </b>\n");
      out.write("                        <b style=\"\">Email: ");
      out.print( escola.getEmail());
      out.write("</b><br>\n");
      out.write("                        <b>Telefone:");
      out.print( escola.getTelefone());
      out.write("</b> <br>\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("\n");
      out.write("                <tr style=\" border-bottom: 1px solid  black; background: white\">\n");
      out.write("                    <td >\n");
      out.write("\n");
      out.write("\n");
      out.write("                        ");
 for (Vagas vaga : this.vagas) {

                                if (vaga.getEscola().equals(escola)) {
                                    vagaList.add(vaga);
                                }
                            }

                            // if (vaga.getNrVagas() > 0) {

                        
      out.write("\n");
      out.write("                        <p style=\"font-size: 20px\">\n");
      out.write("                            <b>8CLASSE:</b> \n");
      out.write("                            ");
 if (vagaList.get(vagaList.size() - 2).getNrVagas() > 0) {
      out.write("\n");
      out.write("                            <i>     ");
      out.print(vagaList.get(vagaList.size() - 2).getNrVagas());
      out.write(" vaga(s) </i>\n");
      out.write("                            ");
 if ((User) session.getAttribute("user") == null) {
      out.write("\n");
      out.write("                            <a href=\"PegaEscola?ide=");
      out.print(vagaList.get(vagaList.size() - 2).getVagasPK().getIdEscola());
      out.write("&classe=");
      out.print(vagaList.get(vagaList.size() - 2).getVagasPK().getClasse());
      out.write("\">Pré-Inscrição</a>\n");
      out.write("\n");
      out.write("                            <!-- <//%//=vagaList.get(vagaList.size()-2).getVagasPK().getClasse() %> -->\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 } else {  
      out.write("\n");
      out.write("\n");
      out.write("                            <i style=\"color: red\">Sem vaga(s) </i>\n");
      out.write("                        </p> \n");
      out.write("                        ");
 } 
      out.write(" \n");
      out.write("                        <p style=\" font-size: 20px\">\n");
      out.write("\n");
      out.write("                            <b>9CLASSE:</b> \n");
      out.write("                            ");
 if (vagaList.get(vagaList.size() - 1).getNrVagas() > 0) {
      out.write("\n");
      out.write("                            <i>");
      out.print(vagaList.get(vagaList.size() - 1).getNrVagas());
      out.write(" vaga(s) </i>\n");
      out.write("\n");
      out.write("                            <a href=\"PegaEscola?ide=");
      out.print(escola.getIdEscola());
      out.write("&classe=");
      out.print(vagaList.get(vagaList.size() - 1).getVagasPK().getClasse());
      out.write("\">Pré-Inscrição</a> \n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");
 } else {  
      out.write("\n");
      out.write("\n");
      out.write("                            <i style=\"color: red\">Sem vaga(s) </i>\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                        ");
 } 
      out.write(" \n");
      out.write("\n");
      out.write("\n");
      out.write("                        <p style=\"font-size: 20px\">\n");
      out.write("                            <b>10CLASSE:</b> \n");
      out.write("\n");
      out.write("                            ");
 if (vagaList.get(0).getNrVagas() > 0) {
      out.write("\n");
      out.write("                            <i> ");
      out.print(vagaList.get(0).getNrVagas());
      out.write(" vaga(s)</i>\n");
      out.write("\n");
      out.write("                            <a href=\"PegaEscola?ide=");
      out.print(escola.getIdEscola());
      out.write("&classe=");
      out.print(vagaList.get(0).getVagasPK().getClasse());
      out.write("\">Pré-Inscrição</a> \n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");

                            } else {  
      out.write("\n");
      out.write("\n");
      out.write("                            <i style=\"color: red\">Sem vaga(s) </i>\n");
      out.write("\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("                        </p>\n");
      out.write("                    </td>\n");
      out.write("                    <td style=\" border-left: 0px solid black\">\n");
      out.write("                        <p style=\"font-size: 20px;\">\n");
      out.write("                            <b>11CLASSE:</b> \n");
      out.write("                            ");
 if (vagaList.get(1).getNrVagas() > 0) {
      out.write("\n");
      out.write("                            <i>");
      out.print(vagaList.get(1).getNrVagas());
      out.write(" vaga(s)</i>\n");
      out.write("\n");
      out.write("                            <a href=\"PegaEscola?ide=");
      out.print(escola.getIdEscola());
      out.write("&classe=");
      out.print(vagaList.get(1).getVagasPK().getClasse());
      out.write("\">Pré-Inscrição</a> \n");
      out.write("\n");
      out.write("                            ");

                            } else {  
      out.write("\n");
      out.write("\n");
      out.write("                            <i style=\"color: red\">Sem vaga(s) </i>\n");
      out.write("\n");
      out.write("                            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                        </p>\n");
      out.write("\n");
      out.write("                        <p style=\" font-size: 20px\">\n");
      out.write("\n");
      out.write("                            <b>12CLASSE:</b> \n");
      out.write("                            ");
 if (vagaList.get(2).getNrVagas() > 0) {
      out.write("\n");
      out.write("                            <i> ");
      out.print(vagaList.get(2).getNrVagas());
      out.write(" vaga(s) </i>\n");
      out.write("\n");
      out.write("                            <a href=\"PegaEscola?ide=");
      out.print(escola.getIdEscola());
      out.write("&classe=");
      out.print(vagaList.get(2).getVagasPK().getClasse());
      out.write("\">Pré-Inscrição</a> \n");
      out.write("\n");
      out.write("\n");
      out.write("                            ");

                            } else {  
      out.write("\n");
      out.write("                            <i style=\"color: red\">Sem vaga(s) </i>\n");
      out.write("                        </p>\n");
      out.write("                        ");
 } 
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                </tr>\n");
      out.write("                ");

                    }

                
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            </tbody>\n");
      out.write("        </table>\n");
      out.write("        <script>\n");
      out.write("            function fechar() {\n");
      out.write("                document.getElementById(\"sucessoModal\").style.display = 'none';\n");
      out.write("            }\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (event.target == document.getElementById('sucessoModal')) {\n");
      out.write("                    document.getElementById('sucessoModal').style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
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
