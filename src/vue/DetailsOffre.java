package src.vue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;


public class DetailsOffre {
    String entrepriseAccueil;
    String sujetStage;
    String missions;
    String poste;
    String lieu;
    int montantIdemnite;
    int idOffre;
    int idUser;

    public DetailsOffre(int id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String query = "SELECT * FROM offre WHERE id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, id);
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next()) {
            idOffre = rs.getInt("id");
            entrepriseAccueil = rs.getString("entrepriseAccueil");
            sujetStage = rs.getString("sujetStage");
            missions = rs.getString("missions");
            poste = rs.getString("poste");
            lieu = rs.getString("lieu");
            montantIdemnite = rs.getInt("montantIdemnite");
            DetailsOffreVue detailsOffreVue = new DetailsOffreVue(idUser, idOffre, entrepriseAccueil, sujetStage, missions, poste, lieu, montantIdemnite);
            detailsOffreVue.setVisible(true);
        }


    }


    public DetailsOffre(int idOffre, int idUser) throws SQLException, ClassNotFoundException {
        this.idUser = idUser;
        initializeWithIdUser(idOffre, idUser);
    }

    private void initializeWithIdUser(int idOffre, int idUser) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String query = "SELECT * FROM offre WHERE id = ?";
        PreparedStatement preparedStmt = con.prepareStatement(query);
        preparedStmt.setInt(1, idOffre);
        ResultSet rs = preparedStmt.executeQuery();
        if (rs.next()) {
            idOffre = rs.getInt("id");
            entrepriseAccueil = rs.getString("entrepriseAccueil");
            sujetStage = rs.getString("sujetStage");
            missions = rs.getString("missions");
            poste = rs.getString("poste");
            lieu = rs.getString("lieu");
            montantIdemnite = rs.getInt("montantIdemnite");
            DetailsOffreVue detailsOffreVue = new DetailsOffreVue(idUser, idOffre, entrepriseAccueil, sujetStage, missions, poste, lieu, montantIdemnite);
            detailsOffreVue.setVisible(true);
        }
    }
}


