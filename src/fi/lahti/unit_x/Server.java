package fi.lahti.unit_x;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;




public class Server {

    ServerSocket serverSocket;
    Socket clientSocket;
    DataInputStream input;
    DataOutputStream output;

    public static void main(String[] args) {

        new Server().Server();

    }


    public void Server() {


        try {
            System.out.println("Server is starting up (Сервер запускается)...");
            serverSocket = new ServerSocket(8888);
            System.out.println("Server is started up (Сервер запущен)...");

            //  Scanner scanner = new Scanner(System.in);
            //  AtomicBoolean isDrop = new AtomicBoolean(false);


            //отправка информции
            /*
            new Thread(() -> {

                try {
                    while (true) {
                        if (isDrop.get()){
                            System.out.println("Closing....");
                            break;
                        }
                        System.out.println("Please type in a message .... ");
                        output.writeUTF(scanner.nextLine()); // отправка сообщений

                    }
                }catch (IOException e){
                    e.printStackTrace();
                }

        }).start();

             */




            //получение информции
            while (true) {
                System.out.println("Server is listening for clients (Сервер ожидает клиентов)...");
                clientSocket = serverSocket.accept();
                System.out.println("Client connected " + clientSocket);
                input = new DataInputStream(clientSocket.getInputStream());
                output = new DataOutputStream(clientSocket.getOutputStream());

                String incomingMessage = input.readUTF();
                if (incomingMessage.contains("-exit")) {
                    output.writeUTF("cmd Exit");
                    break;
                }
                output.writeUTF("Echo: " + incomingMessage);
            }

            System.out.println("Socket shut down");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}