package com.bnpparibas.hackathon.parking.api.controller.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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

        byte[] array = new byte[7];
        new Random().nextBytes(array);

        Parking parkingB1 = new Parking("B1", "Alter-Solutions",  null);

        Parking parkingB2 = new Parking("B2", "Alter-Solutions",  null);

        List<ParkingLot> parkingLotsB1 = new ArrayList<>();
        List<ParkingLot> parkingLotsB2 = new ArrayList<>();

        for (int floor = 0; floor < 10; floor++) {
            for (int width = 0; width < 10; width++) {
                for (int height = 0; height < 10; height++) {

                    String generatedString = new String(array, Charset.forName("UTF-8"));
                    parkingLotsB1.add(new ParkingLot(generatedString, floor, width, height, parkingB1));
                    parkingLotsB2.add(new ParkingLot(generatedString, floor, width, height, parkingB1));

                }
            }
        }

        parkingB1.setParkingLot(parkingLotsB1);
        parkingB2.setParkingLot(parkingLotsB2);

        when(parkingRepository.findAll()).thenReturn(Arrays.asList(parkingB1,parkingB2));

        List<Parking> responseEntity= parkingController.getAllParkings();

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.size()).isEqualTo(2);
        assertThat(responseEntity.get(0) instanceof Parking).isTrue();
        assertThat(responseEntity.get(0).getName()).isEqualTo("Alter-Solutions");

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
