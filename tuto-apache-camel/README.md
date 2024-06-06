
Ce projet contient quelques exemples d’utilisation de Apache Camel

* Quelques classes inspirées du tuto Baeldung ["Apache Camel Intro"](https://www.baeldung.com/apache-camel-intro) sur les différents format DSL à lancer via les tests junit :
    * Tests via junit `ApacheCamelTest`pour les ressources SpringDSL ou/et JavaDSL utilisant les classes
        * `ProcesseurContenuFichier`
        * `ProcesseurNomFichier`
        * `RouteurFichier2`
    * Les tests utilisent et génèrent des fichiers source et destination dans `src/test/dossiers`
* Quelques classes d’exercice pour utiliser Camel : 
    * avec des Timer : `TestTimer`
    * avec ActiveMQ
        * un docker ActiveMQ doit être activé :
            * `docker run --rm --name mon-activemq -p 61616:61616 -p 8161:8161 rmohr/activemq`
            * accès à la console ActiveMQ via http://localhost:8161 (admin/admin)
        * Queue : `ActiveMQQueueProducteur`, `ActiveMQQueueConsommateur`
        * Topics : `ActiveMQTopicProducteur`, `ActiveMQTopicSouscripteur`
        * 
        * ...
* 