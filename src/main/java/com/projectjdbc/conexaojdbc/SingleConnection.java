package com.projectjdbc.conexaojdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {

    private static String url = "";
    private static String password = "";
    private static String user = "";
    private static Connection connection = null;

    static {
        conectar();
    }

    public SingleConnection() {
        conectar();
    }

    private static void conectar() {
        Properties prop = new Properties();
        try {
            InputStream input = new FileInputStream("..\\db.properties");

            prop.load(input);
            url = prop.getProperty("db.url");
            user = prop.getProperty("db.username");
            password = prop.getProperty("db.password");

            if (connection == null) {
                connection = DriverManager.getConnection(url, user, password);
                connection.setAutoCommit(false);
                System.out.println("Conectou com sucesso");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection gConnection() {
        return connection;
    }

}
