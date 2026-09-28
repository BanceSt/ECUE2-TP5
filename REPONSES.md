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
on utilise le setTitre() dans le constructeur.

## Partie 4

**4.1** :
L'étape 3, n'accepte pas l'entrée du nouvelle author car date de naissance incohérente
l'étape 4, refuse la modification de titre car étant null
l'étape 6 ne crache plus.
Le code est maintenant plus robuste et efficace.

**4.2** :
livres[0] = null
livres[0] = livres[1]
On peut conclure qui ne veut pas laisser l'acces directe à la variable livres.

## Partie 5

**5.1** :
La capacité doit rester la mm et inalterable à travers les instances. Comme MAX_CAPICITE est défini avec final, il est pas modifiable
donc il n'y a aucun probleme à le rendre accessible directement.

**5.2** :
Tous les livres aurait le même code.

**5.3** :
Cette une méthode statique qui peut s'utiliser sans instance si on met une méthode ou une variable qui necessite une instance
le code va crash.

**5.4** :
Static est utile quand une information doit être partager ou utiliser toutes les instances de la class alors que quand 
la variable n'est nécéssaire qu'a l'instance il est une erreur d'utiliser statique.

**5.5** :
estValide est utilisable pour tous livre car il suit la norme isbn donc on le met statique, getAge n'est lié qu'a un auteur précis
.Dans le JDk on Math qui suit cette logique.

## Partie 6

Nombre de livres créés affiché à l'étape 10, et explication :

## Bonus B2 : code dupliqué

