package br.com.fiap.capitalquest.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static ConnectionFactory conn;

    private ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() {
        if (conn == null) {
            conn = new ConnectionFactory();
        }
        return conn;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

            conn = DriverManager.getConnection(
                    "jdbc:oracle:thin:@oracle.fiap.com.br:1521:orcl",
                    "USUARIO",
                    "SENHA");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

}