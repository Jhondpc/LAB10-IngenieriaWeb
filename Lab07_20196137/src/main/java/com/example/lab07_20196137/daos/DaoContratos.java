package com.example.lab07_20196137.daos;

import com.example.lab07_20196137.beans.Clientes;
import com.example.lab07_20196137.beans.Contratos;

import java.sql.*;
import java.util.ArrayList;

public class DaoContratos {

    public ArrayList<Contratos> listarContratos(){

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        String url = "jdbc:mysql://localhost:3306/bi_corp_business";
        ArrayList<Contratos> listaContratos = new ArrayList<>();
        try{
            Connection connection = DriverManager.getConnection(url,"root","root");
            String sql = "select concat(c.g4093_name, ' ' , coalesce( c.g4093_last_name ,'')) as 'Cliente',\n" +
                    "\t\tp.g6789_contract as 'Numero de Contrato',\n" +
                    "        case when p.G6789_status='0' then 'Normal' when p.G6789_status='1' then 'Cura' when p.G6789_status='2' then 'Mora'end as 'Estado del contrato',\n" +
                    "        case when p.G6789_status='0' then p.g6789_months_normal when p.G6789_status='1' then p.g6789_moths_default\n" +
                    "        when p.G6789_status='2' then p.g6789_months_late end as 'Meses en ese estado',\n" +
                    "        p.g6789_currency as 'Divisa',\n" +
                    "        (v.lgd_value*v.pd_value*recovery_rate) as 'Expect Loss'\n" +
                    "from jm_client_bii c inner join jm_cotr_bis p on (c.g4093_nro_id = p.client_nro_id) inner join jm_values v on (v.jm_cotr_bis_g6789_cod_nup = p.g6789_cod_nup);";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Contratos contratos = new Contratos();
                contratos.setNombreCliente(rs.getString(1));
                contratos.setNroDeContrato(rs.getString((2)));
                contratos.setEstadoDelContrato(rs.getString(3));
                contratos.setMesesEnEseEstado(rs.getInt(4));
                contratos.setDivisa(rs.getString(5));
                contratos.setExpectedLoss(rs.getInt(6));
                listaContratos.add(contratos);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaContratos;

    }
}
