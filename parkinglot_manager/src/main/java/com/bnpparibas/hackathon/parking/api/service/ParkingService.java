package com.bnpparibas.hackathon.parking.api.service;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;



@Service
public class ParkingService {

    @Autowired
    private ParkingRepository parkingRepository;

    /**
     * Returns a list of availables spots for a given building
     * @param building
     * @return
     * @throws ResourceNotFoundException
     */

    public List<ParkingLot> getParkingLotAvailableByBuilding(String building) throws ResourceNotFoundException{
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
