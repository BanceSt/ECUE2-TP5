package net.lecnam.ussi2a.tp5;

/**
 * Code écrit par l'ancien stagiaire.
 */
public class Bibliotheque {
    public Livre[] livres = new Livre[100];
    public int nbLivres = 0;

    public void ajouterLivre(Livre livre) {
        livres[nbLivres] = livre;
        nbLivres++;
    }

    public void afficherLivres() {
        System.out.println("--- " + nbLivres + " livre(s) dans la bibliothèque ---");
        for (int i = 0; i < nbLivres; i++) {
            System.out.println(livres[i]);
        }
    }
}
