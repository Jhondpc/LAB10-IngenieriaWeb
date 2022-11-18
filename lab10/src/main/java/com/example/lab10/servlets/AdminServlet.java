package com.example.lab10.servlets;

import com.example.lab10.Daos.DaoClientes;
import com.example.lab10.Daos.DaoCredentials;
import com.example.lab10.beans.Clientes;
import com.example.lab10.beans.Credentials;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "AdminServlet", value = "/AdminServlet")
public class AdminServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (action == null) ? "listar" : action;

        DaoCredentials daoCredentials = new DaoCredentials();
        DaoClientes daoClientes = new DaoClientes();
        RequestDispatcher requestDispatcher;
        Clientes clientes=new Clientes();
        Credentials credentials=new Credentials();
        String idClientes;

        switch (action) {
            case "listar":

                ArrayList<Clientes> listaClientes=daoClientes.listarClientes();
                ArrayList<Credentials> listaCredentials=daoCredentials.listarClientesRegistrados();


                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("listaCredentials", listaCredentials);

                requestDispatcher = request.getRequestDispatcher("adminInicio.jsp");
                requestDispatcher.forward(request, response);

                break;


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
