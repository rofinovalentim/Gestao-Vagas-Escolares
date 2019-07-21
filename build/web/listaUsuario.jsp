<%-- 
    Document   : listaUsuario
    Created on : Oct 9, 2018, 9:32:57 AM
    Author     : Rofino Chunga Jr
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Vagas"%>
<%@page import="model.Escola"%>
<%@page import="control.EscolaJpaController"%>
<%@page import="control.VagasJpaController"%>
<%@page import="model.Role"%>
<%@page import="model.TipoUsuario"%>
<%@page import="control.UserJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.User"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/listaEstudantes_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/search-box.css" />
        <link rel="stylesheet" type="text/css" href="_css/modal.css" />

        <title>JSP Page</title>
        <script src="jquery/jquery"></script>
        <script>
            $(document).ready(function (e) {
                $('#loadPage').load('cadastrarAdministrador.jsp', function (data) {
                    $(this).html(data);
                });
            });
        </script>
        <style>

            #loadPage{
                width: 50%;
                margin: 10px auto;
                background-color: #f2f2f2  ;
                height: 400px;
                  
                
            }


            h2{
                float: left;
                color:  #003300;
                border-bottom: 2px solid yellowgreen;  /*#4caf50*/;


                top: -5px;

            }
            .search_box{
                float: right;
                /* position: fixed;*/
            }
           td a{
                color:white;
                background: #00adee;  
                padding: 5px;
                border-radius: 5px;
                text-decoration: none;
                cursor: pointer;
            }
            td a:hover{
                background: yellowgreen;
            }
            .el{
                background: red;
            }
            .modal-content{
                background:  white;
                border: none;
             

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
    <body style=" background: white">


        <div id="cadastroUser" class="modal"> 
            
            <div id="loadPage" class="modal-content">
               
            </div>
        </div>

        <div class="search_box">
            <input type="text" class="search_box_input" id="complete-field" placeholder="Pesquisar..." onkeyup="doCompletion()">
        </div>
        <h2>Lista de Usuarios</h2>
        <!-- <form action="PesquisarUsuario" >
             <input type="text" size="40" name="pesquisa">
             <input type="submit" value="Pesquisar" name="btpesquisar" >
 
         </form> -->
        <%
            List<Role> rol = (List<Role>) session.getAttribute("permissoes");
            if (rol != null) {

        %>
        <%            if (rol.contains(new Role("AdicionarUsuario"))) {
        %>
        <a onclick="cadastroUser(); return false;" style=" border-radius: 0px; cursor: pointer" target="body" class="adicionar"> Adicionar</a> 

        <% }
            } %>



        <%!List<User> users;
        %>
        <%

            List<User> userList = (List<User>) request.getAttribute("users");
            if (userList != null && !userList.isEmpty()) {
                users = userList;
            } else {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                UserJpaController userController = new UserJpaController(emf);
                users = userController.findUserEntities();
            }


        %>

        <%!List<Escola> escolas;
            List<Vagas> vagas;%>
        <%            List<Escola> escolaList = (List<Escola>) request.getAttribute("escolas");
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

        <input type="hidden" id="linha" value="">
        <input type="hidden" id="userName" value="">
        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content" style=" height: 60px">
            
                <b style=" font-family:  sans-serif; font-size: 20px;">Eliminar?</b><br><br>
  

                <button class="yes" onclick="eliminarP();">Sim </button>
                <button class="no" onclick="fechar()">  Não </button>
            </div>                  
        </div>
        <div id="sucessoModal" class="modal">
            <div class="modal-content">
                <b style=" font-family:  sans-serif; font-size: 20px">Eliminado com sucesso!</b>
                <button class="no" onclick="fechar()">Ok</button>
            </div>
        </div>
        <div id="adicionado" class="modal" >
            <!-- Modal content -->
            <div class="modal-content" style=" height: 50px">
                <b style=" font-family:  sans-serif; font-size: 20px">Adicionado com sucesso!</b>
                <button class="no" onclick="fechar()">  Ok </button>
            </div>                  
        </div>


        <%if (request.getAttribute("verificar") != null) {

        %>
        <script>
            document.getElementById("adicionado").style.display = 'block';
        </script>
        <% }%><!--*/else if ((int)request.getAttribute("verificar") ==2) */{%>
        <script>
            document.getElementById("aditado").style.display = 'block';
        </script>
        < % }%> -->



        <table  >
            <thead>
                <tr>
                    <th>Nome de Usuario</th>
                    <th>palavra-Passe</th>
                    <th>Email</th>
                    <th>Tipo</th>
                    <th>Operação</th>
                </tr>
            </thead>
            <tbody id="tb" >
                <% for (int i = 0; i < this.users.size(); i++) {
                        ArrayList<Vagas> vagaList = new ArrayList<Vagas>();
                %>
                <tr id="<%=i%>">
                    <td ><%=users.get(i).getUserName()%></td>
                    <td  ><%=users.get(i).getPassword()%></td>
                    <td ><%=users.get(i).getEmail()%></td>
                    <td  ><%=users.get(i).getIdTipo().getDescricao()%></td>

                    <td>
                        <div>
                            <a class="" href="EditarUsuario?userName=<%=users.get(i).getUserName()%>">Editar</a>
                            <a onclick="eliminar(<%=i%>, '<%=users.get(i).getUserName()%>'); return false;" href="">Eliminar</a>
                        </div>
                    </td>

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
                var url = "PesquisaUsuario?action=complete&id=" + encodeURI(document.getElementById("complete-field").value)
                xhttp.open("POST", url, true);
                xhttp.send();
            }

            function myFunction(xml) {
                var i;
                // var jso = JSON.parse(this.responseText);
                var xmlDoc = xml.responseXML;
                var table = "";//<tr><th>Artist</th><th>Title</th></tr>";

                //alert("gjhgj");
                var x = xmlDoc.getElementsByTagName("Usuario");
                for (i = 0; i < x.length; i++) {
                    var row = document.getElementById("tb").insertRow();
                    var c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("password")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("email")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    c.innerHTML = x[i].getElementsByTagName("tipo")[0].childNodes[0].nodeValue;
                    c = row.insertCell();
                    var ide = x[i].getElementsByTagName("nome")[0].childNodes[0].nodeValue;
                    c.innerHTML = '<div><a href="EditarUsuario?userName=' + ide + '">Editar</a>' +
                            ' <a href="EliminarUsuario?userName=' + ide + '"> Eliminar</a>' +
                            '</div>'
                }
            }

            var id = 0; // ID do ultimo objecto recebido
            var source = new EventSource("CadastrarUsuario");
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
                    c.innerHTML = '<div><a href="EditarUsuario?userName=' + ar[0] + '">Editar</a>' +
                            ' <a   href="EliminarUsuario?userName=' + ar[0] + '">Eliminar</a>' +
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

            }
            function eliminar(idl, id) {
                document.getElementById("linha").value = idl;
                document.getElementById("userName").value = id;
                document.getElementById("myModal").style.display = 'block';
            }
            function mostrar() {
                document.getElementById("sucessoModal").style.display = 'block';
            }
            function cadastroUser() {
                document.getElementById("cadastroUser").style.display = 'block';
            }
            ;
            function eliminarP() {

                var idl = document.getElementById("linha").value;
                var id = document.getElementById("userName").value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (this.readyState == 4 && this.status == 200) {
                        removerLinha(idl, id);
                    }
                };
                fechar();
                var url = "EliminarUsuario?userName=" + id;
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
                document.getElementById("adicionado").style.display = 'none';

            }
         
        </script>
    </body>
</html>
