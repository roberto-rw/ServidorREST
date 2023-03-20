
package dao;

import java.sql.Connection;
import conexion.MySQLConnection;
import entidadesrest.Personaje;
import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class PersonajesDAO implements IPersonajesDAO{
    private final MySQLConnection conexion;

    public PersonajesDAO(MySQLConnection conexion){
        this.conexion = conexion;
    }

    @Override
    public void agregarPersonaje(Personaje personaje) {
        String query = "INSERT INTO personajes (nombre, serie) VALUES (?, ?)";
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, personaje.getNombre());
            ps.setString(2, personaje.getSerie());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void actualizarPersonaje(Personaje personaje) {
        String query = "UPDATE personajes SET nombre=?, serie=? WHERE id_personaje=?";
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, personaje.getNombre());
            ps.setString(2, personaje.getSerie());
            ps.setLong(3, personaje.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void eliminarPersonaje(Personaje personaje) {
         String query = "DELETE FROM personajes WHERE id_personaje=?";
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setLong(1, personaje.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Personaje consultarPorId(Long id) {
        String query = "SELECT * FROM personajes WHERE id_personaje=?";
        Personaje personaje = null;
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                personaje = new Personaje(rs.getLong("id_personaje"), rs.getString("nombre"), rs.getString("serie"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personaje;
    }

    @Override
    public List<Personaje> consultarPorNombre(String nombre) {
        String query = "SELECT * FROM personajes WHERE nombre=?";
        List<Personaje> personajes = new ArrayList<>();
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Personaje personaje = new Personaje(rs.getLong("id_personaje"), rs.getString("nombre"), rs.getString("serie"));
                personajes.add(personaje);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personajes;
    }

    @Override
    public List<Personaje> consultarPorSerie(String serie) {
        String query = "SELECT * FROM personajes WHERE serie=?";
        List<Personaje> personajes = new ArrayList<>();
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ps.setString(1, serie);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Personaje personaje = new Personaje(rs.getLong("id_personaje"), rs.getString("nombre"), rs.getString("serie"));
                personajes.add(personaje);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personajes;
    }

    @Override
    public List<Personaje> consultarTodos() {
        String query = "SELECT * FROM personajes";
        List<Personaje> personajes = new ArrayList<>();
        try {
            Connection c = conexion.getConnection();
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Personaje personaje = new Personaje(rs.getLong("id_personaje"), rs.getString("nombre"), rs.getString("serie"));
                personajes.add(personaje);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return personajes;
    }
}
