package com.karinedias.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String telephone;
    private Ville ville;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Basic
    @Column(name = "prenom")
    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "telephone")
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @OneToOne
    @JoinColumn(name = "ville", referencedColumnName = "id")
    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient patient)) return false;
        return id == patient.id && nom.equals(patient.nom) && prenom.equals(patient.prenom) && email.equals(patient.email) && telephone.equals(patient.telephone) && ville.equals(patient.ville);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, prenom, email, telephone, ville);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                ", ville=" + ville +
                '}';
    }
}
