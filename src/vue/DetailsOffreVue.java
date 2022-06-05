package src.vue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class DetailsOffreVue extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldSujet;
    private JTextField textFieldMission;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JTextField textFieldPoste;
    private JTextField textFieldLieu;
    private JTextField textFieldMontant;
    private JTextField textFieldEntrp;
    private JLabel lblNewLabel_6;


    /**
     * Create the frame.
     */
    public DetailsOffreVue(int idUser, int idOffre, String entrepriseAccueil, String sujetStage, String missions, String poste, String lieu, int montantIdemnite) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDetailOffre = new JLabel("Détails Offre");
        lblDetailOffre.setForeground(new Color(0, 0, 51));
        lblDetailOffre.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
        lblDetailOffre.setBounds(311, 38, 209, 77);
        contentPane.add(lblDetailOffre);

        textFieldSujet = new JTextField();
        textFieldSujet.setEnabled(false);
        textFieldSujet.setEditable(false);
        textFieldSujet.setText(sujetStage);
        textFieldSujet.setBackground(new Color(248, 248, 255));
        textFieldSujet.setBounds(264, 203, 306, 47);
        contentPane.add(textFieldSujet);
        textFieldSujet.setColumns(10);

        textFieldMission = new JTextField();
        textFieldMission.setEnabled(false);
        textFieldMission.setEditable(false);
        textFieldMission.setText(missions);
        textFieldMission.setBackground(new Color(248, 248, 255));
        textFieldMission.setBounds(264, 262, 306, 106);
        contentPane.add(textFieldMission);
        textFieldMission.setColumns(10);

        lblNewLabel_1 = new JLabel("Sujet de stage");
        lblNewLabel_1.setBounds(128, 218, 125, 16);
        contentPane.add(lblNewLabel_1);

        lblNewLabel_2 = new JLabel("Missions");
        lblNewLabel_2.setBounds(128, 272, 61, 16);
        contentPane.add(lblNewLabel_2);

        lblNewLabel_3 = new JLabel("Poste");
        lblNewLabel_3.setBounds(128, 405, 61, 16);
        contentPane.add(lblNewLabel_3);

        lblNewLabel_4 = new JLabel("Lieu de stage");
        lblNewLabel_4.setBounds(128, 466, 102, 16);
        contentPane.add(lblNewLabel_4);

        lblNewLabel_5 = new JLabel("Montant indemnité");
        lblNewLabel_5.setBounds(128, 538, 125, 16);
        contentPane.add(lblNewLabel_5);

        textFieldPoste = new JTextField();
        textFieldPoste.setEnabled(false);
        textFieldPoste.setEditable(false);
        textFieldPoste.setText(poste);
        textFieldPoste.setBackground(new Color(248, 248, 255));
        textFieldPoste.setColumns(10);
        textFieldPoste.setBounds(264, 390, 306, 47);
        contentPane.add(textFieldPoste);

        textFieldLieu = new JTextField();
        textFieldLieu.setEnabled(false);
        textFieldLieu.setEditable(false);
        textFieldLieu.setText(lieu);
        textFieldLieu.setBackground(new Color(248, 248, 255));
        textFieldLieu.setColumns(10);
        textFieldLieu.setBounds(264, 451, 306, 47);
        contentPane.add(textFieldLieu);

        textFieldMontant = new JTextField();
        textFieldMontant.setEnabled(false);
        textFieldMontant.setEditable(false);
        textFieldMontant.setText(String.valueOf(montantIdemnite));
        textFieldMontant.setBackground(new Color(248, 248, 255));
        textFieldMontant.setColumns(10);
        textFieldMontant.setBounds(264, 523, 306, 47);
        contentPane.add(textFieldMontant);

        JButton btnAjoutCatalogue = new JButton("Ajouter au catalogue");
        btnAjoutCatalogue.setBackground(new Color(0, 0, 128));
        btnAjoutCatalogue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Ajout au catalogue");
                System.out.println(idOffre);
                System.out.println(idUser);

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");
                    String query = "INSERT INTO catalogue (offre_id, account_id) VALUES (?, ?)";
                    PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
                    pst.setInt(1, idOffre);
                    pst.setInt(2, idUser);
                    pst.executeUpdate();
                    ResultSet rs = pst.getGeneratedKeys();

                    rs.next();
                    int idResult = rs.getInt(1);

                    if (idResult > 0) {
                        JOptionPane.showMessageDialog(null, "L'offre a été ajouter à votre catalogue, Votre demande est en cours de traitement");
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnAjoutCatalogue.setBounds(352, 590, 160, 38);
        contentPane.add(btnAjoutCatalogue);


        JButton btnNewButton_1 = new JButton("Retour");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                //new ListeOffre();
            }
        });

        btnNewButton_1.setBounds(41, 27, 117, 29);

        contentPane.add(btnNewButton_1);

        textFieldEntrp = new JTextField();
        textFieldEntrp.setEnabled(false);
        textFieldEntrp.setEditable(false);
        textFieldEntrp.setText(entrepriseAccueil);
        textFieldEntrp.setBackground(new Color(248, 248, 255));
        textFieldEntrp.setColumns(10);
        textFieldEntrp.setBounds(264, 144, 306, 47);
        contentPane.add(textFieldEntrp);

        lblNewLabel_6 = new JLabel("Entreprise d'accueil");
        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(128, 159, 125, 16);
        contentPane.add(lblNewLabel_6);
    }
}
