package com.api.Parkingcontrol;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
/*É nessessario prestar atenção aos imports */


@SpringBootApplication
@org.springframework.web.bind.annotation.RestController
public class ParkingControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ParkingControlApplication.class, args);
	} 
	@org.springframework.web.bind.annotation.GetMapping("/")
	/*Responsavel pelo mapeamento. */
	public String index(){
		return "Olá mundo!";
	}
	/* Local onde se cria funções, acima tem um modelo d uma função simples */
}
