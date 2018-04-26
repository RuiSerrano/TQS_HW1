/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tqs_hw1_server;

import tqs_hw1_rui.Converter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author ruiserrano
 */
@Path("convert")
public class GenericResource {

    @Context
    private UriInfo context;

    
    public static final String ACCESS_KEY = "f84efe469a2dafaefb35664321f00edb";
    public static final String BASE_URL = "http://apilayer.net/api/";
    public static final String ENDPOINT = "live";

    // this object is used for executing requests to the (REST) API
    
    Converter converter;
    
    
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        
        this.converter = new Converter();
    }
   

    /**
     * Retrieves representation of an instance of com.mycompany.tqs_hw1_server.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getJson(@QueryParam("from") String from, @QueryParam("to") String to, @QueryParam("value") Double value) throws Exception {
        double rate = converter.getRate(from, to);
        if (rate ==0 ){
            return Response.status(Response.Status.BAD_REQUEST).build();
            
        }
       double response = converter.convert(value, rate);
       return Response.ok(response,MediaType.TEXT_PLAIN).build();
    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
