<%-- 
    Document   : listaEscolaCliente
    Created on : Nov 9, 2018, 11:24:48 AM
    Author     : Rofino Chunga Jr
--%>


<%@page import="java.util.ArrayList"%>
<%@page import="control.VagasJpaController"%>
<%@page import="model.Vagas"%>
<%@page import="model.User"%>
<%@page import="control.EscolaJpaController"%>
<%@page import="javax.persistence.EntityManagerFactory"%>
<%@page import="model.Escola"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="_css/listaEstudantes_style.css" />
        <link rel="stylesheet" type="text/css" href="_css/search-box.css" />
        <link rel="stylesheet" type="text/css" href="_css/modal.css" />


        <style>
            td a{
                color:white;
                background: #00adee;  
                padding: 5px;
                border-radius: 5px;
                text-decoration: none;
            }
            tr{
                background-color: white;
            }
            table{
                position: relative;
                top: -10px;
            }
            td{
                font-family:  sans-serif;
            }
            td  a:hover{
                background: yellowgreen;
            } 
            tr{
                width: 100%;
            }
            #escola{
                width: 500px;
                height: 300px;
            }
            #seta{
                width: 20px;
                height: 20px;

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
        <title>Lista de Escolas</title>
    </head>
    <body style=" background: white">
        <div class="search_box">
            <form action="PesquisarEscola">
                <input type="hidden" value="1" name="tipo">
                <input class="search_box_input" type="search" name="pesquisa" placeholder="Nome Da Escola...">
                <button class="search_box_button" type="submit">&#128269</button>
            </form>
        </div>
        <div id="sucessoModal" class="modal">
            <div class="modal-content">
                <b style=" font-family:  sans-serif; font-size: 20px">Enviada com sucesso!</b>
                <button class="no" onclick="fechar()">Ok</button>
            </div>
        </div>

        <%
            if (request.getAttribute("verificar") != null) {
        %>
        <script>
            document.getElementById("sucessoModal").style.display = 'block';
        </script>
        <%}%> 

        <h2>Lista de Escolas</h2> <br>

        <%!List<Escola> escolas;
            List<Vagas> vagas;%>
        <%

            List<Escola> userList = (List<Escola>) request.getAttribute("escolas");
            if (userList != null && !userList.isEmpty()) {
                escolas = userList;
            } else {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                EscolaJpaController escolaController = new EscolaJpaController(emf);
                escolas = escolaController.findEscolaEntities();

                VagasJpaController vagasController = new VagasJpaController(emf);
                vagas = vagasController.findVagasEntities();
            }

        %>

        <table style="width:100%  " >

            <tbody>
                <% for (Escola escola : this.escolas) {
                        ArrayList<Vagas> vagaList = new ArrayList<Vagas>();
                %>
                <tr>

                    <td style=""> <img id="escola" src="_img/escola.jpg"> </td>
                    <td class="escola" style=" text-align: left; font-size: 20px;">
                        <b>Nome da Escola:</b> <%=escola.getNomeEscola()%><br>
                        <b>Provincia: </b><%= escola.getIddistrito().getProvincia()%><br>
                        <b>Distrito: </b><%= escola.getIddistrito().getNomeDestrito()%><br>
                        <b>Endereço: </b> <%= escola.getEndereco()%> 

                        <b><p style=" text-align: center; font-size: 22px; border-bottom: 1px solid black"> Contactos</p> </b>
                        <b style="">Email: <%= escola.getEmail()%></b><br>
                        <b>Telefone:<%= escola.getTelefone()%></b> <br>
                    </td>
                </tr>

                <tr style=" border-bottom: 1px solid  black; background: white">
                    <td >


                        <% for (Vagas vaga : this.vagas) {

                                if (vaga.getEscola().equals(escola)) {
                                    vagaList.add(vaga);
                                }
                            }

                            // if (vaga.getNrVagas() > 0) {

                        %>
                        <p style="font-size: 20px">
                            <b>8CLASSE:</b> 
                            <% if (vagaList.get(vagaList.size() - 2).getNrVagas() > 0) {%>
                            <i>     <%=vagaList.get(vagaList.size() - 2).getNrVagas()%> vaga(s) </i>
                            <% if ((User) session.getAttribute("user") == null) {%>
                            <a href="PegaEscola?ide=<%=vagaList.get(vagaList.size() - 2).getVagasPK().getIdEscola()%>&classe=<%=vagaList.get(vagaList.size() - 2).getVagasPK().getClasse()%>">Pré-Inscrição</a>

                            <!-- <//%//=vagaList.get(vagaList.size()-2).getVagasPK().getClasse() %> -->
                            <% } %>

                            <% } else {  %>

                            <i style="color: red">Sem vaga(s) </i>
                        </p> 
                        <% } %> 
                        <p style=" font-size: 20px">

                            <b>9CLASSE:</b> 
                            <% if (vagaList.get(vagaList.size() - 1).getNrVagas() > 0) {%>
                            <i><%=vagaList.get(vagaList.size() - 1).getNrVagas()%> vaga(s) </i>

                            <a href="PegaEscola?ide=<%=escola.getIdEscola()%>&classe=<%=vagaList.get(vagaList.size() - 1).getVagasPK().getClasse()%>">Pré-Inscrição</a> 


                            <% } else {  %>

                            <i style="color: red">Sem vaga(s) </i>
                        </p>

                        <% } %> 


                        <p style="font-size: 20px">
                            <b>10CLASSE:</b> 

                            <% if (vagaList.get(0).getNrVagas() > 0) {%>
                            <i> <%=vagaList.get(0).getNrVagas()%> vaga(s)</i>

                            <a href="PegaEscola?ide=<%=escola.getIdEscola()%>&classe=<%=vagaList.get(0).getVagasPK().getClasse()%>">Pré-Inscrição</a> 


                            <%
                            } else {  %>

                            <i style="color: red">Sem vaga(s) </i>

                            <% } %>
                        </p>
                    </td>
                    <td style=" border-left: 0px solid black">
                        <p style="font-size: 20px;">
                            <b>11CLASSE:</b> 
                            <% if (vagaList.get(1).getNrVagas() > 0) {%>
                            <i><%=vagaList.get(1).getNrVagas()%> vaga(s)</i>

                            <a href="PegaEscola?ide=<%=escola.getIdEscola()%>&classe=<%=vagaList.get(1).getVagasPK().getClasse()%>">Pré-Inscrição</a> 

                            <%
                            } else {  %>

                            <i style="color: red">Sem vaga(s) </i>

                            <% } %>

                        </p>

                        <p style=" font-size: 20px">

                            <b>12CLASSE:</b> 
                            <% if (vagaList.get(2).getNrVagas() > 0) {%>
                            <i> <%=vagaList.get(2).getNrVagas()%> vaga(s) </i>

                            <a href="PegaEscola?ide=<%=escola.getIdEscola()%>&classe=<%=vagaList.get(2).getVagasPK().getClasse()%>">Pré-Inscrição</a> 


                            <%
                            } else {  %>
                            <i style="color: red">Sem vaga(s) </i>
                        </p>
                        <% } %>
                    </td>
                </tr>
                <%
                    }

                %>



            </tbody>
        </table>
        <script>
            function fechar() {
                document.getElementById("sucessoModal").style.display = 'none';
            }
            window.onclick = function (event) {
                if (event.target == document.getElementById('sucessoModal')) {
                    document.getElementById('sucessoModal').style.display = "none";
                }
            }
        </script>
    </body>
</html>




