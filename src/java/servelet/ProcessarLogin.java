/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import static com.sun.corba.se.spi.presentation.rmi.StubAdapter.request;
import control.UserJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
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
@WebServlet(name = "ProcessarLogin", urlPatterns = {"/ProcessarLogin"})
public class ProcessarLogin extends HttpServlet {

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
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            if (username != null && !username.equals("")) {
                EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
                UserJpaController userController = new UserJpaController(emf);
                User user = userController.findUser(username);
                if (user != null && user.getPassword().equals(password)) {
                    request.getSession().setAttribute("user", user);
                    List<Role> roleList = user.getIdTipo().getRoleList();
                    request.getSession().setAttribute("permissoes", user.getIdTipo().getRoleList());
                    // System.out.println(request.getSession().getAttribute("recurso").toString());
                    // response.sendRedirect(request.getSession().getAttribute("url").toString());
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                } else {
                    request.setAttribute("verificar", 1);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
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
