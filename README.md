# TP5 : Encapsulation et `static`

### Objectifs

- Comprendre **pourquoi** on encapsule : protéger l'état d'un objet et garantir qu'il reste cohérent
- Rendre des attributs `private`, écrire des accesseurs **seulement quand ils ont un sens**
- Valider les données dans les constructeurs et les méthodes
- Utiliser `static` : attribut de classe, constante, méthode de classe, classe utilitaire
- Écrire soi-même un programme de test complet dans un `main()`

Durée indicative : 3 h

### Prérequis

- Cloner le projet sur votre poste dans le répertoire de votre choix
- Ouvrir le projet :
  * Sur l'écran d'accueil d'IntelliJ, cliquer sur **Open**
  * Sélectionner le dossier **ECUE2-TP5** copié depuis GitHub puis cliquer sur **OK**
  * Vérifier que le SDK est bien sélectionné dans **File > Project Structure** onglet **Project**

### Utilisation de GIT

- Créer une nouvelle branche **prenomNom**
- Faire **1 commit par partie** (le message du commit indique la partie : `Partie 2 : encapsulation Auteur`)
- Ouvrir **une seule** *pull request* sur GitHub et **ne pas** la fermer/merger !!

### Modalités

- Toutes les classes sont dans le package **net.lecnam.ussi2a.tp5**
- Les réponses aux questions sont à écrire dans le fichier **REPONSES.md** (il est commité avec le reste)
- Documentation utile : [LocalDate](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDate.html) et [Period](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/Period.html)

---

## Le contexte

La médiathèque de la ville a fait développer un petit logiciel de gestion par un stagiaire. Le stagiaire est parti, le code est resté... et les bibliothécaires se plaignent : des livres disparaissent, des auteurs changent de nom, des livres sont empruntés alors qu'il n'y en a plus en rayon.

On vous confie le code. Votre mission : **le rendre fiable**.

Le code fourni contient 3 classes métier (`Auteur`, `Livre`, `Bibliotheque`), le programme de démonstration du stagiaire (`CodeDuStagiaire`) et une classe `Exec` vide.

---

## Partie 1 : Enquête (sans rien modifier)

1. Lire les classes `Auteur`, `Livre` et `Bibliotheque`.
2. Exécuter le `main()` de **CodeDuStagiaire** et lire attentivement la sortie, étape par étape.
3. Dans **REPONSES.md**, pour chaque étape (1 à 6), décrire :
   - ce qui s'affiche d'anormal
   - la ligne de code responsable
   - la classe qui **aurait dû** empêcher ça

> **Question 1.1** : Dans l'étape 1, pourquoi tous les auteurs s'appellent-ils Verne ? Et pourquoi s'appellent-ils Dupont à l'étape 4 alors qu'on n'a jamais touché à Hugo ni à Zola ?
>
> **Question 1.2** : Le stagiaire dit : « c'est pas ma faute, c'est le code qui appelle mes classes qui fait n'importe quoi ». Qu'en pensez-vous ?

> Commit : `Partie 1 : enquête`

---

## Partie 2 : Encapsuler `Auteur`

Règles métier :
- le **nom** est obligatoire (ni `null`, ni vide)
- la **date de naissance** est obligatoire et ne peut pas être dans le futur
- une fois créé, un auteur ne change ni de nom, ni de prénom, ni de date de naissance

Travail :
1. Corriger le bug trouvé à la question 1.1.
2. Passer tous les attributs en `private`. Peuvent-ils être `final` ?
3. Dans le constructeur, vérifier les règles métier. Si une règle n'est pas respectée, on refuse de créer l'objet en levant une exception :
   ```java
   if (nom == null || nom.isBlank()) {
       throw new IllegalArgumentException("Le nom est obligatoire");
   }
   ```
4. Ajouter les accesseurs **utiles**.
5. Ajouter une méthode publique `getAge()` et l'utiliser dans `toString()`.

> **Question 2.1** : Avez-vous écrit des setters ? Justifier.
>
> **Question 2.2** : Pourquoi faut-il faire la vérification dans le constructeur et pas dans le code qui appelle `new Auteur(...)` ?

