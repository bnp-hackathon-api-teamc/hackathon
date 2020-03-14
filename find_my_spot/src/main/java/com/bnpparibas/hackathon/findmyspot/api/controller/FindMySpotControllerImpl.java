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

    @Override
    public String getEmployeeParkingLot(long userId) {
        return null;
    }

    @Override
    public void markOcucupied(String building, long parkingLotID) {

    }

    @Override
    public void markUnocucupied(String building, long parkingLotID) {

    }

}
