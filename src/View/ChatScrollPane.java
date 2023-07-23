package View;

import javax.swing.*;
import java.awt.*;

public class ChatScrollPane extends JScrollPane {

    public ChatScrollPane(ChatScreen chatScreen) {

        super(chatScreen);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        setBounds(200, 0, 620, 730); // Set the bounds of the scroll pane
        getViewport().setBackground(new Color(0, 0, 0, 0));
        setOpaque(false);
        getViewport().setOpaque(false);

    }


}
