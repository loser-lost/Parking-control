package com.api.Parkingcontrol.Services;

import org.springframework.stereotype.Service;

import com.api.Parkingcontrol.Repositers.ParkingSpotRepository;
import com.api.Parkingcontrol.models.ParkingSpotModel;



@Service
public class ParkingSpotService{

    final ParkingSpotRepository parkingSpotRepository;

        public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
            this.parkingSpotRepository = parkingSpotRepository;
        }

        public Object save(ParkingSpotModel parkingSpotModel) {
            return null;
        }
}