package negocio;

import entidadesrest.Personaje;
import excepciones.NoDataFoundException;
import excepciones.ValidateServiceException;
import fachada.IPersistencia;
import fachada.Persistencia;

import java.util.List;

public class PersonajesBO implements IPersonajesBO{
    private IPersistencia persistencia;

    public PersonajesBO(){
        persistencia = new Persistencia();
    }
    @Override
    public void agregarPersonaje(Personaje personaje){
        if(personaje.getNombre() == "" || personaje.getSerie() == "" ) throw new ValidateServiceException("Datos vacíos");
        persistencia.agregarPersonaje(personaje);
    }

    @Override
    public void actualizarPersonaje(Personaje personaje) {
        Personaje p = consultarPorId(personaje.getId());
        if(p == null) throw new NoDataFoundException("El personaje a actualizar no existe.");
        if(personaje.getNombre() == "" || personaje.getSerie() == "" ) throw new ValidateServiceException("Datos vacíos");
        p.setNombre(personaje.getNombre());
        p.setSerie(personaje.getSerie());
        persistencia.actualizarPersonaje(p);
    }

    @Override
    public void eliminarPersonaje(Personaje personaje) {
        Personaje p = consultarPorId(personaje.getId());
        if(p == null) throw new NoDataFoundException("El personaje a eliminar no existe.");
        persistencia.eliminarPersonaje(p);
    }

    @Override
    public Personaje consultarPorId(Long id) {
        Personaje p = persistencia.consultarPorId(id);
        if(p == null) throw new NoDataFoundException("El personaje a consultar no existe");
        return p;
    }

    @Override
    public List<Personaje> consultarPorNombre(String nombre) {
        return persistencia.consultarPorNombre(nombre);
    }

    @Override
    public List<Personaje> consultarPorSerie(String serie) {
        return persistencia.consultarPorSerie(serie);
    }

    @Override
    public List<Personaje> consultarTodos() {
        return persistencia.consultarTodos();
    }
}
