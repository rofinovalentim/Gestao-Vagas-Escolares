<%-- 
    Document   : cadastrarAdministrador
    Created on : Oct 6, 2018, 11:40:24 AM
    Author     : Rofino Chunga Jr
--%>

<%@page import="model.TipoUsuario"%>
<%@page import="control.UserJpaController"%>
<%@page import="control.RoleJpaController"%>
<%@page import="model.Role"%>
<%@page import="java.util.List"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />

        <link rel="stylesheet" type="text/css" href="_css/cadastrarAdministrador.css" />

        <style>
            .login-box{
                top: 40%;
                left: 50%;
                width: 95%;
                height: auto;
                background: white; /*rgb(233, 235, 238); */
            }


            .login-box h2{
                /* text-decoration: none;
                 font-family:  sans-serif;
                 color: white;
                 float: left;
                 font-size: 40px;
                 border-bottom: 6px solid white #4caf50*/;
                margin-bottom: 0px;
                text-align: center;
                border-radius: 20%;
                /* padding: 13px 0;*/
            }
            legend{
                text-align:  center;
            }
            .btn{
                float: right;
            }
        </style>


        <script type="text/javascript">
            function validar() {


                if (formuser.senha.value != formuser.tsenha.value) {
                    alert('CONFIRME A PALAVRA PASSE E TENTE NOVAMENTE');
                    formuser.tsenha.focus();
                    return false;
                }
            }
        </script>


        <title>Cadastrar Administrador</title>

    </head>
    <body style=" background: white">

        <%!List<User> userList;
            List<TipoUsuario> tipoUser;%>
        <%
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            userList = new UserJpaController(emf).findUserEntities();

        %>

        <form action="CadastrarUsuario" name="formuser" method="GET">
            <div class="login-box">
                <span class="close">&times;</span>
                <label style=" text-align:  center"> <h3 style="color: black">Cadastrar User</h3></label>


                <label>Username:</label>
                <input type="text" class=" textbox" size="200" required value="${user.userName}"  name="username"  id="cnome" placeholder="Novo usuario"/></td>
                <label>Password:</label>
                <input type="password" class="textbox" required="" size="200" value="${user.password}" name="senha"   placeholder="Senha"/></td>  

                <label>Confirm Password</label>
                <input type="password" class=" textbox" required="" size="200" value="${user.password}" name="tsenha"  placeholder="Confirmar senha"/><td>
                    <label>E-mail:</label>
                    <input type="email" class=" textbox" required="" size="200" value="${user.email}" name="email"  placeholder="E-mail"></td>

                <label>User type:</label>
                <select class="textbox" name="tipo">
                    <option >Administrador</option>
                    <option>SuperAdministrador</option>
                </select>

                <button type="submit" class="btn" onclick="return validar()">Adicionar </button>

            </div>
        </form>

        <script>
            var span = document.getElementsByClassName("close")[0];
            span.onclick = function () {
                document.getElementById('cadastroUser').style.display = "none";
            }
        </script>
    </body>

</html>
