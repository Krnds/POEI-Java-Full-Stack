# POEI Full Stack Java - MySQL

## Configuration et administration du serveur de BDD

## Import & export des BDD

Il faut lancer cette commande

```bash
mysqldump -u user -p --opt bdd_name > nom_sauvegarde.sql

mysqldump -u user -p --opt bdd_name < bdd_name2.sql // copier 1ere BDD dans la 2nde
```

### BDD MySQL

Bdd interne du serveur, destinée à gérer les utilisateurs et leurs droits d'accès. Fichier de type '.iod'
Pour lancer le serveur :

```sh
service mysql start/stop
```

Avec XAMPP, tout ceci est fait via le GUI.

### Gestion des utilisateurs

```sql
CREATE USER 'm2i'@'localhost' IDENTIFIED BY 'm2i_pass'

Pour se connecter, il faut utiliser
mysql.exe -u m2i -p"m2i_pass" -- pas d'espace entre l'option -p et le mdp --

-- On aura accès qu'à certaines bases de données --
GRANT ALL PRIVILEGES on elevage.* TO 'm2i'@localhost WITH GRAND OPTION;
FLUSH PRIVILEGES -- permet de valider les changements --
SHOW DATABASES; -- permet de voir les BDD auxquelles on a accès --
DROP USER user1;
DROP USER user1@%;
```

### Fichier de configuration

### Logs

log-error :

### Bind adress

### Réparation des tables

Pour réparer les tables corrompues, il faut faire :

```sql
CHECK TABLE table1;
REPAIR TABLE table1;
```

## Algèbre relationnel

Concepts qui ont permis de construire le langage SQL.
C'est un langage procédural permet de construire une nouvelle relation à partir d'une ou de plusieurs relations existantes.

C'est aussi un langage abstrait  avec des opérations qui utilisent une ou plusieurs relations pour définir une nouvelle relation sans changer la ou les relations originales.
Le résultat de toute opération effectuée sur une BDD s'appelle une relation.

### opérations fondamentales

- la sélections
- la projection
- le produit cartésien : R x S
- l'union
- la différence
- jointures
- intersection
- division

En langage UML, il faut <ins>souligner</ins> la clef primaire d'une table. Une clef étrangère se nomme : `fk_colonne_clef_etrangere`

MySQL n'implémente pas INTERSECT, il faut utiliser à la place IN avec des requêtes imbriquées :

```sql
SELECT DISTINCT records.id
FROM records
WHERE records.firstname IN (
    select id from data where value = 'john'
) AND records.lastname IN (
    select id from data where value = 'smith'
)
```

#### Opérateur PROJECT

Permet de sélectionner certaines colonnes d'une relation

SELECT prenom, nom FROM etudiants
UNION/INTERSECT
SELECT prenom, nom as nom2
from etudiants2
ORDER BY nom;

## Conception d'une BDD

1. Analyse des besoins

    - Recueil des besoins et de la situation existante
    - Création d'une série de modèles conceptuels pour représenter tous les aspects importants du problème

2. Implementation du SGDB
    - Transformation du modèle conceptuel en modèle logique
    - Conception de la BDD dans un SGBD à partir du modèle logique

## Cardinalités

### Cardinalité 1,1

One-to-one

### Cardinalité 0, n

Zero-to-many

### Cardinalité 1, n

One-to-many

### Cardinalité n, n

Many-to-many

## MCD : Modèle Conceptuel de Données

