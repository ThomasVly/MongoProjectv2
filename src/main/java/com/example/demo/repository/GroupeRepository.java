package com.example.demo.repository;

import com.example.demo.object.Groupe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface GroupeRepository extends MongoRepository<Groupe, String> {
}