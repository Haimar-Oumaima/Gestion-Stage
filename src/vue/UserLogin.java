package src.vue;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class UserLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField textFieldUserLogin;
    private JPasswordField passwordField;
    private JButton btnNewButton;
    private JLabel label;
    private JPanel contentPane;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserLogin frame = new UserLogin();
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
    public UserLogin() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        setBackground(new Color(230, 230, 250));
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Mon Stage");
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 46));
        lblNewLabel.setBounds(300, 13, 273, 93);
        contentPane.add(lblNewLabel);

        textFieldUserLogin = new JTextField();
        textFieldUserLogin.setFont(new Font("Tahoma", Font.PLAIN, 25));
        textFieldUserLogin.setBounds(300, 190, 281, 68);
        contentPane.add(textFieldUserLogin);
        textFieldUserLogin.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 25));
        passwordField.setBounds(300, 306, 281, 68);
        contentPane.add(passwordField);

        JLabel lblUsername = new JLabel("Username");
        lblUsername.setBackground(Color.BLACK);
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblUsername.setBounds(150, 186, 193, 52);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setBackground(Color.CYAN);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 25));
        lblPassword.setBounds(150, 306, 193, 52);
        contentPane.add(lblPassword);

        btnNewButton = new JButton("Login");
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 26));
        btnNewButton.setBounds(350, 450, 162, 73);
        btnNewButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                String userName = textFieldUserLogin.getText();
                String password = passwordField.getText();
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

                            dispose();
                            Menu menu = new Menu(idUser);
                            menu.setVisible(true);
                            JOptionPane.showMessageDialog(btnNewButton, "Connexion r??ussie etudiant");

                        } else if (rs.getString("role").equals("Directeur")) {
                            dispose();
                            JOptionPane.showMessageDialog(btnNewButton, "Connexion r??ussie directeur");

                        } else if (rs.getString("role").equals("Admin")) {
                            dispose();
                            JOptionPane.showMessageDialog(btnNewButton, "Connexion r??ussie admin");

                        } else if ( rs.getString("role").equals("Enseignant")) {
                            dispose();
                            JOptionPane.showMessageDialog(btnNewButton, "Connexion r??ussie enseignant");
                            EspaceCommision enseignant = new EspaceCommision();
                            enseignant.setVisible(true);

                        } else if ( rs.getString("role").equals("Tuteur entreprise")) {
                            dispose();
                            JOptionPane.showMessageDialog(btnNewButton, "Connexion r??ussie tuteur entreprise");
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
        });

        contentPane.add(btnNewButton);
        label = new JLabel("");
        label.setBounds(0, 0, 1008, 562);
        contentPane.add(label);
    }
}