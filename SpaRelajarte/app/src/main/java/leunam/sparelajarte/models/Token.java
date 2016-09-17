package leunam.sparelajarte.models;

/**
 * Created by manuel on 14/05/2016.
 */
public class Token {

    String key;

    public Token() {
    }

    public Token(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Token{" +
                "key='" + key + '\'' +
                '}';
    }
}
