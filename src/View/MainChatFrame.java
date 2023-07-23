package View;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainChatFrame extends JFrame {

    ChatScreen chatScreen;
    ChatChooseScreen chooseScreen;
    JScrollPane scrollPane;
    JPanel panel;
    public MainChatFrame() {
        // Main Chat Frame
        setTitle("Message App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(835, 820);
        setVisible(true);
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setBounds(0, 0, 835, 820);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);

        ArrayList<String> usernames = new ArrayList<>();
        usernames.add("amir");
        usernames.add("reza");


        chatScreen = new ChatScreen(usernames);
        chatScreen.setLocation(200, 0);

        chooseScreen = new ChatChooseScreen();
        chooseScreen.setLocation(0, 0);

        scrollPane = new JScrollPane(chatScreen);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(200, 0, 620, 800); // Set the bounds of the scroll pane
        scrollPane.setBackground(Color.BLACK);

//        panel.add(chatScreen);
        panel.add(scrollPane);
        panel.add(chooseScreen);
        setContentPane(panel);


    }

}
