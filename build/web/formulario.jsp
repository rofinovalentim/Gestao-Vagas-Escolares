<%-- 
    Document   : inscricao
    Created on : 7/set/2018, 0:47:55
    Author     : 1001
--%>



<%@page import="control.EscolaJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.Escola"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Pré-inscrição</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="_css/formulario_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />

        <style>
            .login-box{
                width: 90%;
                top: 70%;
                left: 50%;
                background: white; 
            }
            body{
                background:white;
            }
            label{
                color: black;
            }
            legend{
                color: black;
                border-bottom: 1px solid #4caf50;
            }
        </style>
    </head>
    <body style="">
        <%!Escola escola;%>
        <%
            escola = (Escola) request.getAttribute("escola");
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");

            // escola= new EscolaJpaController(emf).findEscola(Integer.parseInt(request.getParameter("ide")));

        %>



        <form action="AdicionarEstudante">

            <div class="login-box">
        
                <legend> Pré-inscrição</legend><br><br><br><br><br>
                <label>*Nome Completo:</label>
                <div class="textbox">
                    <input class="input_inscricao" type="text" required="" name="nome"  placeholder="Nome completo">
                </div>
                <label>*E-mail:</label>
                <div class="textbox">
                    <input class="input_inscricao" type="text" required="" name="email" placeholder="email">
                </div>
                <label>*Numero de BI:</label>
                <div class="textbox">
                    <input class="input_inscricao" type="text" required="" name="nr_bi" placeholder="Numero de BI">
                </div> 
                <label>*Telefone:</label>
                <div class="textbox">
                    <input class="input_inscricao" type="tel" required="" name="telefone" placeholder="Telefone">
                </div> 
                <label>*Genero:</label>
                <select name="genero" class="textbox">
                    <option>Masculino</option>
                    <option>Femenino</option>
                </select>

                <br><label>*Data de Nascimento:</label><br>

                <input class=" textbox" style=" width: 20%" type="date" required="" name="dataNasc"><br>


                <label>*Escola: </label> <br>          
                  <select class="textbox" name="escola" readonly style="background:  #207dbb;color: white " >  
                      <option readonly value="<%=escola.getIdEscola()%>"> <%=escola.getNomeEscola()%></option>
                  </select>
  
  
                   
  
  
                  <label>*Classe:</label> <br>
                  <input type="text" style=" width: 15%; background:  #207dbb;color: white " name="classe" value="${vaga}" readonly=""> <br>
                

                <button type="submit" class="btn">Enviar</button>

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
