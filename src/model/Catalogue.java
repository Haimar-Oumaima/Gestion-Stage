package src.model;

import java.sql.SQLException;

public class Catalogue extends Offre{

    private int idOffre;
    private int idUser;
    private int statut = 0;

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getStatut() {
        return statut;
    }

    public void setStatut(int statut) {
        this.statut = statut;
    }

    public Catalogue(int idOffre, int idUser) throws SQLException, ClassNotFoundException {
        super(idOffre, idUser);
    }

}
