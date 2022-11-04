package com.api.Parkingcontrol.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Parkingcontrol.Services.ParkingSpotService;
import com.api.Parkingcontrol.models.ParkingSpotModel;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController{
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    public ResponseEntity<object> saveParkingSpot(@RequestBody @valid ParkingSpotDto parkingSpotDto){
        var parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setregistrationDate(LocalTime.now(ZoneId.of("UTC")));
        return ResponseEntity.satatus(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));
    }

}