package com.example.demo.repository;

import com.example.demo.object.Membre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface MembreRepository extends MongoRepository<Membre, String> {
}
