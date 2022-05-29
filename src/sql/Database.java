package src.sql;

import java.sql.*;
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
