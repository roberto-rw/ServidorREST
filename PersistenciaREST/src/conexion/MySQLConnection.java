
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    // Los detalles de conexión a la base de datos
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/entidades_rest";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "1234";

    // Singleton
    private static MySQLConnection instance = null;

    private Connection connection;


    // Constructor privado para evitar que se cree un objeto de esta clase desde fuera
    private MySQLConnection() {
        try {
            
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    // Método público para obtener la instancia única de la clase
    public static MySQLConnection getInstance() {
        if (instance == null) {
            instance = new MySQLConnection();
        }
        return instance;
    }

    // Método para obtener la conexión a la base de datos
    public Connection getConnection() {
        return connection;
    }

    // Método para cerrar la conexión a la base de datos
    public void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
