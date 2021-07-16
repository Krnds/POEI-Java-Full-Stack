# POEI Full Stack Java - MySQL

Système de gestion de bases de données relationnelles (SGBDR)
Distribué sous licence GPL et propriétaire
D'autres SGBDR : Oracle, PostgreSQL

MariaDB est un fork de MySQL qui est open-source et libre de droits (GNUPL).

On peut concevoir les bases de données comme un format organisé et hiérarchisé de données en tables comme dans un tableur.Les BDD peuvent contenir un grand nombre d'informations qui peuvent être manipulées et permettent un stockage efficace.

Une BDD contient plusieurs tables constituées de lignes appelées **entrées** et des colonnes appelées **champs**.

| Tables   |      Are      |  Cool |
|----------|:-------------:|------:|
| col 1 is |  left-aligned | $1600 |
| col 2 is |    centered   |   $12 |
| col 3 is | right-aligned |    $1 |

Pour travailler, nous utiliserons **XAMPP** qui bénéficie de MySQL, MariaDB, PHP et Perl.
 > **phpMyAdmin** is a free software tool written in PHP, intended to handle the administration of MySQL over the Web.

Lancer XAMPP, lancer le module `MySQL` sur le port standard `3006`, lancer l'action `Admin` et l'adresse `http://localhost/phpmyadmin/` avec PhpMyAdmin.
Attention de ne pas installer XAMPP sur `C://ProgramFiles` car soucis de droits d'écriture ensuite !
Si jamais une autre instance est en cours avec le port 3006 qui tourne, il faut modifier manuellement le port de PhpMyAdmin en l'incrémentant, ex 3307.

## SGBDR

MySQL : SGDB libre et gratuit
PostgreSQL : SGDB libre et gratuit avec bien plus de fonctionnalités que MySQL
SQLite : libre et gratuit mais mais très léger et très limité en fonctionnalités
Oracle : SGDBR très complet et utilisé par les grandes entreprises mais c'est un logiciel payant
Microsoft SQL Server : SGBD de Microsoft.

