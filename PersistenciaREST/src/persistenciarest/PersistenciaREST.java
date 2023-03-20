/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package persistenciarest;

import entidadesrest.Personaje;
import fachada.IPersistencia;
import fachada.Persistencia;

/**
 *
 * @author user
 */
public class PersistenciaREST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        IPersistencia p = new Persistencia();
        Personaje personaje = p.consultarPorId(2L);
        
        System.out.println(personaje);
    }
    
}
