package com.example.demo.service;

import com.example.demo.object.Membre;
import com.example.demo.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
