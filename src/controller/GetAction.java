package src.controller;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.sql.*;

/*
public class GetAction extends AbstractAction {
    private LoginView loginView;

    public GetAction(LoginView loginView, String texte){
        super(texte);
        this.loginView = loginView;
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == btnNewButton){
            String userName = loginView.textFieldUserLogin.getText();
            String password = loginView.passwordField.getText();
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");

                PreparedStatement st = (PreparedStatement) con.prepareStatement("Select * from account where firstname=? and password=?");

                st.setString(1, userName);
                st.setString(2, password);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    int idUser = rs.getInt("id");
                    if (rs.getString("role").equals("Etudiant")) {
                       // dispose();
                        this.loginView.setVisible(false);
                        EspaceUserView menu = new EspaceUserView(idUser);
                        menu.setVisible(true);
                        JOptionPane.showMessageDialog(btnNewButton, "Connexion réussie etudiant");

                    } else if (rs.getString("role").equals("Directeur")) {
                       // dispose();
                        JOptionPane.showMessageDialog(btnNewButton, "Connexion réussie directeur");

                    } else if (rs.getString("role").equals("Admin")) {
                       // dispose();
                        this.loginView.setVisible(false);
                        JOptionPane.showMessageDialog(btnNewButton, "Connexion réussie admin");

                    } else if ( rs.getString("role").equals("Enseignant")) {
                        //dispose();
                        this.loginView.setVisible(false);
                        JOptionPane.showMessageDialog(btnNewButton, "Connexion réussie enseignant");
                        EspaceProfView enseignant = new EspaceProfView();
                        //enseignant.setVisible(true);

                    } else if ( rs.getString("role").equals("Tuteur entreprise")) {
                        //dispose();
                        this.loginView.setVisible(false);
                        JOptionPane.showMessageDialog(btnNewButton, "Connexion réussie tuteur entreprise");
                    }

                } else {
                    JOptionPane.showMessageDialog(btnNewButton, "mauvais identifiant ou mot de passe");
                }
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            } catch (ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        }

    }
} */