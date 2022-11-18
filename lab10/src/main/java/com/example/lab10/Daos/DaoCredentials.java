package com.example.lab10.Daos;

import com.example.lab10.beans.Credentials;

import java.sql.*;
import java.util.ArrayList;

public class DaoCredentials extends DaoBase{

    public ArrayList<Credentials> listarClientesRegistrados(){

        ArrayList<Credentials> listaCredentials = new ArrayList<>();
        try{
            Connection connection = getConnection();
            String sql = "select nro_documento,tipoUsuario from credentials";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while(rs.next()){
                Credentials credentials = new Credentials();
                credentials.setNumeroDocumento(rs.getString(1));
                credentials.setTipoUsuario(rs.getInt((2)));
                listaCredentials.add(credentials);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCredentials;

    }
    public Credentials buscarUsuario(String numeroDocumento, String password) {

        Credentials credentials = new Credentials();

        String sql = "SELECT * FROM bi_corp_business.credentials where nro_documento=? and hashedPassword = SHA2(?,256);";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeroDocumento);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String nroDocumento = rs.getString(1);
                    int tipoUsuario = rs.getInt(4);
                    credentials.setNumeroDocumento(nroDocumento);
                    credentials.setTipoUsuario(tipoUsuario);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return credentials;
    }

}
