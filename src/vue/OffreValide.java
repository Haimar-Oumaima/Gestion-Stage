package src.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class OffreValide
{


    public OffreValide()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM offre WHERE statut = 1";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = { "Id", "Entreprise Accueil", "Sujet", "Missions", "poste", "Lieu de stage", "Montant dindemnité","Statut"};
            String data[][] = new String[10][9];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("id_offre");
                String entrepriseAccueil = res.getString("entrepriseAccueil");
                String sujetStage = res.getString("sujetStage");
                String missions = res.getString("missions");
                String poste = res.getString("poste");
                String lieu = res.getString("lieu");
                String montantIdemnite = res.getString("montantIdemnite");
                String statut = res.getString("statut");
                if(statut.equals("1"))
                {
                    statut = "Validé";
                }else {
                    statut = "Non Validé";
                }
                data[i][0] = id + "";
                data[i][1] = entrepriseAccueil;
                data[i][2] = sujetStage;
                data[i][3] = missions;
                data[i][4] = poste;
                data[i][5] = lieu;
                data[i][6] = montantIdemnite;
                data[i][7] = statut;
                i++;
            }

            JLabel lblNewLabel = new JLabel("La liste de vos offres de stage Validées");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
            lblNewLabel.setBounds(353, 0, 140, 60);

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model){
                public Class getColumnClass(int column) {
                    //renvoie Boolean.class
                    return getValueAt(0, column).getClass();
                }
            };
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Liste Offres Validées");
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(pane);
            f.add(panel);

            JButton btnNewButton_1 = new JButton("Retour");
            btnNewButton_1.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    Menu menu=new Menu();
                    menu.setVisible(true);
                }
            });
            btnNewButton_1.setBounds(41, 27, 117, 29);
            panel.add(btnNewButton_1);

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
