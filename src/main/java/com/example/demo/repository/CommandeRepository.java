package com.example.demo.repository;

import com.example.demo.object.Commande;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommandeRepository extends MongoRepository<Commande, String> {

    List<Commande> findByListeMaterielContaining(String searchTerm);
}
