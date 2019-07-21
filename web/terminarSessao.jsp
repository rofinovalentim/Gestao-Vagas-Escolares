<%-- 
    Document   : terminarSessao
    Created on : Oct 11, 2018, 9:28:51 PM
    Author     : Rofino Chunga Jr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Terminar Seccao</title>
    </head>
    <body>
         <%session.removeAttribute("user");
            session.removeAttribute("recurso");
            session.removeAttribute("url");
            session.removeAttribute("permissoes");
            session.invalidate();

            response.sendRedirect(request.getContextPath() + "/index.jsp");
        %>
    </body>
</html>
