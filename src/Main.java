package src;

import src.sql.Connexion;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connexion con = new Connexion();
        con.GetCon();
        System.out.println("lol");

        PreparedStatement pst= Connexion.GetCon().prepareStatement("INSERT INTO etudiant VALUES(?,?,?,?)");
        pst.clearParameters();
        pst.setInt(1,8);
        pst.setString(2,"oumai");
        pst.setString(3,"haji");
        pst.setString(4,"emaili");
        pst.executeUpdate();

    }


}
