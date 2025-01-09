package com.example.demo;

import com.example.demo.object.Groupe;
import com.example.demo.object.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private final MembreService membreService;
	private final GroupeService groupeService;

	@Autowired
	public DemoApplication(MembreService membreService, GroupeService groupeService){
		this.membreService = membreService;
		this.groupeService = groupeService;
	}

	public void initialisation(){
		Membre a = membreService.createMembre(new Membre("1","jean","michel","308 Negra Arroyo Lane, Albuquerque, New Mexico 87104", "jeanmichel@gmail.com", "client","1234" ));
		Membre b = membreService.createMembre(new Membre("2","jeanne","michelle","308 Negra Arroyo Lane, Albuquerque, New Mexico 87104", "jeannemichelle@gmail.com", "admin","1234" ));
		ArrayList<Membre> m = new ArrayList<Membre>(Arrays.asList(a,b));
		groupeService.saveGroupe(new Groupe(1, "test", "paris", 2232, m));
	}
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
