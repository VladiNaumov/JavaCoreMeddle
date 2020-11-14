package  fi.lahti.unit_7.server;


import fi.lahti.unit_7.auth.AuthenticationService;

public interface InterfaceServer {

    // метод оповещает клиента о подключении другого клиента
    void broadcastMessage(String message);

    // проверяет если в системе клиент с темже логином и возвращает true или falsh
    boolean isLoggedIn(String nickname);

    // если в в чате нет одинаковых по имени клиентов ,то добовляет его в чат
    void subscribe(Client client);


    //  void unsubscribe(Client client);

    // авторизация клиента
     AuthenticationService getAuthenticationService();


}
