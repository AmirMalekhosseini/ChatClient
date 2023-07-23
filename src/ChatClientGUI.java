import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class ChatClientGUI extends JFrame {
    private JTextField messageField;
    private PrintWriter writer;
    private JPanel chatPanel;
    private String username;
    private List<String> receivedMessages;

    public ChatClientGUI(String serverAddress, int serverPort, String username) {
        this.username = username;
        setTitle("Chat Client - " + username);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);

        chatPanel = new JPanel();
        chatPanel.setLayout(new BoxLayout(chatPanel, BoxLayout.Y_AXIS));
        JScrollPane scrollPane = new JScrollPane(chatPanel);

        messageField = new JTextField();
        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage(messageField.getText());
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        getContentPane().add(messageField, BorderLayout.SOUTH);

        receivedMessages = new ArrayList<>();

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            InputStreamReader streamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);
            writer = new PrintWriter(socket.getOutputStream(), true);

            new Thread(new MessageReceiver(reader)).start();
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error connecting to the server.");
            System.exit(0);
        }
    }

    private void sendMessage(String message) {
        writer.println(message);
        messageField.setText("");
    }

    private class MessageReceiver implements Runnable {
        private BufferedReader reader;

        public MessageReceiver(BufferedReader reader) {
            this.reader = reader;
        }

        @Override
        public void run() {
            try {
                String message;
                while ((message = reader.readLine()) != null) {
                    receivedMessages.add(message);
                    SwingUtilities.invokeLater(() -> updateChatPanel());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateChatPanel() {
        chatPanel.removeAll();
        for (String message : receivedMessages) {
            String sender = message.startsWith("You: ") ? "You" : message.split(": ")[0];
            ChatBubble bubble = new ChatBubble(sender, message, !message.startsWith("You: "));
            chatPanel.add(bubble);
        }
        chatPanel.revalidate();
        chatPanel.repaint();
    }

    public static void main(String[] args) {
        String serverAddress = "localhost"; // Change this to the server's IP address or domain name
        int serverPort = 12345; // Use the same port number as the server
        String username = "User2"; // Enter the username of the client here

        SwingUtilities.invokeLater(() -> {
            new ChatClientGUI(serverAddress, serverPort, username).setVisible(true);
        });
    }
}
