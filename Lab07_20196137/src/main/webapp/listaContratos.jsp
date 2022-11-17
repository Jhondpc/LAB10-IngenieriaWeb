<%@ page import="com.example.lab07_20196137.beans.Contratos" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="lista" type="java.util.ArrayList<com.example.lab07_20196137.beans.Contratos>" scope="request" />
<html>
    <head>
        <title>Contratos</title>
    </head>
    <body>
        <h1>Lista de Contratos</h1>
        <table>
            <thead>
                <tr>
                    <th>Cliente</th>
                    <th>Nro de Contrato</th>
                    <th>Estado del contrato</th>
                    <th>Meses en ese estado</th>
                    <th>Divisa</th>
                    <th>Expected Loss</th>
                </tr>
            </thead>
            <tbody>

                    <%
                    for (Contratos contratos : lista) {
                %>
                <tr>
                    <td><%=contratos.getNombreCliente()%></td>
                    <td><%=contratos.getNroDeContrato()%></td>
                    <td><%=contratos.getEstadoDelContrato()%></td>
                    <td><%=contratos.getMesesEnEseEstado()%></td>
                    <td><%=contratos.getDivisa()%></td>
                    <td><%=contratos.getExpectedLoss()%></td>
                </tr>
                    <%
                }
                %>

        </table>



    </body>
</html>