cf. Gliffy ou sinon [App Diagrams](https://app.diagrams.net/)

UML VS modèle Merise
 en UML les cardinalités sont inversées càd qu'elles sont notées à côté de la classe à relier et non de la classe actuelle.

### Transformation des entités faibles

Mettre la clef dans l'entité faible de la relation

### Transformation des associations binaires monovaluées

Clef associée à E1 --> attribut de E2
Attributs de association --> attributs de E2

Utiliser des tables d'association quand on a une relation many-to-many ou des attributs entre les relations

## Procedural Language/SQL (PL/SQL)

Les **Procédures stockées** existent pour créées des tables temporaires ou faire des grosses manipulations de données. Les procédures peuvent aussi servir pour se protéger des injections SQL.
Elles doivent être utilisées à défaut d'avoir des requêtes SQL qui suffisent pour réaliser une tâche.
Les procédures stockées permettent de réduire les allers-retours entre le client et le serveur, de sécuriser la BDD en restreignant les droits des users pour qu'ils puissent uniquement exécuter des procédures et non les supprimer par exemple.
Cependant les PS ajoutent de la charge mémoire au serveur et de charge processeur.

CREATE PROCEDURE nom_procedure ([parametre1 [, parametre2, ...]])
<body of_procedure>

BEGIN
    SELECT
END;
Attention, dans les procédures stockées il faut parfois changer le délimiteur, car dans l'exemple ci-dessus, MySQL renverra une erreur car la ligne SELECT [...] se finit par `;` ce qui mettra un terme à l'éxécution.

```sql
DELIMITER | -- On change le délimiteur par défaut pour éviter que l'éxécution n'aille pas jusqu'au bout --
CREATE PROCEDURE afficher_races() -- pas de paramètres --
BEGIN
SELECT `id`, `nom`, `espece_id`, `prix`
FROM Race;
END| -- terminer la procédure par le délimiteur modifié --
DELIMITER ; -- on peut remettre le délimiteur par défaut pour éviter des erreurs ultérieures --
```

### Paramètres des procédures

Les paramètres (dans le sens argument comme en programmation) possède 3 éléments de syntaxe :

1. Son **sens** (entrant, sortant ou les deux)
2. Son **nom**
3. Son **type** (INT, VARCHAR(10), DATETIME etc.)

La bonne pratique est de créér des paramètres qui ont un nom qui préfixé par p_, comme `p_monparametre`

#### IN

Paramètre entrant de la procédure, toujours en mode read-only.

#### OUT

Un paramètre passé en mode `OUT` est utilisé pour renvoyer des infos de la procédure à un autre programme qui l'appelle. C'est un paramètre en mode write-only qui n'a pas de valeur si aucune attribution dans la procédure.
La variable `OUT` est créée mais non initialisée lorsque la procédure est appelée. La valeur du paramètre `OUT` est copié dans une autre valeur passée dans l'appel de la procédure.

#### INOUT

Caractéristiques de `ÌN` et `OUT` à la fois. La valeur du paramètre est transmis et peut-être lu par la procédure. La procédure peut également modifier la valeur et celle-ci sera recopiée dans la variable passée à la fin de la procédure.

#### Procédure avec 2 paramètres

```sql
DELIMITER |
CREATE PROCEDURE nom_procedure (p_espece_id INT, OUT p_nb_races INT)
BEGIN
    SELECT COUNT(*) INTO p_nb_races -- résultat dispo dans var p_nb_races --
    FROM race
    WHERE espece_id = p_espece_id;
END |
DELIMITER ;
```

Pour appeler la procédure créée, il faut l'appeler :

```sql
CALL nom_procedure(2, @nb_races)
SET @nb_races := 0; -- déclaration de variable --
SET @espece_id := 1;
SELECT @nb_races -- équivalent de print/echo --
```

```sql
SET @prix = 0; -- On initialise @prix à 0

CALL calculer_prix (13, @prix); -- Achat de Rouquine, id = 13
SELECT @prix AS prix_intermediaire;

CALL calculer_prix (24, @prix); -- Achat de Cartouche, id = 24
SELECT @prix AS prix_intermediaire;
CALL calculer_prix (42, @prix); -- Achat de Bilba, id = 42
SELECT @prix AS prix_intermediaire;

CALL calculer_prix (75, @prix); -- Achat de Mimi, id = 75
SELECT @prix AS total;
```

On ne peut pas modifier une procédure directement, il faut au préalable la supprimer puis la réécrire. On a la fonction `ALTER PROCEDURE` ou `REPLACE PROCEDURE` dans d'autres SGBD.

```sql
DROP PROCEDURE nom_procedure;
```

On peut aussi utiliser des *variables locales* avec `DECLARE` au tout début du bloc d'instructions dans lequel sera utilisée celle-ci.

```sql
DELIMITER |
CREATE PROCEDURE blabla()
BEGIN
    DECLARE ma_variable DATE DEFAULT CURRENT_DATE();
    SELECT DATE_FORMAT(v_date, '%W %e %M %Y') AS aujourdhui;
END |
DELIMITER ;
```

### Conditions

#### IF

```sql
IF condition THEN instruction
ELSEIF autre_condition THEN instruction
ELSEIF ...
ELSE instruction
END IF; -- obligatoire --
```

#### CASE

```sql
CASE valeur_a_comparer
    WHEN possibilite1 THEN instruction
    WHEN possibilite2 THEN instruction
    ELSE instruction
END CASE;
```

On remarquera l'absence de clause ``BREAK``, ceci n'existe pas en PL/SQL. On peut aussi utiliser `CASE` en dehors des procédures, dans le cas de l'utilisation dans une requête, il faut clôturer le `CASE` par un `END` seul, sans `END CASE`.

### Boucles

#### WHILE
- [ ] todo

### LOOP
- [ ] todo

#### REPEAT
- [ ] todo

## Gestion d'erreur

```sql
DELIMITER |
BEGIN
CREATE PROCEDURE blabla...
BEGIN
    DECLARE EXIT HANDLER FOR SQLSTATE 'code_erreur'
        BEGIN
            SELECT 'une erreur est survenue...';
            SELECT 'arrêt prématuré de la procédure';
        END;
END |
DELIMITER ;
```

## Curseurs

Permettent de parcourir un jeu de résultats provenant d'une requête `SELECT` avec l'instruction `DECLARE`.

- declaration du curseur `DECLARE`
- ouverture du curseur (exécution de la requête SELECT) `OPEN CURSOR`
- parcours du curseur `FETCH`
- fermeture du curseur `CLOSE CURSOR`

```sql
DECLARE nom_curseur CURSOR
FOR requete_select;
FROM table;
```

### Exercices d'entraînement

1. Insérer dans une table nommée res(no) tous les chiffres allant de 0 à 100.

```sql
DROP PROCEDURE IF EXISTS inserer_numero;

DELIMITER $$
CREATE PROCEDURE inserer_numero(
    p_debut INT,
    p_fin INT
)
BEGIN
    WHILE p_debut < p_fin DO
        SET p_debut = p_debut + 1;
        INSERT INTO `res(no)` VALUES(p_debut);
    END WHILE;
END$$
DELIMITER ;

CALL inserer_numero(0, 100);
```

On peut aussi faire un LOOP/END LOOP voire un REPEAT INSERT INTO UNTIL min > max END REPEAT

```sql
DECLARE nb NUMBER := 1;
BEGIN
    LOOP
		INSERT INTO RES
		VALUES(nb);
		nb = nb + 1;
	EXIT WHEN nb > 100;
	END LOOP
END
```

2. Faire la somme de tous les nombres compris entre 1000 et 10000

```sql
DROP PROCEDURE IF EXISTS somme_numero;
DELIMITER $$
CREATE PROCEDURE somme_numero(IN p_nb_inf INT,
   IN p_nb_sup INT,
	OUT result INT)
BEGIN
	DECLARE result INT DEFAULT 0;
	WHILE p_nb_inf < p_nb_sup DO
		SET result = result + p_nb_inf;
		SET p_nb_inf = p_nb_inf + 1;
	END WHILE;
SELECT  result;
END $$

DELIMITER ;

CALL somme_numero(1000, 10000, @res);
-- the result --
SELECT @res;
```

## Transactions

Queries VS transactions :

> Queries are operations to CRUD (create (insert), update (set), read (select), delete (delete)) data inside a table.
> The transaction is more or less the process of a single or multiple statements/queries/operations getting executed.

```sql
COMMIT -- save the changes --
ROLLBACK -- roll back the changes --
SAVEPOINT -- creates points within the groups of transactions in which to ROLLBACK --
SET TRANSACTION -- Places a name on a transaction --
```

## triggers

Ils servent à mettre une contrainte ou une vérification des données.
Ce sont des déclencheurs d'exécution d'instructions ou d'un bloc d'instructions.
Il n'est pas possible d'appeler un trigger, celui-ci doit être déclenché par un évènement.

On peut vérifier l'intégrité des données ou pour remplacer les options des clefs étrangères avec les clauses

```sql
CREATE TRIGGER nom_trigger AFTER INSERT --quand il est déclenché --
ON table FOR EACH ROW
corps_trigger;
```

On ne peut avoir qu'un seul trigger par combinaison moment_trigger (AFTER/BEFORE) par évènement trigger (INSERT/DELETE/UPDATE) d'une table. Soit un maximum de 6 triggers (2x3) par table.

## Enum

Par exemple pour une colonne `sexe` on peut définir une énumération pour avoir uniquement les valeurs possibles M/F

## Vues

Les vues sont utilisées pour clarifier et faciliter les requêtes.

```sql
CREATE [OR REPLACE] VIEW name_view
AS requete_select;
```

Une vue en MySQL est considéré comme une table, d'où la possibilité d'utiliser `ALTER VIEW`
