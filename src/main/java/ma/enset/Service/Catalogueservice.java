package ma.enset.Service;

import ma.enset.Dao.CategorieDao;
import ma.enset.Dao.ProductDao;
import ma.enset.Dao.entities.Categorie;
import ma.enset.Dao.entities.Product;

import java.util.List;

public class Catalogueservice implements CatalogueInterface{
    private ProductDao productDao;
    private CategorieDao categorieDao;

    public Catalogueservice(ProductDao productDao, CategorieDao categorieDao) {
        this.productDao = productDao;
        this.categorieDao = categorieDao;
    }

    @Override
    public List<Product> searchProductByQuery(String query) {

        return productDao.findByQuery(query);
    }

    @Override
    public List<Product> getAll() {
        return productDao.findall();
    }

    @Override
    public void addProduct(Product o) {
    productDao.save(o);
    }

    @Override
    public void deleteProduct(Product o) {
        productDao.delete(o);
    }

    @Override
    public void updateProduct(Product o) {
        productDao.update(o);
    }

    @Override
    public List<Categorie> getAllCat() {

        return categorieDao.findall();
    }

    @Override
    public void addCat(Categorie o) {
        categorieDao.save(o);
    }

    @Override
    public void deleteCat(Categorie o) {
        categorieDao.delete(o);
    }

    @Override
    public void updateCat(Categorie o) {
        categorieDao.update(o);
    }

}
