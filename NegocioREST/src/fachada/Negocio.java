package fachada;

import entidadesrest.Personaje;
import factory.BOFactory;
import negocio.IPersonajesBO;

import java.util.List;

public class Negocio implements INegocio{
    private IPersonajesBO personajesBO;

    public Negocio(){
        personajesBO = BOFactory.crearPersonajesBO();
    }

    @Override
    public void agregarPersonaje(Personaje personaje){
        personajesBO.agregarPersonaje(personaje);
    }

    @Override
    public void actualizarPersonaje(Personaje personaje) {
        personajesBO.actualizarPersonaje(personaje);
    }

    @Override
    public void eliminarPersonaje(Personaje personaje) {
        personajesBO.eliminarPersonaje(personaje);
    }

    @Override
    public Personaje consultarPorId(Long id) {
        return personajesBO.consultarPorId(id);
    }

    @Override
    public List<Personaje> consultarPorNombre(String nombre) {
        return personajesBO.consultarPorNombre(nombre);
    }

    @Override
    public List<Personaje> consultarPorSerie(String serie) {
        return personajesBO.consultarPorSerie(serie);
    }

    @Override
    public List<Personaje> consultarTodos() {
        return personajesBO.consultarTodos();
    }
}
