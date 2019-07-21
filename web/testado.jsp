<%-- 
    Document   : cadastrarEscola
    Created on : Oct 6, 2018, 11:40:05 AM
    Author     : Rofino Chunga Jr
--%>
<%@page import="control.DistritoJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.Distrito"%>
<%@page import="java.util.List"%>
<%@page import="model.Escola"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/login_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/cadastrarAdministrador.css" />
        <title>Cadastrar Escola</title>
        <style>

            body{
                background-color: white;
            }
            .login-box{
                width: 80%;
                padding: 20px 40px;
                background: white;
                top: 90%;
            }

            input{
                border:none;
                outline: none;
                background: none;
                color: black;
                font-size: 18px;
                width: 90%;
                float: left;
                margin: 0 10px;
            }

            .classes{
                background:  #207dbb;
                padding: 20px 30px;
                border-radius: 10px; 
                align-content: center;

            }
            .classes label{
                color: #f2f2f2;
            }
            h1{
                border: none;
                padding: 10px;
                text-align: left;
                text-decoration: none;
                font-size: 40px;
                font-family:  sans-serif;
                color: #000 ;
                float:top;
                border-bottom: 2px solid yellowgreen;  /*#4caf50*/;


                margin-bottom: 20px;
                padding: 10px;

            }
            label{
                color: black;
            }
            .classes input{
                width: 95%;
            }
            .classes label{
                color: black;
            }


        </style>
    </head>
    <body>
        <%!List<Distrito> distritoList;%>
        <%
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            distritoList = new DistritoJpaController(emf).findDistritoEntities();

        %>


        <div class=" login-box">
            <span class="close">&times;</span>
            <form action="CadastrarEscola" method="get">

                <label style=" text-align: center"t> <h3 style="color: black">Cadastrar Escola</h3></label>
                <label>*Nome da Escola:</label>
                <input type="hidden"  name="ide" value="${escola.idEscola}">
                <div class="textbox">
                    <input type="text" required="" value="${escola.nomeEscola}" placeholder="Insira o nome da Escola" name="nomeEscola">
                </div>
                <label>*Endereco:</label>
                <div class="textbox">
                    <input type="text" required="" value="${escola.endereco}" placeholder="Endereco" name="endereco" >
                </div>

                <label>*Distrito: </label>
                <select name="distrito" required="" class="textbox">
                    <% for (int i = 0; i < distritoList.size(); i++) {
                    %>
                    <option value="<%=distritoList.get(i).getIdDistrito()%>"><%=distritoList.get(i).getNomeDestrito()%></option>
                    <%
                        }
                    %>
                </select>

                <label>*Telefone:</label>
                <div class="textbox">
                    <input type="tel" required="" value="${escola.telefone}" placeholder="Telefone" name="tel" >
                </div>

                <label>*Email:</label>
                <div class="textbox">
                    <input type="email" required="" value="${escola.email}" placeholder="Email" name="email" >
                </div>



                <p style=" text-align:  center; color: black">Vagas Nas Classes</p>        


                <div class=" classes" style=" background:  #f2f2f2">
                    <label> 8 Classe:</label>
                    <div class="textbox">
                        <input type="number"required="" value="${vaga1.nrVagas}" placeholder="8 classe" name="8classe" min="0">
                    </div>

                    <label>9 Classe:</label>
                    <div class="textbox">
                        <input type="number"required="" value="${vaga2.nrVagas}" placeholder="9 classe" name="9classe" min="0">
                    </div>

                    <label>10 Classe:</label>
                    <div class="textbox">
                        <input type="number" required="" value="${vaga3.nrVagas}" placeholder="10 classe" name="10classe" min="0">
                    </div>

                    <label>11 Classe:</label>
                    <div class="textbox">
                        <input type="number" required="" value="${vaga4.nrVagas}" placeholder="11 classe" name="11classe" min="0"> 
                    </div>
                    <label>12 Classe:</label>
                    <div class="textbox">
                        <input type="number"  required="" value="${vaga5.nrVagas}" placeholder="12 classe" name="12classe" min="0">
                    </div>

                </div>

                <button type="submit" class="btn" >Adicionar </button>
                <button type="reset" class="reset" >Cancelar</button>

            </form>
        </div>

        <script>
            var span = document.getElementsByClassName("close")[0];
            span.onclick = function () {
                document.getElementById('cadastroEscola').style.display = "none";
            }
        </script>
    </body>
</html>
