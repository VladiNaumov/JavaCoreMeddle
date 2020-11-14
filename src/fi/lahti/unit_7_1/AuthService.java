package fi.lahti.unit_7_1;

public interface AuthService {
    void start();
    String getNickByLoginPass(String login, String pass);
    void stop();

}
