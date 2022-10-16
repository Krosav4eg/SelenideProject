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
}