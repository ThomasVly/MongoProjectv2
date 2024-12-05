package com.example.demo.repository;

import com.example.demo.object.Materiel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielRepository extends MongoRepository<Materiel, String> {
}
