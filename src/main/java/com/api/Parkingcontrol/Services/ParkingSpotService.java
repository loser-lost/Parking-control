package com.api.Parkingcontrol.services;

import org.springframework.stereotype.service;
import org.springframework.beans.factory.annotation.Autowired;



@service
public class ParkingSpotService{

    @Autowired
    ParkingSpotRepository ParkingSpotRepository;
}