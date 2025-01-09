# Utiliser une image Java comme base
FROM openjdk:21-jdk-slim

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le JAR de votre application dans le conteneur
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Exposer le port sur lequel l'application écoute
EXPOSE 8080

# Commande pour démarrer l'application
ENTRYPOINT ["java", "-jar", "app.jar"]
