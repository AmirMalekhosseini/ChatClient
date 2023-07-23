package View;

import javax.swing.*;
import java.awt.*;

public class ChatLabel extends JLabel {

    private static final int MAX_WIDTH = 300; // Maximum width for the label

    private Color labelColor;
    private final String message;

    public ChatLabel(String message, Boolean isUserMessage) {
        this.message = message;
        setText("<html>" + wrapText(message) + "</html>"); // Wrap the text with HTML formatting
        setVisible(true);
        setBackground(isUserMessage ? Color.RED : Color.BLACK);
        setForeground(Color.WHITE);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        setOpaque(true);

        adjustSize(); // Call the method to adjust the label size based on the message length
    }

    private String wrapText(String text) {
        StringBuilder wrappedText = new StringBuilder();
        String[] words = text.split(" ");
        int currentWidth = 0;

        for (String word : words) {
            int wordWidth = getFontMetrics(getFont()).stringWidth(word);
            if (currentWidth + wordWidth <= MAX_WIDTH) {
                wrappedText.append(word).append(" ");
                currentWidth += wordWidth + getFontMetrics(getFont()).charWidth(' ');
            } else {
                wrappedText.append("<br>").append(word).append(" ");
                currentWidth = wordWidth + getFontMetrics(getFont()).charWidth(' ');
            }
        }

        return wrappedText.toString();
    }

    private void adjustSize() {
        Dimension preferredSize = getPreferredSize();
        int width = Math.min(MAX_WIDTH, preferredSize.width); // Limit width to MAX_WIDTH
        setSize(width, preferredSize.height);
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    public String getMessage() {
        return message;
    }
}
