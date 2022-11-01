package com.api.Parkingcontrol.Services;

import org.springframework.stereotype.Service;

import com.api.Parkingcontrol.models.ParkingSpotModel;

import org.springframework.beans.factory.annotation.Autowired;



@Service
public class ParkingSpotService{

    @Autowired
    ParkingSpotModel ParkingSpotRepository;
}