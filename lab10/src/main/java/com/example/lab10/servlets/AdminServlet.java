package com.example.lab10.servlets;

import com.example.lab10.Daos.DaoAdmin;
import com.example.lab10.Daos.DaoClientes;
import com.example.lab10.Daos.DaoCredentials;
import com.example.lab10.beans.Clientes;
import com.example.lab10.beans.Credentials;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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

                ArrayList<Clientes> listaClientes=daoClientes.listarClientesComparacion();
                ArrayList<Credentials> listaCredentials=daoCredentials.listarClientesRegistrados();


                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("listaCredentials", listaCredentials);

                requestDispatcher = request.getRequestDispatcher("adminInicio.jsp");
                requestDispatcher.forward(request, response);

                break;

            case "crear":

                requestDispatcher = request.getRequestDispatcher("adminInicio.jsp");
                requestDispatcher.forward(request, response);

                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        DaoAdmin daoAdmin = new DaoAdmin();
        DaoClientes daoClientes = new DaoClientes();
        DaoCredentials daoCredentials=new DaoCredentials();
        Clientes clientes = new Clientes();
        String dni;
        Clientes client;

        RequestDispatcher requestDispatcher;

        switch (action) {
            case "guardar":
                dni=request.getParameter("DNI");
                client=daoClientes.buscarCliente(dni);

                daoCredentials.guardarCliente(client);
                response.sendRedirect(request.getContextPath()+"/AdminServlet");
                break;


        }
    }
}
