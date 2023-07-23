package View;

import Model.ChatScreenModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatScreen extends JPanel {

    private ChatScreenModel model;
    protected JTextField chatArea;
    private boolean test = false;

    public ChatScreen(ArrayList<String> usernames, JTextField chatArea) {
        this.chatArea = chatArea;
        model = new ChatScreenModel(usernames);
        init();
    }

    private void init() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(new Dimension(model.getSCREEN_WIDTH(), 800));

    }

    public void addMessage(String message) {

        // Add vertical padding
        add(Box.createVerticalStrut(10));
        ChatLabel messageLabel = new ChatLabel(message, test);
        test = !test;
        add(messageLabel);
        revalidate();
        scrollDown(); // Scroll to the bottom to show the latest message
        
    }

    protected void sendMessage() {
        String messageText = chatArea.getText().trim();
        if (!messageText.isEmpty()) {

            // Scroll down to show the latest message
            scrollDown();

            // Clear the chatArea after sending the message
            chatArea.setText("");

            addMessage(messageText);
        }
    }


    private void scrollDown() {
        SwingUtilities.invokeLater(() -> {
            Container parent = getParent();
            while (parent != null && !(parent instanceof JScrollPane)) {
                parent = parent.getParent();
            }

            if (parent != null) {
                JScrollPane scrollPane = (JScrollPane) parent;
                JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
                verticalBar.setValue(verticalBar.getMaximum());
            }
        });
    }

    public ChatScreenModel getModel() {
        return model;
    }

    public void setModel(ChatScreenModel model) {
        this.model = model;
    }
}
