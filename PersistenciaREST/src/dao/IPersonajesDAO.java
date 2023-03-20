
package dao;

import entidadesrest.Personaje;

import java.util.List;

public interface IPersonajesDAO {
    void agregarPersonaje(Personaje personaje);
    void actualizarPersonaje(Personaje personaje);
    void eliminarPersonaje(Personaje personaje);
    Personaje consultarPorId(Long id);
    List<Personaje> consultarPorNombre(String nombre);
    List<Personaje> consultarPorSerie(String serie);
    List<Personaje> consultarTodos();
}
