package com.example.lab10_20182895_20196137.Daos;

import com.example.lab10_20182895_20196137.beans.Clientes;
import com.example.lab10_20182895_20196137.beans.Credentials;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoCredentials extends DaoBase{

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
                    int tipoUsuario = rs.getInt(2);
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
