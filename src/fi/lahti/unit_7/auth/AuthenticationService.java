package  fi.lahti.unit_7.auth;


import fi.lahti.unit_7.entity.User;

import java.util.Optional;

public interface AuthenticationService {
    Optional<User> doAuth(String login, String password);
}
