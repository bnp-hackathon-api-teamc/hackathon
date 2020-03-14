package com.bnpparibas.hackathon.parking.api.controller;

import java.util.List;

import javax.validation.Valid;

import javassist.NotFoundException;
import org.springframework.http.ResponseEntity;

import com.bnpparibas.hackathon.commons.api.exception.ResourceNotFoundException;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;

public interface ParkingControllerAPI {
	
	public ResponseEntity<ParkingLot> updateParkingLot(Long parkingLotId, @Valid ParkingLot parkingLotDetails) throws ResourceNotFoundException, NotFoundException;
	
	public ResponseEntity<Parking> updateParking(Long parkingId, @Valid Parking parkingDetails) throws ResourceNotFoundException;

	public ParkingLot createParkingLot(@Valid ParkingLot parkingLot);
	
	public Parking createParking(@Valid Parking parking);

	public ResponseEntity<Parking> getParkingById(Long parkingId) throws ResourceNotFoundException;
	
	public ResponseEntity<Parking> getParkingByBuilding(String building) throws ResourceNotFoundException;

	public List<Parking> getAllParkings();
	
	public ResponseEntity<ParkingLot> getParkingLotById(Long parkingLotId) throws ResourceNotFoundException;
	
	public ResponseEntity<ParkingLot> getParkingLotByAliasId(String aliasLotId) throws ResourceNotFoundException;
	
	public List<ParkingLot> getParkingLotAvailableByBuilding(String building) throws ResourceNotFoundException;

	public List<ParkingLot> getAllParkingLots();
	
	public List<ParkingLot> getAllAvailableParkingLots();

	public List<ParkingLot> getAvailableParkingLot();
}
