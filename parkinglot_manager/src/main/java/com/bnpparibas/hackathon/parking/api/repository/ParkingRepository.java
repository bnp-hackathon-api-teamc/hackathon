package com.bnpparibas.hackathon.parking.api.repository;

import com.bnpparibas.hackathon.parking.api.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bnpparibas.hackathon.parking.api.model.Parking;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Long>{


}
