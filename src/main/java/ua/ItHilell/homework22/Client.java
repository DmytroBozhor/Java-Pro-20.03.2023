package ua.ItHilell.homework22;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8080));

            Thread osThread = new Thread(() -> {
                try {
                    InputStream is = socket.getInputStream();
                    Scanner scanner = new Scanner(is);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("New thread has been activated!");
            });

            osThread.start();

            /*InputStream is = socket.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            System.out.println(dis.readUTF());
            is.close();
            dis.close();
*/
            OutputStream os = socket.getOutputStream();

            while (true) {
                Scanner scanner1 = new Scanner(System.in);
                scanner1.next();
            }
        }


    }
}
