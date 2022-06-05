package src.vue;
import src.sql.Connexion;
import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.PreparedStatement;

public class OffreStage extends JFrame {

    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_0;
    private JLabel lblNewLabel_6;


    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    OffreStage frame = new OffreStage();
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
    public OffreStage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(230, 230, 250));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Ajouter une offre de stage");
        lblNewLabel.setForeground(new Color(0, 0, 51));
        lblNewLabel.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
        lblNewLabel.setBounds(264, 39, 322, 77);
        contentPane.add(lblNewLabel);


        textField_0 = new JTextField();
        textField_0.setBackground(new Color(248, 248, 255));
        textField_0.setColumns(10);
        textField_0.setBounds(264, 144, 306, 47);
        contentPane.add(textField_0);

        textField = new JTextField();
        textField.setBackground(new Color(248, 248, 255));
        textField.setBounds(264, 203, 306, 47);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBackground(new Color(248, 248, 255));
        textField_1.setBounds(264, 262, 306, 106);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        textField_2 = new JTextField();
        textField_2.setBackground(new Color(248, 248, 255));
        textField_2.setColumns(10);
        textField_2.setBounds(264, 390, 306, 47);
        contentPane.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setBackground(new Color(248, 248, 255));
        textField_3.setColumns(10);
        textField_3.setBounds(264, 451, 306, 47);
        contentPane.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setBackground(new Color(248, 248, 255));
        textField_4.setColumns(10);
        textField_4.setBounds(264, 523, 306, 47);
        contentPane.add(textField_4);


        lblNewLabel_6 = new JLabel("Entreprise d'accueil");
        lblNewLabel_6.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
        lblNewLabel_6.setBounds(128, 159, 125, 16);
        contentPane.add(lblNewLabel_6);

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


        JButton btnNewButton = new JButton("Ajouter");
        btnNewButton.setBackground(new Color(0, 0, 128));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    PreparedStatement pst= Connexion.GetCon().prepareStatement("INSERT INTO offre( entrepriseAccueil, sujetStage, missions, poste, lieu, montantIdemnite) VALUES(?,?,?,?,?,?)");
                    pst.clearParameters();
                    pst.setString(1,textField_0.getText());
                    pst.setString(2,textField.getText());
                    pst.setString(3,textField_1.getText());
                    pst.setString(4,textField_2.getText());
                    pst.setString(5,textField_3.getText());
                    pst.setInt(6, Integer.parseInt(textField_4.getText()));
                    pst.executeUpdate();

                    /* Pop Up*/
                    JOptionPane.showMessageDialog(null,"offre Bien Ajouté","Success",1);
                } catch (Exception e1) {
                    System.err.println(e1.getMessage());
                }  }
        });
        btnNewButton.setBounds(366, 590, 160, 38);
        contentPane.add(btnNewButton);


        JButton btnNewButton_1 = new JButton("Retour");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                Menu menu=new Menu();
                menu.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(41, 27, 117, 29);
        contentPane.add(btnNewButton_1);

    }
}
