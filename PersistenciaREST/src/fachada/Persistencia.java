package fachada;

import dao.IPersonajesDAO;
import entidadesrest.Personaje;
import factory.DAOFactory;

import java.util.List;

public class Persistencia implements IPersistencia{
    private IPersonajesDAO personajesDAO;

    public Persistencia(){
        personajesDAO = DAOFactory.crearPersonajesDAO();
    }
    @Override
    public void agregarPersonaje(Personaje personaje) {
        personajesDAO.agregarPersonaje(personaje);
    }

    @Override
    public void actualizarPersonaje(Personaje personaje) {
        personajesDAO.actualizarPersonaje(personaje);
    }

    @Override
    public void eliminarPersonaje(Personaje personaje) {
        personajesDAO.eliminarPersonaje(personaje);
    }

    @Override
    public Personaje consultarPorId(Long id) {
        return personajesDAO.consultarPorId(id);
    }

    @Override
    public List<Personaje> consultarPorNombre(String nombre) {
        return personajesDAO.consultarPorNombre(nombre);
    }

    @Override
    public List<Personaje> consultarPorSerie(String serie) {
        return personajesDAO.consultarPorSerie(serie);
    }

    @Override
    public List<Personaje> consultarTodos() {
        return personajesDAO.consultarTodos();
    }
}
