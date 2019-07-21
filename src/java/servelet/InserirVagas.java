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
import model.Vagas;
import model.VagasPK;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "InserirVagas", urlPatterns = {"/InserirVagas"})
public class InserirVagas extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");

        List<Escola> escolas= new EscolaJpaController(emf).findEscolaEntities();
        Escola escola=escolas.get(escolas.size()-1);
       // Escola escola1=new EscolaJpaController(emf).buscarEsc("25 de setembro");
        
        VagasPK vagaspk = new VagasPK();
        
        
        
        vagaspk.setIdEscola(escola.getIdEscola());
        vagaspk.setClasse("18classe");
        

        Vagas vagas = new Vagas();
        
        vagas.setEscola(escola);
       // vagas.getVagasPK().setIdEscola(1);
        //vagas.getVagasPK().setClasse("9classe");
      //  vagas.setVagasPK(vagaspk);
       // vagas.setNrVagas(9);
       
        vagas.setNrVagas(20);
        vagas.setVagasPK(vagaspk);
        new VagasJpaController(emf).create(vagas);
                 /*out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PesquisarEstudante</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet PesquisarEstudante at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");*/
        
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
            Logger.getLogger(InserirVagas.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(InserirVagas.class.getName()).log(Level.SEVERE, null, ex);
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
