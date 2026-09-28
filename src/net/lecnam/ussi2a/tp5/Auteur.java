package net.lecnam.ussi2a.tp5;

import java.time.LocalDate;
import java.time.Period;

/**
 * Code écrit par l'ancien stagiaire.
 * Il "marche"... à peu près.
 */
public class Auteur {
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;

    public Auteur(String nom, String prenom, LocalDate dateNaissance) {
        if (nom == null || nom.isBlank()) {
            throw new IllegalArgumentException("Le nom est obligatoire");
        }

        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date de naissance est dans le future");
        }
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
    }

    public String getNom() {
        return nom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    public String toString() {
        return prenom + " " + nom + " (" + getAge() + " ans)";
    }
}
