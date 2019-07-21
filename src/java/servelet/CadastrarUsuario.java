/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.EstudanteJpaController;
import control.RoleJpaController;
import control.TipoUsuarioJpaController;
import control.UserJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Role;
import model.TipoUsuario;
import model.User;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "CadastrarUsuario", urlPatterns = {"/CadastrarUsuario"})
public class CadastrarUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private String msg = "0";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter()) {

            if (request.getParameter("username") != null) {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                String idUsuario = "";

                User user = new User();

                UserJpaController userController = new UserJpaController(emf);
                if (userController.findUser(request.getParameter("username")) != null) {
                    user = userController.findUser(request.getParameter("username"));
                }
                user.setUserName(request.getParameter("username"));
                user.setPassword(request.getParameter("senha"));
                user.setEmail(request.getParameter("email"));

                TipoUsuarioJpaController tuc = new TipoUsuarioJpaController(emf);
                TipoUsuario tipoUsuario = null;
                if (request.getParameter("tipo").equals("Administrador")) {
                    tipoUsuario = tuc.findTipoUsuario(2);
                    tipoUsuario.setDescricao("Administrador");
                } else {
                    tipoUsuario = tuc.findTipoUsuario(1);
                    tipoUsuario.setDescricao("Super Administrador");
                }
                user.setIdTipo(tipoUsuario);

                if (userController.findUser(request.getParameter("username")) == null) {

                    try {
                        // request.setAttribute("verificar", 1);
                        userController.create(user);
                    } catch (Exception ex) {
                        Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    try {
                        // request.setAttribute("verificar", 2);
                        userController.edit(user);
                    } catch (Exception ex) {
                        Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                msg = user.getUserName() + "|" + user.getPassword() + "|" + user.getEmail() + "|" + user.getIdTipo().getDescricao();
                request.setAttribute("verificar", 1);
                request.getRequestDispatcher("listaUsuario.jsp").forward(request, response);
            } else {
                response.setContentType("text/event-stream");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write("data: " + msg + "\n\n");
                response.getWriter().flush();
                response.getWriter().close();
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
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(CadastrarUsuario.class.getName()).log(Level.SEVERE, null, ex);
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
    }// </editor-fold
}
