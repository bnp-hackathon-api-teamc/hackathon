package com.bnpparibas.hackathon.findmyspot.api.controller;

import com.bnpparibas.hackathon.findmyspot.api.service.FindMySpotService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FindMySpotControllerImpl implements FindMySpotControllerAPI{

    private FindMySpotService findMySpotService;

    public String assign(@RequestBody String building, @RequestBody long userId){
        return findMySpotService.assign(building, userId);
    }

}
