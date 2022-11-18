package com.example.lab10_20182895_20196137.servlets;

import com.example.lab10_20182895_20196137.Daos.DaoClientes;
import com.example.lab10_20182895_20196137.Daos.DaoCredentials;
import com.example.lab10_20182895_20196137.beans.Clientes;
import com.example.lab10_20182895_20196137.beans.Credentials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DaoCredentials daoCredentials = new DaoCredentials();
        DaoClientes daoClientes = new DaoClientes();

        String nroDocumento = request.getParameter("nroDocumento");
        String password = request.getParameter("password");

        Credentials credentials = daoCredentials.buscarUsuario(nroDocumento, password);
        Clientes usuarioRegistrado = daoClientes.buscarCliente(credentials.getNumeroDocumento());

        if(credentials != null){
            if(credentials.getTipoUsuario()==2){
                HttpSession sessionClienteReg = request.getSession();
                sessionClienteReg.setAttribute("clienteRegistrado", usuarioRegistrado);
                response.sendRedirect(request.getContextPath() + "/vistaCliente.jsp");
            }else{
                HttpSession sessionAdmin = request.getSession();
                sessionAdmin.setAttribute("admin", usuarioRegistrado);
                response.sendRedirect(request.getContextPath() + "/adminInicio.jsp");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
        }
    }
}
