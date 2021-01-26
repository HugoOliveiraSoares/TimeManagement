package com.hugooliveirasoares.timemanagement.dao;

import java.sql.*;

public class ConnectionFactory {
    private static final String DRIVER = "org.h2.Driver";
    private static final String URL = "jdbc:h2:mem:testdb";
    private static final String USER = "sa";
    private static final String PASS = "password";

    public static Connection getConnection(){

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException("Erro na conexão: ", e);
        }
    }

    public static void closeConnection(Connection con){

        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt){

        closeConnection(con);

        try {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs){

        closeConnection(con, stmt);

        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
