package com.example.demo;

import com.example.demo.controller.CommandeController;
import com.example.demo.object.Commande;
import com.example.demo.object.Groupe;
import com.example.demo.object.Materiel;
import com.example.demo.object.Membre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.service.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

	private final MembreService membreService;
	private final GroupeService groupeService;
	private final MaterielService materielService;
	private final CommandeService commandeService;

	@Autowired
	public DemoApplication(MembreService membreService, GroupeService groupeService, MaterielService materielService, CommandeService commandeService){
		this.membreService = membreService;
		this.groupeService = groupeService;
		this.materielService = materielService;
		this.commandeService = commandeService;
	}

	public void initialisation(){
		Membre a = membreService.createMembre(new Membre("1","jean","michel","308 Negra Arroyo Lane, Albuquerque, New Mexico 87104", "jeanmichel@gmail.com", "client","1234" ));
		Membre b = membreService.createMembre(new Membre("2","jeanne","michelle","308 Negra Arroyo Lane, Albuquerque, New Mexico 87104", "jeannemichelle@gmail.com", "admin","1234" ));
		Materiel x = materielService.addMateriel(new Materiel("ezaeaz","adidos","nike","chaussure",12));
		Date d = new Date();
		ArrayList<Materiel> materiels = new ArrayList<>();
		materiels.add(x);
		Commande c = new Commande("1",a,b,d,materiels,12);
		commandeService.saveCommande(c);
		ArrayList<Membre> m = new ArrayList<Membre>(Arrays.asList(a,b));
		groupeService.saveGroupe(new Groupe("1", "test", "paris", 2232, m, materiels));
	}
	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}

}
