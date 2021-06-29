# POEI Full Stack Java - Méthodes Agiles  [Jour 1/57]

## Introduction aux méthodes Agiles

- XP et Scrum sont les principales méthodes Agiles

**User Stories** : les besoins du client
Les US sont notées dans un logiciel de gestion de projet de type Jira par exmple.

Implication du client et de l'équipe
Meilleure gestion de l'équipe grâce à la communication entre le client et l'équipe de développement.

Estimation du temps que prendra une tâche particulière.

Provient du *masnifeste Agile* publié en 2001 qui déploie 4 valeurs clefs :

1. Se focaliser sur personnes et interactions
2. Opter pour des logiciels fonctionnels
3. Favoriser la collaboration avec le client
4. S'adapater au changement selon les besoins du client

## Introduction à Scrum

C'est un *concept*, une *méthode* de dev basé sur l'agilité.
Un *projet informatique* est une demande émanant d'un client qui répond à un cahier de charges de fonctionnalités.

- **Backlog du produit** : liste des fonctionnalitées demandées par le client, aka *User Stories* classée selon un ordre de priorité.
- **Product Owner** : c'est le *chef de projet* qui écrit les Users Stories à réaliser pour un sprint donné.
- **Sprint** : itération ou phase de développement du logiciel, qui varie entre 1 et 4 semaines. A la fin de chaque sprint, on doit avoir une version du produit livrable qui a été testé et sans bugs. Une durée constante de sprint apporte un meilleur rythme.
- **Daily meetings** : Mêlées quotidiennes ou *stand-up meetings*, réunion journalière où toute l'équipe présente à son tour ce qu'il a fait et ce qu'il va faire durant la journée. On peut aussi présenter ses problèmes rencontrés.

Objectif de Scrum : méthode *itérative* et *incrémentale* pour satisfaire au mieux les besoins du cleint et maximiser les chances de réussite du projet.

