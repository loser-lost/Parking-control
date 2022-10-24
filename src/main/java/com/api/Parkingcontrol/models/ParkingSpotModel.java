/*Classe estacionamento */
package com.api.Parkingcontrol.models;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime
import java.util.UUID

@Entity /*Torna a classe uma identidade */
@Table(name = "TB_PARKING_SPOT") /*Da o nome a tabela */

public class ParkingSpotModel implements Serializable {
    private static final long serialVersionUID = 1L;

    /*Crinado uma tablela com as especificações */
    @id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @column( nullable = false, unique = true, length = 10)
    private String ParkingSpotNumber;
    @column( nullable = false, unique = true, length = 7)
    private String LicencePlateCar;
    @column( nullable = false, length = 70)
    private String brandCar;
    @column( nullable = false, length = 70)
    private String modelCar;
    @column( nullable = false, length = 70)
    private String collorCar;
    @column( nullable = false)
    private LocalDateTime registrationDate;
    @column( nullable = false, length = 130)
    private String ResponsibleName;
    @column( nullable = false, length = 30)
    private String Apartment;
    @column( nullable = false, length = 30)
    private String block;
    


}