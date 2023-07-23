package View;

import Model.ChatChooseModel;

import javax.swing.*;
import java.awt.*;

public class ChatChoosePanel extends JPanel {

    private ChatChooseModel model;

    public ChatChoosePanel() {
        model = new ChatChooseModel();
        setSize(200, 800);
        setBackground(Color.BLACK);
        setOpaque(true);
    }

}
