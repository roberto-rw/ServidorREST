/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package ws;

import converter.Converter;
import entidadesrest.Personaje;
import excepciones.NoDataFoundException;
import fachada.INegocio;
import fachada.Negocio;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author user
 */
@Path("personaje")
public class PersonajeResource {

    @Context
    private UriInfo context;
    private INegocio negocio;
    /**
     * Creates a new instance of PersonajeResource
     */
    public PersonajeResource() {
        this.negocio = new Negocio();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonajeById(@PathParam("id") Long id) {
        try{
            Personaje p = negocio.consultarPorId(id);
            return Response.status(200).entity(p).build();
        }catch (NoDataFoundException e){
            return Response.status(404).entity("Personaje no encontrado").build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(500).entity("Error inesperado").build();
    }
    
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response getPersonajeByName(@QueryParam("nombre") String nombre) {
//        try{
//            List<Personaje> personajes = negocio.consultarPorNombre(nombre);
//            Personaje[] arrayPersonajes = Converter.convertirToArray(personajes);
//            return Response.status(200).entity(arrayPersonajes).build();
//        }catch (NoDataFoundException e){
//            return Response.status(404).entity("Personaje no encontrado").build();
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return Response.status(500).entity("Error inesperado").build();
//    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonajeBySerie(@QueryParam("serie") String serie) {
        try{
            List<Personaje> personajes = negocio.consultarPorSerie(serie);
            Personaje[] arrayPersonajes = Converter.convertirToArray(personajes);
            return Response.status(200).entity(arrayPersonajes).build();
        }catch (NoDataFoundException e){
            return Response.status(404).entity("Personaje no encontrado").build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(500).entity("Error inesperado").build();
    }
    
    @GET
    @Path("/todos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonajes() {
        try{
            List<Personaje> personajes = negocio.consultarTodos();
            Personaje[] arrayPersonajes = Converter.convertirToArray(personajes);
            return Response.status(200).entity(arrayPersonajes).build();
        }catch (NoDataFoundException e){
            return Response.status(404).entity("Personaje no encontrado").build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(500).entity("Error inesperado").build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response postPersonaje(Personaje personaje) {
        try{
            negocio.agregarPersonaje(personaje);
            return Response.status(201).entity("Personaje creado con exito").build();
        }catch (NoDataFoundException e){
            return Response.status(404).entity("Personaje no encontrado").build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(500).entity("Error inesperado").build();
    }
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updatePersonaje(Personaje personaje) {
        try{
            negocio.actualizarPersonaje(personaje);
            return Response.status(200).entity("Personaje actualizado").build();
        }catch (NoDataFoundException e){
            return Response.status(404).entity("Personaje no encontrado").build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(500).entity("Error inesperado").build();
    }
    
    @DELETE
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePersonaje(@PathParam("id") Long id) {
        Personaje personaje = new Personaje();
        personaje.setId(id);
        try{
            negocio.eliminarPersonaje(personaje);
            return Response.status(200).entity("Personaje eliminado").build();
        }catch (NoDataFoundException e){
            return Response.status(404).entity("Personaje no encontrado").build();
        }catch(Exception e){
            e.printStackTrace();
        }
        return Response.status(500).entity("Error inesperado").build();
    }
    
    
}
