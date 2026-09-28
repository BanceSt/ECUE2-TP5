package net.lecnam.ussi2a.tp5;

import java.util.Arrays;

/**
 * Code écrit par l'ancien stagiaire.
 */
public class Bibliotheque {
    public static final int MAX_LIVRE = 100;
    private Livre[] livres = new Livre[MAX_LIVRE];
    private int nbLivres = 0;

    public boolean ajouterLivre(Livre livre) {
        if (nbLivres == MAX_LIVRE) return false;
        if (livre == null) return false;
        if (rechercherLivre(livre.getIsbn()) != null) return false;
        livres[nbLivres] = livre;
        nbLivres++;
        return true;
    }

    public void afficherLivres() {
        System.out.println("--- " + nbLivres + " livre(s) dans la bibliothèque ---");
        for (int i = 0; i < nbLivres; i++) {
            System.out.println(livres[i]);
        }
    }

    public Livre rechercherLivre(String isbn) {
        for (int i =0;i < nbLivres;i++) {
            if (livres[i].getIsbn().equals(isbn))
                return livres[i];
        }
        return null;
    }

    public boolean estPleine() {
        return nbLivres == MAX_LIVRE;
    }

    public int getNbLivres() {
        return nbLivres;
    }

    public boolean emprunter(String isbn) {
        Livre livreAEmprunter = rechercherLivre(isbn);
        if (livreAEmprunter == null) return false;
        return livreAEmprunter.emprunter();
    }

    public boolean rendre(String isbn) {
        Livre livreARendre = rechercherLivre(isbn);
        if (livreARendre == null) return false;
        return livreARendre.rendre();
    }

    @Override
    public String toString() {
        return String.format("Bibliothèque (%d/%d)", nbLivres, MAX_LIVRE);
    }
}
