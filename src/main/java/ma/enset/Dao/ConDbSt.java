package ma.enset.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConDbSt {
    private static  Connection connection;

    public static Connection getConnection() {
        return connection;
    }

    static {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_produit","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
