/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.EscolaJpaController;
import control.VagasJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Escola;
import model.Vagas;
import model.VagasPK;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "EditarEscola", urlPatterns = {"/EditarEscola"})
public class EditarEscola extends HttpServlet {

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

            int idEscola = Integer.parseInt(request.getParameter("ide"));

            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");

            EscolaJpaController escolaController = new EscolaJpaController(emf);
            Escola escola = escolaController.findEscola(idEscola);
            
            VagasJpaController vagasController=new VagasJpaController(emf);
            
            
            VagasPK vagaspk = new VagasPK();
            vagaspk.setClasse("8classe");
            vagaspk.setIdEscola(idEscola);
            Vagas vaga1=vagasController.findVagas(vagaspk);
            
            
            vagaspk = new VagasPK();
            vagaspk.setClasse("9classe");
            vagaspk.setIdEscola(idEscola); 
            Vagas vaga2=vagasController.findVagas(vagaspk);
            
            
            vagaspk = new VagasPK();
            vagaspk.setClasse("10classe");
            vagaspk.setIdEscola(idEscola);
            Vagas vaga3=vagasController.findVagas(vagaspk);
            
            
            
            vagaspk = new VagasPK();
            vagaspk.setClasse("11classe");
            vagaspk.setIdEscola(idEscola);
            Vagas vaga4=vagasController.findVagas(vagaspk);
            
            
            vagaspk = new VagasPK();
            vagaspk.setClasse("12classe");
            vagaspk.setIdEscola(idEscola);
            Vagas vaga5=vagasController.findVagas(vagaspk);
            
            
            
           
            request.setAttribute("escola", escola);
            request.setAttribute("vaga1", vaga1);
            request.setAttribute("vaga2", vaga2);
            request.setAttribute("vaga3", vaga3);
            request.setAttribute("vaga4", vaga4);
            request.setAttribute("vaga5", vaga5);
            
            
            
            request.getRequestDispatcher("cadastrarEscola.jsp").forward(request, response);
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
