package com.api.Parkingcontrol.dtos;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ParkingSpotDto {
    
    @NotBlank /* o campo nao pode ser em branco */
    private String parkingSpotNumber;
    @NotBlank
    @Size(max = 7)/*o tamanho maximo de letras ou numeros que nao permitidos */
    private String licencePlateCar;
    @NotBlank
    private String brandCar;
    @NotBlank
    private String modelCar;
    @NotBlank
    private String colorCar;
    @NotBlank
    private String responsibleName;
    @NotBlank
    private String apartiment;
    @NotBlank
    private String block;

      /*Metodos get e set */
/*-------------------------------------------------------------------- */
    public String getParkingSpotNumber(){
        return parkingSpotNumber;
    }
    public void setParkingSpotNumber(String ParkingSpotNumber){
        this.parkingSpotNumber = ParkingSpotNumber;
    }
/*-------------------------------------------------------------------- */

    public String LicencePlateCar(){
        return licencePlateCar;
    }
    public void setLicencePlateCar(String LicencePlateCar){
        this.licencePlateCar = LicencePlateCar;
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
        return colorCar;
    }
    public void setcollorCar(String collorCar){
        this.colorCar = collorCar;
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
        this.apartiment = Apartment;
    }
/* ----------------------------------------------------------------------*/
    public String getblock(){
        return block;
    }
    public void setblock(String block){
        this.block = block;
    }
}

