<%@ page import="com.example.lab07_20196137.beans.Clientes" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" type="java.util.ArrayList<com.example.lab07_20196137.beans.Clientes>" scope="request" />
<html>
    <head>
        <title>Clientes</title>
    </head>
    <body>
        <h1>Lista de Clientes</h1>

        <table>
            <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Edad</th>
                    <th>Tipo de Cliente</th>
                    <th>Tipo de documento</th>
                    <th>Numero de documento</th>
                    <th>Cantidad de contratos</th>
                </tr>
            </thead>
            <tbody>

                    <%
                        for (Clientes clientes : lista) {
                    %>
                <tr>
                    <td><%=clientes.getNombreCliente()%></td>
                    <td><%=clientes.getEdad()%></td>
                    <td><%=clientes.getTipoCliente()%></td>
                    <td><%=clientes.getTipoDocumento()%></td>
                    <td><%=clientes.getNumeroDocumento()%></td>
                    <td><%=clientes.getCantidadDeContratos()%></td>
                </tr>
                    <%
                    }
                    %>

        </table>
    </body>
</html>
