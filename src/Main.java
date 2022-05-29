package src;

import src.sql.Database;

public class Main {
    public static void main(String[] args) {
        Database con = new Database();
        con.getConnection();
    }


}
