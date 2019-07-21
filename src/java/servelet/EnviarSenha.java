/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.UserJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "EnviarSenha", urlPatterns = {"/EnviarSenha"})
public class EnviarSenha extends HttpServlet {

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

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        User user = null;

        EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
        UserJpaController userController = new UserJpaController(emf);

        user = userController.findUser(username);

        if (user != null && user.getEmail().equals(email)) {

            Properties props = new Properties();

            /**
             * Parâmetros de conexão com servidor Gmail
             */
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");

            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication("rvalentim@unilurio.ac.mz", "senha");
                }
            });

            /**
             * Ativa Debug para sessão
             */
            session.setDebug(true);

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("rvalentim@unilurio.ac.mz")); //Remetente

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(email);

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Envio Da Senha");//Assunto
                message.setText("Username: "+user.getUserName()+"\nPassword: "+user.getPassword());

                /**
                 * Método para enviar a mensagem criada
                 */
                Transport.send(message);

                System.out.println("Feito!!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }
            request.getRequestDispatcher("enviado.jsp").forward(request, response);

        }

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EnviarSenha</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Nome do usuario ou email invalido, tente novamente </h1>");
            out.println("</body>");
            out.println("</html>");
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
