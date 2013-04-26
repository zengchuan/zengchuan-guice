package com.zeng.servlet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/test")
public class TestResource {
    @GET
    @Produces("text/plain")
    public String helloWorld(){
        return "hello !";
    }
}
