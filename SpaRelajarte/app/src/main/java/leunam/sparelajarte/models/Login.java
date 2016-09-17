package leunam.sparelajarte.models;

/**
 * Created by manuel on 14/05/2016.
 */
public class Login {

    String username, password, key;

    public Login() {

    }

    public Login(String username, String password) {
        this.username = username;
        this.password = password;

    }

    public Login(String username, String password, String key) {
        this.username = username;
        this.password = password;
        this.key = key;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", key='" + key + '\'' +
                '}';
    }
}

