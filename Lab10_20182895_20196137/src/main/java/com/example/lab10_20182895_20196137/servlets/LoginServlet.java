package com.example.lab10_20182895_20196137.servlets;

import com.example.lab10_20182895_20196137.Daos.DaoClientes;
import com.example.lab10_20182895_20196137.Daos.DaoCredentials;
import com.example.lab10_20182895_20196137.beans.Clientes;
import com.example.lab10_20182895_20196137.beans.Credentials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String action = request.getParameter("action");
        action = (action == null) ? "loginform" : action;

        DaoCredentials daoCredentials = new DaoCredentials();
        DaoClientes daoClientes = new DaoClientes();
        RequestDispatcher view;
        Clientes clientes=new Clientes();
        Credentials credentials=new Credentials();
        String idClientes;

        switch (action) {
            case "loginform":
                view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);
                break;
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoCredentials daoCredentials = new DaoCredentials();

        String nroDocumento = request.getParameter("nroDocumento");
        String password = request.getParameter("password");

        Credentials credentials = daoCredentials.buscarUsuario(nroDocumento, password);

        if(credentials != null){
            if(credentials.getTipoUsuario()==1){

            }else{

            }

        }else{
            response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
        }
    }
}
