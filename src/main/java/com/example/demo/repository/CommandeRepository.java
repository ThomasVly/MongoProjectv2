package com.example.demo.repository;

import com.example.demo.object.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface CommandeRepository extends MongoRepository<Commande, String> {
}
