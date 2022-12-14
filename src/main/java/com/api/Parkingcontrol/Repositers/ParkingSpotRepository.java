package com.api.Parkingcontrol.Repositers;

import com.api.Parkingcontrol.models.ParkingSpotModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.UUID;

@Repository
public interface ParkingSpotRepository extends JpaRepository <ParkingSpotModel, UUID> {


    boolean existsByLicensePlateCar(String LicensePlateCar);
    boolean existsByApartimentAndBlock(String Apartment, String Block);
    boolean existsByParkingSpotNumber(String ParkingSpotNumber);
}