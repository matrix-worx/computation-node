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
@Path("/multiply")
public class Multiplier {
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response multiply( String inputValues ) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        String responseString = new String();
        try
        {
            Double[] inputArray = mapper.readValue(inputValues, Double[].class);
            if ( inputArray.length % 2 != 0 )
            {
                return Response.serverError().entity("Something wrong").build();
            }
            double[] resultArray = new double[inputArray.length/2];
            for ( int i = 0; i < inputArray.length; i += 2 )
            {
                resultArray[i/2] = inputArray[i] * inputArray[i+1];
            }
            responseString = mapper.writeValueAsString(resultArray);
        }
        catch( IOException e )
        {
            return Response.serverError().entity(e.toString()).build();
        }        
        return Response.ok( responseString, MediaType.APPLICATION_JSON).build();
    }
    
}
