package com.example.lab10.servlets;

import com.example.lab10.Daos.DaoClientes;
import com.example.lab10.Daos.DaoContratos;
import com.example.lab10.Daos.DaoCredentials;
import com.example.lab10.beans.Clientes;
import com.example.lab10.beans.Contratos;
import com.example.lab10.beans.Credentials;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ClientesServlet", value = "/ClientesServlet")
public class ClientesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        action = (action == null) ? "perfil" : action;

        DaoCredentials daoCredentials = new DaoCredentials();
        DaoContratos daoContratos=new DaoContratos();
        DaoClientes daoClientes = new DaoClientes();
        RequestDispatcher requestDispatcher;
        Clientes clientes=new Clientes();
        Credentials credentials=new Credentials();
        String idClientes;

        switch (action) {
            case "lost":

                ArrayList<Contratos> expectedLoss=daoContratos.listarContratos();
                request.setAttribute("listaContratos", expectedLoss);

                requestDispatcher = request.getRequestDispatcher("expectedLoss.jsp");
                requestDispatcher.forward(request, response);

                break;

            case "perfil":

                Clientes perfil=daoClientes.buscarCliente("09634122");
                request.setAttribute("perfil", perfil);

                requestDispatcher = request.getRequestDispatcher("misDatos.jsp");
                requestDispatcher.forward(request,response);
                break;


        }
        ArrayList<Clientes> listaClientes = daoClientes.listarClientes();

        request.setAttribute("lista", listaClientes);

        RequestDispatcher view = request.getRequestDispatcher("listaContratos.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
