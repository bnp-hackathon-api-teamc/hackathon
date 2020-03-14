package com.bnpparibas.hackathon.parking.api.controller.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.bnpparibas.hackathon.parking.api.Application;
import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.bnpparibas.hackathon.parking.api.model.Parking;
import com.bnpparibas.hackathon.parking.api.model.ParkingLot;

import java.util.List;


@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class ParkingControllerTest {

    @InjectMocks
    private ParkingController parkingController;

    @Mock
    private ParkingRepository parkingRepository;

    @Mock
    private ParkingLotRepository parkingLotRepository;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void updateParkingLot() throws Exception {
    }

    @Test
    public void updateParking() throws Exception {
    }

    @Test
    public void createParkingLot() throws Exception {
    }

    @Test
    public void createParking() throws Exception {
    }

    @Test
    public void getParkingById() throws Exception {
    }

    @Test
    public void getParkingByBuilding() throws Exception {
    }

    @Test
    public void getAllParkings() throws Exception {
        List<Parking> responseEntity= parkingController.getAllParkings();

    }

    @Test
    public void getParkingLotById() throws Exception {
    }

    @Test
    public void getParkingLotByAliasId() throws Exception {
    }

    @Test
    public void getParkingLotAvailableByBuilding() throws Exception {
    }

    @Test
    public void getAllParkingLots() throws Exception {
    }

    @Test
    public void getAllAvailableParkingLots() throws Exception {
    }
}