![principe](https://laurine-parmentier.fr/wp-content/uploads/2020/02/15067158503807_scrum_pratiques.png)

La méthode Agile la plus utilisée est Scrum mais il y a aussi eXtreme Programming (XP)

### Théorie de la méthode Scrum

#### Pilliers

1. Transparence vis à vis des collaborateurs
2. Inspection
3. Adaptation par rapport aux délais des US

#### Cadre SCRUM

1. Equipes Scrum
2. Blocs de temps
3. Artefacts (liste des tâches)
4. Règles

#### Logiciel de gestion de projet : Jira

La création des US et de l'organisation du sprint sur Jira se fait notamment par le Scrum Master
On peut aussi voir la liste des tickets en cours, la liste des tickets restants à faire etc.
Jira peut être aussi lié à Git pour lier les commits, les changements de code effectués avec les US.

![exemple de projet Jira](https://valiantys.com/app/uploads/2016/03/Backlog@2x.png)

### Contenu de la méthode Scrum

1. **Equipe Scrum**

    Généralement une équipe de 5 à 10 personnes qui ne change pas durant un sprint. Cette équipe comporte :
    - **Product Owner** : représente le client. C'est lui qui définit les fonctionnalités du produit, choisit la date et le contenu des releases et est responsable du retour sur investissement. Il définit les priorités dans le backlog en fonctionne de la valeur "métier" et il ajuste les fonctionnalités et les priorités de chaque sprint si nécessaire.
    - **Scrum Master** : responsable de l'équipe Scrum qui veille au bon déroulement des itérations (délais...). Le Scrum Master gère le backlog avec le PO, et la bonne exécution des sprints. Il a plutôt un rôle de suivi.
    - **Team members** : représente les dev, les testeurs (MOA) et les DevOps si jamais il y en a.

    Le Product Owner peut gérer plus de choses que le Scrum Master.

2. **Blocs de temps**

    - **Réunion de planification de la livraison** : sélection des tâches et de la durée du sprint si jamais elle change. Découper les US du backlog selon la durée du sprint.
    - **Réunion de planification du sprint** : estimation du nombre de tâches totales en heures suivant le nombre de devs présents. Puis sélection des US à réaliser durant le sprint. Les estimations sont de plus en plus réalistes avec l'expérience des dev et le temps.
    - Le **sprint** en lui-même (cf. section suivante, Jira)
    - **Daily Meeting** : réunion chaque matin en étant debout présentant les remarques, problèmes de la veille et présenter les tâches du jour. Permet une bonne visibilité des tâches de chacun.
    A la fin du sprint, en fin de semaine :
    - **Revue du sprint** : clotûre du sprint en cours. Revue des TU, du code, des TI et préparation de la livraison du produit.
    - **Rétrospective du sprint** : qu'est-ce qui a fonctionné, qu'est-ce qui n'a pas été ? Tirer parti des conclusions du sprint qui vient de s'achever

3. **Artefacts (liste des tâches)**

    - Carnet de produit
    - Carnet de sprint
    - Graphique de progression (burndown chart)
    - Graphique de progression de la livraison de la nouvelle version (release burndown chart)
    - Graphique de progression du sprint (sprint burndown chart)

    ![burndown chart](https://upload.wikimedia.org/wikipedia/commons/thumb/8/8e/SampleBurndownChart.svg/1920px-SampleBurndownChart.svg.png)

    Quelques uns de ces graphiques sont disponibles dans Jira.

    ![vue générale](https://bubbleplan.net/blog/wp-content/uploads/2018/05/430.jpeg)

4. **Les règles de Scrum**

Liaison entre les blocs de temps, les rôles et les artéfacts.
ex : seuls les membres de l'équipe peuvent prendre la parole durant les daily meetings.
Tirer parti du sprint pour présenter ses problèmes rencontrés sans attendre de chercher longtemps par soi-même. Ne pas avoir honte de demander de l'aide aux dev séniors.

### Conclusion de la méthodologie Scrum

Scrum doit être conforme au principe m^mee de l'Agilité.
Accentuation sur :

- l'auto-organisation de l'équipe
- pouvoir de décision donné à l'équipe
- délais fixes
- sprint en isolement
- réunions quotidiennes
- livrer un logiciel fonctionnel et démonstration du résultat du sprint
- planning adaptatif

Les équipes Scrum font un peu de tout tout le temps entre exigences du projet (demandes du client ou SAD (Spécifications Avant Développement)), conception (problématiques), développement du logiciel et enfin tests de la version (TU, TI, E2E, Acceptance Testing, Production Testing, API Testing...)

## Planification d'un projet

Pour planifier les releases d'un logiciel, il faut prévoir de les livrer à l'issue de généralement plusieurs sprints. Cette planification s'effectue par le Scrum Master et le Product Owner.

Le **backlog** est généralement produit par le Product Owner,  jusqu'à avoir une version stable suivant la stratégie suivie par l'équipe.

La planification s'effectue aussi grâce à un roadmap qui stipule les fonctionnalités futures à développer au cours de plusieurs sprints et donc les futures versions du logiciel à livrer.

Les corrections de bugs ainsi que les nouvelles tâches sont tous les deux regroupés dans chaque sprint. Il faut prioriser les tâches à faire.

La planification initiale est affinée à chaque itération (sprint) en fonction de l'avancement et des problèmes rencontrés et de l'expérience.

![vue globale Scrum](https://upload.wikimedia.org/wikipedia/commons/8/89/VueGlobaleScrum.png)

## Responsabilités

- Le product owner effectue la gestion des besoins (product backlog), il faut toute la planification ainsi que l'estimation du temps
- Le scrum master s'occupe de toute la gestion du projet dans sa globalité
- La team écrit les recettes, et exécute les tests de recette. Les tests unitaires , le code et la conception sont aussi créés par l'équipe des dev

![responsabilités](https://image.slidesharecdn.com/oeildecoachscrumroles-et-responsabilitesv1-180326180740/95/oeildecoach-scrum-rolesetresponsabilites-3-638.jpg?cb=1534187827)

----------------------
@author : Karine Dias
