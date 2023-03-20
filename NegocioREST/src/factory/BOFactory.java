package factory;

import negocio.IPersonajesBO;
import negocio.PersonajesBO;

public class BOFactory {

    public static IPersonajesBO crearPersonajesBO(){
        return new PersonajesBO();
    }
}
