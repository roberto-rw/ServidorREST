/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package negociorest;

import entidadesrest.Personaje;
import fachada.INegocio;
import fachada.Negocio;

/**
 *
 * @author user
 */
public class NegocioREST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        INegocio n = new Negocio();
        Personaje personaje = n.consultarPorId(3L);
        System.out.println(personaje);
    }
    
}
