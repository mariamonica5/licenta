package Exemplu;

/**
 * Created by camelia on 11/16/2016.
 */
public class User {
    String username;
    String passw;

    public User(String username, String passw) {
        this.username = username;
        this.passw = passw;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", passw='" + passw + '\'' +
                '}';
    }
}
