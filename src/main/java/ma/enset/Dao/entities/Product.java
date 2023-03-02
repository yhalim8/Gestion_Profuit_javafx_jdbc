package ma.enset.Dao.entities;

import java.io.Serializable;

public class Product implements Serializable {
    private String nom;
    private long id;
    private float prix;
    private String reference;
    Categorie categorie;

    public void setId(long id) {
        this.id = id;
    }

    public Product(String nom, String reference, float prix, Categorie categorie) {
        this.nom = nom;
        this.reference=reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Product() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public long getId() {
        return id;
    }
    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        return "Product{" +
                "nom='" + id + '\'' +
                ", id=" + nom +
                ", prix=" + prix +
                ", reference='" + reference + '\'' +
                ", categorie=" + categorie +
                '}';
    }
}