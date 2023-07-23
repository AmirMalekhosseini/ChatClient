package View;

import Model.ChatChooseModel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChatChooseScreen extends JPanel {

    private ChatChooseModel model;

    public ChatChooseScreen() {
        model = new ChatChooseModel();
        setSize(200, 800);
        setLayout(null);
        setBackground(Color.BLACK);
        setOpaque(true);
    }

}
