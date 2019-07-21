<%-- 
    Document   : teste
    Created on : Nov 25, 2018, 5:57:37 PM
    Author     : Rofino Chunga Jr
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="control.VagasJpaController"%>
<%@page import="control.EscolaJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.Escola"%>
<%@page import="model.Vagas"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="jquery/jquery"></script>
        <title>JSP Page</title>

        <link rel="stylesheet" type="text/css" href="_css/listaEstudantes_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/search-box.css" />
        <link rel="stylesheet" type="text/css" href="_css/modal.css" />


        <script>
            $(document).ready(function (e) {
                $('#loadPage').load('cadastrarEscola.jsp', function (data) {
                    $(this).html(data);
                });
            });
        </script>


        <style>
          
            #loadPage{
                width: 60%;
                margin: auto;
                background-color: white ;
                height: 550px;
                overflow:  scroll;
            }

            td a{
                color:white;
                background: #00adee;  
                padding: 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            td  a:hover{
                background: yellowgreen;
            }

            .modal-content{
                background: white;
                height: 20px;
                top: -12%;
                border-radius: 0px;
                
            }

            .modal-content p{
                font-family:  sans-serif;
                font-size: 20px;
            }

            .yes{
                float: left;
                border: none;
                background:  red;
                font-size: 20px;
                font-family: sans-serif;
                border-radius: 5px;
                color: white;
                cursor: pointer;
            }
            .no{
                float: right;
                border: none;
                background: #00adee;
                border-radius: 5px;
                font-size: 20px;
                font-family: sans-serif;
                color: white;
                cursor: pointer;
            }
            tr:hover{
                background: #A7C3DB;
            }

        </style>
    </head>
    <body style=" background:  white;">
        <div id="cadastroEscola" class="modal"> 
            <div id="loadPage" class="modal-content" style=" border-radius: 0px; background: white; border: none">
                Aprece
            </div>
        </div>

        <%!List<Escola> escolas;
            List<Vagas> vagas;%>
        <%

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

        %>


        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">
                <b style=" font-family:  sans-serif; font-size: 20px">Eliminar?</b><br>
                <button class="yes" onclick="eliminarP()">Sim </button>
                <button class="no" onclick="fechar()">  Não </button>
            </div>                  
        </div>

        <div id="sucessoModal" class="modal" >
            <!-- Modal content -->
            <div class="modal-content">
                <b style=" font-family:  sans-serif; font-size: 20px">Eliminado com sucesso!</b>
                <button class="no" onclick="fechar()">  Ok </button>
            </div>                  
        </div>
        <div id="adicionado" class="modal" >
            <!-- Modal content -->
            <div class="modal-content">
                <b style=" font-family:  sans-serif; font-size: 20px">Adicionado com sucesso!</b>
                <button class="no" onclick="fechar()">  Ok </button>
            </div>                  
        </div>

        <div class="search_box">
            <form action="PesquisarEscola">
                <input type="hidden" value="0" name="tipo">
                <input class="search_box_input" type="search" name="pesquisa" placeholder="Nome Da Escola...">
                <button class="search_box_button" type="submit">&#128269</button>
            </form>
        </div> 


        <h2>Lista de Escolas</h2> <br>
        <a onclick="cadastroEscola(); return false;" target="body" class="adicionar"> Adicionar</a> 

        <table  >
            <thead>
                <tr>
                    <th>Nome da Escola</th>
                    <th>Endereco</th>
                    <th>Distrito</th>
                    <th>Provincia</th>
                    <th>8Classe-Vagas</th>
                    <th>9Classe-Vagas</th>
                    <th>10Classe-Vagas</th>
                    <th>11Classe-Vagas</th>
                    <th>12Classe-Vagas</th>
                    <th>Editar </th>
                    <th>Eliminar</th>



                </tr>
            </thead>
            <tbody id="tb" >
                <% for (int i = 0; i < this.escolas.size(); i++) {
                        ArrayList<Vagas> vagaList = new ArrayList<Vagas>();
                %>
                <tr id="<%=i%>">
                    <td class="escola" ><%=escolas.get(i).getNomeEscola()%></td>
                    <td class="escola"><%= escolas.get(i).getEndereco()%></td>
                    <td class="escola"><%= escolas.get(i).getIddistrito().getNomeDestrito()%></td>
                    <td class="escola"><%= escolas.get(i).getIddistrito().getProvincia()%></td>


                    <% for (Vagas vaga : this.vagas) {

                            if (vaga.getEscola().equals(escolas.get(i))) {
                                vagaList.add(vaga);
                            }
                        }

                        // if (vaga.getNrVagas() > 0) {

                    %>

                    <% if (vagaList.get(vagaList.size() - 2).getNrVagas() > 0) {%>
                    <td><%=vagaList.get(vagaList.size() - 2).getNrVagas()%> <br><br>

                    </td>
                    <% } else {  %>

                    <td> <p style="color: red">Sem vaga(s)<p></td>

                    <% } %>

                    <% if (vagaList.get(vagaList.size() - 1).getNrVagas() > 0) {%>
                    <td><%=vagaList.get(vagaList.size() - 1).getNrVagas()%> <br><br>

                    </td>
                    <%  %>
                    <% } else {  %>

                    <td> <p style="color: red">Sem vaga(s)<p></td>

                    <% } %>

                    <% if (vagaList.get(0).getNrVagas() > 0) {%>
                    <td><%=vagaList.get(0).getNrVagas()%> <br><br>

                    </td>

                    <%
                    } else {  %>

                    <td> <p style="color: red">Sem vaga(s)<p></td>

                    <% } %>

                    <% if (vagaList.get(1).getNrVagas() > 0) {%>
                    <td><%=vagaList.get(1).getNrVagas()%> <br><br>

                    </td>
                    <%
                    } else {  %>

                    <td> <p style="color: red">Sem vaga(s)<p></td>

                    <% } %>

                    <% if (vagaList.get(2).getNrVagas() > 0) {%>
                    <td><%=vagaList.get(2).getNrVagas()%> <br><br>

                    </td>
                    <%
                    } else {  %>

                    <td> <p style="color: red">Sem vaga(s)<p></td>

                    <% }%>


                    <td style="">

                        <a style="text-decoration: none" href="EditarEscola?ide=<%=escolas.get(i).getIdEscola()%>">Editar</a>

                    </td>
                    <td>
                        <a style="text-decoration: none" href="EliminarEscola?ide=<%=escolas.get(i).getIdEscola()%>">Eliminar</a>
                    </td>
                </tr>
                <%

                    }
                %>



            </tbody>
        </table>
        <script>

            function clearTable() {
                var t = document.getElementById('tb');
                if (t.getElementsByTagName("tr").length > 0) {
                    // t.style.display = 'none';
                    for (loop = t.childNodes.length - 1; loop >= 0; loop--) {
                        t.removeChild(t.childNodes[loop]);
                    }
                }
            }

            function doCompletion() {
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    clearTable();
                    if (this.readyState == 4 && this.status == 200) {
                        myFunction(this);
                    }
                };
                var url = "PesquisarEscola2?action=complete&id=" + encodeURI(document.getElementById("complete-field").value)
                xhttp.open("POST", url, true);
                xhttp.send();
            }

            function myFunction(xml) {
                var i;
                // var jso = JSON.parse(this.responseText);
                var xmlDoc = xml.responseXML;
                var table = "";//<tr><th>Artist</th><th>Title</th></tr>";

                //alert("gjhgj");
                var x = xmlDoc.getElementsByTagName("escola");
                for (i = 0; i < x.length; i++) {
                    var row = document.getElementById("tb").insertRow();
                    var c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("Endereco")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("Distrito")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("Provincia")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    var ide = x[i].getElementsByTagName("ide")[0].childNodes[0].nodeValue;
                    c.innerHTML = '<div><a href="EditarEmpregado?ide=' + ide + '">Editar</a>' +
                            '<a href="EliminarEmpregado?ide=' + ide + '">Eliminar</a>' +
                            '</div>'
                }
            }

            var id = 0; // ID do ultimo objecto recebido
            var source = new EventSource("CadastrarEscola");
            source.onmessage = function (event) {
                var ar = event.data.split("|"); //Convertendo uma String em um Array
                if (ar[0] != id) { // Se for um novo objecto
                    var row = document.getElementById("tb").insertRow(0);
                    //row.id=ar[0];
                    for (loop = 0; loop < ar.length; loop++) {
                        var c = row.insertCell();
                        c.innerHTML = ar[loop];
                    }
                    var c = row.insertCell();
                    c.innerHTML = '<div><a href="EditarEscola?ide=' + ar[0] + '">Editar</a>' +
                            '<a href="EliminarEscola?ide=' + ar[0] + '">Eliminar</a>' +
                            '</div>';
                    id = ar[0];
                    var t = document.getElementById('tb');
                    if (t.getElementsByTagName("tr").length > 0) {
                        // t.style.display = 'none';
                        for (loop = t.childNodes.length - 1; loop >= 0; loop--) {
                            if (t.childNodes[loop].id === ar[0]) {
                                t.removeChild(t.childNodes[loop]);
                            }
                        }
                    }
                }

            };
            function eliminar(idl, id) {
                document.getElementById("linha").value = idl;
                document.getElementById("idEscola").value = id;
                document.getElementById("myModal").style.display = 'block';
            }
            function mostrar() {
                document.getElementById("sucessoModal").style.display = 'block';
            }
            function cadastroEscola() {
                document.getElementById("cadastroEscola").style.display = 'block';
            }
            ;
            function eliminarP() {
                var idl = document.getElementById("linha").value;
                var id = document.getElementById("idEscola").value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        removerLinha(idl, id);
                    }
                };
                fechar();
                var url = "EliminarEscola?ide=" + id;
                xhttp.open("POST", url, true);
                xhttp.send();
                mostrar();
            }
            ;
            function removerLinha(idl, id) {
                document.getElementById("tb").removeChild(document.getElementById(idl));
            }
            ;
            function fechar() {
                document.getElementById("myModal").style.display = 'none';
                document.getElementById("sucessoModal").style.display = 'none';
                document.getElementById("adicionado").style.display = 'none';
            }
            window.onclick = function (event) {
                if (event.target == document.getElementById('myModal')) {
                    document.getElementById('myModal').style.display = "none";
                }
                if (event.target == document.getElementById('sucesso')) {
                    document.getElementById('sucessoModal').style.display = "none";
                }
                if (event.target == document.getElementById('cadastroEscola')) {
                    document.getElementById('cadastroEscola').style.display = "none";
                }
            }
        </script>


    </body>
</html>
