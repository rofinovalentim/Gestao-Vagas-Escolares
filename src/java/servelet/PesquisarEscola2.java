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
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Escola;
import model.Vagas;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "PesquisarEscola2", urlPatterns = {"/PesquisarEscola2"})
public class PesquisarEscola2 extends HttpServlet {

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
        EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
        List<Escola> le;
        if (targetId.equals("")) {
            le = new EscolaJpaController(emf).findEscolaEntities(); //System.out.println("1");
        } else {
            le = new EscolaJpaController(emf).buscarEscola(targetId);// System.out.println("2");
        }
        StringBuffer sb = new StringBuffer();

//        if (targetId != null) {
//            targetId = targetId.trim().toLowerCase();
//        } else {
//            context.getRequestDispatcher("/error.jsp").forward(request, response);
//        }
        boolean namesAdded = false;
        List<Vagas> vagaList = new VagasJpaController(emf).findVagasEntities();
        List<Vagas> vagas = null;
        // if (action.equals("complete")) {

        // Verificar se encontrou alguma informacao
        for (int i = 0; i < le.size(); i++) {
            sb.append("<escola>");
            sb.append("<ide>" + le.get(i).getIdEscola() + "</ide>");
            sb.append("<nome>" + le.get(i).getNomeEscola() + "</nome>");
            sb.append("<Endereco>" + le.get(i).getEndereco() + "</Endereco>");
            sb.append("<Distrito>" + le.get(i).getIddistrito().getNomeDestrito() + "</Distrito>");
            sb.append("<Provincia>" + le.get(i).getIddistrito().getProvincia() + "</Provincia>");

            for (int index = 0; index < vagaList.size(); index++) {
                Vagas vaga = vagaList.get(index);
                if (vaga.getVagasPK().getIdEscola() == le.get(i).getIdEscola()) {
                    vagas.add(vaga);
                }
            }
                /* for(int j=0;j<4;j++){
                
            }*/
                sb.append("</escola>");
                /*for (int index=0;index<vagaList.size();index++) {
                Vagas vaga=vagaList.get(i);
                if (vaga.getVagasPK().getIdEscola() == le.get(i).getIdEscola()) {
                    vagas.add(vaga);
                }
            }*/

                namesAdded = true;
                System.out.println("3");
            }
            if (namesAdded) {
                System.out.println("4");
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<escola>" + sb.toString() + "</escola>");
            } else {
                //nada para mostrar
                System.out.println("5");
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }
            //}
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
        protected void doGet
        (HttpServletRequest request, HttpServletResponse response)
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
        protected void doPost
        (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            processRequest(request, response);
        }

        /**
         * Returns a short description of the servlet.
         *
         * @return a String containing servlet description
         */
        @Override
        public String getServletInfo
        
            () {
        return "Short description";
        }// </editor-fold>

    }
