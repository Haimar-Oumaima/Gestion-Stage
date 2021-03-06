package src.vue;

import src.model.CatalogueOffre;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame {

    private int idUser;

    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        System.out.println();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Menu frame = new Menu();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void initializeWidthIdUser(int idUser) {
        this.idUser = idUser;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAjoutOffre = new JButton("Ajouter une offre trouvée");
        btnAjoutOffre.setBackground(new Color(255, 255, 255));
        btnAjoutOffre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                OffreStage stg = new OffreStage("Etudiant");
                stg.setVisible(true);
            }
        });
        btnAjoutOffre.setBounds(287, 122, 271, 83);
        contentPane.add(btnAjoutOffre);

        JButton btnConsulterMesOffres = new JButton("Consulter les offres proposées");
        btnConsulterMesOffres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                System.out.println("idUser2 : " + idUser);
                new ListeOffre(idUser);
            }
        });
        btnConsulterMesOffres.setBounds(287, 243, 271, 83);
        contentPane.add(btnConsulterMesOffres);

        JButton btnOffreValides = new JButton("Suivre Mes Offres");
        btnOffreValides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CatalogueOffre catalogueOffre = new CatalogueOffre("Offre Validées", idUser);
            }
        });
        btnOffreValides.setBounds(287, 375, 271, 83);
        contentPane.add(btnOffreValides);

        JButton btnConvention = new JButton("Etablir Convention");
        btnConvention.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CatalogueOffre("Convention");
            }
        });
        btnConvention.setBounds(287, 500, 271, 83);
        contentPane.add(btnConvention);

        JLabel lblNewLabel = new JLabel("Mon Stage");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
        lblNewLabel.setBounds(353, 31, 140, 56);
        contentPane.add(lblNewLabel);

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRetour.setBounds(34, 31, 117, 29);
        contentPane.add(btnRetour);
    }

    private void initialize() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnAjoutOffre = new JButton("Ajouter une offre");
        btnAjoutOffre.setBackground(new Color(255, 255, 255));
        btnAjoutOffre.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                OffreStage stg = new OffreStage("Etudiant");
                stg.setVisible(true);
            }
        });
        btnAjoutOffre.setBounds(287, 122, 271, 83);
        contentPane.add(btnAjoutOffre);

        JButton btnConsulterMesOffres = new JButton("Consulter mes offres");
        btnConsulterMesOffres.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new ListeOffre("Etudiant");
            }
        });
        btnConsulterMesOffres.setBounds(287, 243, 271, 83);
        contentPane.add(btnConsulterMesOffres);

        JButton btnOffreValides = new JButton("Offre Validées");
        btnOffreValides.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                CatalogueOffre catalogueOffre = new CatalogueOffre("Offre Validées");

            }
        });
        btnOffreValides.setBounds(287, 375, 271, 83);
        contentPane.add(btnOffreValides);

        JButton btnConvention = new JButton("Etablir Convention");
        btnConvention.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new CatalogueOffre("Convention");
            }
        });
        btnConvention.setBounds(287, 500, 271, 83);
        contentPane.add(btnConvention);

        JLabel lblNewLabel = new JLabel("Mon Stage");
        lblNewLabel.setForeground(new Color(0, 0, 128));
        lblNewLabel.setFont(new Font("Kokonor", Font.BOLD, 30));
        lblNewLabel.setBounds(353, 31, 140, 56);
        contentPane.add(lblNewLabel);

        JButton btnRetour = new JButton("Retour");
        btnRetour.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnRetour.setBounds(34, 31, 117, 29);
        contentPane.add(btnRetour);
    }

    public Menu() {
        initialize();
    }

    public Menu(int idUser) {
        initializeWidthIdUser(idUser);
    }
}
