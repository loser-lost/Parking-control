package com.api.Parkingcontrol.Services;

import org.springframework.stereotype.Service;

import com.api.Parkingcontrol.Repositers.ParkingSpotRepository;



@Service
public class ParkingSpotService{

    final ParkingSpotRepository parkingSpotRepository;

        public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
            this.parkingSpotRepository = parkingSpotRepository;
        }
}