package src.vue;
import src.model.UserRegistration;

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

public class EspaceAdmin extends JFrame {

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    EspaceAdmin frame = new EspaceAdmin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public EspaceAdmin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAjouterUser = new JButton("Ajouter un utilisateur");
        btnAjouterUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new UserRegistration().setVisible(true);
            }
        });
        btnAjouterUser.setBounds(164, 211, 227, 67);
        contentPane.add(btnAjouterUser);

        JButton btnConsulterListeUser = new JButton("Consulter la liste des utilisateurs");
        btnConsulterListeUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConsulterListeUser.setBounds(447, 211, 227, 67);
        contentPane.add(btnConsulterListeUser);

        JButton btnConsulterLesOffres = new JButton("Consulter les offres de stage");
        btnConsulterLesOffres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListeOffre();
            }
        });
        btnConsulterLesOffres.setBounds(164, 360, 227, 67);
        contentPane.add(btnConsulterLesOffres);

        JButton btnConsulterListEtudiant = new JButton("Consulter la liste des Etudiants");
        btnConsulterListEtudiant.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnConsulterListEtudiant.setBounds(447, 360, 227, 67);
        contentPane.add(btnConsulterListEtudiant);

        JLabel lblNewLabel = new JLabel("ESPACE ADMIN");
        lblNewLabel.setForeground(new Color(75, 0, 130));
        lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewLabel.setBounds(283, 56, 301, 67);
        contentPane.add(lblNewLabel);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(656, 30, 117, 29);
        contentPane.add(btnLogout);

        JButton btnConsulterLesConventions = new JButton("Consulter les conventions de stage");
        btnConsulterLesConventions.setBounds(291, 482, 276, 67);
        contentPane.add(btnConsulterLesConventions);
    }
}

