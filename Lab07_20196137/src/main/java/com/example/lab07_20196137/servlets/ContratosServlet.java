package com.example.lab07_20196137.servlets;

import com.example.lab07_20196137.beans.Clientes;
import com.example.lab07_20196137.beans.Contratos;
import com.example.lab07_20196137.daos.DaoClientes;
import com.example.lab07_20196137.daos.DaoContratos;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ContratosServlet", value = "/ContratosServlet")
public class ContratosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoContratos daoContratos = new DaoContratos();
        ArrayList<Contratos> listaContratos = daoContratos.listarContratos();

        request.setAttribute("lista", listaContratos);

        RequestDispatcher view = request.getRequestDispatcher("listaContratos.jsp");
        view.forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
