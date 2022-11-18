package com.example.lab10.servlets;

import com.example.lab10.Daos.DaoContratos;
import com.example.lab10.beans.Contratos;
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
