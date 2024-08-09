import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.log4j.Logger;

public class BD {
    private static final Logger logger = Logger.getLogger(BD.class);

    // SQL para eliminar la tabla si existe y crear una nueva
    private static final String DROP_CREATE = "DROP TABLE IF EXISTS ODONTOLOGO; " +
            "CREATE TABLE ODONTOLOGO (" +
            "ID INTEGER PRIMARY KEY AUTO_INCREMENT, " +
            "MATRICULA INTEGER, " +
            "NOMBRE VARCHAR(255), " +
            "APELLIDO VARCHAR(255))";

    // Método para crear la tabla
    public static void creaTabla() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = getConnection();
            statement = connection.createStatement();
            statement.execute(DROP_CREATE);
            logger.info("Tabla ODONTOLOGO creada correctamente.");
        } catch (Exception e) {
            logger.error("Error al crear la tabla ODONTOLOGO", e);
        } finally {
            // Cerrar el Statement y la conexión si están abiertas
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    logger.error("Error al cerrar el Statement", e);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    logger.error("Error al cerrar la conexión", e);
                }
            }
        }
    }

    // Método para obtener la conexión a la base de datos
    private static Connection getConnection() throws Exception {
        // Cargar el driver de H2
        Class.forName("org.h2.Driver");
        // Obtener la conexión a la base de datos H2
        return DriverManager.getConnection("jdbc:h2:~/test", "sa", "sa");
    }
}