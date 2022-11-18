package com.example.lab10_20182895_20196137.servlets;

import com.example.lab10_20182895_20196137.Daos.DaoClientes;
import com.example.lab10_20182895_20196137.Daos.DaoCredentials;
import com.example.lab10_20182895_20196137.beans.Clientes;
import com.example.lab10_20182895_20196137.beans.Credentials;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


                request.setAttribute("listaClientes", daoClientes.listarClientes());
                request.setAttribute("listaCredentials", daoCredentials.listarClientesRegistrados());

                requestDispatcher = request.getRequestDispatcher("AdminListaUsers.jsp");
                requestDispatcher.forward(request, response);

                break;


        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
