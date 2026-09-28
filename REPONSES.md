# TP5 : Réponses

Nom / Prénom :

## Partie 1 : Enquête

| Étape | Ce qui est anormal | Ligne responsable | Classe qui aurait dû l'empêcher |
|-------|--------------------|-------------------|---------------------------------|
| 1     |   nom identique pour chaque auteur,<br/>Age auteur montrer de façon absurde |   L.11, L.23 (Auteur) | Auteur, Autheur|
| 2     |    Il y a -2 livres dans la bibliothèques | L31à33 (CodeDuStagiaire)| Livre  |
| 3     |    Age est -63 ans     | L37 (CodeDuStagiaire)  |    Author   |
| 4     |  Le nom du livre est null, Le nom de l'auteur à changer | L42 (CodeDuStagiaire), L.11 (Author) | Livre, Author |
| 5     |    Le nombre de livre incoherent avec l'affichage  | L46 (CodeDuStagiaire) |  Bibliothèque |
| 6     |       Le code crash  |        L53           |        Bibliotheque|

**1.1** :

Car la variable qui contient le nom de l'auteur est statique ainsi tous les auteurs auront le même dernier nom attribué à la variable.

**1.2** :

C'est rarament la faute du langage ou du code, les class sont mal construite, elle permet de modifier les propriétés sans probleme ou met des statique n'importe où.

## Partie 2

**2.1** :
Non, les règles disent qu'après attribution les valeurs ne sont plus modifiable donc les setteurs sont inutiles

**2.2** :
Le faire dans le constructeur permet de vérifier automatique à chaque création d'instance au lieu de le faire à cheque fois
individuellement.

## Partie 3

**3.1** :
un setNbDisponibles(int n) est inutile car on peut déjà changer cette valeur via les methodes emprunter et rendre. Etant donner 
que c'est la seul raison de modifier cette valeur, mettre setNbDisponibles(int n) perdrait aussi en lisibilité.

**3.2** :
on utilise le setTitre() dans le constructeure.

## Partie 4

**4.1** :

**4.2** :

## Partie 5

**5.1** :

**5.2** :

**5.3** :

**5.4** :

**5.5** :

## Partie 6

Nombre de livres créés affiché à l'étape 10, et explication :

## Bonus B2 : code dupliqué

