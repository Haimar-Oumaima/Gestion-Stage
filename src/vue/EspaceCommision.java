package src.vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EspaceCommision extends JFrame {

    private JPanel contentPane;
    /**
     * Create the frame.
     */
    public EspaceCommision() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnValiderOffre = new JButton("Valider offre");
        btnValiderOffre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                CatalogueOffre ca = new CatalogueOffre("commision");
                dispose();
            }
        });
        btnValiderOffre.setBounds(154, 234, 227, 78);
        contentPane.add(btnValiderOffre);

        JButton btnConsulterLesOffres = new JButton("Consulter les offres de stage");
        btnConsulterLesOffres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListeOffre listeOffres = new ListeOffre("Espace Commission");
            }
        });
        btnConsulterLesOffres.setBounds(447, 234, 227, 78);
        contentPane.add(btnConsulterLesOffres);

        JButton btnConsulterListEtudiant = new JButton("Consulter la liste des Etudiants");
        btnConsulterListEtudiant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                ListEtudiant listeEtudiant = new ListEtudiant("Espace Commision");
            }
        });
        btnConsulterListEtudiant.setBounds(447, 383, 227, 78);
        contentPane.add(btnConsulterListEtudiant);

        JLabel lblNewLabel = new JLabel("ESPACE COMMISION");
        lblNewLabel.setForeground(new Color(75, 0, 130));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel.setBounds(248, 68, 374, 67);
        contentPane.add(lblNewLabel);

        JButton btnLogout = new JButton("Logout");
        btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnLogout.setBounds(657, 40, 117, 29);
        contentPane.add(btnLogout);

        JButton btnSignerConvention = new JButton("Signer Convention");
        btnSignerConvention.setBounds(154, 383, 227, 78);
        contentPane.add(btnSignerConvention);
    }
}








