package src.vue;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListeOffre
{
    public ListeOffre()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");


            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM offre";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = { "Id", "Entreprise Accueil", "Sujet", "Missions", "poste", "Lieu de stage", "Montant dindemnité" };
            String data[][] = new String[10][9];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("id");
                String entrepriseAccueil = res.getString("entrepriseAccueil");
                String sujetStage = res.getString("sujetStage");
                String missions = res.getString("missions");
                String poste = res.getString("poste");
                String lieu = res.getString("lieu");
                String montantIdemnite = res.getString("montantIdemnite");
                data[i][0] = id + "";
                data[i][1] = entrepriseAccueil;
                data[i][2] = sujetStage;
                data[i][3] = missions;
                data[i][4] = poste;
                data[i][5] = lieu;
                data[i][6] = montantIdemnite;
                i++;
            }

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Liste Offres");
            JLabel lblNewLabel = new JLabel("La liste de vos offres de stage");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
            lblNewLabel.setBounds(353, 0, 140, 56);
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(pane);
            f.add(panel);
            panel.add(lblNewLabel);

            f.setSize(800, 700);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}