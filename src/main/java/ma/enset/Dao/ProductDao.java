package ma.enset.Dao;

import ma.enset.Dao.entities.Product;

import java.util.List;

public interface ProductDao extends Dao<Product> {
    List<Product> findByQuery(String query);
}
