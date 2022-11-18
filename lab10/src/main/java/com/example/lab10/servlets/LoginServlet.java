package com.example.lab10.servlets;

import com.example.lab10.Daos.DaoClientes;
import com.example.lab10.Daos.DaoCredentials;
import com.example.lab10.beans.Clientes;
import com.example.lab10.beans.Credentials;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

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
                response.sendRedirect(request.getContextPath() + "/misDatos.jsp");
            }else if (credentials.getTipoUsuario()==1){
                HttpSession sessionAdmin = request.getSession();
                sessionAdmin.setAttribute("admin", usuarioRegistrado);
                ArrayList<Clientes> listaClientes = daoClientes.listarClientes();
                ArrayList<Credentials> listaCredentials=daoCredentials.listarClientesRegistrados();


                request.setAttribute("listaClientes", listaClientes);
                request.setAttribute("listaCredentials", listaCredentials);
                response.sendRedirect(request.getContextPath() + "/adminInicio.jsp");
            }
        }else{
            response.sendRedirect(request.getContextPath() + "/LoginServlet?error");
        }
    }
}
