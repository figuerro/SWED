# Schritt 1: Das Basis-Image mit Java definieren
FROM openjdk:11-jdk-slim

# Schritt 2: Das Arbeitsverzeichnis im Container festlegen
WORKDIR /app

# Schritt 3: Alle .java-Dateien in den Container kopieren
COPY *.java /app/

# Schritt 4: Den Java-Code im Container kompilieren
RUN javac *.java

# Schritt 5: Den Befehl festlegen, der beim Start ausgeführt wird
ENTRYPOINT ["java", "WebsiteMonitorApp"]

