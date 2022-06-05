package src.model;

import java.sql.SQLException;

public class Convention {
    private int id;
    private String name;
    private String description;
    private String startDate;
    private String endDate;
    private String statut;


    public void setId(int id) {
        this.id = id;
    }

    public Convention(int id, String name, String description, String startDate, String endDate, String status ) throws SQLException, ClassNotFoundException {
        //super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.statut = status;
    }


    public int getId() {
        return id;
    }

    public String getStatus() {
        return statut;
    }

    public void setStatus(String statut) {
        this.statut = statut;
    }
}
