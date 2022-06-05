package src.vue;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

/**
 * User Registration using Swing
 * @author javaguides.net
 *
 */
public class UserRegistration extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField firstname;
    private JTextField lastname;
    private JTextField email;
    private JTextField username;
    private JTextField mob;
    private JPasswordField passwordField;
    private JButton btnNewButton;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UserRegistration frame = new UserRegistration();
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

    public UserRegistration() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\User\\Desktop\\STDM.jpg"));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 700);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewUserRegister = new JLabel("Nouveau Utilisateur");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lblNewUserRegister.setBounds(250, 52, 360, 80);
        contentPane.add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblName.setBounds(30, 152, 99, 43);
        contentPane.add(lblName);

        JLabel lblNewLabel = new JLabel("Last name");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(30, 243, 110, 29);
        contentPane.add(lblNewLabel);

        JLabel lblEmailAddress = new JLabel("Email address");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblEmailAddress.setBounds(30, 324, 124, 36);
        contentPane.add(lblEmailAddress);

        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        firstname.setBounds(130, 151, 228, 50);
        contentPane.add(firstname);
        firstname.setColumns(10);

        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lastname.setBounds(130, 235, 228, 50);
        contentPane.add(lastname);
        lastname.setColumns(10);

        email = new JTextField();

        email.setFont(new Font("Tahoma", Font.PLAIN, 20));
        email.setBounds(130, 320, 228, 50);
        contentPane.add(email);
        email.setColumns(10);

        String[] items = {"Admin", "Etudiant", "Enseignant", "Directeur", "Tuteur entreprise"};
        JComboBox username = new JComboBox(items);
        contentPane.add(username);
        username.setBounds(507, 151, 228, 50);

        JLabel lblUsername = new JLabel("Role");
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblUsername.setBounds(400, 159, 99, 29);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblPassword.setBounds(400, 245, 99, 24);
        contentPane.add(lblPassword);

        JLabel lblMobileNumber = new JLabel("Mobile number");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblMobileNumber.setBounds(400, 329, 139, 26);
        contentPane.add(lblMobileNumber);

        mob = new JTextField();
        mob.setFont(new Font("Tahoma", Font.PLAIN, 20));
        mob.setBounds(507, 320, 228, 50);
        contentPane.add(mob);
        mob.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
        passwordField.setBounds(507, 235, 228, 50);
        contentPane.add(passwordField);


        btnNewButton = new JButton("Register");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String firstName = firstname.getText();
                String lastName = lastname.getText();
                String emailId = email.getText();
                String role = (String) username.getSelectedItem();
                String mobileNumber = mob.getText();
                int len = mobileNumber.length();
                String password = passwordField.getText();

                String msg = "" + firstName;
                msg += " \n";
                if (len != 10) {
                    JOptionPane.showMessageDialog(btnNewButton, "Enter a valid mobile number");
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:8889/gestion_stage","root","root");

                    String query = "insert into account (firstname,lastname,email,role,phone_number,password) values (?,?,?,?,?,?)";

                    PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);

                    pst.setString(1, firstName);
                    pst.setString(2, lastName);
                    pst.setString(3, emailId);
                    pst.setString(4, role);
                    pst.setString(5, mobileNumber);
                    pst.setString(6, password);

                    pst.executeUpdate();
                    ResultSet rs = pst.getGeneratedKeys();

                    rs.next();
                    int idResult = rs.getInt(1);


                    if (idResult > 0) {
                        JOptionPane.showMessageDialog(btnNewButton, "Account created successfully");
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        JButton btnNewButton_1 = new JButton("Retour");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                EspaceAdmin espaceAdmin = new EspaceAdmin();
                espaceAdmin.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(41, 27, 117, 29);
        contentPane.add(btnNewButton_1);

        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(300, 447, 259, 74);
        contentPane.add(btnNewButton);
    }
}
