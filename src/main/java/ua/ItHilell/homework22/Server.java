package ua.ItHilell.homework22;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private static List<ClientConnection> activeClients = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            int clientID = 1;
            while (true) {
                Socket socket = serverSocket.accept();
                ClientConnection clientConnection = new ClientConnection(socket, Instant.now(), clientID);
                activeClients.add(clientConnection);
                Thread thread = new Thread(clientConnection);
                thread.setDaemon(true);
                thread.start();
                clientID++;
            }

        }
    }

    public static class ClientConnection implements Runnable {

        private final Socket clientSocket;
        private final String clientName;
        private final Instant clientConnectionDate;

        public ClientConnection(Socket clientSocket, Instant now, int clientID) {
            this.clientSocket = clientSocket;
            this.clientName = "Client-" + clientID;
            this.clientConnectionDate = now;
        }

        @Override
        public void run() {

            this.sentNotificationToActiveClients("[SERVER] " + this.clientName + " успішно підключився.");

            clientInputCheck();

        }

        private void clientInputCheck() {
            Thread thread = new Thread(() -> {
                try {
                    DataInputStream dataInputStream = new DataInputStream(clientSocket.getInputStream());
                    DataOutputStream dataOutputStream = new DataOutputStream(clientSocket.getOutputStream());
                    boolean active = true;
                    while (active) {
                        String clientMessage = dataInputStream.readUTF();
                        if (clientMessage.equals("exit")) {
                            this.sentNotificationToActiveClients(clientName + " has been disconnected!");
                            activeClients.remove(this);
                            active = false;
                        } else if (clientMessage.startsWith("file")) {
//                            String fileName = clientMessage.substring(clientName.lastIndexOf("/") + 1);

                            String fileName = dataInputStream.readUTF();
                            long fileLength = dataInputStream.readLong();

                            byte[] buffer = new byte[(int) fileLength];

                            dataInputStream.readFully(buffer, 0, (int) fileLength);

                            IOUtils.write(buffer, new FileOutputStream("C:\\Users\\ddima\\Desktop\\server\\" + fileName));

                            dataOutputStream.writeUTF("File was successfully transfered!");

                        } else {
                            this.sentNotificationToActiveClients(clientName + ": " + clientMessage);
                        }
                        Thread.sleep(1000);
                    }
                } catch (IOException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.setDaemon(true);
            thread.start();
        }

        private void sentNotificationToActiveClients(String message) {
            for (ClientConnection clientConnection : activeClients) {
                if (!clientConnection.clientSocket.isClosed()) {
                    try {
                        DataOutputStream dos = new DataOutputStream(clientConnection.clientSocket.getOutputStream());
                        dos.writeUTF(message);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }

    }
}
