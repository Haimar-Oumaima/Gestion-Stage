package src.controller;


import src.vue.UserLogin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login implements ActionListener {

    private UserLogin loginView;

    public Login(UserLogin loginView) {
        this.loginView = loginView;
    }
    @Override

    public void actionPerformed(ActionEvent e) {
       /* if (e.getSource() == loginView.getLoginButton()) {
            String username = loginView.getUsername();
            String password = loginView.getPassword();
            if (username.equals("admin") && password.equals("admin")) {
                loginView.setVisible(false);
                new MainMenu().show();
            } else {
                loginView.setVisible(false);
                new Login().show();
            }
        }*/
    }


    public void show() {
        loginView.setVisible(true);
    }
}
