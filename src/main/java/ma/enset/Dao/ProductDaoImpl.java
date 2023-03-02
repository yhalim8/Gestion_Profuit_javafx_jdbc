package ma.enset.Dao;

import ma.enset.Dao.entities.Categorie;
import ma.enset.Dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImpl implements ProductDao {

    @Override
    public Product find(long id) {
        Connection connection = ConDbSt.getConnection();
        Product p = new Product();
        try{
            PreparedStatement pstm = connection.prepareStatement("SELECT * from product where id=?");
            pstm.setLong(1,id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                p.setId(rs.getLong(1));
                p.setNom(rs.getString(2));
                p.setReference((rs.getString(3)));
                p.setPrix(rs.getFloat(4));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public void save(Product o){
        Connection connection = ConDbSt.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO product(nom,reference,prix,id_cat) VALUES (?,?,?,?)");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getReference());
            pstm.setFloat(3,o.getPrix());
            pstm.setLong(4,o.getCategorie().getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("sql");
        }
    }

    @Override
    public void delete(Product o) {
        Connection connection = ConDbSt.getConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement("DELETE  from product where id=?");
            pstm.setLong(1,o.getId());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product o) {
        Connection connection = ConDbSt.getConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement("UPDATE  product set nom=?,reference=?,prix=?,id_cat=? where id=?");
            pstm.setString(1,o.getNom());
            pstm.setString(2,o.getReference());
            pstm.setFloat(3,o.getPrix());
            pstm.setLong(4,o.getCategorie().getId());
            pstm.setLong(5,o.getId());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findall() {
        List<Product> products = new ArrayList<>();
        Connection connection = ConDbSt.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("Select * from product");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getLong(1));
                p.setNom(rs.getString(2));
                p.setReference((rs.getString(3)));
                p.setPrix(rs.getFloat(4));
                PreparedStatement pstm1 = connection.prepareStatement("SELECT * from categorie where id=?");
                pstm1.setLong(1,rs.getLong("id_cat"));
                ResultSet rs1 = pstm1.executeQuery();
                Categorie c = new Categorie();
                if(rs1.next())
                c.setNom(rs1.getString(2));
                p.setCategorie(c);
                products.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findByQuery(String query) {
        List<Product> products = new ArrayList<>();
        Connection connection = ConDbSt.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("Select * from product where nom like ? or reference like ? or prix like ?");
            pstm.setString(1,"%"+query+"%");
            pstm.setString(2,"%"+query+"%");
            pstm.setString(3,"%"+query+"%");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Product p = new Product();
                p.setId(rs.getLong(1));
                p.setNom(rs.getString(2));
                p.setReference((rs.getString(3)));
                p.setPrix(rs.getFloat(4));
                products.add(p);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }
}
