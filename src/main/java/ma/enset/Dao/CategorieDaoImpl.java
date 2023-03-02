package ma.enset.Dao;

import ma.enset.Dao.entities.Categorie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategorieDaoImpl implements CategorieDao{
    @Override
    public Categorie find(long id) {
        Connection connection = ConDbSt.getConnection();
        Categorie c = new Categorie();
        try{
            PreparedStatement pstm = connection.prepareStatement("SELECT * from categorie where id=?");
            pstm.setLong(1,id);
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                c.setId(rs.getLong(1));
                c.setNom(rs.getString(2));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public void save(Categorie o) {
        Connection connection = ConDbSt.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("INSERT INTO categorie(nom) values(?)");
            pstm.setString(1,o.getNom());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Categorie o) {
        Connection connection = ConDbSt.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("DELETE from  categorie where id=?");
            pstm.setLong(1,o.getId());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Categorie o) {
        Connection connection = ConDbSt.getConnection();
        try{
            PreparedStatement pstm = connection.prepareStatement("UPDATE  product set nom=? where id=?");
            pstm.setString(1,o.getNom());
            pstm.setLong(2,o.getId());
            pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Categorie> findall() {
        List<Categorie> categories = new ArrayList<>();
        Connection connection = ConDbSt.getConnection();
        try {
            PreparedStatement pstm = connection.prepareStatement("Select * from categorie");
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                Categorie c = new Categorie();
                c.setId(rs.getLong(1));
                c.setNom(rs.getString(2));
                categories.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }
}
