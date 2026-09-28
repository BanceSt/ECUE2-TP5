package net.lecnam.ussi2a.tp5;

/**
 * Code écrit par l'ancien stagiaire.
 */
public class Livre {
    private Auteur auteur;
    private String titre;
    private String isbn;
    private String code;
    private int nbExemplaires;
    private int nbDisponibles;
    private static int nbLivresCrees = 0;

    public Livre(Auteur auteur, String titre, String isbn, int nbExemplaires) {

        if (auteur == null) {
            throw new IllegalArgumentException("L'auteur est Null");
        }

        if (nbExemplaires < 1) {
            throw new IllegalArgumentException("Au moins un exemplaire");
        }

        if (!(Isbn.estValide(isbn))) throw new IllegalArgumentException("Invalid ISBN");;
        setTitre(titre);
        this.auteur = auteur;
        this.isbn = isbn;
        this.nbExemplaires = nbExemplaires;
        this.nbDisponibles = nbExemplaires;
        nbLivresCrees++;
        this.code = String.format("LIV-%04d", nbLivresCrees);
    }

    public Livre(Auteur auteur, String isbn, String titre) {
        this(auteur, titre, isbn, 1);
    }

    public boolean estDisponible() {
        return nbDisponibles > 0;
    }

    public boolean emprunter() {
        if (nbDisponibles == 0) return false;
        nbDisponibles--;
        return true;
    }

    public boolean rendre() {
        if (nbDisponibles == nbExemplaires) return false;
        nbExemplaires++;
        return true;
    }

    public boolean aLeMemeIsbnQue(Livre autre) {
        return autre.isbn.equals(isbn);
    }

    public Auteur getAuteur() {
        return auteur;
    }

    public int getNbDisponibles() {
        return nbDisponibles;
    }

    public int getNbExemplaires() {
        return nbExemplaires;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        if (titre == null || titre.isBlank()) {
            throw new IllegalArgumentException("Le titre ne peut pas être null");
        }
        this.titre = titre;
    }

    public String toString() {
        return String.format("[ %s ] %s - %s - %s - %d/%d disponible(s).", isbn, code, titre, auteur, nbDisponibles, nbExemplaires);
    }

    public static int getNbLivresCrees() {
        return nbLivresCrees;
    }
}
