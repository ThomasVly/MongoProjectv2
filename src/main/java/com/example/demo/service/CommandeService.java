package com.example.demo.service;

import com.example.demo.object.Commande;
import com.example.demo.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommandeService {

    @Autowired
    private CommandeRepository commandeRepository;

    public List<Commande> getAllCommandes() {

        return commandeRepository.findAll();
    }

    public void saveCommande(Commande commande){

        commandeRepository.save(commande);
    }
}
