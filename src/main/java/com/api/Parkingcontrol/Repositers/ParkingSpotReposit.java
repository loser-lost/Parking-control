package com.api.Parkingcontrol.Repositers;

import com.api.Parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.repository;
import java.util.UUID;

@repository
public interface ParkingSpotRepository extends_JpaRepository <ParkingSpotModel, UUID> {

}