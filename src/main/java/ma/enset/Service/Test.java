package ma.enset.Service;

import ma.enset.Dao.CategorieDao;
import ma.enset.Dao.CategorieDaoImpl;
import ma.enset.Dao.ProductDao;
import ma.enset.Dao.ProductDaoImpl;
import ma.enset.Dao.entities.Categorie;
import ma.enset.Dao.entities.Product;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        Catalogueservice catalogueservice = new Catalogueservice(new ProductDaoImpl(), new CategorieDaoImpl());
        Categorie c1 = new Categorie();
        c1.setNom("gaming");
        c1.setId(1);

       /* Product p = new Product();
        p.setNom("hp omen");
        p.setReference("ref732164");
        p.setPrix(3500);
        p.setCategorie(c1);
     catalogueservice.addProduct(p);*/
        //List<Product> list = catalogueservice.getAll();

        /*for (Product pr:list) {
            System.out.println("id: "+"\t"+pr.getId()+"\t"+pr.getNom()+"\t"+pr.getPrix());
        }*/
    }
}
