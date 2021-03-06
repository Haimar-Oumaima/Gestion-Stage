package src.model;

import src.vue.EspaceAdmin;
import src.vue.EspaceCommision;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Etudiant
{
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String tel;
    private String password;

    public Etudiant(String rolee)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");

            Class.forName("com.mysql.cj.jdbc.Driver");

            String query = "SELECT * FROM account where role = 'Etudiant'";

            Statement stm = con.createStatement();
            ResultSet res = stm.executeQuery(query);

            String columns[] = { "Id","Nom", "Prénom", "Gmail", "Rôle", "Tel", "Password"};
            String data[][] = new String[10][9];

            int i = 0;
            while (res.next()) {
                int id = res.getInt("id");
                 nom = res.getString("firstname");
                 prenom = res.getString("lastname");
                 email = res.getString("email");
                 role = res.getString("role");
                 tel = res.getString("phone_number");
                 password = res.getString("password");

                data[i][0] = String.valueOf(id);
                data[i][1] = nom;
                data[i][2] = prenom;
                data[i][3] = email;
                data[i][4] = role;
                data[i][5] = tel;
                data[i][6] = password;
                i++;

            }

            JLabel lblNewLabel = new JLabel("La liste des étudiants");
            lblNewLabel.setForeground(new Color(0, 0, 128));
            lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
            lblNewLabel.setBounds(353, 0, 140, 60);

            DefaultTableModel model = new DefaultTableModel(data, columns);
            JTable table = new JTable(model);
            table.setShowGrid(true);
            table.setShowVerticalLines(true);
            JScrollPane pane = new JScrollPane(table);
            JFrame f = new JFrame("Liste Etudiant");
            JPanel panel = new JPanel();
            panel.add(lblNewLabel);
            panel.add(pane);
            f.add(panel);

            JButton btnRetour = new JButton("Retour");
            btnRetour.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    f.dispose();
                    if(rolee.equals("Admin"))
                    {
                        EspaceAdmin espaceAdmin = new EspaceAdmin();
                        espaceAdmin.setVisible(true);
                    }
                    else if(rolee.equals("Espace Commision"))
                    {
                        EspaceCommision espaceCommission = new EspaceCommision();
                        espaceCommission.setVisible(true);
                    }

                }
            });
            btnRetour.setBounds(41, 27, 117, 29);
            panel.add(btnRetour);

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