package com.api.Parkingcontrol.controllers;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.Parkingcontrol.Services.ParkingSpotService;
import com.api.Parkingcontrol.dtos.ParkingSpotDto;
import com.api.Parkingcontrol.models.ParkingSpotModel;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController{
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }
    //Metodo Post/ set com verificações.
    @PostMapping
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        
        if(parkingSpotService.existsByLicensePlateCar(parkingSpotDto.getLicencePlateCar())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Licence plate car Alread in use!");
        // valida��o, caso haja alguma placa de acarro que seja igual a que esta tentando adicionar, ele retorna um aviso de erro.
        }
        if(parkingSpotService.existsByParkingSpotNumber(parkingSpotDto.getParkingSpotNumber())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Parking spot Alread in use!");
        // valida��o, caso haja alguma vaga de estacionamento que seja igual a que esta tentando adicionar, ele retorna um aviso de erro.
        }
        if(parkingSpotService.existsByApartimentAndBlock(parkingSpotDto.getApartment(), parkingSpotDto.getblock())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: Apartiment/Block Alread in use!");
        // valida��o, caso haja alguma vaga de estacionamento que seja igual a que esta tentando adicionar, ele retorna um aviso de erro.
        }

        var parkingSpotModel = new ParkingSpotModel(null);
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        // copia as propriedades colocadas no dto para o model.
        parkingSpotModel.setregistrationDate(LocalTime.now(ZoneId.of("UTC")));
        // seta o local e o tempo onde a informação foi upada.
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.save(parkingSpotModel));

    }
    //Metodo Get
    @GetMapping
    public ResponseEntity<List<ParkingSpotModel>> getALLParkingSpots(@PageableDefault(page = 0,size = 10,sort = "id", direction = Sort.Direction.ASC) final Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.findALL(pageable));
    }

    // Get por id... por conta da diferença o "o "getmapping" vai ter um campo para receber o id.
    @GetMapping ("/{id}")// UUID acaba sendo o tipo de informação.
    public ResponseEntity<Object> getOneParkingSpot(@PathVariable(value = "id")UUID id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        //na linha acima faz a busca usando de uma função, preexistente.
        //na linha abaixo faz uma verificação, se encontra ou nao o registro.
        if (!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Parking Spot not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    // Metodo delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteParkingSpot(@PathVariable(value = "id") UUID id){
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if (!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found!");
        }
        parkingSpotService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Deleted!");

    }
    //Metodo push
    @PutMapping(value="push/{id}") //sempre usado quando e necessario o id.
    public ResponseEntity<Object> updateParkingSpot(@PathVariable(value = "id")UUID id, @RequestBody @Valid ParkingSpotDto parkingSpotDto) {
        // e uma função publica, e vai receber dois valores, o id e o que esta armazenado no dto, para isso chama o request body e o validate.
        Optional<ParkingSpotModel> parkingSpotModelOptional = parkingSpotService.findById(id);
        if(!parkingSpotModelOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Not found");
        }  
        // if para verificar a existencia do recurso.
        
         var parkingSpotModel = parkingSpotModelOptional.get();
        //Basicamente joga os dados do optional no model comum.
        parkingSpotModel.setParkingSpotNumber(parkingSpotDto.getParkingSpotNumber());
        parkingSpotModel.setApartment(parkingSpotDto.getApartment());
        parkingSpotModel.setResponsibleName(parkingSpotDto.getResponsibleName());
        parkingSpotModel.setblock(parkingSpotDto.getblock());
        parkingSpotModel.setbrandCar(parkingSpotDto.getbrandCar());
        parkingSpotModel.setcollorCar(parkingSpotDto.getcollorCar());
        parkingSpotModel.setmodelCar(parkingSpotDto.getcollorCar());
        parkingSpotModel.setLicencePlateCar(parkingSpotDto.getLicencePlateCar());
        return ResponseEntity.status(HttpStatus.OK).body("sucess");
        //Nesse caso os dados vão ser adicionados usando os sets acima, com valores no dto, seria uma atualização.
        
            
        /*
        var parkingSpotModel = new ParkingSpotModel();
        //nesse caso cria outra instancia.
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        //copia as propriedades para ela.
        parkingSpotModel.setId(parkingSpotModelOptional.get().getId());
        parkingSpotModel.setregistrationDate(parkingSpotModelOptional.get().getregistrationDate());
        //Mantem o ID e a data de registro.
        return ResponseEntity.status(HttpStatus.OK).body("sucess");
         */
    }

}