package View;

import Model.ChatScreenModel;
import javax.swing.*;
import java.awt.*;

public class ChatScreen extends JPanel {

    private ChatScreenModel model;
    protected JTextField chatArea;

    public ChatScreen(String myUsername,String otherUsername, JTextField chatArea) {
        this.chatArea = chatArea;
        model = new ChatScreenModel(myUsername,otherUsername);
        init();
    }

    private void init() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        setSize(new Dimension(model.getSCREEN_WIDTH(), 800));

    }

    public void addUserMessage(String message) {

        // Add vertical padding
        add(Box.createVerticalStrut(10));
        ChatLabel messageLabel = new ChatLabel(message, true);
        add(messageLabel);
        revalidate();
        scrollDown(); // Scroll to the bottom to show the latest message
        
    }

    public void addOtherMessage(String message) {

        // Add vertical padding
        add(Box.createVerticalStrut(10));
        ChatLabel messageLabel = new ChatLabel(message, false);
        add(messageLabel);
        revalidate();
        scrollDown(); // Scroll to the bottom to show the latest message

    }

    public void scrollDown() {
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
