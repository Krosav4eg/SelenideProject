package api.serializableClasses;

import lombok.Data;

@Data
public class User {
    public String username;
    public String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public static synchronized User getUserAuth(String username, String password) {
        return new User(username, password);
    }
}