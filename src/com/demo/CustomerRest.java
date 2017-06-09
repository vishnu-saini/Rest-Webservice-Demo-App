package com.demo;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

// api/CustomerRest?customerId=121&customerName=raj
@Path("/CustomerRest")
public class CustomerRest {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getCustomerInfo(@QueryParam("customerId") String customerId,
			@QueryParam("customerName") String customerName) {

		return customerId + " " + customerName + " processed!";
	}
}