package src.vue;

import src.model.Offre;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import static java.lang.Integer.parseInt;

public class ListeOffre
{
    int idUser = 0;

    private void initialize (String rolee) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM offre";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = { "Id", "Entreprise Accueil", "Sujet", "Missions", "poste", "Lieu de stage", "Montant dindemnité"};
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

                data[i][0]= String.valueOf(id);
                data[i][1] = entrepriseAccueil;
                data[i][2] = sujetStage;
                data[i][3] = missions;
                data[i][4] = poste;
                data[i][5] = lieu;
                data[i][6] = montantIdemnite;
                i++;
            }

            JLabel lblNewLabel = new JLabel("La liste de tous les offres de stage");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
            lblNewLabel.setBounds(353, 0, 140, 60);

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);

          /*  model.addTableModelListener(new TableModelListener() {
                @Override
                public void tableChanged(TableModelEvent e) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    String columnName = table.getColumnName(0);
                    Object IdOffre = table.getValueAt(row, 0);
                    if (IdOffre != null) {
                        System.out.println(IdOffre);
                        try {
                            new DetailsOffre(parseInt(IdOffre.toString()) , idUser);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            });*/

            JFrame f = new JFrame("Liste Offres");
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(pane);
            f.add(panel);

            JButton btnRetour = new JButton("Retour");
            btnRetour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    if(rolee == "Espace Commission"){
                        new EspaceCommision().setVisible(true);

                    } else if (rolee == "Etudiant"){
                        Menu menu=new Menu(idUser);
                        menu.setVisible(true);
                    }else if (rolee == "Admin"){
                        new EspaceAdmin().setVisible(true);
                    }
                }
            });
            btnRetour.setBounds(41, 27, 117, 29);
            panel.add(btnRetour);

            f.setBounds(100,100,800, 700);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private void initializeWithIdUser (int idUser){
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM offre";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = { "Id", "Entreprise Accueil", "Sujet", "Missions", "poste", "Lieu de stage", "Montant dindemnité"};
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

                data[i][0]= String.valueOf(id);
                data[i][1] = entrepriseAccueil;
                data[i][2] = sujetStage;
                data[i][3] = missions;
                data[i][4] = poste;
                data[i][5] = lieu;
                data[i][6] = montantIdemnite;
                i++;
            }

            JLabel lblNewLabel = new JLabel("La liste des offres de stage");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 28));
            lblNewLabel.setBounds(353, 0, 140, 60);

            JLabel lblInfo = new JLabel("Cliquer pour voir en détail et pour ajouter l'offre à votre catalogue");
            lblInfo.setForeground(new Color(0, 0, 128));
            lblInfo.setFont(new Font("Lucida Grande", Font.BOLD, 22));
            lblInfo.setBounds(353, 30, 140, 60);


        //    DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(data, columns);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            table.isEditing();
            JScrollPane pane = new JScrollPane(table);

            table.addMouseListener( new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    int row = table.getSelectedRow();
                    int column = table.getSelectedColumn();
                    String IdOffre = (String) table.getValueAt(row, 0);
                    if (IdOffre != null) {
                        try {
                            new Offre(parseInt(IdOffre.toString()) , idUser);
                } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
              /* public void tableChanged(TableModelEvent e) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    String columnName = table.getColumnName(0);
                    Object IdOffre = table.getValueAt(row, 0);
                    if (IdOffre != null) {
                        try {
                            new DetailsOffre(parseInt(IdOffre.toString()) , idUser);
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        } catch (ClassNotFoundException ex) {
                            throw new RuntimeException(ex);
                        }
                    }*/
                }
            });

            JFrame f = new JFrame("Liste Offres");
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(lblInfo);
            panel.add(pane);
            f.add(panel);

            JButton btnDetail = new JButton("Voir les détails");
            btnDetail.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                }
            });
            btnDetail.setBounds(41, 27, 117, 29);
            panel.add(btnDetail);

            JButton btnRetour = new JButton("Retour");
            btnRetour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    Menu menu=new Menu(idUser);
                    menu.setVisible(true);
                }
            });
            btnRetour.setBounds(41, 27, 117, 29);
            panel.add(btnRetour);


            f.setBounds(0,0,800, 700);
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setVisible(true);

        } catch(SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public ListeOffre(String rolee)
    {
        initialize(rolee);
    }

    public ListeOffre(int idUser) {
        this.idUser = idUser;
        System.out.println("id:  a   " +idUser);
        initializeWithIdUser(idUser);
    }
}