/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filtro;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Role;
import model.User;

/**
 *
 * @author Rofino Chunga Jr
 */
public class FiltroDeAutenticacao implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {

    }

    public void destroy() {

    }

    public FiltroDeAutenticacao() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

        HttpSession session = ((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            System.out.println(((HttpServletRequest) request).getRequestURL());
            session.setAttribute("url", ((HttpServletRequest) request).getRequestURL());
            session.setAttribute("recurso", ((HttpServletRequest) request).getServletPath());
            ((HttpServletRequest) request).getRequestDispatcher("/login.jsp").forward(request, response);
        } else {

            boolean perm = false;
            if (user != null) {
                System.out.println(user.getUserName());
            }
            String recurso = ((HttpServletRequest) request).getServletPath();
            List<Role> rol = (List<Role>) session.getAttribute("permissoes");

            System.out.println(rol.size() + "");
            for (int i = 0; i < rol.size(); i++) {
                System.out.println(recurso + " " + rol.get(i).getRecurso());
                if (rol.get(i).getRecurso().equals(recurso)) {
                    perm = true;
                    chain.doFilter(request, response);
                }
            }
            
            if (!perm) {
                ((HttpServletResponse) response).sendRedirect(((HttpServletRequest) request).getContextPath() + "/AcessoNegado.jsp");
            }
        }

    }
}
