package Model;

import View.ChatLabel;

import javax.swing.*;
import java.util.ArrayList;

public class ChatScreenModel {


    private final int MESSAGE_PADDING = 10;
    private final int SCREEN_WIDTH = 600;
    private int currentY;
    protected ArrayList<String> chatUsernames = new ArrayList<>();
    protected ArrayList<JLabel> chatLabels = new ArrayList<>();

    public ChatScreenModel(ArrayList<String> chatUsernames) {
        this.chatUsernames.addAll(chatUsernames);
    }

    public void addMessage(JLabel messageLabel) {
        chatLabels.add(messageLabel);
        currentY += messageLabel.getHeight() + MESSAGE_PADDING;
    }

    public int getCurrentY() {
        return currentY;
    }

    public void setCurrentY(int currentY) {
        this.currentY = currentY;
    }

    public ArrayList<String> getChatUsernames() {
        return chatUsernames;
    }

    public void setChatUsernames(ArrayList<String> chatUsernames) {
        this.chatUsernames = chatUsernames;
    }

    public ArrayList<JLabel> getChatLabels() {
        return chatLabels;
    }

    public void setChatLabels(ArrayList<JLabel> chatLabels) {
        this.chatLabels = chatLabels;
    }

    public int getMESSAGE_PADDING() {
        return MESSAGE_PADDING;
    }

    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }
}
