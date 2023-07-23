package View;

import javax.swing.*;
import java.awt.*;

public class ChatLabel extends JLabel {

    private final int MAX_WIDTH = 400; // Maximum width for the label
    private final int PADDING = 10;

    private Color labelColor;
    private final String message;
    private int x;
    private int width;
    private int height;

    public ChatLabel(String message, Boolean isUserMessage) {
        this.message = message;
        setText("<html>" + wrapText(message) + "</html>"); // Wrap the text with HTML formatting
        labelColor = isUserMessage ? Color.RED : Color.WHITE;
        setFont(new Font("Comic Sans MS", Font.PLAIN, 18));

        adjustSize(); // Call the method to adjust the label size based on the message length
        adjustX(isUserMessage);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw the label background
        g.setColor(labelColor);
        g.fillRect(0, 0, width + PADDING, height + PADDING);

        // Draw the text on the label
        g.setColor(Color.BLACK);
        g.setFont(getFont());
        String wrappedText = wrapText(message);
        String[] lines = wrappedText.split("<br>");
        int lineHeight = getFontMetrics(getFont()).getHeight();
        int y = 0;
        for (String line : lines) {
            g.drawString(line, 0, y + lineHeight-5);
            y += lineHeight;
        }
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
        width = Math.min(MAX_WIDTH, preferredSize.width);

        height = getFontMetrics(getFont()).getHeight() * (preferredSize.width / width);

        int paddingHeight = 10;

        // Set the label size based on the calculated width and height
        setSize(width, height + paddingHeight);
    }

    private void adjustX(boolean isUserMessage) {

        if (isUserMessage) { // Should be on Right
            x = 570 - getWidth();
        } else {
            x = 30;
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
