/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package clientes;

import entidadesrest.Personaje;
import java.util.List;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Jersey REST client generated for REST resource:PersonajeResource
 * [personaje]<br>
 * USAGE:
 * <pre>
 *        ClientePersonaje client = new ClientePersonaje();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author user
 */
public class ClientePersonaje {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ServidorREST/webresources";

    public ClientePersonaje() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("personaje");
    }

    public Response deletePersonaje(String id) throws ClientErrorException {
        return webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete(Response.class);
    }

    public List<Personaje> getPersonajes() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("todos");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Personaje>>(){});
    }

    public List<Personaje> getPersonajeBySerie(String serie) throws ClientErrorException {
        WebTarget resource = webTarget;
        if (serie != null) {
            resource = resource.queryParam("serie", serie);
        }
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(new GenericType<List<Personaje>>(){});
    }

    public Personaje getPersonajeById(String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(Personaje.class);
    }

    public Response updatePersonaje(Long id, String nombre, String serie) throws ClientErrorException {
        Personaje personaje = new Personaje(id, nombre, serie);
        return webTarget
                        .queryParam("id", id)
                        .queryParam("nombre", nombre)
                        .queryParam("serie", serie)
                        .request()
                        .put(Entity.entity(personaje, MediaType.APPLICATION_JSON), Response.class);
    }

    public Response postPersonaje(Personaje personaje) throws ClientErrorException {
        //Personaje personaje = new Personaje(nombre, serie);
        return webTarget
                        .queryParam("nombre", personaje.getNombre())
                        .queryParam("serie", personaje.getSerie())
                        .request()
                        .post(Entity.entity(personaje, MediaType.APPLICATION_JSON), Response.class);
    
    }

    public void close() {
        client.close();
    }
    
}
