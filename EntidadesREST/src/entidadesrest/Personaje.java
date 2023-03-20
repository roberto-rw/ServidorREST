package entidadesrest;

import java.util.Objects;

public class Personaje {
    

    private Long id;
    private String nombre;
    private String serie;
    
    public Personaje(Long id, String nombre, String serie){
        this.nombre = nombre;
        this.serie = serie;
        this.id = id;
    }
    
    public Personaje(String nombre, String serie){
        this.nombre = nombre;
        this.serie = serie;
    }
    
    public Personaje(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Personaje other = (Personaje) obj;
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Personaje{" + "id=" + id + ", nombre=" + nombre + ", serie=" + serie + '}';
    }
}
