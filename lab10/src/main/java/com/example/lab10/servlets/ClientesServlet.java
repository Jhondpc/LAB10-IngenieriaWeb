package com.example.lab10.servlets;

import com.example.lab10.Daos.DaoClientes;
import com.example.lab10.beans.Clientes;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClientesServlet", value = "/ClientesServlet")
public class ClientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DaoClientes daoClientes = new DaoClientes();
        ArrayList<Clientes> listaClientes = daoClientes.listarClientes();

        request.setAttribute("lista", listaClientes);

        RequestDispatcher view = request.getRequestDispatcher("listaClientes.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
