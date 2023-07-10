package ua.ItHilell.homework22;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {

    private static List<ClientConnection> clientList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            int clientId = 1;
            while (true) {
                Socket socket = serverSocket.accept();
                ClientConnection clientConnection = new ClientConnection(socket, clientId, Instant.now());
                clientList.add(clientConnection);
                Thread thread = new Thread(clientConnection);
                thread.setDaemon(true);
                thread.start();
                clientId++;
            }

        }
    }

    public static class ClientConnection implements Runnable {

        private final Socket clientSocket;
        private final String clientName;
        private final Instant clientConnectionDate;

        public ClientConnection(Socket clientSocket, int clientId, Instant now) {
            this.clientSocket = clientSocket;
            this.clientName = "Client-" + clientId;
            this.clientConnectionDate = now;
        }

        @Override
        public void run() {
            sentNotificationToActiveClients();

            try {
                DataInputStream is = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream os = new DataOutputStream(clientSocket.getOutputStream());

                while (true) {
                    String clientMessage = is.readUTF();
                    System.out.println("From client " + clientMessage);
                    os.writeUTF("You've sent " + clientMessage);
                    os.flush();
                }

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }

        private static void sentNotificationToActiveClients() {
            for (ClientConnection clientConnection : clientList) {
                try {
                    if (!clientConnection.clientSocket.isClosed()) {
                        DataOutputStream os = new DataOutputStream(clientConnection.clientSocket.getOutputStream());
                        os.writeUTF("[SERVER] " + clientConnection.clientName + " успішно підключився.");
                        os.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
