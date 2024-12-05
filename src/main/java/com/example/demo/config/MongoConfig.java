package com.example.demo.config;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;


@Configuration
public class MongoConfig {

    private final MongoTemplate mongoTemplate;

    public MongoConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @PostConstruct
    public void init() {
        // Parcourez toutes les classes annotées avec @Document
        for (Class<?> documentClass : new Class<?>[]{MonDocument.class, AutreDocument.class}) {
            if (!mongoTemplate.collectionExists(documentClass)) {
                mongoTemplate.createCollection(documentClass);
            }
        }
    }
}
