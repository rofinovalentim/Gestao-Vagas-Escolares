/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servelet;

import control.EstudanteJpaController;
import control.EstudanteaceiteJpaController;
import control.VagasJpaController;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import model.Estudante;
import model.Estudanteaceite;
import model.Vagas;

/**
 *
 * @author Rofino Chunga Jr
 */
@WebServlet(name = "Aceitar", urlPatterns = {"/Aceitar"})
public class Aceitar extends HttpServlet {

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
            Properties props = new Properties();

            int idEstudante = Integer.parseInt(request.getParameter("ide"));

            EntityManagerFactory emf = (EntityManagerFactory) request.getServletContext().getAttribute("emf");
            EstudanteJpaController estudanteController = new EstudanteJpaController(emf);

            Estudante estudante = estudanteController.findEstudante(idEstudante);
            String emailEstudante = estudante.getEmail();

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
                    return new PasswordAuthentication("rvalentim@unilurio.ac.mz", "rofinounilurio");
                }
            });

           
            session.setDebug(true);

            try {

                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("rvalentim@unilurio.ac.mz")); //Remetente

                Address[] toUser = InternetAddress //Destinatário(s)
                        .parse(emailEstudante);

                message.setRecipients(Message.RecipientType.TO, toUser);
                message.setSubject("Pre-Inscricao");//Assunto
                message.setText("A sua Pre-Inscricao Foi Aceite!");
                /**
                 * Método para enviar a mensagem criada
               */
                 
              // Transport.send(message);

                System.out.println("Feito!!!");

            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }

            List<Vagas> vagas = new VagasJpaController(emf).findVagasEntities();

            for (Vagas vaga : vagas) {
                if (vaga.getVagasPK().getIdEscola() == estudante.getVagas().getVagasPK().getIdEscola()
                        && vaga.getVagasPK().getClasse().equals(estudante.getVagas().getVagasPK().getClasse())) {
                    if (vaga.getNrVagas() > 0) {
                        int numeroDeVagas = vaga.getNrVagas();
                        vaga.setNrVagas(--numeroDeVagas);

                        try {
                            new VagasJpaController(emf).edit(vaga);
                        } catch (Exception ex) {

                        }

                    }
                }
            }

            try {

                Estudanteaceite estudanteAceite = new Estudanteaceite();
                estudanteAceite.setIdEstudante(estudante.getIdEstudante());
                estudanteAceite.setNomeEstudante(estudante.getNomeEstudante());
                estudanteAceite.setTelefone((long) estudante.getTelefone());
                estudanteAceite.setGenero(estudante.getIdGenero().getDescricao());
                estudanteAceite.setDataNascimento(estudante.getDataNascimento());
                estudanteAceite.setEmail(estudante.getEmail());
                estudanteAceite.setEscola(estudante.getVagas().getEscola().getNomeEscola());
                estudanteAceite.setClasse(estudante.getVagas().getVagasPK().getClasse());
                try {
                    new EstudanteaceiteJpaController(emf).create(estudanteAceite);
                } catch (Exception ex) {

                }

            } catch (Exception ex) {

            }
            try{
                new EstudanteJpaController(emf).destroy(estudante.getIdEstudante());
                  request.getRequestDispatcher("listaEstudantes.jsp").forward(request, response);
            }catch(Exception ex){
                
            }

            request.getRequestDispatcher("listaEstudantes.jsp").forward(request, response);
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
