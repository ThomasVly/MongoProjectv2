package com.example.demo.controller;


import com.example.demo.object.Membre;
import com.example.demo.service.MembreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membre")
public class MembreController {
    private final MembreService membreService;
    @Autowired
    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @PostMapping("/create")
    public Membre create(@RequestBody Membre membre) {
        return membreService.createMembre(membre);
    }
}
