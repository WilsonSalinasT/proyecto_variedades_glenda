package Paneles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {
    private Connection con;

    private ConexionSQLServer(Connection con) {
        this.con = con;
    }

   public static Connection getConexion(String ip, String puerto, String dbName, String user, String password) {
    String url = "jdbc:sqlserver://" + ip + ":" + puerto + ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";

    try {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Conexión exitosa a la base de datos SQL Server");
        return con; // Devolver la conexión directamente
    } catch (ClassNotFoundException | SQLException e) {
        e.printStackTrace();
        return null;
    }
}

    public Connection getConnection() {
        return con;
    }

    public void cerrarConexion() {
        try {
            if (con != null) {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}