package com.softwaredevs.proyecto;

import com.softwaredevs.proyecto.entities.Enterprise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication
public class ProyectoApplication {

	public static void main(String[] args) {
		//SpringApplication.run(ProyectoApplication.class, args);
		Enterprise empresa1 = new Enterprise("Alqueria","8300769803-2","3176253465","calle 45 #20-30");
		System.out.println("<-------Creacion empresa 1--------->");
		System.out.println("Nombre empresa 1: "+ empresa1.getName());
		System.out.println("NIT empresa 1: "+ empresa1.getDocument());
		System.out.println("Direccion empresa 1: "+ empresa1.getAddress());
		System.out.println("Telefono empresa 1: "+ empresa1.getPhone());
		System.out.println("Creacion empresa 1: "+ empresa1.getCreateAt());
		empresa1.setName("Algarra");
		empresa1.setDocument("93078494-2");
		empresa1.setAddress("Carrera 20 #30-20");
		empresa1.setPhone("6015203024");
		System.out.println("<-------Modificacion empresa 1--------->");
		System.out.println("Nombre empresa 1: "+ empresa1.getName());
		System.out.println("NIT empresa 1: "+ empresa1.getDocument());
		System.out.println("Direccion empresa 1: "+ empresa1.getAddress());
		System.out.println("Telefono empresa 1: "+ empresa1.getPhone());
		System.out.println("Creacion empresa 1: "+ empresa1.getCreateAt());
	}

}
