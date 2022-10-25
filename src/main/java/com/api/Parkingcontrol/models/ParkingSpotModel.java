/*Classe estacionamento */
package com.api.Parkingcontrol.models;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity /*Torna a classe uma identidade */
@Table(name = "TB_PARKING_SPOT") /*Da o nome a tabela */

public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /*Crinado uma tablela com as especificações */
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    /* ------------*/
    @column( nullable = false, unique = true, length = 10)
    private String ParkingSpotNumber;
    /*------------ */
    @column( nullable = false, unique = true, length = 7)
    private String LicencePlateCar;
    /*------------ */
    @column( nullable = false, length = 70)
    private String brandCar;
    /*------------ */
    @column( nullable = false, length = 70)
    private String modelCar;
    /*------------ */
    @column( nullable = false, length = 70)
    private String collorCar;
    /*------------ */
    @column( nullable = false)
    private LocalDateTime registrationDate;
    /*------------ */
    @column( nullable = false, length = 130)
    private String ResponsibleName;
    /*------------ */
    @column( nullable = false, length = 30)
    private String Apartment;
    /*------------ */
    @column( nullable = false, length = 30)
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
        return ParkingSpotNumber;
    }
    public void setParkingSpotNumber(String ParkingSpotNumber){
        this.ParkingSpotNumber = ParkingSpotNumber;
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
    public String registrationDate(){
        return registrationDate;
    }
    /*Provalvelmete esta errado, afinal o item a receber o valor nao e uma String
    mas sim um:LocalDateTime */
    public void setregistrationDate(String registrationDate){
        this.registrationDate = registrationDate;
    }
/* ----------------------------------------------------------------------*/
    public String getResponsibleName(){
        return ResponsibleName;
    }
    public void setResponsibleName(String ResponsibleName){
        this.ResponsibleName = ResponsibleName;
    }
/* ----------------------------------------------------------------------*/
    public String getApartment(){
        return Apartment;
    }
    public void setApartment(String Apartment){
        this.Apartment = Apartment;
    }
/* ----------------------------------------------------------------------*/
    public String getblock(){
        return block;
    }
    public void setblock(String block){
        this.block = block;
    }
}