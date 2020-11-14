package fi.lahti.unit_7;

import java.util.List;
import java.util.Optional;

public class BasicAuthenticationService implements AuthenticationService {
    /**
     * Fake database with stubbed entities
     */
    private static final List<User> users;

    static {
        users = List.of(
                new User("Vladimir", "n1@mail.com", "1"),
                new User("Teemu", "n2@mail.com", "2"),
                new User("Alena", "n3@mail.com", "3")
        );
    }

    @Override
    public Optional<User> doAuth(String email, String password) {
        for (User user : users) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
}