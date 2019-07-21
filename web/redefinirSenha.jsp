<%-- 
    Document   : redefinirSenha
    Created on : Oct 6, 2018, 7:43:01 AM
    Author     : Rofino Chunga Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/redefinirSenha_style.css" />
        <title>Redefinir Senha</title>
    </head>
    <body>
        <form action="EnviarSenha" method="get">
            <div class="login-box" id="redefinirSenha">
                <p id="title">Esqueceu a senha ?</p>
                <p>Digite seu username e email para enviarmos a senha.</p>
                <div class="textbox">
                    <table>
                        <tr> 
                            <td>&#128100</td> 
                            <td><input type="text"  name="username" required="" value=""  placeholder="username"></td>
                        <tr>
                    </table>
                </div>
                <div class="textbox">
                    <table>
                        <tr> <td>&#64</td> <td><input type="email" required="" name="email" value=""  placeholder="E-mail"></td><tr>
                    </table>
                </div>

                <input type="submit"  class="btn"  name="" value="Enviar &#9654">
                <a href="login.jsp"><input type="button" id="btn-back" name="" value="&#9668 Voltar"></a><br><br><br>
            </div>
        </form>
    </body>
</html>
