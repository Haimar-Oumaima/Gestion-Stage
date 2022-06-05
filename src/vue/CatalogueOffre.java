package src.vue;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class CatalogueOffre {

    //String[] listeOffre;
    String entrepriseAccueil;
    String lieu;
    String missions;
    String montantIdemnite;
    String poste;
    String sujetStage;

    private void intialize(String type) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM catalogue";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = {"Id", "Entreprise Accueil", "Sujet", "Missions", "poste", "Lieu de stage", "Montant dindemnité", "Statut"};
            String data[][] = new String[20][9];
            int i = 0;
            while (res.next()) {

                data[i][0] = String.valueOf(res.getInt("id")); // hed la ligne

                int offreId = res.getInt("offre_id");
                int idUser = res.getInt("account_id");
                int statut = res.getInt("statut");

                String query2 = "SELECT * FROM offre WHERE id = " + offreId;
                Statement stm2 = con.createStatement();
                ResultSet res2 = stm2.executeQuery(query2);
                 entrepriseAccueil = null;
                 sujetStage = null;
                 montantIdemnite = null;
                 lieu = null;
                 poste = null;
                 missions = null;

                while (res2.next()) {
                    int id = res.getInt("id");
                    entrepriseAccueil = res2.getString("entrepriseAccueil");
                    sujetStage = res2.getString("sujetStage");
                    missions = res2.getString("missions");
                    poste = res2.getString("poste");
                    lieu = res2.getString("lieu");
                    montantIdemnite = res2.getString("montantIdemnite");
                }

                String query3 = "SELECT * FROM account WHERE id = " + idUser;
                Statement stm3 = con.createStatement();
                ResultSet res3 = stm3.executeQuery(query3);
                String nameComplet = null;

                while (res3.next()) {
                    String nom = res3.getString("firstname");
                    String prenom = res3.getString("lastname");
                    nameComplet = nom + " " + prenom;
                }

                data[i][1] = entrepriseAccueil;
                data[i][2] = sujetStage;
                data[i][3] = missions;
                data[i][4] = poste;
                data[i][5] = lieu;
                data[i][6] = montantIdemnite;
                data[i][7] = statut == 0 ? "En attente" : statut == 1 ? "Accepté" : "Refusé";
                i++;
            }

            //DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(data, columns);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);

            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    String idCatalogue = (String) table.getValueAt(row, 0);
                    if (idCatalogue != null) {
                        System.out.println(idCatalogue);
                    }
                }
            });

            JLabel lblNewLabel = new JLabel("La liste de toutes les offres des étudiants");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
            lblNewLabel.setBounds(353, 0, 140, 60);

            JFrame f = new JFrame("Liste Offres Validées");
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(pane);
            f.add(panel);

            if (type.equals("Convention")) {
                JButton btnEtablConv = new JButton("Etablir ma convention");
                btnEtablConv.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                btnEtablConv.setBounds(200, 400, 117, 29);
                panel.add(btnEtablConv);
            }

            JButton btnRetou = new JButton("Retour");
            btnRetou.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    if(type.equals("commision")){
                        new EspaceCommision().setVisible(true);
                    }else {
                        Menu menu = new Menu();
                        menu.setVisible(true);
                    }
                }
            });

            btnRetou.setBounds(41, 27, 117, 29);
            panel.add(btnRetou);

            JButton btnAccepter = new JButton("Accepter");
            btnAccepter.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    String idCatalogue = (String) table.getValueAt(row, 0);
                    if (idCatalogue != null) {
                        int idOffre = Integer.parseInt(idCatalogue);
                        String query = "UPDATE catalogue SET statut = 1 WHERE id = " + idOffre;
                        try {
                            stm.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Offre a été accepter");
                        } catch (SQLException ex) {
                            Logger.getLogger(ListeOffre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            panel.add(btnAccepter);

            JButton btnRefuser = new JButton("Refuser");
            btnRefuser.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    String idCatalogue = (String) table.getValueAt(row, 0);
                    if (idCatalogue != null) {
                        int idOffre = Integer.parseInt(idCatalogue);
                        String query = "UPDATE catalogue SET statut = 2 WHERE id = " + idOffre;
                        try {
                            stm.executeUpdate(query);
                            JOptionPane.showMessageDialog(null, "Offre a été refuser");
                        } catch (SQLException ex) {
                            Logger.getLogger(ListeOffre.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });

            panel.add(btnRefuser);
            f.setSize(800, 700);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void intializewithIdUser(String type, int idUser) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM catalogue WHERE account_id = " + idUser;

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = {"Id", "Entreprise Accueil", "Sujet", "Missions", "poste", "Lieu de stage", "Montant dindemnité", "Statut"};
            String data[][] = new String[10][9];
            int i = 0;
            while (res.next()) {
                data[i][0] = String.valueOf(res.getInt("id"));

                int offreId = res.getInt("offre_id");
                int statut = res.getInt("statut");

                String query2 = "SELECT * FROM offre WHERE id = " + offreId;
                Statement stm2 = con.createStatement();
                ResultSet res2 = stm2.executeQuery(query2);
                String entrepriseAccueil = null;
                String sujetStage = null;
                String montantIdemnite = null;
                String lieu = null;
                String poste = null;
                String missions = null;
                while (res2.next()) {
                    int id = res.getInt("id");
                    entrepriseAccueil = res2.getString("entrepriseAccueil");
                    sujetStage = res2.getString("sujetStage");
                    missions = res2.getString("missions");
                    poste = res2.getString("poste");
                    lieu = res2.getString("lieu");
                    montantIdemnite = res2.getString("montantIdemnite");
                }
                String query3 = "SELECT * FROM account WHERE id = " + idUser;
                Statement stm3 = con.createStatement();
                ResultSet res3 = stm3.executeQuery(query3);
                String nameComplet = null;

                while (res3.next()) {
                    String nom = res3.getString("firstname");
                    String prenom = res3.getString("lastname");
                    nameComplet = nom + " " + prenom;
                }

                data[i][1] = entrepriseAccueil;
                data[i][2] = sujetStage;
                data[i][3] = missions;
                data[i][4] = poste;
                data[i][5] = lieu;
                data[i][6] = montantIdemnite;
                data[i][7] = statut == 0 ? "En attente" : statut == 1 ? "Accepté" : "Refusé";
                i++;
            }

            JLabel lblNewLabel = new JLabel("Votre catalogue");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
            lblNewLabel.setBounds(353, 0, 140, 60);

            JTable table = new JTable(data, columns);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.isEditing();
            JScrollPane pane = new JScrollPane(table);

            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    String idCatalogue = (String) table.getValueAt(row, 0);
                    if (idCatalogue != null) {
                        try {
                            new ConventionVue(idCatalogue).setVisible(true);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });

            JFrame f = new JFrame("Liste Offres");
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(pane);
            f.add(panel);
            f.setBounds(100, 100, 800, 600);
            f.setVisible(true);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public CatalogueOffre(String type, int idUser) {
        intializewithIdUser(type, idUser);
    }

    public CatalogueOffre(String type) {
        intialize(type);
    }
}
