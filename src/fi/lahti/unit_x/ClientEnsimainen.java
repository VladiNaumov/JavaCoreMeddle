package fi.lahti.unit_x;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ClientEnsimainen {

    Socket socket;
    DataInputStream input;
    DataOutputStream output;

    public static void main(String[] args) {

        new  ClientToinen().runClient();

    }

    public void runClient(){


        try {
            // Создаём подключение
            System.out.println("Socket is starting up... ");
            socket = new Socket("localhost",8888);


            input = new DataInputStream(socket.getInputStream());
            output = new DataOutputStream(socket.getOutputStream());


            //получение информции
            new Thread(() -> {
                try {
                    while (true) {
                        String incomingMassege = input.readUTF();

                        System.out.println(incomingMassege);
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }).start();


            Scanner scanner = new Scanner(System.in);

            //отправка информции
            while (true){

                System.out.println("Please type in a message .... ");
                output.writeUTF(scanner.nextLine()); // отправка сообщений

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
