package Model;

import View.ChatLabel;

import javax.swing.*;
import java.util.ArrayList;

public class ChatScreenModel {


    private final int SCREEN_WIDTH = 600;
    private String myUsername;
    private String otherUsername;

    public ChatScreenModel(String myUsername,String otherUsername) {
        this.myUsername = myUsername;
        this.otherUsername = otherUsername;
    }

    public int getSCREEN_WIDTH() {
        return SCREEN_WIDTH;
    }

    public String getMyUsername() {
        return myUsername;
    }

    public void setMyUsername(String myUsername) {
        this.myUsername = myUsername;
    }

    public String getOtherUsername() {
        return otherUsername;
    }

    public void setOtherUsername(String otherUsername) {
        this.otherUsername = otherUsername;
    }
}
