package com.bnpparibas.hackathon.parking.api.controller.impl;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import com.bnpparibas.hackathon.parking.api.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bnpparibas.hackathon.parking.api.controller.ParkingControllerAPI;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ParkingController implements ParkingControllerAPI{

    @Autowired
    private ParkingService parkingService;


    @Override
    public ResponseEntity<ParkingLot> updateParkingLot(Long parkingLotId, @Valid ParkingLot parkingLotDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Parking> updateParking(Long parkingId, @Valid Parking parkingDetails) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ParkingLot createParkingLot(@Valid ParkingLot parkingLot) {
        return null;
    }

    @Override
    public Parking createParking(@Valid Parking parking) {
        return null;
    }

    @Override
    public ResponseEntity<Parking> getParkingById(Long parkingId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<Parking> getParkingByBuilding(String building) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<Parking> getAllParkings() {
        return null;
    }

    @Override
    public ResponseEntity<ParkingLot> getParkingLotById(Long parkingLotId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public ResponseEntity<ParkingLot> getParkingLotByAliasId(String aliasLotId) throws ResourceNotFoundException {
        return null;
    }

    @Override
    public List<ParkingLot> getAllParkingLots() {
        return null;
    }

    @Override
    public List<ParkingLot> getAllAvailableParkingLots() {
        return null;
    }

    @Override
    public List<ParkingLot> getAvailableParkingLot() {
        return null;
    }

    @Override
    @RequestMapping(value = "/availableParkingLots")
    public List<ParkingLot> getParkingLotAvailableByBuilding(String building) throws ResourceNotFoundException {
       return parkingService.getParkingLotAvailableByBuilding(building);
    }
}
