package  fi.lahti.unit_7.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Objects;


public class Client {
    private InterfaceServer interfaceServer;
    private Socket clientSocet;
    private DataInputStream in;
    private DataOutputStream out;
    private String name;

    public Client(InterfaceServer interfaceServer, Socket socket) {
        try {
            this.interfaceServer = interfaceServer;
            this.clientSocet = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());

            doListen();
            } catch (IOException e) {
            throw new RuntimeException("ClientHandler()", e);
        }
    }

    public String getName() {
        return name;
    }



    // запуск потока для работы с методом doAuthentication(); он работает для идентификации пользователя
    private void doListen() {

        new Thread(() -> {
            try {
                doAuthentication();

            } catch (Exception e) {
                throw new RuntimeException("void doListen() -> doAuth() ", e);
            } finally {
               //interfaceServer.unsubscribe(this);
            }

            /*
            try {
                receiveMessage();

            } catch (Exception e) {
                throw new RuntimeException("void doListen() -> receiveMessage() ", e);
            } finally {
                interfaceServer.unsubscribe(this);
            }

             */


        }).start();
    }

    //обработка сообщения "-auth" о начале аудентификации

    private void doAuthentication() {
        try {
            while (true) {

                // Приём сообщения с сокета
                String credentials = in.readUTF();

                if(getName() != null){
                    sendMessage("Вам сообщение: " + credentials + " от пользователя: " + getName());
                }

                /**
                 * Input credentials sample
                 * "-auth n1@mail.com 1" -так выглядит аудентификация пользователя
                 */


                if (credentials.startsWith("-auth")) {
                    /**
                     * After splitting sample
                     * array of ["-auth", "n1@mail.com", "1"]
                     */
                    String[] credentialValues = credentials.split("\\s");
                    interfaceServer.getAuthenticationService()
                            .doAuth(credentialValues[1], credentialValues[2])
                            .ifPresentOrElse(
                                    user -> {
                                        if (!interfaceServer.isLoggedIn(user.getNickname())) {
                                            sendMessage("cmd auth: " + user.getNickname() + " Status OK");
                                            name = user.getNickname();
                                            interfaceServer.broadcastMessage(name + " is logged in (сейчас авторизован).");
                                            sendMessage(name);
                                            interfaceServer.subscribe(this);

                                            sendMessage("Подтверждение что пользователь: " + getName() + " в чате");

                                        } else {
                                            sendMessage("Current user is already logged in. (Текущий пользователь уже вошел в систему) ");
                                        }
                                    },

                                    new Runnable() {
                                        @Override
                                        public void run() {
                                            sendMessage("No a such user by email and password (Нет такого пользователя по электронной почте и паролю.).");
                                        }
                                    }
                            );

                }
            }
        } catch (IOException e) {
            throw new RuntimeException("private void doAuth() ", e);
        }
    }

    /**
     * Receives input data from {@link Client#in} and then broadcast via {@link InterfaceServer#broadcastMessage(String)}
     */


    /*
    //обработка сообщения о выходе из программы "-exit"
    private void receiveMessage() {
        try {
            while (true) {
                String message = in.readUTF();
                if (message.equals("-exit")) {
                    return;
                }
                interfaceServer.broadcastMessage(message);
            }
        } catch (IOException e) {
            throw new RuntimeException("receiveMessage() ", e);
        }
    }

     */

    // выводит служебную информацию на консоль
    public void sendMessage(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            throw new RuntimeException("sendMessage() ", e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client that = (Client) o;
        return Objects.equals(interfaceServer, that.interfaceServer) &&
                Objects.equals(clientSocet, that.clientSocet) &&
                Objects.equals(in, that.in) &&
                Objects.equals(out, that.out) &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(interfaceServer, clientSocet, in, out, name);
    }
}
