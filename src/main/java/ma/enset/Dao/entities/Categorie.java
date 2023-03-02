package ma.enset.Dao.entities;

import java.io.Serializable;

public class Categorie implements Serializable {
    private long id;
    private String nom;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Categorie() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Categorie(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
