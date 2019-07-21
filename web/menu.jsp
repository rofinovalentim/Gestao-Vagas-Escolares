<%-- 
    Document   : menu
    Created on : Oct 11, 2018, 9:30:15 PM
    Author     : Rofino Chunga Jr
--%>

<%@page import="control.DistritoJpaController"%>
<%@page import="model.Distrito"%>
<%@page import="model.Role"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />
        <title>Menu</title>
        <style>
            a{
                font-family:sans-serif;
                font-size:14px;
                color:navy;
                cursor: pointer;
            }

            button{
                background: none;
            }
            .menuList {
                border: none;
                /*margin: 10px;*/
                list-style-type: none;
                width: 100%;
                margin: 0;
                padding: 0;
                overflow: auto;

                text-align: center;
            }
            a {
                margin-left: 30px;
                text-align: center;
                border-radius:2px ;
                border: none;
                margin: 2px;
                display: block;
                color: black;
                padding: 8px 16px;
                font-size: 30px;
                text-decoration: none;
                background-color: #A7C3DB;
                background:#A7C3DB;
                /*background: -webkit-linear-gradient(right,#e2f6f6,#f1eeee);*/
            }
            h2{

                border-radius: 10%;
                padding: 2px;
            }
            .textbox{
                width: 80%;
                background: #2991d6;
                border: none;
                border-radius: 0px;
                padding: 5px;
                color: white;
            }
            .search_box_button{
                background:rgb(66, 103, 178);
                padding: 10px;
                color: white;
                font-size: 18px;
                border-radius:50%;
                border: none;
                float: right;

                cursor: pointer;
            }
        </style>
    </head>
    <body style="height: 100%; background: white;" >

        <h2 style="font-family: inherit;font-size:30px; 
            color: #000;text-align: center ;">MENU</h2>

        <%!List<Distrito> distritos;%>
        <%
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            DistritoJpaController distritoController = new DistritoJpaController(emf);
            distritos = distritoController.findDistritoEntities();
        %>
        <%
            List<Role> rol = (List<Role>) session.getAttribute("permissoes");
            if (rol != null) {
                if (rol.contains(new Role("VerEstudantes"))) {
        %>
        <a id="a1" onclick="select('a1')" href="listaEstudantes.jsp" target="body" >Pedidos</a>

        <%
            }
            if (rol.contains(new Role("VerUsuarios"))) {
        %>

        <a id="a2"  onclick="select('a2')"   href="listaUsuario.jsp" target="body" >Utilizadores</a>

        <% }%>
        <%
            if (rol.contains(new Role("VerEscolas"))) {
        %>

        <a  id="a3" onclick="select('a3')"  href="listaEscola.jsp" target="body">Escolas</a>


        <a  id="a4" onclick="select('a4')"  href="listaDistrito.jsp" target="body">Distritos</a>

        <% }

        %>


        <% } else {%>

        <a id="a4" onclick="select('a4')"  href="listaEscolaCliente.jsp" target="body">Escolas</a>
      

        <br><P style="font-size: 20px"> Procurar por distrito: </p>
        <form action="PesquisarPorDistrito" target="body" method="get">

            <select name="distrito" class="textbox"   style=" background:#A7C3DB; ">
                <%for (Distrito distrito : this.distritos) {
                %>
                <option value="<%=distrito.getIdDistrito()%>"><%=distrito.getNomeDestrito()%></option>
                <%
                    }
                %>
            </select>

            <button class="search_box_button"  type="submit">Pesquisar</button>

        </form>
        <%}%>

        <script>
            function select(j) {
                var anc = document.getElementsByTagName('a');
                var i;
                for (i = 0; i < anc.length; i++) {
                    anc[i].style.backgroundColor = "#A7C3DB";
                    anc[i].style.color = "black";
                }
                var a = document.getElementById(j);
                // var a = document.getElementById(j);
                a.style.backgroundColor = "rgb(66, 103, 178)";
                a.style.color = 'white';
                top.location.hash = a.innerHTML;
                // alert(top.location.href);
            }

        </script>
    </body>
</html>