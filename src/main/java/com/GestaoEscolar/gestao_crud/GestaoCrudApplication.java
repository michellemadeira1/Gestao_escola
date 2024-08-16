package com.GestaoEscolar.gestao_crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;



@EntityScan(basePackages = "model")
@SpringBootApplication
@ComponentScan(basePackages = {"com.GestaoEscolar.controller", "com.GestaoEscolar.service", "com.GestaoEscolar.repository"})
public class GestaoCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestaoCrudApplication.class, args);
	}

}
