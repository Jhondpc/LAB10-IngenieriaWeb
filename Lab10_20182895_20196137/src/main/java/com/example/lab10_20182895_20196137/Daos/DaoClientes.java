package com.example.lab10_20182895_20196137.Daos;

import com.example.lab10_20182895_20196137.beans.Clientes;

import java.sql.*;
import java.util.ArrayList;

public class DaoClientes extends DaoBase {

    /*public ArrayList<Clientes> listarClientes(){

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String sql = "select concat(c.g4093_name, ' ' , coalesce( c.g4093_last_name ,'')) as 'Cliente',\n" +
                    "\t\tc.g4093_age as 'Edad',\n" +
                    "\t\tcase when c.g4093_type='N' then 'Normal' when c.g4093_type='J' then 'Juridica' end as 'Tipo de Cliente',\n" +
                    "        c.g4093_documentType as 'Tipo de Documento',\n" +
                    "        c.g4093_nro_id as 'Numero de Documento',\n" +
                    "        count(g4093_nro_id) as 'Cantidad de Contratos'\n" +
                    "from jm_client_bii c inner join jm_cotr_bis p on (c.g4093_nro_id = p.client_nro_id)\n" +
                    "group by g4093_nro_id;";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Clientes clientes = new Clientes();
                clientes.setNombreCliente(rs.getString(1));
                clientes.setEdad(rs.getString((2)));
                clientes.setTipoCliente(rs.getString(3));
                clientes.setTipoDocumento(rs.getString(4));
                clientes.setNumeroDocumento(rs.getString(5));
                listaClientes.add(clientes);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;

    }*/

    public ArrayList<Clientes> listarClientesRegistrados(){

        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String sql = "select nro_documento from bi_corp_business.jm_client_bii";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Clientes clientes = new Clientes();
                clientes.setNumeroDocumento(rs.getString(1));
                clientes.setNombreCliente(rs.getString((2)));
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





}
