/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienterest;

import clientes.ClientePersonaje;
import entidadesrest.Personaje;

import javax.ws.rs.core.Response;

/**
 *
 * @author user
 */
public class ClienteREST {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Personaje personaje= new Personaje("Capitan Magma", "Bob Esponja");
        ClientePersonaje cp = new ClientePersonaje();
        Response r = cp.postPersonaje(personaje);

        System.out.println(r.getStatus());
        System.out.println(r.readEntity(String.class));
    }
    
}
