/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.EscolaJpaController;
import control.VagasJpaController;
import control.exceptions.IllegalOrphanException;
import control.exceptions.NonexistentEntityException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Escola;
import static model.Estudante_.vagas;
import model.Vagas;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "EliminarEscola", urlPatterns = {"/EliminarEscola"})
public class EliminarEscola extends HttpServlet {

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
            throws ServletException, IOException, IllegalOrphanException {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            Escola escola = new EscolaJpaController(emf).findEscola(Integer.parseInt(request.getParameter("ide")));

            VagasJpaController vagasController = new VagasJpaController(emf);
            List<Vagas> vagas = vagasController.findVagasEntities();

            try {
                for (Vagas vaga : vagas) {
                    if (vaga.getVagasPK().getIdEscola() == escola.getIdEscola()) {
                        try {
                            vagasController.destroy(vaga.getVagasPK());
                        } catch (Exception ex) {

                        }
                    }
                }
            } catch (Exception ex) {

            }

            try {
                new EscolaJpaController(emf).destroy(escola.getIdEscola());
            } catch (NonexistentEntityException ex) {
                Logger.getLogger(EliminarUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
            request.getRequestDispatcher("listaEscola.jsp").forward(request, response);

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
        try {
            processRequest(request, response);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(EliminarEscola.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (IllegalOrphanException ex) {
            Logger.getLogger(EliminarEscola.class.getName()).log(Level.SEVERE, null, ex);
        }
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
