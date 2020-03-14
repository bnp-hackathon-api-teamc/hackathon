package com.bnpparibas.hackathon.parking.api.controller.impl;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpparibas.hackathon.parking.api.controller.ParkingControllerAPI;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public abstract class ParkingController implements ParkingControllerAPI{

    @Autowired
	private ParkingRepository parkingRepository;

    @Override
    @RequestMapping(value = "/availableParkingLots")
    public List<ParkingLot> getParkingLotAvailableByBuilding(String building) throws ResourceNotFoundException {
        List<Parking> parkings = parkingRepository.findAll();

        List<ParkingLot> parkingLots = new ArrayList<>();

        for(Parking p : parkings){
            if(p.getBuilding().equals(building)){
                 parkingLots = p.getAvailableParkingLot();
            }
        }
        return parkingLots;
    }
}
