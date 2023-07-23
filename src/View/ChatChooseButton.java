package View;

import javax.swing.*;
import java.awt.*;

public class ChatChooseButton extends JButton {

    protected ChatScreen chatScreen;
    private final String recipientUsername;
    private final int height = 100;
    private final int width = 200;
    private int indexInList;

    public ChatChooseButton(ChatScreen chatScreen, String recipientUsername) {
        this.chatScreen = chatScreen;
        this.recipientUsername = recipientUsername;

        setPreferredSize(new Dimension(width, height));
        setMaximumSize(new Dimension(Short.MAX_VALUE, height)); // Set maximum width to expand horizontally
        setText(recipientUsername);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        setForeground(Color.WHITE);
        setBackground(Color.DARK_GRAY);
    }

    public ChatScreen getChatScreen() {
        return chatScreen;
    }

    public void setChatScreen(ChatScreen chatScreen) {
        this.chatScreen = chatScreen;
    }

    public String getRecipientUsername() {
        return recipientUsername;
    }

    public int getIndexInList() {
        return indexInList;
    }

    public void setIndexInList(int indexInList) {
        this.indexInList = indexInList;
    }
}
