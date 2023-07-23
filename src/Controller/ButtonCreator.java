package Controller;

import Model.MyProject;
import View.ChatChooseButton;
import View.ChatScreen;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ButtonCreator {

    public ArrayList<ChatChooseButton> createButton(JTextField chatArea) {
        ArrayList<ChatChooseButton> buttons = new ArrayList<>();

        for (String username:MyProject.usernames) {
            if (username.equals(MyProject.activeUser)) {
                continue;
            }
            ChatScreen chatScreen = new ChatScreen(MyProject.activeUser, username, chatArea);
            chatScreen.setLocation(200, 0);
            chatScreen.setOpaque(false);
            chatScreen.setBackground(new Color(0, 0, 0, 0));
            ChatChooseButton button = new ChatChooseButton(chatScreen, username);
            buttons.add(button);
        }

        return buttons;
    }

}
