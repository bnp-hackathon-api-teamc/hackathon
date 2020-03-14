package com.bnpparibas.hackathon.findmyspot.api.service;

import entities.Employee;
import entities.Parking;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.core.MediaType;

public class FindMySpotServiceImpl {

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public String assign(Parking parking, Employee employee){
        return "";
    }

}
