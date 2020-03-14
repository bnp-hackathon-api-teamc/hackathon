package com.bnpparibas.hackathon.findmyspot.api.rest;

import org.springframework.web.client.RestTemplate;

public class UserRESTClient {

    private RestTemplate restTemplate = new RestTemplate();

    public void getUsers() {
        restTemplate.postForObject("localhost:8080/employee/api/v1/employees");
    }
}
