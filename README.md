# POEI Java Full Stack

## Module1 : Méthodes Agiles (Scrum, XP)

[Notes sur les méhodes Agiles](https://github.com/Krnds/POEI-Java-Full-Stack/tree/master/module1)

## Module2 : SGDBR (MySQL)

- [ ] TODO: mettre le lien

Création des requêtes avec SQL
Création de fonctions grâce au langage déclaratif PL/SQL
Administration des bases de données

## Module3 : Outils DevOps (Jenkins, Ansible, Docker)

Automatiser les livraisons grâce à des outils d'Intégration Continue (CI)

Jenkins : lancer des builds (scripts) pour automatiser l'éxécution de versions d'applications.
Les collaborateurs ont des machines avec un OS, des versions de logiciels etc.
Un build peut se lancer manuellement (ouvrir le script et le lancer en ligne de commande, Jenkins permet d'automatiser les tâches grâce à la création d'un build ou pour lancer des TU (Tests Unitaires).
TU : test automatique d'une fonctionnalité spécifique, ne doit tester qu'une partie dite unitaire, qui n'a qu'une seule fonctionnalité dans le code.

Les TU permettent d'évaluer la qualité du code en repérant déjà les répétitions de code, de repérer en amont les bugs avant de lancer une application.

Docker permet de construire des environnements déjà prêts, avec un OS particulier, des versions de logiciels contrôlés et des bases de données déjà configurées. Une image est créée avec Docker, par exemple avec SQL et Java. Une sorte de snapshot de machine virtuelle sans le désavantage de la lourdeur niveau mémoire.

## Les systèmes de gestion de version : Git & SVN

Validation des tâches, intégrer le code d'autres dev, tester et  en équipe.

## Programmation Orientée Objet

Propriétés particulières telles que l'héritage, l'abstraction , l'encapsulation, le polymorphisme etc.
Communication avec une base de données.
Page de login
Tests unitaires avec JUnit5
TDD (Test Driven Develoment), créér les TU avant d'écrire le code de la fonctionnalité

## HTML5/CSS3 sans framework

Connaissances sur les nouvelles fonctionnalités d'HTML5
Création de pages web

## ORM (Object Relationnal Mapping) avec JPA et l'implementation Hibernate

Communication avec un SGDB sans passer par des requêtes SQL
Récupération de tableaux et de listes

## Web Services (API Rest notamment)

Communication entre une application et un serveur web
Les WS permettent de récupérer des informations à partir d'un logiciel grâce à une API.
Utilisation des formats JSON (JavaScript Object Notation) et XML (moins utilisé, plutôt pour les réservations)

## Framework MVC Spring

Model View Controler :

- Model permet communiquer avec la BDD (ex : Hibernate)
- Vue partie template affichée en front à l'utilisateur (Bootstrap, Angular mais au début plutôt JSP (Java Server Pages))
- Controler regroupe toute la logique, exécution des tâches (Java)

## JavaScript

1. Framework Bootstrap version 5 (basé sur CSS) pour gérer l'interface graphique
2. Bases de JavaScript avec JQuery (permet de simplifier le JS, d'avoir accès à l'AJAX)

## Angular

- Installation avec NodeJS
- Apprentissage de TypeScript
- Communication avec des BDD grâce à des API

## Modalités de la formation

+ IDE : VSCode et NetBeans (pratique pour les configurations)
+ Journées de Travaux Pratiques (TP) insérées durant la formation
+ Evaluations notées
+ QCM à la fin de chaque modules