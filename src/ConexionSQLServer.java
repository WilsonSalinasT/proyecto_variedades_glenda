import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionSQLServer {
    private Connection connection;

    public ConexionSQLServer() {
        String ip = "localhost"; // Cambiado a localhost
        int port = 1433; // Cambiado a 1433
        String dbName = "GlendaDB"; // Cambiado a GlendaDB
        String user = "sa"; // Cambiado a sa
        String password = "123456789"; // Cambiado a 123456789

        String url = "jdbc:sqlserver://" + ip + ":" + port + ";databaseName=" + dbName;

        try {
            // Cargar el controlador JDBC
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establecer la conexión
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos SQL Server");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void cerrarConexion() {
        try {
            if (connection != null) {
                connection.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejo de excepciones
        }
    }

    public static void main(String[] args) {
        ConexionSQLServer conexion = new ConexionSQLServer();
        // Puedes utilizar la conexión en tu aplicación
        Connection conn = conexion.getConnection();

        // Cuando hayas terminado, asegúrate de cerrar la conexión
        conexion.cerrarConexion();
    }
}
