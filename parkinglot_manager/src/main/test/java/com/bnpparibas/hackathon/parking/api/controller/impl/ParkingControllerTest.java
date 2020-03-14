package com.bnpparibas.hackathon.parking.api.controller.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.bnpparibas.hackathon.parking.api.repository.ParkingLotRepository;
import com.bnpparibas.hackathon.parking.api.repository.ParkingRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
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
@RunWith(MockitoJUnitRunner.class)
public class ParkingControllerTest {

    @InjectMocks
    private ParkingController parkingController;

    @Mock
    private ParkingRepository parkingRepository;

    @Mock
    private ParkingLotRepository parkingLotRepository;


    protected Parking parkingB1;
    protected Parking parkingB2;

    protected List<ParkingLot> parkingLotsB1;
    protected List<ParkingLot> parkingLotsB2;

    @Before
    public void setUp() throws Exception {

        byte[] array = new byte[7];
        Random random = new Random();
        random.nextBytes(array);

        parkingB1 = new Parking("B1", "Alter-Solutions", null);

        parkingB2 = new Parking("B2", "Alter-Solutions", null);

        parkingLotsB1 = new ArrayList<>();
        parkingLotsB2 = new ArrayList<>();

        boolean switchBool = true;

        int id = 0;

        for (int floor = 0; floor < 2; floor++) {
            for (int width = 0; width < 5; width++) {
                for (int height = 0; height < 5; height++) {
                    ParkingLot parkingLot = new ParkingLot(String.format("%s %d %d %d", parkingB1.getName(), floor, width, height)
                            , floor, width, height, parkingB1, switchBool);
                    ParkingLot parkingLot2 = new ParkingLot(String.format("%s %d %d %d", parkingB2.getName(), floor, width, height)
                            , floor, width, height, parkingB2, switchBool);

                    parkingLot.setId(id++);
                    parkingLot2.setId(id++);
                    parkingLotsB1.add(parkingLot);
                    parkingLotsB2.add(parkingLot2);

                }
                switchBool = !switchBool;
            }
        }

        parkingB1.setParkingLot(parkingLotsB1);
        parkingB2.setParkingLot(parkingLotsB2);

    }

    @Test
    public void updateParkingLot() throws Exception {
        ResponseEntity<ParkingLot> responseEntity = parkingController.updateParkingLot(1L, new ParkingLot());

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void updateParking() throws Exception {
        ResponseEntity<Parking> responseEntity = parkingController.updateParking(1L, new Parking());

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void createParkingLot() throws Exception {
        ParkingLot responseEntity = parkingController.createParkingLot(new ParkingLot());

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void createParking() throws Exception {
        Parking responseEntity = parkingController.createParking(new Parking());

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void getParkingById() throws Exception {
        ResponseEntity<Parking> responseEntity = parkingController.getParkingById(1L);

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void getParkingByBuilding() throws Exception {
        ResponseEntity<ParkingLot> responseEntity = parkingController.updateParkingLot(1L, new ParkingLot());

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void getAllParkings() throws Exception {

        when(parkingRepository.findAll()).thenReturn(Arrays.asList(parkingB1, parkingB2));

        List<Parking> responseEntity = parkingController.getAllParkings();

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.size()).isEqualTo(2);
        assertThat(responseEntity.get(0).getName()).isEqualTo("Alter-Solutions");
        assertThat(responseEntity.get(0).getParkingLot().size()).isEqualTo(50);
        assertThat(responseEntity.get(1).getParkingLot().size()).isEqualTo(50);
        assertThat(responseEntity.get(0).getBuilding()).isEqualTo("B1");
        assertThat(responseEntity.get(1).getBuilding()).isEqualTo("B2");

    }

    @Test
    public void getParkingLotById() throws Exception {

        ResponseEntity<ParkingLot> responseEntity = parkingController.getParkingLotById(1L);

        assertThat(responseEntity).isNotNull();

    }

    @Test
    public void getParkingLotByAliasId() throws Exception {

        ResponseEntity<ParkingLot> responseEntity = parkingController.getParkingLotByAliasId("aliasId");

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void getParkingLotAvailableByBuilding() throws Exception {

        when(parkingRepository.findAll()).thenReturn(Arrays.asList(parkingB1, parkingB2));

        List<ParkingLot> responseEntity = parkingController.getParkingLotAvailableByBuilding("B1");

        assertThat(responseEntity).isNotNull();
        assertThat(responseEntity.size()).isEqualTo(25);
        System.out.println("ParkingLot available on building B1 is "+ responseEntity.size());

    }

    @Test
    public void getAllParkingLots() throws Exception {
        List<ParkingLot> responseEntity = parkingController.getAllParkingLots();

        assertThat(responseEntity).isNotNull();
    }

    @Test
    public void getAllAvailableParkingLots() throws Exception {
        ResponseEntity<ParkingLot> responseEntity = parkingController.getParkingLotByAliasId("aliasId");

        assertThat(responseEntity).isNotNull();
    }
}
