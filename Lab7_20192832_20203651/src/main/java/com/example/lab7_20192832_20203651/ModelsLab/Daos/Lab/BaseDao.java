package com.example.lab7_20192832_20203651.ModelsLab.Daos.Lab;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BaseDao {

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/lab7?serverTimezone=America/Lima", "root", "root");
    }
}
