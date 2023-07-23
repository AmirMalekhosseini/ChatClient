package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainChatFrame extends JFrame {

    ChatPanel chatPanel;
    ChatScreen chatScreen;
    ChatChooseScreen chooseScreen;
    JScrollPane chatScroll;
    JPanel panel;
    JPanel inputPanel;

    protected JLabel backgroundImage;
    protected JButton sendButton;
    protected JTextField messageField;
    public MainChatFrame() {
        // Main Chat Frame
        setTitle("Message App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(835, 830);
        setVisible(true);
        setLocationRelativeTo(null);
        panel = new JPanel();
        panel.setBounds(0, 0, 835, 820);
        panel.setVisible(true);
        panel.setFocusable(true);
        panel.requestFocus();
        panel.requestFocusInWindow();
        panel.setLayout(null);

        chatPanel = new ChatPanel();
        chatPanel.setBounds(200, 0, 605, 800);
        chatPanel.setLayout(null);

        inputPanel = new JPanel();
        inputPanel.setBounds(200, 735, 605, 55);
        inputPanel.setLayout(new BorderLayout());

        ArrayList<String> usernames = new ArrayList<>();
        usernames.add("amir");
        usernames.add("reza");

        ImageIcon background = new ImageIcon("Background.png");
        backgroundImage = new JLabel(background);
        int imageWidth = background.getIconWidth();
        int imageHeight = background.getIconHeight();
        backgroundImage.setBounds(0, 0, imageWidth, imageHeight);

        messageField = new JTextField();
        messageField.setBackground(Color.DARK_GRAY);
        messageField.setForeground(Color.WHITE);
        messageField.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

        chatScreen = new ChatScreen(usernames,messageField);
        chatScreen.setLocation(200, 0);
        chatScreen.setOpaque(false);
        chatScreen.setBackground(new Color(0, 0, 0, 0));

        messageField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatScreen.sendMessage();

            }
        });

        chooseScreen = new ChatChooseScreen();
        chooseScreen.setLocation(0, 0);

        chatScroll = new JScrollPane(chatScreen);
        chatScroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        chatScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        chatScroll.setBounds(200, 0, 620, 730); // Set the bounds of the scroll pane
        chatScroll.getViewport().setBackground(new Color(0, 0, 0, 0));
        chatScroll.setOpaque(false);
        chatScroll.getViewport().setOpaque(false);


        inputPanel.add(messageField,BorderLayout.CENTER);
        panel.add(inputPanel);
        panel.add(chatScroll);
        panel.add(chatPanel);
        panel.add(chooseScreen);
        setContentPane(panel);
        messageField.requestFocus();

    }

}
