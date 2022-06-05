package src.vue;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class ConventionVue extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldSujet;
    private JTextField textFieldEncadrant;
    private JLabel lblNewLabel_1;
    private JLabel lblEncadrantEntp;
    private JLabel lblDateDeb;
    private JLabel lblDateFin;
    private JLabel lblLieu;
    private JTextField textFieldDateDeb;
    private JTextField textFieldDateFin;
    private JTextField textFieldLieu;
    private JTextField textFieldEntrp;
    private JLabel lblNewLabel_6;
    private JTextField textFieldMontant;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    // ConventionVue frame = new ConventionVue();
                    // frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ConventionVue(String idCatalogue) throws SQLException, ClassNotFoundException {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblDemandConvention = new JLabel("Etablir Convention");
        lblDemandConvention.setForeground(new Color(0, 0, 51));
        lblDemandConvention.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
        lblDemandConvention.setBounds(311, 39, 348, 77);
        contentPane.add(lblDemandConvention);

        textFieldSujet = new JTextField();
        textFieldSujet.setEditable(false);
        textFieldSujet.setBackground(new Color(248, 248, 255));
        textFieldSujet.setBounds(300, 210, 306, 47);
        contentPane.add(textFieldSujet);
        textFieldSujet.setColumns(10);

        textFieldEncadrant = new JTextField();
        textFieldEncadrant.setBackground(new Color(248, 248, 255));
        textFieldEncadrant.setBounds(300, 269, 306, 47);
        contentPane.add(textFieldEncadrant);
        textFieldEncadrant.setColumns(10);

        lblNewLabel_1 = new JLabel("Sujet de stage");
        lblNewLabel_1.setBounds(162, 223, 125, 16);
        contentPane.add(lblNewLabel_1);

        lblEncadrantEntp = new JLabel("Encadrant entreprise");
        lblEncadrantEntp.setBounds(162, 277, 138, 29);
        contentPane.add(lblEncadrantEntp);

        lblDateDeb = new JLabel("Date de Début");
        lblDateDeb.setBounds(162, 341, 102, 16);
        contentPane.add(lblDateDeb);

        lblDateFin = new JLabel("Date de Fin");
        lblDateFin.setBounds(162, 410, 102, 16);
        contentPane.add(lblDateFin);

        lblLieu = new JLabel("Lieu");
        lblLieu.setBounds(162, 471, 125, 16);
        contentPane.add(lblLieu);

        textFieldDateDeb = new JTextField();
        textFieldDateDeb.setBackground(new Color(248, 248, 255));
        textFieldDateDeb.setColumns(10);
        textFieldDateDeb.setBounds(300, 328, 306, 47);
        contentPane.add(textFieldDateDeb);

        textFieldDateFin = new JTextField();
        textFieldDateFin.setBackground(new Color(248, 248, 255));
        textFieldDateFin.setColumns(10);
        textFieldDateFin.setBounds(300, 397, 306, 47);
        contentPane.add(textFieldDateFin);

        textFieldLieu = new JTextField();
        textFieldLieu.setEditable(false);
        textFieldLieu.setBackground(new Color(248, 248, 255));
        textFieldLieu.setColumns(10);
        textFieldLieu.setBounds(300, 458, 306, 47);
        contentPane.add(textFieldLieu);

        JButton btnAjoutCatalogue = new JButton("Etablir ma convention");
        btnAjoutCatalogue.setBackground(new Color(0, 0, 128));


        btnAjoutCatalogue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String encadrant = textFieldEncadrant.getText();
                String dateDeb = textFieldDateDeb.getText();
                String dateFin = textFieldDateFin.getText();
                String lieu = textFieldLieu.getText();
                String entreprise = textFieldEntrp.getText();
                String montant = textFieldMontant.getText();
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");
                    String query = "INSERT INTO convention(catalogue_id, identite_encadrant, date_debut, date_fin) VALUES (?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
                    pst.setInt(1, Integer.parseInt(idCatalogue));
                    pst.setString(2, encadrant);
                    pst.setString(3, dateDeb);
                    pst.setString(4, dateFin);
                    pst.executeUpdate();
                    ResultSet rs = pst.getGeneratedKeys();

                    rs.next();
                    int idResult = rs.getInt(1);

                    if (idResult > 0) {
                        JOptionPane.showMessageDialog(null, "Convention établie avec succès");  //affiche un message de succès
                    }
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btnAjoutCatalogue.setBounds(360, 594, 167, 47);
        contentPane.add(btnAjoutCatalogue);


        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });

        btnRetour.setBounds(40, 22, 117, 29);
        contentPane.add(btnRetour);

        textFieldEntrp = new JTextField();
        textFieldEntrp.setEditable(false);
        textFieldEntrp.setBackground(new Color(248, 248, 255));
        textFieldEntrp.setColumns(10);
        textFieldEntrp.setBounds(300, 144, 306, 47);
        contentPane.add(textFieldEntrp);

        lblNewLabel_6 = new JLabel("Entreprise d'accueil");
        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(162, 159, 125, 16);
        contentPane.add(lblNewLabel_6);

        textFieldMontant = new JTextField();
        textFieldMontant.setEditable(false);
        textFieldMontant.setColumns(10);
        textFieldMontant.setBackground(new Color(248, 248, 255));
        textFieldMontant.setBounds(300, 520, 306, 47);
        contentPane.add(textFieldMontant);

        JLabel lblMontant = new JLabel("Montant indemnité");
        lblMontant.setBounds(162, 535, 125, 16);
        contentPane.add(lblMontant);
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage", "root", "root");

        Class.forName("com.mysql.cj.jdbc.Driver");

        String query = "SELECT * FROM catalogue WHERE id = " + idCatalogue;


        Statement stm = con.createStatement();
        ResultSet res = stm.executeQuery(query);
        String entrepriseAccueil = null;
        String montantIdemnite = null;
        String lieu = null;
        String sujetStage = null;
        while (res.next()) {
            int offreId = res.getInt("offre_id");
            int accountId = res.getInt("account_id");
            int statut = res.getInt("statut");
            String query2 = "SELECT * FROM offre WHERE id = " + offreId;
            Statement stm2 = con.createStatement();
            ResultSet res2 = stm2.executeQuery(query2);
            entrepriseAccueil = null;
            sujetStage = null;
            montantIdemnite = null;
            lieu = null;

            while (res2.next()) {
                entrepriseAccueil = res2.getString("entrepriseAccueil");
                sujetStage = res2.getString("sujetStage");
                lieu = res2.getString("lieu");
                montantIdemnite = res2.getString("montantIdemnite");

            }

        }
        textFieldEntrp.setText(entrepriseAccueil);
        textFieldSujet.setText(sujetStage);
        textFieldLieu.setText(lieu);
        textFieldMontant.setText(montantIdemnite);

    }
}
