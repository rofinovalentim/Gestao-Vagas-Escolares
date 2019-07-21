<%-- 
    Document   : index
    Created on : Oct 11, 2018, 10:48:28 PM
    Author     : Rofino Chunga Jr
--%>

<%@page import="model.Role"%>
<%@page import="java.util.List"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="css/style.css">

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/modal.css" />
        <title>Pagina Principal</title>
        <script>
            function info() {
                document.getElementById('myModal').style.display = "block";
            }

            function fecharInfo() {
                alert('sdfsdf');
                //modal.style.display = "block";
            }

            var span = document.getElementsByClassName("close")[0];
            span.onclick = function () {
                document.getElementById('myModal').style.display = "none";
            }



            window.onclick = function (event) {
                if (event.target == document.getElementById('myModal')) {
                    document.getElementById('myModal').style.display = "none";
                }
            };

            function validar() {
                if (formu.s1.value != formu.s2.value) {
                    alert('Por favor confirme a senha');
                    formu.s2.scrollIntoView();
                    return false;
                }
            }
        </script>
        <style>

            #footer{
                top:100px;
            }

            #header ul{
                list-style: none;
                text-transform: uppercase;
                position: relative;

            }
            body{

                background: rgb(233, 235, 238);
            }

            .link_menu{
                margin: 5px;
                background:  #207dbb;
                border: none; 
            }
            .enter_sair{

            }

            li{
                font-family:  sans-serif;
                padding: 10px;
                margin-left: 10px;
                border-radius: 10px;
                display: inline-block;
            }
            a{
                font-size: 20px;
                text-decoration: none;
                border-radius: 10px;
                color: white;
            }
            .corpo1{
                height: 535px;
                border-left: 2px solid #f1eeee;

            }
            .menu1{
                height: 535px;
            }

            .click{
                color:  #000;

                padding: 10px;
                border-radius: 50%;
                margin: 5px;

            }
            label{
                color: black;
            }
            .btn{
                background:  #207dbb;
            }
            .click{
                position: absolute;
                float: right;
                left: 83%;
            }
            #header{
                height: 70px;
                background: white;
                border-bottom: 2px solid #f1eeee;
            }
            #footer{
                height: 20px;
            }
            .modal-content{
                background: #f2f2f2;
                border:  none;
                color: black;
                left: 40%;
                height: 170px;
                width: 200px;
                top: -7%;
            }
            .modal{
                background-color: rgba(0,0,0,0); /* Black w/ opacity */;
            }
            .btn{
                text-align: center;
            }
        </style>
    </head>
    <body style=" background: white" >


        <div id="header" style=" ;/* -webkit-linear-gradient(left,#e2f6f6,#f1eeee); */">

            <ul>
                <button class="link_menu"><li><a  href="index.jsp" target="my_frame">Pagina Inicial</a></li></button>
                <!-- <button class="link_menu"><li><a  href="http://www.mined.gov.mz/Pages/Home.aspx" target="blanck">Educação</a></li></button> -->

                <%
                    List<Role> rol = (List<Role>) session.getAttribute("permissoes");
                    if (rol == null) {
                %>
                <button class="link_menu" style=" background: none; position: absolute;left: 92%;"><li><a   style=" color: black" href="login.jsp">Entrar</a></li></button>
                        <%
                        } else {

                        %>
                <label class="click" onclick="info();">	&#128100<%= ((User) session.getAttribute("user")).getUserName()%></label>
                <% }%>

            </ul>

        </div>

        <div id="myModal" class="modal">
            <!-- Modal content -->
            <div class="modal-content">
                <span class="close">&times;</span>

                <% if ((User) session.getAttribute("user") != null) {%>
                <p>User: 
                    <%= ((User) session.getAttribute("user")).getUserName().toLowerCase()%> </p>
                <p> Tipo</p>

                <option style=" font-size:  20px"> 
                    <%= ((User) session.getAttribute("user")).getIdTipo().getDescricao()%>
                </option>

                <a class=" btn"  style=" font-size: 20px;" href="terminarSessao.jsp">Sair</a>
                <% }%>

            </div>                  
        </div>

        <div>
            <iframe class="menu1" frameborder="none" name="menu" width="18%" height="500px"  src="menu.jsp"></iframe>
                <% if ((User) session.getAttribute("user") != null) {%>
            <iframe class="corpo1"  frameborder="none" name="body" width="77%" height="500px"  src="listaEstudantes.jsp"></iframe>
                <%} else {  %>
            <iframe class="corpo1"  frameborder="none" name="body" width="77%" height="500px"  src="home.jsp"></iframe>
                <%}%>
        </div>


        <div align="center" style=" background: #f1eeee;" id="footer">
            <p>Copyright &copy; 2018 </p>
        </div>
    </body>
    <script>

        function select(j) {
            var anc = document.getElementsByTagName('a');
            var i;
            for (i = 0; i < anc.length; i++) {
                anc[i].parentNode.style.backgroundColor = "inherit";
                anc[i].style.color = "white";
            }
            var a = document.getElementById(j);
            // var a = document.getElementById(j);
            a.parentNode.style.backgroundColor = "blue";
            a.style.color = 'black';
            top.location.hash = a.innerHTML;
            // alert(top.location.href);
        }
        function info() {
            //modal.style.display = "block";
            document.getElementById('myModal').style.display = "block";
        }

        function fecharInfo() {
            alert('sdfsdf');
            //modal.style.display = "block";
        }

        var span = document.getElementsByClassName("close")[0];
        span.onclick = function () {
            document.getElementById('myModal').style.display = "none";
        }
        window.onclick = function (event) {
            if (event.target == document.getElementById('myModal')) {
                document.getElementById('myModal').style.display = "none";
            }
        };

        function validar() {
            if (formu.senha.value != formu.confirm.value) {
                alert('Por favor confirme a senha');
                formu.confirm.scrollIntoView();
                return false;
            }
        }
    </script>

</html>