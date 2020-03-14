package com.bnpparibas.hackathon.findmyspot.api.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class FindMySpotControllerTest {


    @InjectMocks
    FindMySpotControllerImpl findMySpotController;


    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void assign() throws Exception {
        String responseEntity = findMySpotController.assign("B1",1L);

        assertThat(responseEntity).isNotEmpty();
    }

    @Test
    public void getEmployeeParkingLot() throws Exception {

        String responseEntity = findMySpotController.getEmployeeParkingLot(1L);

        assertThat(responseEntity).isNotEmpty();

    }

    @Test
    public void markOcucupied() throws Exception {
        findMySpotController.markOcucupied("B1",1L);
    }

    @Test(expected = Exception.class)
    public void failToMarkOccupies() throws Exception {
        findMySpotController.markOcucupied("kuytfkgf",-1L);
    }

    @Test
    public void markUnocucupied() throws Exception {
        findMySpotController.markUnocucupied("B1",1L);
    }

    @Test(expected = Exception.class)
    public void failToMarkUnocucupied() throws Exception {
        findMySpotController.markUnocucupied("oahgskgfdhas",-1L);
    }
}
