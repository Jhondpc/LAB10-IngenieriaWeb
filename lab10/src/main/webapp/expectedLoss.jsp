<%@ page import="com.example.lab10.beans.Contratos" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: willi
  Date: 17/11/2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  ArrayList<Contratos> listaContratos = (ArrayList<Contratos>) request.getAttribute("listaContratos");
%>
<html>

  <head>
    <title>Title</title>
  </head>
  <body>
    <table class="table table-striped table-hover">
      <thead>
        <tr style="align-content: center">
          <th>N°</th>
          <th>Código</th>
          <th>Nombres</th>
          <th>Apellidos</th>
          <th scope="col">Correo</th>
          <th scope="col">DNI</th>
          <th scope="col">Rol</th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <%
          for (Clientes clientes : lista) {
        %>
        <tr>

          <td><%=usuarios.getCodigoPucp()%>
          </td>
          <td><%=usuarios.getNombres()%>
          </td>
          <td><%=usuarios.getApellidos()%>
          </td>
          <td><%=usuarios.getCorreoPucp()%>
          </td>
          <td><%=usuarios.getDni()%>
          </td>
          <td><%=usuarios.getRol()%>
          </td>
          <td>

            <a type="button" class="btn btn-primary"
               href="<%=request.getContextPath()%>/AdminServlet?action=editar&id=<%=usuarios.getIdUsuarios()%>">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                   class="bi bi-pencil" viewBox="0 0 16 16">
                <path d="M12.146.146a.5.5 0 0 1 .708 0l3 3a.5.5 0 0 1 0 .708l-10 10a.5.5 0 0 1-.168.11l-5 2a.5.5 0 0 1-.65-.65l2-5a.5.5 0 0 1 .11-.168l10-10zM11.207 2.5 13.5 4.793 14.793 3.5 12.5 1.207 11.207 2.5zm1.586 3L10.5 3.207 4 9.707V10h.5a.5.5 0 0 1 .5.5v.5h.5a.5.5 0 0 1 .5.5v.5h.293l6.5-6.5zm-9.761 5.175-.106.106-1.528 3.821 3.821-1.528.106-.106A.5.5 0 0 1 5 12.5V12h-.5a.5.5 0 0 1-.5-.5V11h-.5a.5.5 0 0 1-.468-.325z"></path>
              </svg>
            </a>
          </td>
          <td>
            <a type="button" class="btn btn-danger"
               onclick="return confirm('¿Estas seguro(a) que deseas borrar?')"
               href="<%=request.getContextPath()%>/AdminServlet?action=borrar&id=<%=usuarios.getIdUsuarios()%>">
              <i class="bi bi-trash"></i></a>

          </td>
        </tr>
        <%
          }
        %>

      </tbody>
    </table>
  </body>
</html>
