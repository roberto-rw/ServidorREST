
package converter;

import entidadesrest.Personaje;
import java.util.List;

public class Converter {
    
    public static Personaje[] convertirToArray(List<Personaje> personajes){
        Personaje[] arrayPersonajes = new Personaje[personajes.size()];
        arrayPersonajes = personajes.toArray(new Personaje[0]);
        return arrayPersonajes;
    }
    
}
