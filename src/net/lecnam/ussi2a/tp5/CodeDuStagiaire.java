package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;

/**
 * Le programme de démonstration laissé par l'ancien stagiaire.
 * Lancez-le et observez attentivement ce qui s'affiche.
 * NE PAS MODIFIER avant la Partie 4.
 */
public class CodeDuStagiaire {

    public static void main(String[] args) {
        Bibliotheque bib = new Bibliotheque();

        Auteur hugo = new Auteur("Hugo", "Victor", LocalDate.of(1802, 2, 26));
        Auteur zola = new Auteur("Zola", "Émile", LocalDate.of(1840, 4, 2));
        Auteur verne = new Auteur("Verne", "Jules", LocalDate.of(1828, 2, 8));

        Livre miserables = new Livre(hugo, "Les Misérables", "9782070409228", 2);
        Livre germinal = new Livre(zola, "Germinal", "9782253004226", 1);
        Livre tourDuMonde = new Livre(verne, "Le Tour du monde en 80 jours", "9782253012696", 1);

        bib.ajouterLivre(miserables);
        bib.ajouterLivre(germinal);
        bib.ajouterLivre(tourDuMonde);

        System.out.println("\n=== Étape 1 : état initial");
        bib.afficherLivres();

        System.out.println("\n=== Étape 2 : trois lecteurs empruntent Germinal");
        germinal.nbDisponibles--;
        germinal.nbDisponibles--;
        germinal.nbDisponibles--;
        System.out.println(germinal);

        System.out.println("\n=== Étape 3 : un auteur contemporain");
        Auteur inconnu = new Auteur("Dupont", "Jean", LocalDate.of(2090, 1, 1));
        System.out.println(inconnu);

        System.out.println("\n=== Étape 4 : \"correction\" d'une faute de frappe");
        tourDuMonde.isbn = "123";
        tourDuMonde.titre = null;
        System.out.println(tourDuMonde);

        System.out.println("\n=== Étape 5 : \"petit ménage\" dans la bibliothèque");
        bib.nbLivres = 1;
        bib.afficherLivres();
        bib.ajouterLivre(new Livre(hugo, "Notre-Dame de Paris", "9782253096337", 1));
        bib.afficherLivres();

        System.out.println("\n=== Étape 6 : on remplit tout");
        bib.nbLivres = 100;
        bib.ajouterLivre(new Livre(zola, "L'Assommoir", "9782070360024", 1));
        bib.afficherLivres();

        System.out.println("\nFin du programme");
    }
}