> Le projet ne compile plus à cause de `CodeDuStagiaire` ? **C'est normal et c'est bon signe** : ce code utilisait des accès qui ne sont plus autorisés. Commentez les lignes en erreur pour l'instant, on le réécrit en Partie 4.

> Commit : `Partie 2 : encapsulation Auteur`

---

## Partie 3 : Encapsuler `Livre`

Règles métier :
- un livre a obligatoirement un auteur et un titre (ni `null`, ni vide)
- l'**ISBN** identifie le livre : il ne change jamais après la création
- un livre a au moins 1 exemplaire
- le nombre de disponibles est toujours compris entre `0` et `nbExemplaires`
- le titre peut être corrigé (faute de frappe), mais jamais par un titre vide

Travail :
1. Passer tous les attributs en `private`, ajouter `final` là où c'est pertinent.
2. Vérifier les règles métier dans le constructeur.
3. Ajouter les accesseurs utiles et **uniquement** `setTitre(String titre)` comme modificateur (avec vérification).
4. Écrire les méthodes :
   - `boolean estDisponible()`
   - `boolean emprunter()` : retire un exemplaire disponible. Retourne `false` (et ne fait rien) s'il n'y en a plus.
   - `boolean rendre()` : remet un exemplaire. Retourne `false` si tous les exemplaires sont déjà rendus.
   - `boolean aLeMemeIsbnQue(Livre autre)`

> **Question 3.1** : Pourquoi n'y a-t-il pas de `setNbDisponibles(int n)` ? Qu'est-ce qu'on y perdrait ?
>
> **Question 3.2** : Le constructeur doit vérifier le titre, et `setTitre()` aussi. Comment éviter d'écrire deux fois la même vérification ?

> Commit : `Partie 3 : encapsulation Livre`

---

## Partie 4 : Encapsuler `Bibliotheque` et réécrire le code du stagiaire

Règles métier :
- la bibliothèque contient au maximum 100 livres
- on ne peut pas ajouter deux livres avec le même ISBN
- le nombre de livres ne peut évoluer **que** par un ajout

Travail :
1. Passer les attributs en `private`.
2. `ajouterLivre(Livre livre)` retourne maintenant un `boolean` : `false` si le livre est `null`, si la bibliothèque est pleine ou si l'ISBN est déjà présent. Elle ne doit **jamais** planter.
3. Ajouter :
   - `int getNbLivres()`
   - `boolean estPleine()`
   - `Livre rechercherLivre(String isbn)` (retourne `null` si absent)
   - `boolean emprunter(String isbn)` et `boolean rendre(String isbn)`
   - `toString()` qui retourne par exemple `Bibliothèque : 4/100 livres`
4. Réécrire `CodeDuStagiaire` pour qu'il compile, **en n'utilisant que les méthodes publiques**. Pour chaque étape, afficher ce qui est accepté ou refusé. Pour intercepter une exception :
   ```java
   try {
       new Auteur("Dupont", "Jean", LocalDate.of(2090, 1, 1));
   } catch (IllegalArgumentException e) {
       System.out.println("Refusé : " + e.getMessage());
   }
   ```

> **Question 4.1** : Certaines étapes du stagiaire n'ont plus aucun équivalent possible. Lesquelles, et pourquoi est-ce une bonne nouvelle ?
>
> **Question 4.2** : Un collègue propose d'ajouter `public Livre[] getLivres() { return livres; }` pour pouvoir afficher les livres ailleurs. Écrire 2 lignes de code qui, avec cette méthode, cassent la bibliothèque. Qu'en concluez-vous ?

> Commit : `Partie 4 : encapsulation Bibliotheque`

---

## Partie 5 : `static`

### 5.1 Une constante

La capacité (100) est écrite « en dur ». Remplacer par une constante `CAPACITE_MAX` dans `Bibliotheque`, utilisable depuis l'extérieur par `Bibliotheque.CAPACITE_MAX`.

> **Question 5.1** : Pourquoi `static` ? Pourquoi `final` ? Pourquoi peut-elle être `public` sans casser l'encapsulation ?

### 5.2 Un compteur partagé

