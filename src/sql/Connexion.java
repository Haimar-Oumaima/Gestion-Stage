package src.sql;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;

/**
 * @author Oumaima
 *
 *
 */
public class Connexion {

    public static Connection GetCon()

    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");
            return con;

        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null ;
        }


    }
}
