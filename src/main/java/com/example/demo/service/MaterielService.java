package com.example.demo.service;

import com.example.demo.object.Materiel;
import com.example.demo.repository.MaterielRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterielService {
    @Autowired
    private MaterielRepository materielRepository;

    public List<Materiel> getAllMateriel() {
        return materielRepository.findAll();
    }
}
