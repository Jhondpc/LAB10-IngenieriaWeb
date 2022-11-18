package com.example.lab10.Daos;

import com.example.lab10.Dtos.DtoCantidadContratos;
import com.example.lab10.Dtos.DtoMaxExpectedLoss;
import com.example.lab10.beans.Contratos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DaoContratos extends DaoBase{

    public ArrayList<Contratos> listarContratos(){

        ArrayList<Contratos> listaContratos = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String sql = "select c.g4093_nro_id as 'idCliente',\n" +
                    "\t\tc.g4093_name as 'Cliente',\n" +
                    "\t\tp.g6789_contract as 'Numero de Contrato',\n" +
                    "\t\tcase when p.G6789_status='0' then 'Normal' when p.G6789_status='1' then 'Cura' when p.G6789_status='2' then 'Mora'end as 'Estado del contrato',\n" +
                    "\t\tp.g6789_months as 'Meses en ese estado',\n" +
                    "\t\tp.g6789_currency as 'Divisa',\n" +
                    "\t\t(v.lgd_value*v.pd_value*(1-recovery_rate)) as 'Expect Loss'\n" +
                    "\t\tfrom jm_client_bii c \n" +
                    "\t\tleft join jm_cotr_bis p on (c.g4093_nro_id = p.client_nro_id) \n" +
                    "\t\tleft join jm_values v on (v.jm_cotr_bis_g6789_cod_nup = p.g6789_contract);";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Contratos contratos = new Contratos();
                contratos.setIdCliente(rs.getString(1));
                contratos.setNroDeContrato(rs.getString(3));
                contratos.setEstadoDelContrato(rs.getInt(4));
                contratos.setMesesEnEseEstado(rs.getInt(5));
                contratos.setDivisa(rs.getString(6));
                listaContratos.add(contratos);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaContratos;
    }

    public ArrayList<DtoCantidadContratos> mostrarCantidadContratos() {

        ArrayList<DtoCantidadContratos> lista = new ArrayList<>();

        String sql = "select case when p.G6789_status='0' then 'Normal' when p.G6789_status='1' then 'Cura' when p.G6789_status='2' then 'Mora'end as 'Estado del contrato',\n" +
                "\tcount(G6789_status) as 'Numero de Contratos' from jm_cotr_bis p\n" +
                "    group by G6789_status";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()){
                DtoCantidadContratos c = new DtoCantidadContratos();
                c.setEstadoContrato(rs.getString(1));
                c.setNumeroContratos(rs.getInt(2));
                lista.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }

    public ArrayList<DtoMaxExpectedLoss> mostrarMaxExpectedLoss() {

        ArrayList<DtoMaxExpectedLoss> lista = new ArrayList<>();

        String sql = "select c.g4093_name as 'Cliente', max(lgd_value*pd_value*(1-recovery_rate)) as 'ExpectedLoss maximo'\n" +
                "\tfrom jm_client_bii c\n" +
                "    left join jm_cotr_bis ct on (ct.client_nro_id = c.g4093_nro_id)\n" +
                "    left join jm_values v on (v.jm_cotr_bis_g6789_cod_nup = ct.g6789_contract)\n" +
                "    group by c.g4093_nro_id";
        try (Connection conn = this.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while(rs.next()){
                DtoMaxExpectedLoss maxExpectedLoss = new DtoMaxExpectedLoss();
                maxExpectedLoss.setNombreCliente(rs.getString(1));
                maxExpectedLoss.setMaxExpectedLoss(rs.getFloat(2));
                lista.add(maxExpectedLoss);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}

