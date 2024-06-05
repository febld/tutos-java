Projet java OSGI basé sur le tuto Baeldung ["Introduction to OSGI"](https://www.baeldung.com/osgi)

Requiert l’installation de Apache Karaf https://karaf.apache.org/get-started.html


# Compilation

````
cd tuto-osgi-service
mvn clean install
cd ../tuto-osgi-client
mvn clean install
````

# Tests dans Karaf


````
~> $KARAF_HOME/bin/karaf start

karaf@root()> bundle:install mvn:feb.tutos/tuto-osgi-service/1.0-SNAPSHOT
Bundle ID: 57

karaf@root()> bundle:start 57
Enregistrement service.

karaf@root()> bundle:stop 57
Désinscription du service.

karaf@root()> bundle:list
START LEVEL 100 , List Threshold: 50
ID │ State    │ Lvl │ Version        │ Name
───┼──────────┼─────┼────────────────┼────────────────────────────────────────────────────────────────────────────────────────────────────
33 │ Active   │  80 │ 4.4.6          │ Apache Karaf :: OSGi Services :: Event
57 │ Resolved │  80 │ 1.0.0.SNAPSHOT │ tuto-osgi-service

karaf@root()> bundle:install mvn:feb.tutos/tuto-osgi-client/1.0-SNAPSHOT
Bundle ID: 60

karaf@root()> bundle:list
START LEVEL 100 , List Threshold: 50
ID │ State     │ Lvl │ Version        │ Name
───┼───────────┼─────┼────────────────┼───────────────────────────────────────────────────────────────────────────────────────────────────
33 │ Active    │  80 │ 4.4.6          │ Apache Karaf :: OSGi Services :: Event
57 │ Resolved  │  80 │ 1.0.0.SNAPSHOT │ tuto-osgi-service
60 │ Installed │  80 │ 1.0.0.SNAPSHOT │ tuto-osgi-client

karaf@root()> bundle:start 57
Enregistrement service.

karaf@root()> bundle:start 60

karaf@root()> bundle:stop 57
Désinscription du service.
Notification de désinscription du service.

karaf@root()> bundle:start 57
Enregistrement service.
Notification d’inscription du service.
Bonjour Toto
````
