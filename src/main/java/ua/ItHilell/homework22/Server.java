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
            this.sentNotificationToActiveClients();

        }

        private void sentNotificationToActiveClients() {
            for (ClientConnection clientConnection : clientList) {
                if (!clientConnection.clientSocket.isClosed()) {
                    try {
                        OutputStream os = clientConnection.clientSocket.getOutputStream();
                        os.write(("[SERVER] " + clientName + " успішно підключився.").getBytes());
                        os.flush();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    System.out.println(clientConnection.clientName + " is inactive");
                }
            }
        }

    }
}
