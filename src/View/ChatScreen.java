package View;

import Model.ChatScreenModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatScreen extends JLayeredPane {

    private ChatScreenModel model;
    protected JLabel backgroundImage;
    protected JButton sendButton;
    protected JTextArea chatArea;

    public ChatScreen(ArrayList<String> usernames) {
        model = new ChatScreenModel(usernames);
        init();
    }

    private void init() {

        setLayout(null);
        setSize(new Dimension(model.getSCREEN_WIDTH(), 800));
        model.setCurrentY(model.getMESSAGE_PADDING());

        ImageIcon background = new ImageIcon("Background.png");
        backgroundImage = new JLabel(background);
        int imageWidth = background.getIconWidth();
        int imageHeight = background.getIconHeight();
        backgroundImage.setBounds(0, 0, imageWidth, imageHeight);

        chatArea = new JTextArea();
        chatArea.setVisible(true);
        chatArea.setLineWrap(true);
        chatArea.setBounds(0, imageHeight, 550, 50);
        chatArea.setForeground(Color.WHITE);
        chatArea.setBackground(Color.GRAY);

        ImageIcon sendIcon = new ImageIcon("SendButton.png");
        sendButton = new JButton(sendIcon);
        sendButton.setFocusable(false);
        sendButton.setBounds(550, imageHeight, 50, 50);
        sendButton.setBackground(Color.WHITE);
        sendButton.addActionListener(e -> sendMessage());

        add(backgroundImage, Integer.valueOf(0));
        add(chatArea, Integer.valueOf(1));
        add(sendButton, Integer.valueOf(1));


    }

    public void addMessage(String message) {

        ChatLabel messageLabel = new ChatLabel(message, false);
        messageLabel.setLocation(messageLabel.getX(), model.getCurrentY());
        add(messageLabel, Integer.valueOf(2));
        revalidate();
        model.addMessage(messageLabel);
        scrollDown(); // Scroll to the bottom to show the latest message
        
    }

    private void sendMessage() {
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
