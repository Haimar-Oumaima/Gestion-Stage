package src.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Login frame = new Login();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");

    JLabel lblSeConnecter = new JLabel("Se Connecter");

    JLabel lblMonStage = new JLabel("Mon Stage");


    Login() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setForegroundFont();
        setTitle("Login Form");
        setVisible(true);
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(230, 250, 100, 30);
        passwordLabel.setBounds(230, 320, 100, 30);
        userTextField.setBounds(330, 250, 150, 30);
        passwordField.setBounds(330, 320, 150, 30);
        showPassword.setBounds(380, 350, 150, 30);
        loginButton.setBounds(230, 400, 100, 30);
        resetButton.setBounds(430, 400, 100, 30);
        lblSeConnecter.setBounds(280, 130, 322, 77);
        lblMonStage.setBounds(280, 30, 322, 77);
        setBounds(100, 100, 800, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
    }

    public void setForegroundFont() {
        lblSeConnecter.setForeground(new Color(0, 0, 51));
        lblMonStage.setForeground(new Color(0, 0, 52));
        lblSeConnecter.setFont(new Font("Helvetica Neue", Font.BOLD, 22));
        lblMonStage.setFont(new Font("Helvetica Neue", Font.BOLD, 26));
    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
        container.add(lblSeConnecter);
        container.add(lblMonStage);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == loginButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("oumaima") && pwdText.equalsIgnoreCase("haimar")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
                setVisible(false);
                Menu menu=new Menu();
                menu.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        // RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }


        }
    }

}
