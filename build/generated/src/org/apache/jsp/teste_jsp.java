package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import control.VagasJpaController;
import control.EscolaJpaController;
import javax.persistence.EntityManagerFactory;
import model.Escola;
import model.Vagas;
import java.util.List;

public final class teste_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script src=\"jquery/jquery\"></script>\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/listaEstudantes_style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/search-box.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"_css/modal.css\" />\n");
      out.write("\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            $(document).ready(function (e) {\n");
      out.write("                $('#loadPage').load('cadastrarEscola.jsp', function (data) {\n");
      out.write("                    $(this).html(data);\n");
      out.write("                });\n");
      out.write("            });\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <style>\n");
      out.write("          \n");
      out.write("            #loadPage{\n");
      out.write("                width: 60%;\n");
      out.write("                margin: auto;\n");
      out.write("                background-color: white ;\n");
      out.write("                height: 550px;\n");
      out.write("                overflow:  scroll;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            td a{\n");
      out.write("                color:white;\n");
      out.write("                background: #00adee;  \n");
      out.write("                padding: 5px;\n");
      out.write("                border-radius: 5px;\n");
      out.write("                text-decoration: none;\n");
      out.write("            }\n");
      out.write("            td  a:hover{\n");
      out.write("                background: yellowgreen;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            .modal-content{\n");
      out.write("                background: white;\n");
      out.write("                height: 20px;\n");
      out.write("                top: -12%;\n");
      out.write("                border-radius: 0px;\n");
      out.write("                \n");
      out.write("            }\n");
      out.write("\n");
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
      out.write("            tr:hover{\n");
      out.write("                background: #A7C3DB;\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </style>\n");
      out.write("    </head>\n");
      out.write("    <body style=\" background:  white;\">\n");
      out.write("        <div id=\"cadastroEscola\" class=\"modal\"> \n");
      out.write("            <div id=\"loadPage\" class=\"modal-content\" style=\" border-radius: 0px; background: white; border: none\">\n");
      out.write("                Aprece\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        ");
      out.write("\n");
      out.write("        ");


            List<Escola> escolaList = (List<Escola>) request.getAttribute("escolas");
            if (escolaList != null && !escolaList.isEmpty()) {
                escolas = escolaList;
            } else {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                EscolaJpaController escolaController = new EscolaJpaController(emf);
                escolas = escolaController.findEscolaEntities();

                VagasJpaController vagasController = new VagasJpaController(emf);
                vagas = vagasController.findVagasEntities();
            }

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"myModal\" class=\"modal\">\n");
      out.write("            <!-- Modal content -->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <b style=\" font-family:  sans-serif; font-size: 20px\">Eliminar?</b><br>\n");
      out.write("                <button class=\"yes\" onclick=\"eliminarP()\">Sim </button>\n");
      out.write("                <button class=\"no\" onclick=\"fechar()\">  Não </button>\n");
      out.write("            </div>                  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div id=\"sucessoModal\" class=\"modal\" >\n");
      out.write("            <!-- Modal content -->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <b style=\" font-family:  sans-serif; font-size: 20px\">Eliminado com sucesso!</b>\n");
      out.write("                <button class=\"no\" onclick=\"fechar()\">  Ok </button>\n");
      out.write("            </div>                  \n");
      out.write("        </div>\n");
      out.write("        <div id=\"adicionado\" class=\"modal\" >\n");
      out.write("            <!-- Modal content -->\n");
      out.write("            <div class=\"modal-content\">\n");
      out.write("                <b style=\" font-family:  sans-serif; font-size: 20px\">Adicionado com sucesso!</b>\n");
      out.write("                <button class=\"no\" onclick=\"fechar()\">  Ok </button>\n");
      out.write("            </div>                  \n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <div class=\"search_box\">\n");
      out.write("            <form action=\"PesquisarEscola\">\n");
      out.write("                <input type=\"hidden\" value=\"0\" name=\"tipo\">\n");
      out.write("                <input class=\"search_box_input\" type=\"search\" name=\"pesquisa\" placeholder=\"Nome Da Escola...\">\n");
      out.write("                <button class=\"search_box_button\" type=\"submit\">&#128269</button>\n");
      out.write("            </form>\n");
      out.write("        </div> \n");
      out.write("\n");
      out.write("\n");
      out.write("        <h2>Lista de Escolas</h2> <br>\n");
      out.write("        <a onclick=\"cadastroEscola(); return false;\"  class=\"adicionar\"> Adicionar</a> \n");
      out.write("\n");
      out.write("        <table  >\n");
      out.write("            <thead>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Nome da Escola</th>\n");
      out.write("                    <th>Endereco</th>\n");
      out.write("                    <th>Distrito</th>\n");
      out.write("                    <th>Provincia</th>\n");
      out.write("                    <th>8Classe-Vagas</th>\n");
      out.write("                    <th>9Classe-Vagas</th>\n");
      out.write("                    <th>10Classe-Vagas</th>\n");
      out.write("                    <th>11Classe-Vagas</th>\n");
      out.write("                    <th>12Classe-Vagas</th>\n");
      out.write("                    <th>Editar </th>\n");
      out.write("                    <th>Eliminar</th>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                </tr>\n");
      out.write("            </thead>\n");
      out.write("            <tbody id=\"tb\" >\n");
      out.write("                ");
 for (int i = 0; i < this.escolas.size(); i++) {
                        ArrayList<Vagas> vagaList = new ArrayList<Vagas>();
                
      out.write("\n");
      out.write("                <tr id=\"");
      out.print(i);
      out.write("\">\n");
      out.write("                    <td class=\"escola\" >");
      out.print(escolas.get(i).getNomeEscola());
      out.write("</td>\n");
      out.write("                    <td class=\"escola\">");
      out.print( escolas.get(i).getEndereco());
      out.write("</td>\n");
      out.write("                    <td class=\"escola\">");
      out.print( escolas.get(i).getIddistrito().getNomeDestrito());
      out.write("</td>\n");
      out.write("                    <td class=\"escola\">");
      out.print( escolas.get(i).getIddistrito().getProvincia());
      out.write("</td>\n");
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 for (Vagas vaga : this.vagas) {

                            if (vaga.getEscola().equals(escolas.get(i))) {
                                vagaList.add(vaga);
                            }
                        }

                        // if (vaga.getNrVagas() > 0) {

                    
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (vagaList.get(vagaList.size() - 2).getNrVagas() > 0) {
      out.write("\n");
      out.write("                    <td>");
      out.print(vagaList.get(vagaList.size() - 2).getNrVagas());
      out.write(" <br><br>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    ");
 } else {  
      out.write("\n");
      out.write("\n");
      out.write("                    <td> <p style=\"color: red\">Sem vaga(s)<p></td>\n");
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (vagaList.get(vagaList.size() - 1).getNrVagas() > 0) {
      out.write("\n");
      out.write("                    <td>");
      out.print(vagaList.get(vagaList.size() - 1).getNrVagas());
      out.write(" <br><br>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    ");
  
      out.write("\n");
      out.write("                    ");
 } else {  
      out.write("\n");
      out.write("\n");
      out.write("                    <td> <p style=\"color: red\">Sem vaga(s)<p></td>\n");
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (vagaList.get(0).getNrVagas() > 0) {
      out.write("\n");
      out.write("                    <td>");
      out.print(vagaList.get(0).getNrVagas());
      out.write(" <br><br>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("\n");
      out.write("                    ");

                    } else {  
      out.write("\n");
      out.write("\n");
      out.write("                    <td> <p style=\"color: red\">Sem vaga(s)<p></td>\n");
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (vagaList.get(1).getNrVagas() > 0) {
      out.write("\n");
      out.write("                    <td>");
      out.print(vagaList.get(1).getNrVagas());
      out.write(" <br><br>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    ");

                    } else {  
      out.write("\n");
      out.write("\n");
      out.write("                    <td> <p style=\"color: red\">Sem vaga(s)<p></td>\n");
      out.write("\n");
      out.write("                    ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("                    ");
 if (vagaList.get(2).getNrVagas() > 0) {
      out.write("\n");
      out.write("                    <td>");
      out.print(vagaList.get(2).getNrVagas());
      out.write(" <br><br>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    ");

                    } else {  
      out.write("\n");
      out.write("\n");
      out.write("                    <td> <p style=\"color: red\">Sem vaga(s)<p></td>\n");
      out.write("\n");
      out.write("                    ");
 }
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("                    <td style=\"\">\n");
      out.write("\n");
      out.write("                        <a style=\"text-decoration: none\" href=\"EditarEscola?ide=");
      out.print(escolas.get(i).getIdEscola());
      out.write("\">Editar</a>\n");
      out.write("\n");
      out.write("                    </td>\n");
      out.write("                    <td>\n");
      out.write("                        <a style=\"text-decoration: none\" href=\"EliminarEscola?ide=");
      out.print(escolas.get(i).getIdEscola());
      out.write("\">Eliminar</a>\n");
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
      out.write("\n");
      out.write("            function clearTable() {\n");
      out.write("                var t = document.getElementById('tb');\n");
      out.write("                if (t.getElementsByTagName(\"tr\").length > 0) {\n");
      out.write("                    // t.style.display = 'none';\n");
      out.write("                    for (loop = t.childNodes.length - 1; loop >= 0; loop--) {\n");
      out.write("                        t.removeChild(t.childNodes[loop]);\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function doCompletion() {\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    clearTable();\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        myFunction(this);\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                var url = \"PesquisarEscola2?action=complete&id=\" + encodeURI(document.getElementById(\"complete-field\").value)\n");
      out.write("                xhttp.open(\"POST\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function myFunction(xml) {\n");
      out.write("                var i;\n");
      out.write("                // var jso = JSON.parse(this.responseText);\n");
      out.write("                var xmlDoc = xml.responseXML;\n");
      out.write("                var table = \"\";//<tr><th>Artist</th><th>Title</th></tr>\";\n");
      out.write("\n");
      out.write("                //alert(\"gjhgj\");\n");
      out.write("                var x = xmlDoc.getElementsByTagName(\"escola\");\n");
      out.write("                for (i = 0; i < x.length; i++) {\n");
      out.write("                    var row = document.getElementById(\"tb\").insertRow();\n");
      out.write("                    var c = row.insertCell();\n");
      out.write("                    c.innerHTML = x[i].getElementsByTagName(\"nome\")[0].childNodes[0].nodeValue;\n");
      out.write("                    c = row.insertCell();\n");
      out.write("                    c.innerHTML = x[i].getElementsByTagName(\"Endereco\")[0].childNodes[0].nodeValue;\n");
      out.write("                    c = row.insertCell();\n");
      out.write("                    c.innerHTML = x[i].getElementsByTagName(\"Distrito\")[0].childNodes[0].nodeValue;\n");
      out.write("                    c = row.insertCell();\n");
      out.write("                    c.innerHTML = x[i].getElementsByTagName(\"Provincia\")[0].childNodes[0].nodeValue;\n");
      out.write("                    c = row.insertCell();\n");
      out.write("                    var ide = x[i].getElementsByTagName(\"ide\")[0].childNodes[0].nodeValue;\n");
      out.write("                    c.innerHTML = '<div><a href=\"EditarEmpregado?ide=' + ide + '\">Editar</a>' +\n");
      out.write("                            '<a href=\"EliminarEmpregado?ide=' + ide + '\">Eliminar</a>' +\n");
      out.write("                            '</div>'\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            var id = 0; // ID do ultimo objecto recebido\n");
      out.write("            var source = new EventSource(\"CadastrarEscola\");\n");
      out.write("            source.onmessage = function (event) {\n");
      out.write("                var ar = event.data.split(\"|\"); //Convertendo uma String em um Array\n");
      out.write("                if (ar[0] != id) { // Se for um novo objecto\n");
      out.write("                    var row = document.getElementById(\"tb\").insertRow(0);\n");
      out.write("                    //row.id=ar[0];\n");
      out.write("                    for (loop = 0; loop < ar.length; loop++) {\n");
      out.write("                        var c = row.insertCell();\n");
      out.write("                        c.innerHTML = ar[loop];\n");
      out.write("                    }\n");
      out.write("                    var c = row.insertCell();\n");
      out.write("                    c.innerHTML = '<div><a href=\"EditarEscola?ide=' + ar[0] + '\">Editar</a>' +\n");
      out.write("                            '<a href=\"EliminarEscola?ide=' + ar[0] + '\">Eliminar</a>' +\n");
      out.write("                            '</div>';\n");
      out.write("                    id = ar[0];\n");
      out.write("                    var t = document.getElementById('tb');\n");
      out.write("                    if (t.getElementsByTagName(\"tr\").length > 0) {\n");
      out.write("                        // t.style.display = 'none';\n");
      out.write("                        for (loop = t.childNodes.length - 1; loop >= 0; loop--) {\n");
      out.write("                            if (t.childNodes[loop].id === ar[0]) {\n");
      out.write("                                t.removeChild(t.childNodes[loop]);\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            };\n");
      out.write("            function eliminar(idl, id) {\n");
      out.write("                document.getElementById(\"linha\").value = idl;\n");
      out.write("                document.getElementById(\"idEscola\").value = id;\n");
      out.write("                document.getElementById(\"myModal\").style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function mostrar() {\n");
      out.write("                document.getElementById(\"sucessoModal\").style.display = 'block';\n");
      out.write("            }\n");
      out.write("            function cadastroEscola() {\n");
      out.write("                document.getElementById(\"cadastroEscola\").style.display = 'block';\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("            function eliminarP() {\n");
      out.write("                var idl = document.getElementById(\"linha\").value;\n");
      out.write("                var id = document.getElementById(\"idEscola\").value;\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (this.readyState == 4 && this.status == 200) {\n");
      out.write("                        removerLinha(idl, id);\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("                fechar();\n");
      out.write("                var url = \"EliminarEscola?ide=\" + id;\n");
      out.write("                xhttp.open(\"POST\", url, true);\n");
      out.write("                xhttp.send();\n");
      out.write("                mostrar();\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("            function removerLinha(idl, id) {\n");
      out.write("                document.getElementById(\"tb\").removeChild(document.getElementById(idl));\n");
      out.write("            }\n");
      out.write("            ;\n");
      out.write("            function fechar() {\n");
      out.write("                document.getElementById(\"myModal\").style.display = 'none';\n");
      out.write("                document.getElementById(\"sucessoModal\").style.display = 'none';\n");
      out.write("                document.getElementById(\"adicionado\").style.display = 'none';\n");
      out.write("            }\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (event.target == document.getElementById('myModal')) {\n");
      out.write("                    document.getElementById('myModal').style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                if (event.target == document.getElementById('sucesso')) {\n");
      out.write("                    document.getElementById('sucessoModal').style.display = \"none\";\n");
      out.write("                }\n");
      out.write("                if (event.target == document.getElementById('cadastroEscola')) {\n");
      out.write("                    document.getElementById('cadastroEscola').style.display = \"none\";\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("\n");
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
