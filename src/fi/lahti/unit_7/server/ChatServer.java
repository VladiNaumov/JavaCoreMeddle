package  fi.lahti.unit_7.server;

import fi.lahti.unit_7.auth.AuthenticationService;
import fi.lahti.unit_7.auth.BasicAuthenticationService;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Set;

public class ChatServer implements InterfaceServer {
    private Set<Client> clients;
    private AuthenticationService authenticationService;

    ServerSocket serverSocket;
    Socket clientSocket;
    DataInputStream in;
    DataOutputStream out;


    public ChatServer() {
        try {
            System.out.println("Server is starting up (Сервер запускается)...");
            serverSocket = new ServerSocket(8888);
            clients = new HashSet<>();
            authenticationService = new BasicAuthenticationService();

            System.out.println("Server is started up (Сервер запущен)...");

            while (true) {
                System.out.println("Server is listening for clients (Сервер ожидает клиентов)...");

                clientSocket = serverSocket.accept(); // делает ожидание, пока не придёт к нему информация с serverSocket.accept();

               System.out.println("Client accepted (Клиент принят):  " + clientSocket );
               new Client(this, clientSocket);


            }


        } catch (IOException e) {
            throw new RuntimeException("Ошибка в работе сервера", e);

        }

    }


    @Override
    public synchronized void broadcastMessage(String message) {
        // метод оповещает клиента о подключении другого клиента
        clients.forEach(client -> client.sendMessage("String message  " + message));

    }


    @Override
    public synchronized boolean isLoggedIn(String nickname) {
        // проверяет если в системе клиент с темже логином и возвращает true или falsh
            return clients.stream()
                .filter(clientHandler -> clientHandler.getName().equals(nickname))
                .findFirst()
                .isPresent();


    }

    @Override
    public synchronized void subscribe(Client client) {
        // если в в чате нет одинаковых по имени клиентов ,то добовляет его в чат
        clients.add(client);
    }

    /*
    @Override
    public synchronized void unsubscribe(Client client) {
        clients.remove(client);
    }

     */


    @Override
    public AuthenticationService getAuthenticationService() {
        // авторизация клиента
        return authenticationService;
    }


}
