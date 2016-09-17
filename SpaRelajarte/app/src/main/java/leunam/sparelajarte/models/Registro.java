package leunam.sparelajarte.models;

/**
 * Created by manuel on 14/05/2016.
 */
public class Registro {

    String username, password1, password2, email;

    public Registro() {

    }

    public Registro(String username, String password1) {
        this.username = username;
        this.password1 = password1;

    }

    public Registro(String username, String password1, String email) {
        this.username = username;
        this.password1 = password1;
        this.email = email;
    }

    public Registro(String username, String password1, String password2, String email) {
        this.username = username;
        this.password1 = password1;
        this.password2 = password2;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Registro{" +
                "username='" + username + '\'' +
                ", password='" + password1 + '\'' +
                ", passwordo='" + password2 + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

