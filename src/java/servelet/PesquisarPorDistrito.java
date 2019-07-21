/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.DistritoJpaController;
import control.EscolaJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Distrito;
import model.Escola;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "PesquisarPorDistrito", urlPatterns = {"/PesquisarPorDistrito"})
public class PesquisarPorDistrito extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            int idDistrito = Integer.parseInt(request.getParameter("distrito"));
            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            EscolaJpaController eController = new EscolaJpaController(emf);
            List<Escola> escolaList = eController.findEscolaEntities();

            ArrayList<Escola> escolaListDistrito = new ArrayList<>();

            for (Escola escola : escolaList) {
                if (escola.getIddistrito().getIdDistrito() == idDistrito) {
                    escolaListDistrito.add(escola);
                }
            }

            //List<Escola> escolaList = eController.buscarEscola(Integer.parseInt();
            if (escolaListDistrito.isEmpty()) {
                request.getRequestDispatcher("notFound.jsp").forward(request, response);
            } else {
                request.setAttribute("escolas", escolaListDistrito);
                request.getRequestDispatcher("listaEscolaCliente.jsp").forward(request, response);
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
