package com.example.lab07_20196137.servlets;

import com.example.lab07_20196137.beans.Clientes;
import com.example.lab07_20196137.daos.DaoClientes;
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
