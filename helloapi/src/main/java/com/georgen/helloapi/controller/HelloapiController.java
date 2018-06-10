package com.georgen.helloapi.controller;

import com.georgen.helloapi.service.Calculator;
import com.georgen.helloapi.service.Caller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

@Path("hello")
public class HelloapiController {
    @Path("call")
    @GET
    @Produces("text/plain")
    public String call(@QueryParam("name") String name) {
        Caller caller = new Caller();
        return caller.getStringHello(name);
    }

    @Path("calc")
    @GET
    @Produces("text/plain")
    public String sum(@QueryParam("x") Integer x, @QueryParam("y") Integer y) {
        Calculator calculator = new Calculator();
        return calculator.getStringFormula(x, y);
    }
}