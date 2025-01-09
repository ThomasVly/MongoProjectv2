package com.example.demo.service;

import com.example.demo.object.Membre;
import com.example.demo.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MembreService {
    @Autowired
    private MembreRepository membreRepository;
    public List<Membre> getAllMembres() {

        return membreRepository.findAll();
    }

    public Membre createMembre(Membre membre) {

        return membreRepository.save(membre);
    }

    public Boolean validateLogin(String mail, String pass){

        return Objects.equals(membreRepository.getMembreByEmail(mail).getPassword(), pass);
    }
}
