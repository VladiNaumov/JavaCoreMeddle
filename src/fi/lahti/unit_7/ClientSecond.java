package fi.lahti.unit_7;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 * Input credentials sample
 * "-auth n1@mail.com 1" -так выглядит аудентификация пользователя
 */


public class ClientSecond {

    public static void main(String[] args) {

    runClient();
    }


    // метод запускающий клиента
    public static void  runClient() {
        Socket clientSocet;
        DataInputStream in;
        DataOutputStream out;
        Scanner scanner = new Scanner(System.in);

        try {
            clientSocet = new Socket("localhost", 8888);
            in = new DataInputStream(clientSocet.getInputStream());
            out = new DataOutputStream(clientSocet.getOutputStream());

            // получение сообщения
            new Thread(() -> {
                try {
                    while (true) {
                        String message = in.readUTF();
                        System.out.println( message);
                    }
                } catch (IOException e) {
                    throw new RuntimeException("ClientApp() ->  ", e);
                }
            }).start();


            // отправка сообщения в сокет

            while (true) {
                try {
                    System.out.println("msgn...");
                    // передача сообщения в сокет
                    out.writeUTF(scanner.nextLine());
                } catch (IOException e) {
                    throw new RuntimeException(" ClientApp() ->", e);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
