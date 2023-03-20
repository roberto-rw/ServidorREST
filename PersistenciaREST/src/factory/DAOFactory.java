package factory;

import conexion.MySQLConnection;
import dao.IPersonajesDAO;
import dao.PersonajesDAO;

public class DAOFactory {
    private static final MySQLConnection conexionBD = MySQLConnection.getInstance();

    public static IPersonajesDAO crearPersonajesDAO(){
        return new PersonajesDAO(conexionBD);
    }
}
