package com.example.lab10.Daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoAdmin extends DaoBase{
    public void createCredentialCliente(String numeroDocumento, String password) {

        String sql = "INSERT INTO `bi_corp_business`.`credentials` (`nro_documento`, `password`, `hashedPassword`, `tipoUsuario`) VALUES (?, ?, SHA2(?,256), '2');";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, numeroDocumento);
            pstmt.setString(2, password);
            pstmt.setString(3, password);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