La médiathèque veut un **code interne** pour chaque livre, attribué automatiquement dans l'ordre de création : `LIV-0001`, `LIV-0002`, ...

1. Ajouter dans `Livre` un attribut de classe qui compte les livres créés, et un attribut `code` propre à chaque livre.
2. Le code est calculé dans le constructeur (indice : `String.format("LIV-%04d", n)`). Attention : un livre refusé (exception) ne doit **pas** consommer de numéro.
3. Ajouter une méthode `static int getNbLivresCrees()`.
4. Ajouter le code dans le `toString()`.

> **Question 5.2** : Que se passerait-il si le compteur n'était pas `static` ?
>
> **Question 5.3** : Essayez d'appeler `getTitre()` depuis `getNbLivresCrees()`. Que dit le compilateur ? Expliquer pourquoi.
>
> **Question 5.4** : Relier la question 1.1 à cette partie : quand un attribut `static` est-il une bonne idée, et quand est-ce un bug ?

### 5.3 Une classe utilitaire

Un ISBN-13 valide contient 13 chiffres, et sa clé est vérifiable : on multiplie les chiffres alternativement par 1 et par 3 (1 pour le 1er, 3 pour le 2e, 1 pour le 3e...), la somme des 13 produits doit être un multiple de 10.

Exemple : `9782253004226` → 9×1 + 7×3 + 8×1 + 2×3 + 2×1 + 5×3 + 3×1 + 0×3 + 0×1 + 4×3 + 2×1 + 2×3 + 6×1 = 100 ✅

1. Créer une classe `Isbn` avec une méthode `public static boolean estValide(String isbn)`.
2. Faire en sorte qu'on ne puisse **pas** faire `new Isbn()`.
3. Utiliser `Isbn.estValide()` dans le constructeur de `Livre`.

> **Question 5.5** : Pourquoi `estValide()` est-elle `static` alors que `getAge()` ne l'est pas ? Citer une classe du JDK construite sur le même principe que `Isbn`.

> Commit : `Partie 5 : static`

---

## Partie 6 : À vous d'écrire le `main()`

Dans la classe **Exec**, écrire un programme qui déroule le scénario suivant. Aucun code n'est fourni : à vous de choisir les variables, les appels et les affichages. Chaque étape doit afficher quelque chose de lisible.

1. Afficher la capacité maximale de la bibliothèque (sans créer de bibliothèque).
2. Créer 3 auteurs (au choix, réels ou inventés).
3. Créer au moins 4 livres, dont un avec **1 seul exemplaire**.
4. Créer une bibliothèque, y ajouter les livres, puis tenter d'ajouter une 2e fois le même livre. Afficher le résultat.
5. Afficher la liste des livres.
6. Tenter de créer un livre avec un ISBN faux, puis un auteur sans nom : le programme ne doit **pas** s'arrêter, il affiche l'erreur et continue.
7. Emprunter 2 fois le livre à 1 exemplaire, le rendre 2 fois. Afficher le résultat de chaque opération.
8. Tenter d'emprunter un ISBN qui n'existe pas dans la bibliothèque.
9. Rechercher un livre par son ISBN et l'afficher.
10. Afficher le nombre total de livres créés depuis le lancement du programme (y compris ceux qui ne sont pas dans la bibliothèque). Le résultat est-il celui que vous attendiez ?

> Commit : `Partie 6 : main`
> Pensez à faire un push (`git push origin prenomNom`)
> Si elle n'est pas déjà ouverte, ouvrez une pull request (branche **prenomNom** vers **master**) NE PAS LA FERMER/MERGER !

---

## Bonus (pour ceux qui ont fini)

**Les CD** : la médiathèque veut aussi prêter des CD. Un CD a un titre, un artiste, une durée en minutes (> 0) et un code-barres EAN-13 (même algorithme de clé que l'ISBN !). Il se prête et se rend comme un livre.
- Écrire la classe `CD` en respectant les mêmes principes d'encapsulation.
- Faire en sorte que la bibliothèque puisse stocker des CD.
- Noter dans REPONSES.md tout le code que vous avez dû **dupliquer**. On en reparlera au TP sur l'héritage...
