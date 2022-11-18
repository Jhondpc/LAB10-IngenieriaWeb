package com.example.lab10.Daos;

import com.example.lab10.beans.Clientes;

import java.sql.*;
import java.util.ArrayList;

public class DaoClientes extends DaoBase {

    public ArrayList<Clientes> listarClientes(){

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String sql = "select c.g4093_name as 'Cliente',\n" +
                    "\tc.g4093_age as 'Edad',\n" +
                    "    case when c.g4093_type='N' then 'Normal' when c.g4093_type='J' then 'Juridica' end as 'Tipo de Cliente',\n" +
                    "    c.g4093_documentType as 'Tipo de Documento',\n" +
                    "    c.g4093_nro_id as 'Nro de Documento'\n" +
                    "\tfrom jm_client_bii c;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Clientes clientes = new Clientes();
                clientes.setNombreCliente(rs.getString(1));
                clientes.setEdad(rs.getString(2));
                clientes.setTipoCliente(rs.getString(3));
                clientes.setTipoDocumento(rs.getString(4));
                clientes.setNumeroDocumento(rs.getString(5));
                listaClientes.add(clientes);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;

    }

    public ArrayList<Clientes> listarClientesComparacion(){

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String sql = "select * from jm_client_bii";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Clientes clientes = new Clientes();
                clientes.setNumeroDocumento(rs.getString(1));
                clientes.setNombreCliente(rs.getString(2));
                clientes.setEdad(rs.getString(3));
                clientes.setTipoCliente(rs.getString(4));
                clientes.setTipoDocumento(rs.getString(5));

                listaClientes.add(clientes);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;

    }

    public Clientes buscarCliente(String numeroDocumento) {

        Clientes cliente = null;
        try{
            Connection connection = getConnection();
            String sql = "SELECT * FROM jm_client_bii where g4093_nro_id= ?;";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,numeroDocumento);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    cliente = new Clientes();
                    cliente.setNumeroDocumento(rs.getString(1));
                    cliente.setNombreCliente(rs.getString(2));
                    cliente.setEdad(rs.getString(3));
                    cliente.setTipoCliente(rs.getString(4));
                    cliente.setTipoDocumento(rs.getString(5));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return cliente;
    }


}
