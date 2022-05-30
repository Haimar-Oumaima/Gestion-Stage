package src.sql;
import java.sql.DriverManager;
import java.sql.*;
/*

import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:8889/gestion_stage" ;
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    private Connection connection;

    public Database(){
        try {
            connection = DriverManager.getConnection(URL,USER,PASSWORD);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
}
*/
import java.sql.SQLException;
import java.sql.*;
import java.sql.Connection;

/**
 * @author HP
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
