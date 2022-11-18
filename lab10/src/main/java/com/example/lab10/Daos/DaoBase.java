package com.example.lab10.Daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class DaoBase {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }

        String URL = "jdbc:mysql://localhost:3306/";
        String USER = "root";
        String PASS = "root";
        String DB = "bi_corp_business";

        return DriverManager.getConnection(URL + DB, USER, PASS);
    }
}
