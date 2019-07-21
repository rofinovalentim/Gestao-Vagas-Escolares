<%-- 
    Document   : alterarSenha
    Created on : Oct 13, 2018, 6:47:37 PM
    Author     : Rofino Chunga Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />
        <title>Alterar Senha</title>
        <style>
            label{
                color: #f1eeee;
            }
            .reset{
                background: red;
                color:black;
                float: left;
                font-size: 25px;
                border: none;
                margin-top: 10px;
                border-radius: 5px;
            }
        </style>
    </head>
    <body>
        <div class="login-box">
            <form name="formu" action="AlterarSenha" method="post">
                <label>*Nome de Usuario:</label>
                <div class="textbox">
                    <input type="text" required="" name="username"  placeholder="Insira o seu Nome de usuario">
                </div>
                <label>*Senha Antiga:</label>
                <div class="textbox">
                    <input type="password" required="" name="SenhaAntiga" placeholder="Insira A senha Antiga">
                </div>

                <label>*Senha Nova:</label>
                <div class="textbox">
                    <input type="password" required="" name="novaSenha" placeholder="Insira a nova Senha">
                </div>
                <label>*Confirmar Senha:</label>
                <div class="textbox">
                    <input type="password" required="" name="confirm" placeholder="Confirmar Senha">
                </div>
                <input style="display: block" type="submit" class="btn"  value="Ok"/>
                <input type="reset" class="reset" value="Cancelar"/>
            </form>
        </div>

    </body>
</html>
