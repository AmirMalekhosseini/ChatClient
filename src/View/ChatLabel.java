package View;

import javax.swing.*;
import java.awt.*;

public class ChatLabel extends JLabel {

    private static final int MAX_WIDTH = 400; // Maximum width for the label

    private Color labelColor;
    private final String message;
    private int x;

    public ChatLabel(String message, Boolean isUserMessage) {
        this.message = message;
        setVerticalAlignment(JLabel.TOP);
        setText("<html>" + wrapText(message) + "</html>"); // Wrap the text with HTML formatting
        setVisible(true);
        labelColor = isUserMessage ? Color.RED : Color.WHITE;
        setBackground(labelColor);
        setForeground(Color.BLACK);
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        setOpaque(true);

        adjustSize(); // Call the method to adjust the label size based on the message length
        adjustX(isUserMessage);
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
        int width = Math.min(MAX_WIDTH, preferredSize.width);
        int height = getFontMetrics(getFont()).getHeight() * (preferredSize.width / width);

        int paddingHeight = 10;

        // Set the label size based on the calculated width and height
        setSize(width, height + paddingHeight);
    }

    private void adjustX(boolean isUserMessage) {

        if (isUserMessage) { // Should be on Right
            x = 580 - getWidth();
        } else {
            x = 20;
        }

    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public Dimension getPreferredSize() {
        return super.getPreferredSize();
    }

    public String getMessage() {
        return message;
    }
}
