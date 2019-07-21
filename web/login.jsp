<%-- 
    Document   : login
    Created on : Oct 1, 2018, 5:21:27 PM
    Author     : Rofino Chunga Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <script>
            if (top.location !== self.location) {//Esta instrucao faz com que esta pagina nao fique inclusa dentro das outras
                top.location = self.location;
            }



            }
        </script>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />
        <title>Login</title>

    </head>
    <body>

        <form method="post" name="login" action="ProcessarLogin">
            <div class="login-box">
                <img src="_img/user.png" class="user">
                <h2>Autenticação</h2>
                <div class="textbox">
                    <table>
                        <tr> <td>&#128100</td> <td><input type="text"  required=""  name="username" value=""  placeholder="Nome do Usuario"></td><tr>
                    </table>
                </div>
                <div class="textbox">
                    <table>
                        <tr><td>&#128273</td><td><input type="password" required  name="password" value="" placeholder="Palavra-Passe"></td></tr>
                    </table>
                </div>

                <input type="submit"  class="btn" name="" value="Entrar &#9654"><br><br><br>
                <%
                    if (request.getAttribute("verificar") != null) {
                %>
                <i style=" color:  #990000; text-decoration: none">Utilizador ou Senha inválida</i>
                <%}%> 
                <p>Esqueceu a senha ?<br>
                    Clique <a href="redefinirSenha.jsp" >aqui</a> para redefinir sua senha.</p>

            </div>
        </form>
    </body>
</html>
