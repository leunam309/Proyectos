package leunam.sparelajarte.models;

/**
 * Created by manuel on 14/05/2016.
 */
public class Usuario {

    String email, firstName, username, lastName;


    public Usuario() {
    }

    public Usuario(String email, String firstName, String username) {
        this.email = email;
        this.firstName = firstName;
        this.username = username;
    }

    public Usuario(String email, String firstName, String username, String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.username = username;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
