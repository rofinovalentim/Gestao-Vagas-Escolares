/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.EscolaJpaController;
import control.EstudanteJpaController;
import control.GeneroJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Escola;
import model.Estudante;
import model.Genero;
import model.Vagas;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "AdicionarEstudante", urlPatterns = {"/AdicionarEstudante"})
public class AdicionarEstudante extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");

            Estudante estudante;//new Estudante();

            estudante = new Estudante();

            estudante.setNomeEstudante(request.getParameter("nome"));
            estudante.setEmail(request.getParameter("email"));
            estudante.setTelefone(Integer.parseInt(request.getParameter("telefone")));

            String dataNascimento = "";
            String aux = request.getParameter("dataNasc");

            for (int i = 0; i < aux.length(); i++) {
                char character = aux.charAt(i);
                if (character != '-') {
                    dataNascimento = dataNascimento + character;
                } else {
                    dataNascimento = dataNascimento + "/";
                }
            }
            estudante.setNrBI(request.getParameter("nr_bi"));
            estudante.setDataNascimento(new Date(dataNascimento));

            if (request.getParameter("genero").equals("Masculino")) {
                GeneroJpaController generoController = new GeneroJpaController(emf);
                Genero genero = generoController.findGenero(1);
                estudante.setIdGenero(genero);
            } else {
                GeneroJpaController generoController = new GeneroJpaController(emf);
                Genero genero = generoController.findGenero(2);
                estudante.setIdGenero(genero);
            }

            EscolaJpaController escolaController = new EscolaJpaController(emf);
            Escola escola = escolaController.findEscola(Integer.parseInt(request.getParameter("escola")));
            Vagas vagas = new Vagas(escola.getIdEscola(), request.getParameter("classe"));
            estudante.setVagas(vagas);

            try {
                new EstudanteJpaController(emf).create(estudante);
                request.setAttribute("verificar", 1);
                request.getRequestDispatcher("listaEscolaCliente.jsp").forward(request, response);
            } catch (Exception ex) {

            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
