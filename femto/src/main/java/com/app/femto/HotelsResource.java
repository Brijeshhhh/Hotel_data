package com.app.femto;

import java.util.List;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
@Path("hotels")

public class HotelsResource {
    
    HotelsRepository repo= new HotelsRepository();
    @GET
    @Produces( MediaType.APPLICATION_JSON)
    public List<Hotels> getDetails(){  
 		return repo.gethotelDetails();
 		   
 	   }
 	   
 	@GET
 	@Path("hotel/{id}")
 	@Produces({MediaType.APPLICATION_JSON,})
 	public Hotels getDetail(@PathParam("id") int id) {
 		
 		return repo.getHoteldetail(id);
	
 	}
}