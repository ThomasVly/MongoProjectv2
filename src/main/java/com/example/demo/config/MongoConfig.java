package com.example.demo.config;
import jakarta.annotation.PostConstruct;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;
import java.util.Set;


@Configuration
public class MongoConfig {

    private final MongoTemplate mongoTemplate;
    private final ApplicationContext applicationContext;
    public MongoConfig(MongoTemplate mongoTemplate, ApplicationContext applicationContext) {
        this.mongoTemplate = mongoTemplate;
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void init() {
        System.out.println("Initializing Mongo collections...");

        // Utiliser Reflections pour trouver les classes annotées avec @Document
        Reflections reflections = new Reflections("com.example.demo");
        Set<Class<?>> documentClasses = reflections.getTypesAnnotatedWith(Document.class);

        System.out.println("Found @Document classes: " + documentClasses);

        for (Class<?> documentClass : documentClasses) {
            System.out.println("Processing document class: " + documentClass.getSimpleName());
            if (!mongoTemplate.collectionExists(documentClass)) {
                mongoTemplate.createCollection(documentClass);
                System.out.println("Created collection for: " + documentClass.getSimpleName());
            } else {
                System.out.println("Collection already exists for: " + documentClass.getSimpleName());
            }
        }
    }

}
