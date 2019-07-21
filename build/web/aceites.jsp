<%-- 
    Document   : aceites
    Created on : Oct 15, 2018, 9:57:09 PM
    Author     : Rofino Chunga Jr
--%>

<%@page import="control.EstudanteaceiteJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.Estudanteaceite"%>
<%@page import="java.util.List"%>
<%@page import="model.Estudante"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/listaEstudantes_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/search-box.css" />
        <link rel="stylesheet" type="text/css" href="_css/modal.css" />
        <title>Lista de Estudantes Aceites</title>
        <style>
            a{
                color:white;
                background: red;  
                padding: 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            a:hover{
                background: yellowgreen;
            }
            .genero{
                width: 300px;
                height: 300px;
                border-radius: 50%;
            }
            td{
                font-family:  sans-serif;
            }
            .modal-content{
                background:  #f2f2f2;
                height: 20px;

                border-radius: 10px;
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
        </style>
    </head>

    <body style=" background: white">

        <h2>Lista de Alunos Aceites</h2>

        <div class="search_box">
            <form action="PesquisarAceites">
                <input class="search_box_input" type="search" name="pesquisa" placeholder="Procurar...">
                <button class="search_box_button" type="submit">&#128269</button>
            </form>
        </div>

        <a  style=" border-radius: 10px; background:  none;" href="listaEstudantes.jsp"  target="body" class="adicionar" > Lista de Pedidos </a> 
        <%!List<Estudanteaceite> estudantes;%>
        <%
            List<Estudanteaceite> estudanteList = (List<Estudanteaceite>) request.getAttribute("estudants");
            if (estudanteList != null && !estudanteList.isEmpty()) {
                estudantes = estudanteList;
            } else {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                EstudanteaceiteJpaController estudanteController = new EstudanteaceiteJpaController(emf);
                estudantes = estudanteController.findEstudanteaceiteEntities();
            }
        %>

        <input type="hidden" id="linha" value="">
        <input type="hidden" id="idEstudante" value="">
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
                <button class="no" onclick="fechar()"> Ok </button>
            </div>                  
        </div>

        <table >
            <tbody id="tb">
                <% for (int i = 0; i < estudantes.size(); i++) {
                        if (estudantes.get(i).getGenero().equals("Masculino")) {
                %>
                <tr id="<%=i%>">
                    <td> <img class="genero" src="_img/masculino.jpg"> </td>
                        <%} else {%>
                    <td> <img class="genero" src="_img/femenino.jpg"> </td>
                        <% }%>

                    <td style=" font-size: 20px">
                        <b>NOME DO CANDIDATO: </b><%=estudantes.get(i).getNomeEstudante()%><br>
                        <b>GENERO: </b> <%= estudantes.get(i).getGenero()%><br>
                        <b>BI: </b><%= estudantes.get(i).getNrBI()%><br>
                        <b>DATA DE NASCIMENTO: </b><%=estudantes.get(i).getDataNascimento()%>          
                        <p style=" text-align: center; border-bottom: 1px solid black"><b>CANDIDATURA</b></p> <br>
                        <b>ESCOLA: </b><%= estudantes.get(i).getEscola()%><br>
                        <b>CLASSE: </b><%= estudantes.get(i).getClasse()%>

                        <p style=" text-align: center">
                            <a onclick="eliminar(<%=i%>,<%=estudantes.get(i).getIdEstudante()%>); return false;" href="EliminarAceites?ide=<%=estudantes.get(i).getIdEstudante()%>">Eliminar</a>
                        </p>


                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <script>
            
            function eliminar(idl, id) {
                document.getElementById("linha").value = idl;
                document.getElementById("idEstudante").value = id;
                document.getElementById("myModal").style.display = 'block';
            }
            function mostrar() {
                document.getElementById("sucessoModal").style.display = 'block';
            }
            ;
            function eliminarP() {
                var idl = document.getElementById("linha").value;
                var id = document.getElementById("idEstudante").value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        removerLinha(idl);
                    }
                };
                fechar();
                var url = "EliminarAceites?ide=" + id;
                xhttp.open("POST", url, true);
                xhttp.send();
                mostrar();
            }
            ;
            function removerLinha(idl) {
                document.getElementById("tb").removeChild(document.getElementById(idl));
            }
            ;

            function fechar() {
                document.getElementById("myModal").style.display = 'none';
                document.getElementById("sucessoModal").style.display = 'none';
            }
            window.onclick = function (event) {
                if (event.target == document.getElementById('myModal')) {
                    document.getElementById('myModal').style.display = "none";
                }
                if (event.target == document.getElementById('sucesso')) {
                    document.getElementById('sucessoModal').style.display = "none";
                }
            }
        </script>
    </body>
</html>
