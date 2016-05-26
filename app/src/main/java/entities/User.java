package entities;

import java.io.Serializable;

/**
 * Created by Anastasiya on 26.05.2016.
 */
public class User  implements Serializable {
    //TODO: id <-which type it should havein postgresql? Fix if needed.
    String username;
    String password;
    String id;

    public User(String username, String password, String id) {
        this.username = username;
        this.password = password;
        this.id = id;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
