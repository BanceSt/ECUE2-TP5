package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;
import java.time.Period;

/**
 * Code écrit par l'ancien stagiaire.
 * Il "marche"... à peu près.
 */
public class Auteur {
    public static String nom;
    public String prenom;
    public LocalDate dateNaissance;

    public Auteur(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String toString() {
        int age = Period.between(dateNaissance, LocalDate.now()).getYears();
        return prenom + " " + nom + " (" + age + " ans)";
    }
}
