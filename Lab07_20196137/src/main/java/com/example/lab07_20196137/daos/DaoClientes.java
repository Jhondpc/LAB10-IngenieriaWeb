package com.example.lab07_20196137.daos;

import com.example.lab07_20196137.beans.Clientes;

import java.sql.*;
import java.util.ArrayList;

public class DaoClientes {

    public ArrayList<Clientes> listarClientes(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/bi_corp_business";
        ArrayList<Clientes> listaClientes = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(url,"root","root");
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
                clientes.setCantidadDeContratos(rs.getInt(6));
                listaClientes.add(clientes);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaClientes;

    }
}
