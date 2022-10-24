package com.api.Parkingcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.web.dind.annotation.GetMapping;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.sringframework.web.bind.annotation.RestController;
/*É nessessario prestar atenção aos imports */


@SpringBootApplication
@RestController
public class ParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	} 
	@GetMapping("/")
	/*Responsavel pelo mapeamento. */
	public String index(){
		return "Olá mundo!"
	}
	/* Local onde se cria funções, acima tem um modelo d uma função simples */
}
