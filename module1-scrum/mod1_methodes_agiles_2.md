# POEI Full Stack Java - Méthodes Agiles n° 2 [Jour 2/57]

## Planification d'un sprint

**Périmètre du sprint** : analyser et évalue le backlog et définir le but du sprint en cours
**Plan d'action du sprint** : décider comment s'y prendre (conception), créer la liste des tâches à partir des éléments du backlog de produit, estimer la durée des tâches (en heures).

## Les besoins de l'équipe Scrum

Scrum est basé sur des réunions de planification et revue du sprint, rétrospective et daily meetings.
Si jamais les tickets sont finis avant la fin du sprint, il est possible de s'attarder sur la couverture du code, la qualité du code (refactoring) ou encore la documentation du code.

**Backlog de produit** : liste des exigences produit exprimées sous la forme d'user stories (US), càd les besoins de l'utilisateur.
La complexité du backlog de produit est estimée par l'équipe Scrum par rapport à un item de référence et sur une échelle issue de la suite de Fibonacci (Poker planning)
![poker planning cards](http://www.agilebuddha.com/wp-content/uploads/2020/06/3c1643d431a2080d720153793904e7b4.png)

La complexité est utilisée pour calculer la priorité de chaque tâche du product backlog. On peut aussi exprimer la notation de la complexité d'une tâche en heures de travail.

A partir d'un backlog produit, on peut ainsi convertir chaque tâche à réaliser en US. Chaque ticket créé reflétera une US.

![exemple de backlog produit](https://d2slcw3kip6qmk.cloudfront.net/marketing/blog/2019Q3/product-backlog/product-backlog-example.png)

**But du sprint** : énoncé de sur quoi le travail va essentiellement porter durant le sprint. Exemple : "database application" &#8594; faire tourner l'appli sur une base MySQL en plus d'Oracle.

**Vie du backlog de sprint** : un backlog définit quelles tâches seront réalisées durant le sprint. Durant un sprint, chacun s'engage sur le travail qu'il choisit, le travail n'est jamais assigné par un autre. L'estimation du reste à faire est ajustée tous les jours. N'importe qui peut ajouter, supprimer ou changer le backlog de sprint.
Si une tâche à faire n'est pas correctement définie, on peut la décomposer en plusieurs petites tâches. N'importe qui peut modifier le backlog du sprint.
Une fois que les tâches sont finies, il faudra les déplacer dans la colonne *DONE* dans le tableau de bord des tâches.

On peut aussi faire des *POC*, Proof Of Concept : vérifier qu'une théorie, un concept ou encore une idée (la plupart du temps innovant) "peut fonctionner" d'un point de vue marketing, économique ou technique.

L'estimation doit souvent être revue à la hausse. Plus les risques d'un projet donné sont importants, plus il faut revoir l'estimation de la durée de traitement des tâches à la hausse (le doubler par exemple).

La MAJ du travail restant se fait au fur et à mesure lorsqu'il devient un peu plus identifiée.
On peut aussi faire du *pair-programming* si jamais une tâche est très complexe. Ou dans un contexte d'apprentissage.

## Principes du manifeste Agile

1. **Satisfaire le client**

    - Il faut livrer des fonctionnalités rapidement et régulièrement à grande valeur ajoutée (pas que de la résolution de bugs par exemple)

2. **Accueillir positivement les changements de besoins**

    - Même si les changements arrivent tard pendant le projet, il faut s'adapter, car rien n'est figé. Les process Agiles exploitent le changement pour donner un avantage compétitif au client.

3. **Livrer fréquemment les fonctionnalités**

    - Il faut un logiciel opérationnel avec des cycles de vie de quelques semaines à quelques mois avec une préférence pour des cycles de release courts.

4. **Simplicité**

   - C'est l'art de minimiser la quantité de travail inutile, d'empêcher l'apparition de bugs difficiles à corriger dûs à la complexité du code et une meilleure maintenance.

5. **Meilleure architecture**

   - Spécifications et conceptions émergent d'équipes qui s'auto-organisent. Il faut sans cesse se remettre en question et savoir si les dernières technologies sont utilisées.

6. **Être efficace**

7. **Travailler ensemble**

    - Les utilisateurs et leurs représentants doivent travailler ensemble quotidiennement tout au long du projet.

8. **Motivation**

   - Avoir un environnement stimulant et le soutien dont les membres de l'équipe ont besoin pour atteindre l'objectif fixé.

9. **Communication**

    - Transmettre l'information à l'équipe de développement et dans celle-ci le moyen le plus simple de maintenir le dialogue est de se parler en face à face.

10. **Logiciel opérationnel**

    - C'est la principale mesure d'avancement

11. **Rythme de développement soutenable**

    - Les commanditaires, les développeurs  et les utilisateurs doivent être capables de maintenir indéfiniment un rythme constant.

12. **Excellence technique**

    - Une attention continue à l'excellence technique et une bonne conception du projet renforce l'Agilité (produit à jour etc.)

## Planification du sprint

Le déroulement du sprint dans le temps se base sur ce graphique ci :
![planification sprint](https://www.visual-paradigm.com/servlet/editor-content/scrum/what-is-product-backlog-in-scrum/sites/7/2018/12/scrum-sprint-progress.png)

### Avant la 1ère itération

- Estimation : utilisation du planning poker.
- Planification : le planning permet à l'équipe de souffler entre 2 sprints. Par exemple démo & rétrospective le vendredi matin pour le sprint N et planification du sprint N+1 le lundi matin. Garder une demi-journée de libre pour de la veille technique.

Les estimations et la planification se basent sur le calcul de la vélocité. Cette vélocité estimée grâce au nombre de jour/homme disponibles x <b style="color:#538b01">Coefficient d'effort</b>

Le <b style="color:#538b01"> coefficient d'effort</b> est une estimation sur la concentration de l'équipe. Il peut être évalue à partir des sprints précédents.

Il faut définir des aspects contractuels d'un projet Agile :
    - le **prix** du projet (plutôt une estimation du rapport qualité/prix) est borné mais le client peut changer d'avis en cours de projet.
    - le **périmètre** des fonctionnalités tracé de manière collaborative (le backlog produit est initialisé conjointement entre le client et le fournisseur)
    - le **budget** et la date de livraison du produit final fixés par le client
    - le **délai** mis pour livrer un projet définitif
    - la **qualité** du projet livré

Pour le client, la méthode Agile Scrum permet de définir clairement le projet et les priorités associées et d'obtenir à la fin de chaque itération de sprint un produit fonctionnel. Les bénéfices d'une telle méthode sont une plus grande confiance entre les deux parties (client & fournisseur). Ceux-ci sont donc complémentaires.
Un contrat Agile est basé sur l'engagement du fournisseur à délivrer un produit avec des critères de qualité. Le développement peut s'arrêter à tout moment à la fin d'une itération/sprint.

Afin que le projet se passe au mieux, il faut éviter l'individualisme afin d'améliorer la communication. Chaque équipe a son lot de responsabilités, pas de responsabilité individuelle. Le processus Agile est avant tout un processus d'amélioration permanente.

### Le sprint

Si jamais la méthode Scrum n'est pas encore mise en place dans l'entreprise, il est nécessaire de faire un **Sprint 0**, c'est un sprint de démarrage de la mise en place de la méthode Scrum, une sorte de sprint "test".

#### 1ère partie

    - engagement de l'équipe
    - définition des enjeux du sprint
    - participants : Product Owner, Scrum Master et la team

#### 2ème partie

    - 1 item = 1 tâche
    - Définir le temps par chaque
    - participants : Scrum Master et la team

L'équipe choisit à partir du backlog produit les éléments qu'il faut finir. Le backlog de sprint est ainsi créé, les tâches sont donc identifiées et estimées en terme de durée de manière collective.

Une fois le sprint en cours terminé, la dernière version livrable du logiciel pourra être livrée au product owner à la fin du sprint, une fois le dernier build en cours testé et terminé.

## Mesure de l'Agilité

### Vélocité

Il s'agit de la part du product backlog dont l'équipe peut s'occuper durant un sprint donné.
La vélocité peut s'estimer en regardant les sprints précédents à supposer que la composition ede l'équipe et la durées des sprints soient stables.
La vélocité une fois établie est utilisée pour planifier les projets et prévoir les dates de release et de finalisation du produit.

La vélocité estimée n'est pas la même que la vélocité effective (réelle).

### Indicateurs Agile

Estimation en points d'une story est faite de manière collective. Les estimations de taille ou de durée sont faites par ceux qui réalisent.
L'estimation se base sur des mesures, par ex la capacité de l'équipe est estimée à partir de la mesure de la vélocité des sprints passés.
Publier les indicateurs sous forme d'un historique de vélocité. Il sont donc transparents et restent publics.

La **vélocité** est une mesure basée sur les sprints passés.
La **capacité** est une prévision basée sur les sprints futurs.
Un **périmètre de sprint** est fixé suivant :
    - la taille du backlog
    - la capacité de l'équipe en terme de personnes
    - la durée d'un sprint
    - une indication sur la date de fin de projet

### Sprint review

Valider le produit pendant le sprint
Faire une démonstration de la tâche réalisée
Valider la nouvelle version pour qu'elle soit pleinement utilisable

### Amélioration continue

C'est un principe qui se base sur le feedback du(des) client(s).
L'amélioration continue passe à la fois par la rétrospective et les retours d'expérience du client.

La **rétrospective du sprint** aide à réfléchir régulièrement sur ce qui fonctionne et les problèmes rencontrés. La rétrospective s'effectue à chaque fin de sprint et tout l'équipe y participe (Scrum Master, Directeur Produit, l'équipe et éventuellement les clients)

----------------------
@author : Karine Dias
