/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.DistritoJpaController;
import control.EscolaJpaController;
import control.VagasJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Distrito;
import model.Escola;
import model.Vagas;
import model.VagasPK;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "CadastrarEscola", urlPatterns = {"/CadastrarEscola"})
public class CadastrarEscola extends HttpServlet {

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
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            boolean exist = request.getParameter("ide") != null;
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            String idUsuario = "";
            Escola escola = null;

            int idEscola = 0;

            //user = new User();
            if (!request.getParameter("ide").equals("")) {
                idEscola = Integer.parseInt(request.getParameter("ide"));
                escola = new EscolaJpaController(emf).findEscola(idEscola);
            } else {
                escola = new Escola();
            }

            escola.setNomeEscola(request.getParameter("nomeEscola"));
            escola.setEndereco(request.getParameter("endereco"));
            escola.setTelefone(Integer.parseInt(request.getParameter("tel")));
            escola.setEmail(request.getParameter("email"));

            DistritoJpaController distritoController = new DistritoJpaController(emf);
            Distrito distrito = distritoController.findDistrito(Integer.parseInt(request.getParameter("distrito")));

            escola.setIddistrito(distrito);

            if (request.getParameter("ide").equals("")) {
                try {

                    new EscolaJpaController(emf).create(escola);
                   // request.setAttribute("verificar", 1);
                } finally {

                }
            } else {
                try {
                    new EscolaJpaController(emf).edit(escola);
                    //request.setAttribute("verificar", 1);
                } finally {
                }
            }

            if (!request.getParameter("ide").equals("")) {
                escola = new EscolaJpaController(emf).findEscola(Integer.parseInt(request.getParameter("ide")));

                VagasJpaController vagasController = new VagasJpaController(emf);
                List<Vagas> vagas = vagasController.findVagasEntities();

                try {
                    for (Vagas vaga : vagas) {
                        if (vaga.getVagasPK().getIdEscola() == escola.getIdEscola()) {

                            if (vaga.getVagasPK().getClasse().equals("8classe")) {
                                try {
                                    vaga.setNrVagas(Integer.parseInt(request.getParameter("8classe")));
                                    vagasController.edit(vaga);
                                } catch (Exception ex) {

                                }
                            }
                            if (vaga.getVagasPK().getClasse().equals("9classe")) {
                                try {
                                    vaga.setNrVagas(Integer.parseInt(request.getParameter("9classe")));
                                    vagasController.edit(vaga);
                                } catch (Exception ex) {

                                }
                            }
                            if (vaga.getVagasPK().getClasse().equals("10classe")) {
                                try {
                                    vaga.setNrVagas(Integer.parseInt(request.getParameter("10classe")));
                                    vagasController.edit(vaga);
                                } catch (Exception ex) {

                                }
                            }
                            if (vaga.getVagasPK().getClasse().equals("11classe")) {
                                try {
                                    vaga.setNrVagas(Integer.parseInt(request.getParameter("11classe")));
                                    vagasController.edit(vaga);
                                } catch (Exception ex) {

                                }
                            }
                            if (vaga.getVagasPK().getClasse().equals("12classe")) {
                                try {
                                    vaga.setNrVagas(Integer.parseInt(request.getParameter("12classe")));
                                    vagasController.edit(vaga);
                                } catch (Exception ex) {

                                }
                            }
                        }
                    }
                   // request.setAttribute("verificar", 1);
                    request.getRequestDispatcher("listaEscola.jsp").forward(request, response);
                } catch (Exception ex) {

                }

            } else {
                List<Escola> escolas = new EscolaJpaController(emf).findEscolaEntities();
                escola = escolas.get(escolas.size() - 1);

                VagasPK vagaspk = new VagasPK();
                Vagas vagas = new Vagas();
                VagasJpaController vagasController = new VagasJpaController(emf);

                vagaspk.setIdEscola(escola.getIdEscola());
                vagaspk.setClasse("8classe");

                vagas.setEscola(escola);
                vagas.setVagasPK(vagaspk);
                vagas.setNrVagas(Integer.parseInt(request.getParameter("8classe")));
                try {
                    new VagasJpaController(emf).create(vagas);
                } catch (Exception ex) {

                }
                vagas = new Vagas();

                vagaspk.setIdEscola(escola.getIdEscola());
                vagaspk.setClasse("9classe");

                vagas.setEscola(escola);
                vagas.setVagasPK(vagaspk);
                vagas.setNrVagas(Integer.parseInt(request.getParameter("9classe")));
                try {
                    new VagasJpaController(emf).create(vagas);
                } catch (Exception ex) {

                }

                vagas = new Vagas();

                vagaspk.setIdEscola(escola.getIdEscola());
                vagaspk.setClasse("10classe");

                vagas.setEscola(escola);
                vagas.setVagasPK(vagaspk);
                vagas.setNrVagas(Integer.parseInt(request.getParameter("10classe")));
                try {
                    new VagasJpaController(emf).create(vagas);
                } catch (Exception ex) {

                }

                vagas = new Vagas();

                vagaspk.setIdEscola(escola.getIdEscola());
                vagaspk.setClasse("11classe");

                vagas.setEscola(escola);
                vagas.setVagasPK(vagaspk);
                vagas.setNrVagas(Integer.parseInt(request.getParameter("11classe")));
                try {
                    new VagasJpaController(emf).create(vagas);
                } catch (Exception ex) {

                }

                vagas = new Vagas();

                vagaspk.setIdEscola(escola.getIdEscola());
                vagaspk.setClasse("12classe");

                vagas.setEscola(escola);
                vagas.setVagasPK(vagaspk);
                vagas.setNrVagas(Integer.parseInt(request.getParameter("12classe")));

                try {
                    new VagasJpaController(emf).create(vagas);
                } catch (Exception ex) {

                }
                request.getRequestDispatcher("listaEscola.jsp").forward(request, response);
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
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(CadastrarEscola.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (Exception ex) {
            Logger.getLogger(CadastrarEscola.class.getName()).log(Level.SEVERE, null, ex);
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
