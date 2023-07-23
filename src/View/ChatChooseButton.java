package View;

import javax.swing.*;

public class ChatChooseButton extends JButton {

    protected ChatScreen chatScreen;
    private final String recipientUsername;
    private int x;
    private int y;
    private final int height = 100;
    private final int width = 200;
    private int indexInList;

    public ChatChooseButton(ChatScreen chatScreen, String recipientUsername) {

        this.setSize(width, height);

        this.chatScreen = chatScreen;
        this.recipientUsername = recipientUsername;

    }

    public ChatScreen getChatScreen() {
        return chatScreen;
    }

    public void setChatScreen(ChatScreen chatScreen) {
        this.chatScreen = chatScreen;
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
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