***Se référer au tutoriel en ligne*** [tutoriel](https://www.mysqltutorial.org/basic-mysql-tutorial.aspx)

Attention pour la syntaxe, les noms de table et de champs peuvent s'écrire avec des backtick ` mais on peut aussi ne rien utiliser avec PhpMyAdmin.

## Types

### Types numériques

- Nombres entiers :
`TINYINT` : 1 octet, -128 à 127
`SMALLINT`: 2 octets, -32768 à 32767
`MEDIUMINT`: 3 octets
`INT`: 4 octets
`BIGINT`: valeur numérique sur 8 octets

`UNSIGNED`, de type INT mais positif, en gros on peut avoir des valeurs de 0 à 255 (sur un octet)

### Nombres décimaux

`DECIMAL` : DECIMAL(5,3) peut stocker des nombres de 5 chiffres significatifs dont trois après la virgule. ex : 12.354, -54.836, 87.5 ou -60
`NUMERIC`
`FLOAT`
`REAL`
`DOUBLE`

### Types alphanumériques
Stocker un texte court de moins de 255 caractères.
`CHAR` : stocker tjs X caractères en remplissant si nécessaire l'espace vide pour compléter.
`VARCHAR` : stockera jusqu'à X caractères (entre 0 et x) sans stocker des espaces en plus.
Varchar stockera x octets par rapport au nombre de caractères stockés.

Si jamais plus des X caractères spécifiés, ceux-ci seront tronqués.

Char(5) '' -> 5 octets
Varchar(5) '' -> 1 octet (car c'est un caractère qui permet de gérer la taille)


### Chaîne de caractères

`TINYTEXT` : 2^8 octets (longueur de la chaîne + 1 octet)
`TEXT` : 2^16  (longueur de la chaîne + 2 octets)
`MEDIUMTEXT` : 2^24 octets
``LONGTEXT` : 2^32

### Type binaire

`VARBINARY` : Variable-length binary data avec n le nombre maximum de bytes.

Une chaîne binaire est une suite d'octets, peut être servi pour enregistrer un fichier en base de données. On peut aussi utiliser ce type pour enregistrer une image par exemple.

### Type date

`DATE`  de type YYYY-MM-DD
`DATETIME` de type YYYY-MM-DD HH:MM:SS
`TIMESTAMP` représentation en secondes de la date, `1970-01-01 00:00:01.000000`

## Création d'une BDD

Avec l'outil phpMyAdmin, on peut créer une BDD

Noms de BDD/tables/champs sans accents et sans espaces. ex: `"date_de_naissance"` "prenom". Il faut également définir l'encodage UTF-8.

```sql
CREATE DATABASE elevage CHARACTERSET 'utf-8';
```

pour la supprimer

```sql
DROP DATABASE elevage;
```

### Notion d'interclassement

> Un interclassement (ou collation en Anglais) est un ensemble de règles permettant la comparaison de caractères dans un jeu. Ce paramètre influe donc sur le résultat des tris. MySQL vous propose plusieurs interclassements pour l'UTF-8

### Clefs primaires

Contrainte d'unicité, composé d'une ou plusieurs colonnes. La clef primaire permet d'identifier de manière unique cette ligne dans une table.

Moteurs de table --> spécificité MySQL (MyISAM moteur par défaut) et MariaDB. L'inconvénient de **MyISAM est qu'il ne gère pas les clefs étrangères ou les transactions** par exemple. Les transactions permettent de regrouper des requêtes dans des blocs, et de faire en sorte que tout le bloc soit exécuté en une seule fois, cela afin de préserver l'intégrité des données de la base.

Moteur **InnoDB** plus lent mais il **gère les clefs étrangères et les transactions** mais il est plus performant.

Pour choisir le moteur, il suffit d'ajouter à la fin de la commande de création ENGINE=INNODB;

Attention, on ne peut que avoir une seule clef primaire par table, soit une clef de type 'ID' ou soit une clef primaire combinée avec plusieurs champs de la table.

- [ ] TODO: rechercher les index d'unicité, une seule clef primaire par table

You can only have one primary key, but you can have multiple columns in your primary key.

A Table can have a Composite Primary Key which is a primary key made from two or more columns. For example:

```sql
USE database_name;

CREATE TABLE [IF NOT EXISTS] userdata (
  userid INT,
  userdataid INT,
  info char(200),
  primary key (userid, userdataid)

  [ENGINE=INNODB/MYISAM];
);
```

Pour déplacer des données il vaut mieux utiliser le format SQL.
On peut simplement copier les données d'une machine à une autre en c/c les dossiers de BDD dans Xampp/mysql/data.

pour voir les BDD en ligne de commande on peut faire `show tables`
Pour lister toutes les infos `describe table` ou `show columns from table`

```sql
DESCRIBE table;
SHOW COLUMNS FROM table; 
```

## Syntaxe

```sql
INSERT INTO table (col1, col2, col3) VALUES (val1, val2, val3); -- plutôt pour certaines col données --
INSERT INTO table VALUES (val1, val2, val3. val4, val5); -- toutes les col dans l'ordre de création --
INSERT INTO table (col1, col2, col3, col4, col5) VALUES
  (val1, val2, val3? val4, val5),
  (val1, val2, val3? val4, val5);
  (val1, val2, val3? val4, val5);
```

Attention, en cas de modification des colonnes, il ne faut pas utiliser à postériori la syntaxe :

```sql
INSERT INTO table (col1, col2, col3) VALUES (val1, val2, val3);
```

```sql
ALTER TABLE name ADD col_n TYPE(n) AFTER col_1 DEFAULT X;
ALTER TABLE name DROP col_name;
ALTER TABLE name MODIFY col_name col_name CHAR(5) NOT NULL; -- conversion entre l'ancien type et le nouveau type --
ALTER TABLE name CHANGE col_name new_col_name CHAR(5) NOT NULL; -- renommage possible --
```

On peut aussi utiliser `CHANGE` pour renommer mais avec `MODIFY` ceci n'est pas possible.

Vider une table avec TRUNCATE et réinitialiser le compteur auto-increment
Sélectionner des données à partir d'une table avec le filtre de la clause WHERE

```sql
SELECT * FROM animal WHERE espece='chien';
```

```sql
SELECT * FROM animal WHERE date_naissance < 2008-01-01; -- animaux nés avant 2008 --
```

Combinaisons de filtres

```sql
SELECT * FROM animal 
WHERE espece='chat' AND espece='chien';
-- Toutes les espèces != de chat -- 
SELECT * FROM animal WHERE espece<>'chat';
-- Toutes les lignes avec des espèces de type chat ou chien --
SELECT * FROM animal WHERE espece in ('chat', 'cheval');
```

On peut aussi les opérateurs `IS NULL`, `IS NOT NULL`, <, >, <=, <> (valeur différente de équivalent de !=) `LIKE`, `OR`, `IN`, `BETWEEN`.

Pour l'opérateur `LIKE`, on peut sélectionner des tables selon des filtres de type regex.

SELECT * FROM table WHERE espece LIKE '%at%' récupérera les colonnes 'chat', 'chien'


SELECT * FROM animal WHERE espece LIKE 'ch%';
récupère chien, chat, cheval dont le nom commencer par "ch"

Récupérer les especes dont le nom contient "ch"
'%ch%';

Récupérer les espaces dont le nom contient "ch + un caractère puis la lettre "t" :
'%ch_t%', le tiret bas remplace UN SEUL caractère, n'importe lequel.

Le fait de rechercher des données sur une chaîne de caractères est une opération assez lourde en terme de mémoire.

L'opérateur `IN` permet de déterminer si une valeur spécifique correspond à une valeur quelconque dans un ensemble de valeurs

L'opérateur `BETWEEN` plutôt utilisé pour les dates ou les nombres

```sql
SELECT * FROM animal WHERE id BETWEEN 1 AND 4;
SELECT * FROM animal WHERE date_naissance BETWEEN 2015-01-01 AND 2020-12-31;
```

Le temps de requête est à peu près équivalent avec les commandes BETWEEN et IN.
Côté performance, les opérateurs IN et LIKE sont assez longs, il vaut mieux utiliser l'opérateur EXISTS

## ordre
Notion d'ordre avec les parenthèses :

```sql
SELECT * FROM animal WHERE date_naissance > 2009-07-01 AND (espece = 'chat' OR espece = 'cheval');
```


`ORDER BY`

La clause `offset` permet de spécifier à partir de quelle ligne commence la requête.

```sql
SELECT * FROM animal WHERE date_naissance > 2009-07-01 ORDER BY id ASC/DESC;
LIMIT 10 OFFSET 1; -- limiter les élem affichés à 10 sans compter la ligne 1 -- 
```

## Suppression

```sql
DELETE FROM table
WHERE nom="X"; -- colonne à supprimer --
```

## Modification

```sql
UPDATE table
SET col1=val1 [, col2=val2 etc.]
WHERE col=val;

UPDATE animal SET nom = "loulou" WHERE animal.id = 1;
```

## Directive Explain

Directive `EXPLAIN` + <requête SQL>

> EXPLAIN is used to obtain a query execution plan (that is, an explanation of how MySQL would execute a query).

```sql
SELECT * FROM `villes_france_free` WHERE ville_nom LIKE "ch%" ORDER BY ville_id DESC LIMIT 10;
```

## Index

Utilisés pour accélérer les requêtes (impliquant plusieurs tables ou les requêtes de recherche) et sont indispensables à la création de clefs étrangères et primaires.
Avoir un **index unique** permet de s'assurer de ne jamais jamais la même valeur.

Un **index fulltext** est utilisé pour faire des recherches puissantes et rapides (uniquement via le moteur InnoDB). On utilise que l'index fulltext sur les types CHAR, VARCHAR ou TEXT.
> Full-Text Search in MySQL server lets users run full-text queries against character-based data in MySQL tables. You must create a full-text index on the table before you run full-text queries on a table. The full-text index can include one or more character-based columns in the table.
> FULLTEXT is the index type of full-text index in MySQL.
    InnoDB or MyISAM tables use Full-text indexes.
    Full-text indexes can be created only for VARCHAR, CHAR or TEXT columns.
    A FULLTEXT index definition can be given in the CREATE TABLE statement or can be added later using ALTER TABLE or CREATE INDEX.
    Large data sets without FULLTEXT index is much faster to load data into a table than to load data into a table which has an existing FULLTEXT index. Therefore create the index after loading data.

On peut utiliser un index multi-colonnes quand on utiliser une requête qui utiliser les 2 colonnes à a fois.

```sql
SELECT * FROM departement WHERE departement_code = X AND departement_nom = Y;
```

## Clefs primaires & secondaires

Les clefs sont liées aux index, lors de la création d'une clef, un index est créé. Les clefs font partie des contraintes.

Il y a les clefs **primaires** servent à identifier une ligne de manière unique.

Les clefs **étrangères** permettent de gérer l'intégrité de la BDD.
Une clef étrangère fait référence à une clef primaire dans une autre table.

```sql
ALTER TABLE commande
ADD CONSTRAINT fk_client_numero FOREIGN KEY (client)REFERENCES client(numero);
DROP FOREIGN KEY symbole_contrainte.
```

## Alias

Noms de remplacement donné de manière temporaire à une colonne/table/ligne.
Les alias sont donnés par le mot-clef `AS`. Ils sont surtout utilisés dans les jointures.

## Sous-requêtes

```sql
SELECT id, nom AS nom_animal, year(date_naissance) annee_naisssance FROM animal
```

```sql
SELECT espece.description FROM espece INNER JOINT animal ON espece.id = animal.espece_id WHERE animal.nom = 'bibou';
```

## Jointures

![jointures](https://upload.wikimedia.org/wikipedia/commons/9/9d/SQL_Joins.svg)

### Inner Join ou Join

```sql
SELECT x
FROM table1 -- table de gauche --
[INNER] JOIN table2 -- table de droite --
ON col.table1 = col.table2
WHERE XXXX
ORDER BY xxx
LIMIT
```

Inner join suppose que toutes les valeurs de la table animal ont une correspondance dans la table espece.

### Left join

Toutes les lignes de la première table t1 sont incorporées, si elles n'ont pas de correspondance avec la table t2 alors celle valeur sera assignée à `NULL`.

```sql
SELECT * FROM animal LEFT JOIN espece ON espece WHERE x
```

|    Name   |   Like   |
|:---------:|:--------:|
| Patrik    | Climbing |
| Patrik    | Code     |
| Albert    | NULL     |
| Maria     | Stars    |
| Darwin    | Apples   |
| Elizabeth | NULL     |

### Right join

La même chose mais si les valeurs de la table t2 n'ont pas de correspondance avec la table t1 alors les valeurs de t2 seront assignées à `NULL`

|    Name   |   Like   |
|:---------:|:--------:|
| Maria     | Stars    |
| Patrik    | Climbing |
| Patrik    | Code     |
| NULL      | Rugby    |
| Darwin    | Apples   |
| Elizabeth | NULL     |

### Outer join

Toutes les valeurs des deux tables t1 et t2 sont inclues et sans correspondance, à la fois les valeurs de  t1 et t2 seront `ǸULL`

|    Name   |   Like   |
|:---------:|:--------:|
| Maria     | Stars    |
| Patrik    | Climbing |
| Patrik    | Code     |
| NULL      | Rugby    |
| Darwin    | Apples   |
| Elizabeth | NULL     |

### Cross join

Sélectionner deux tables quand il n'y a pas de relation entre les deux. Cela permet de sélectionner le produit cartésien.

## GROUP BY

Permet de regrouper plusieurs résultats et d'utiliser une fonction de totaux sur un groupe de résultat. Sur une table qui contient toutes les ventes d’un magasin, il est possible de regrouper les ventes par clients identiques et d’obtenir le coût total des achats pour chaque client.

```sql
SELECT colonne1, fonction(colonne2)
FROM table
GROUP BY colonne1
```

On obtient ce type de données :

| Continent|      Are      |  Cool |
|----------|:-------------:|------:|
| Europe   |  150          | $1600 |
| Amérique |    400        |   $12 |
| Asie     | 2100          |       |

Il faut les utiliser avec les fonctions d'aggrégation.

**Attention** le `ORDER BY` et le `HAVING` viennent après `GROUP BY`!

Voici l'ordre des clauses MySQL

![ordre des clauses](https://1.bp.blogspot.com/-8aA8S257X14/XaXylrEZZjI/AAAAAAAAHd0/Tl8peOvx3cIkD2eylz7Wfi6wrK0oaPI4QCNcBGAsYHQ/s1600/having-sql.png)

```sql
SELECT col1 AS C
FROM table
WHERE cdt (OR:AND)
GROUP BY col
ORDER BY c;
```

## HAVING

Il intervient juste avant la récupération des valeurs, et permet de filtrer en utilisant des fonctions.
`HAVING` est souvent utilisé avec `GROUP BY`.
Le **Where ne s'utilise pas avec les fonctions d'aggrégation, on utilise dans ces cas-là le `HAVING` !**

```sql
SELECT continent, COUNT(*)
FROM pays
GROUP BY continent
HAVING COUNT(*) > 3;
```

Par exemple si je veux identifier les 5 pays les plus visités par le site :

```sql
SELECT country, COUNT(ip_adress) AS nb_connexions
FROM access_ip
GROUP BY country
ORDER BY nb_connexions DESC
LIMIT 5;
```

### Quand utiliser WHERE VS HAVING

> The WHERE clause is applied first to the individual rows in the tables or table-valued objects in the Diagram pane. Only the rows that meet the conditions in the WHERE clause are grouped.

A **`WHERE` clause is used is filter records from a result**.  The **filter occurs before any groupings** are made.
A **`HAVING` clause is used to filter values from a group**.

> The HAVING clause is then applied to the rows in the result set. Only the groups that meet the HAVING conditions appear in the query output. You can apply a HAVING clause only to columns that also appear in the GROUP BY clause or in an aggregate function.
En gros avec les fct d'aggrégations, il faut utiliser HAVING

### Quand utiliser GROUP BY VS ORDER BY

`ORDER BY` sert uniquement à classer les résultats d'une colonne par ordre croissant/décroissant sans toucher aux données.

`GROUP BY` sert à **aggréger** les données par colonne(s) spécifiée(s) et donc de regrouper les valeurs par

## GROUP_CONCAT

Regrouper plusieurs informations dans une même colonne
> Dans le langage SQL, la fonction `GROUP_CONCAT()` permet de regrouper les valeurs non nulles d’un groupe en une chaîne de caractère. Cela est utile pour regrouper des résultats en une seule ligne autant d’avoir autant de ligne qu’il y a de résultat dans ce groupe.

GROUP_CONCAT(country SEPARATOR ',') AS liste_pays

```sql
SELECT year(access_creation_date) annee , GROUP_CONCAT(DISTINCT country SEPARATOR ',' ) as listepays
FROM `access_ip`
WHERE ip_adress LIKE '102.10%'
AND access_creation_date IS NOT NULL
AND country <> ''
GROUP BY annee
ORDER BY annee
```
