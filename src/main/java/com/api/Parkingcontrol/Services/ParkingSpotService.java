package com.api.Parkingcontrol.Services;

import org.springframework.stereotype.Service;

import com.api.Parkingcontrol.Repositers.ParkingSpotRepository;
import com.api.Parkingcontrol.models.ParkingSpotModel;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;


@Service
public class ParkingSpotService{

    final ParkingSpotRepository parkingSpotRepository;
    // ponto de inje��o do model.
        public ParkingSpotService(ParkingSpotRepository parkingSpotRepository){
            this.parkingSpotRepository = parkingSpotRepository;
        }
        @Transactional
        //para calso algo esteja errado, garantir um rollback, ou seja para nao ter dados quebrados.
        public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
            return parkingSpotRepository.save(parkingSpotModel);   
        }
        public boolean existsByLicensePlateCar(String LicensePlateCar){
            return parkingSpotRepository.existsByLicensePlateCar(LicensePlateCar);
        }
        public boolean existsByParkingSpotNumber(String ParkingSpotNumber){
            return parkingSpotRepository.existsByParkingSpotNumber(ParkingSpotNumber);
        }
        public boolean existsByApartimentAndBlock(String Apartment, String Block){
            return parkingSpotRepository.existsByApartimentAndBlock(Apartment, Block);
        }
        public List<ParkingSpotModel> findALL(){
            return parkingSpotRepository.findAll();
        }
        public Optional<ParkingSpotModel> findById(UUID id) {
            return parkingSpotRepository.findById(id);
        }
        @Transactional
        public void delete(ParkingSpotModel parkingSpotModel) {
             parkingSpotRepository.delete(parkingSpotModel);
             // void nao tem retono
             // a maior parte das funçoes usaram o JPA. para encurtar a programação.
        }
}