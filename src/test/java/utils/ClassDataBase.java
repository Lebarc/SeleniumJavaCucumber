package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClassDataBase {

    private static Connection getConnection() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            Connection con = DriverManager.getConnection(
                    "jdbc:oracle:thin:@faserv22.fundacred.local:1521/teste1", "sgcred", "paris");
            return con;
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println("Falha ao conectar o banco -> " + e);
            return null;
        }
    }
}
