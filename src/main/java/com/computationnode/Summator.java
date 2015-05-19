/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.computationnode;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.ws.rs.core.Response;

/**
 *
 * @author gleab
 */
@Path("/sum")
public class Summator {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response sum( String inputValues ) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        String responseString = new String();
        try
        {
            Double[] inputArray = mapper.readValue(inputValues, Double[].class);
            double result = 0;
            for ( int i = 0; i < inputArray.length; ++i )
            {
                result += inputArray[i];
            }
            responseString = "["+result+"]";
        }
        catch( IOException e )
        {
            return Response.serverError().entity(e.toString()).build();
        }        
        return Response.ok( responseString, MediaType.APPLICATION_JSON).build();
    }
    
}
