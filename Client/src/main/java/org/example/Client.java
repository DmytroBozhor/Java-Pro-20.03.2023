package org.example;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {

        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress("localhost", 8080));

            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            Thread osThread = new Thread(() -> {
                try {
                    while (true) {
                        System.out.println(dis.readUTF());
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            osThread.setDaemon(true);
            osThread.start();

            while (true) {
                Scanner scanner1 = new Scanner(System.in);

                String clientMessage = scanner1.nextLine();

                dos.writeUTF(clientMessage);

                if ("exit".equals(clientMessage)) {
                    break;

                } else if (clientMessage.startsWith("file")) {

                    File file = new File(clientMessage.replace("file ", ""));

                    dos.writeUTF(file.getName());
                    dos.writeLong(file.length());

                    byte[] buffer = new byte[(int) file.length()];

                    IOUtils.readFully(new FileInputStream(file), buffer);

                    dos.write(buffer);

                }
            }
        }
    }
}

