package atmINTERFACE;

import java.util.HashMap;

public class UserDatabase {
    private HashMap<String, User> users; // Key: UserID, Value: User

    public UserDatabase() {
        users = new HashMap<>();
        // Initialize with some dummy data or load data from a file or database.
        users.put("user123", new User("user123", "1234", 1000.0));
    }

    public User getUser(String userID) {
        // Get user by UserID
        return users.get(userID);
    }

    public boolean authenticate(String userID, String enteredPin) {
        // Implement user authentication logic
        User user = users.get(userID);
        if (user != null && user.authenticate(enteredPin, enteredPin)) {
            return true;
        }
        return false;
    }

    public void addUser(User user) {
        // Add a new user to the database
        users.put(user.getUserId(), user);
    }
}
