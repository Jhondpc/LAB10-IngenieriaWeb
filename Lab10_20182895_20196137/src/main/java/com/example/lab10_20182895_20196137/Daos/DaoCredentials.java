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

        String sql = "SELECT * FROM jobs WHERE job_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            //pstmt.setString(1, jobId);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    /*
                    job = new Job();
                    job.setJobId(rs.getString(1));
                    job.setJobTitle(rs.getString(2));
                    job.setMinSalary(rs.getInt(3));
                    job.setMaxSalary(rs.getInt(4));

                     */
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return credentials;
    }

}
