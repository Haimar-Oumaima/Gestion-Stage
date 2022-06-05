package src.model;

public class Account {
    private int id;
    private String lastname;
    private String firstname;
        private String role; // "admin" or "prof" or "etudiant" or "Directeur"
    private String password;
    private String email;
    private String phone_number;

    public Account(int id, String lastname, String firstname, String role, String password, String email, String phone_number) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.role = role;
        this.password = password;
        this.email = email;
        this.phone_number = phone_number;
    }

    public Account(String firstname,String password) {
        this.firstname = firstname;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }



}
