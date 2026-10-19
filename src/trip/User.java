package trip;

import java.util.UUID;

/**
 * User
 */
public class User {
    private final String userID;
    public User() {
        this.userID = UUID.randomUUID().toString();
    }
    public Object getID() {
        return this.userID;
    }
}
