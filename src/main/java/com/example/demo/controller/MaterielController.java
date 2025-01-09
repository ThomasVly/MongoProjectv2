package com.example.demo.controller;

import com.example.demo.object.Materiel;
import com.example.demo.service.MaterielService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/materiel")
public class MaterielController {

    private final MaterielService materielService;
    public MaterielController(MaterielService materielService) {
        this.materielService = materielService;
    }

    @PostMapping("/add")
    public Materiel addMateriel(Materiel materiel) {
        return materielService.addMateriel(materiel);
    }

    @GetMapping("/getAll")
    public List<Materiel> getAllMateriel() {
        return materielService.getAllMateriel();
    }
}
