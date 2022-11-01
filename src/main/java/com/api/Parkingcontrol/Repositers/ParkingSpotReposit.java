package com.api.Parkingcontrol.Repositers;

import com.api.Parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ParkingSpotReposit extends JpaRepository <ParkingSpotModel, UUID> {

}