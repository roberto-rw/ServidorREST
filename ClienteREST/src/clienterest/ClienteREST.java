/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clienterest;

import clientes.ClientePersonaje;

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
        ClientePersonaje cp = new ClientePersonaje();
        Response r = cp.deletePersonaje("24");

        System.out.println(r.getStatus());
        System.out.println(r.readEntity(String.class));
    }
    
}
