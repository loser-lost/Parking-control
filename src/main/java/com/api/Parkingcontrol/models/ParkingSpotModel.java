/*Classe estacionamento */
package com.api.Parkingcontrol.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.UUID;

@Entity /*Torna a classe uma identidade */
@Table(name = "TB_PARKING_SPOT") /*Da o nome a tabela */

public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final String Apartiment = null;

    /*Crinado uma tablela com as especificações */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    /* ------------*/
    @Column( nullable = false, unique = true, length = 10)
    private String parkingSpotNumber;
    /*------------ */
    @Column( nullable = false, unique = true, length = 7)
    private String LicencePlateCar;
    /*------------ */
    @Column( nullable = false, length = 70)
    private String brandCar;
    /*------------ */
    @Column( nullable = false, length = 70)
    private String modelCar;
    /*------------ */
    @Column( nullable = false, length = 70)
    private String collorCar;
    /*------------ */
    @Column( nullable = false)
    private LocalTime registrationDate;
    /*------------ */
    @Column( nullable = false, length = 130)
    private String responsibleName;
    /*------------ */
    @Column( nullable = false, length = 30)
    private String apartiment;
    public ParkingSpotModel(String apartiment) {
        this.apartiment = apartiment;
    }
    /*------------ */
    @Column( nullable = false, length = 30)
    private String block;
    /*----------------------------------- */
    
        /*Metodos get e set */
    public UUID getId(){
        return id;
    }
    public void setId(UUID id){
        this.id = id;
    }
/*-------------------------------------------------------------------- */
    public String getParkingSpotNumber(){
        return parkingSpotNumber;
    }
    public void setParkingSpotNumber(String ParkingSpotNumber){
        this.parkingSpotNumber = ParkingSpotNumber;
    }
/*-------------------------------------------------------------------- */

    public String LicencePlateCar(){
        return LicencePlateCar;
    }
    public void setLicencePlateCar(String LicencePlateCar){
        this.LicencePlateCar = LicencePlateCar;
    }

/*---------------------------------------------------------------------- */
    public String getbrandCar(){
        return brandCar;
    }
    public void setbrandCar(String brandCar){
        this.brandCar = brandCar;
    }
/* ----------------------------------------------------------------------*/
    public String getmodelCar(){
        return modelCar;
    }
    public void setmodelCar(String modelCar){
        this.modelCar = modelCar;
    }

/* ----------------------------------------------------------------------*/
    public String getcollorCar(){
        return collorCar;
    }
    public void setcollorCar(String collorCar){
        this.collorCar = collorCar;
    }
/* ----------------------------------------------------------------------*/
    public LocalTime registrationDate(){
        return registrationDate;
    }
    /*Provalvelmete esta errado, afinal o item a receber o valor nao e uma String
    mas sim um:LocalDateTime */
    public void setregistrationDate(LocalTime localTime){
        this.registrationDate = localTime;
    }
/* ----------------------------------------------------------------------*/
    public String getResponsibleName(){
        return responsibleName;
    }
    public void setResponsibleName(String ResponsibleName){
        this.responsibleName = ResponsibleName;
    }
/* ----------------------------------------------------------------------*/
    public String getApartment(){
        return apartiment;
    }
   
    public void setApartment(String Apartment){
        this.apartiment = Apartiment;
    }
/* ----------------------------------------------------------------------*/
    public String getblock(){
        return block;
    }
    public void setblock(String block){
        this.block = block;
    }
}