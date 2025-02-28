package com.example.demo.service;

import com.example.demo.object.Groupe;
import com.example.demo.repository.GroupeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupeService {
    @Autowired
    private GroupeRepository groupeRepository;
    public List<Groupe> getAllGroupes() {

        return groupeRepository.findAll();
    }
    public Groupe createGroupe(Groupe groupe) {

        return groupeRepository.save(groupe);
    }

    public Groupe getGroupe(String num){

        return groupeRepository.getGroupeByNumeroGroupe(num);
    }

    public Groupe saveGroupe(Groupe g){

        groupeRepository.save(g);
        return g;
    }

}
