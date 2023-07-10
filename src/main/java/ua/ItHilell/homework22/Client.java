package ua.ItHilell.homework22;

import javax.print.attribute.standard.PDLOverrideSupported;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8080));

            DataInputStream is = new DataInputStream(socket.getInputStream());
            DataOutputStream os = new DataOutputStream(socket.getOutputStream());

            while (true) {
                Scanner scanner = new Scanner(System.in);
                String clientMessage = scanner.nextLine();

                if ("exit".equals(clientMessage)) {
                    break;
                }

                os.writeUTF(clientMessage);
                os.flush();

                String serverMessage = is.readUTF();
                System.out.println(serverMessage);

            }
        }


    }
}
