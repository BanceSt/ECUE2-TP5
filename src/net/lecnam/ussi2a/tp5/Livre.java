package net.lecnam.ussi2a.tp5;

/**
 * Code écrit par l'ancien stagiaire.
 */
public class Livre {
    public Auteur auteur;
    public String titre;
    public String isbn;
    public int nbExemplaires;
    public int nbDisponibles;

    public Livre(Auteur auteur, String titre, String isbn, int nbExemplaires) {
        this.auteur = auteur;
        this.titre = titre;
        this.isbn = isbn;
        this.nbExemplaires = nbExemplaires;
        this.nbDisponibles = nbExemplaires;
    }

    public String toString() {
        return "[" + isbn + "] " + titre + " - " + auteur
                + " - " + nbDisponibles + "/" + nbExemplaires + " disponible(s)";
    }
}
