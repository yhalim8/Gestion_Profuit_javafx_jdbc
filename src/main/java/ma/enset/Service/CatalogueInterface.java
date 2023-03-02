package ma.enset.Service;

import ma.enset.Dao.entities.Categorie;
import ma.enset.Dao.entities.Product;

import java.util.List;

public interface CatalogueInterface {
    List<Product> searchProductByQuery(String query);
    List<Product> getAll();
    void addProduct(Product o);
    void deleteProduct(Product o);
    void updateProduct(Product o);
    List<Categorie> getAllCat();
    void addCat(Categorie o);
    void deleteCat(Categorie o);
    void updateCat(Categorie o);


}
