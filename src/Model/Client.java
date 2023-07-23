package Model;

import java.io.*;
import java.net.*;

public class Client {
    private String username;
    private Socket socket;
    private ObjectInputStream inputStream;
    private ObjectOutputStream outputStream;

    public Client(String serverAddress, int serverPort, String username) {
        this.username = username;
        try {
            socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server.");

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(username);
            outputStream.flush();

            inputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void startMessaging() {
        // Create a separate thread to handle incoming messages from the server
        Thread receiveThread = new Thread(() -> {
            try {
                // ToDo: Change While True.
                while (true) {
                    Message message = (Message) inputStream.readObject();
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        receiveThread.start();

    }

    public ObjectInputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(ObjectInputStream inputStream) {
        this.inputStream = inputStream;
    }

    public ObjectOutputStream getOutputStream() {
        return outputStream;
    }

    public void setOutputStream(ObjectOutputStream outputStream) {
        this.outputStream = outputStream;
    }
}
