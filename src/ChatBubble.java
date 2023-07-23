import javax.swing.*;
import java.awt.*;

public class ChatBubble extends JPanel {
    private String sender;
    private String message;
    private boolean isSentByUser;
    private int bubbleHeight;

    public ChatBubble(String sender, String message, boolean isSentByUser) {
        this.sender = sender;
        this.message = message;
        this.isSentByUser = isSentByUser;
        setOpaque(false);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        bubbleHeight = calculateBubbleHeight(message);
    }

    private int calculateBubbleHeight(String message) {
        FontMetrics fontMetrics = getFontMetrics(getFont());
        int width = 300 - 10;
        int textHeight = fontMetrics.getHeight();
        String[] words = message.split(" ");
        StringBuilder wrappedText = new StringBuilder("<html>");
        int currentWidth = 0;
        int currentHeight = 0;

        for (String word : words) {
            int wordWidth = fontMetrics.stringWidth(word + " ");
            if (currentWidth + wordWidth <= width) {
                wrappedText.append(word).append(" ");
                currentWidth += wordWidth;
            } else {
                wrappedText.append("<br>").append(word).append(" ");
                currentWidth = wordWidth;
                currentHeight += textHeight;
            }
        }
        wrappedText.append("</html>");
        return currentHeight + textHeight;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int padding = 10;
        int radius = 10;
        int x = isSentByUser ? getWidth() - padding - radius * 2 : padding;
        int y = padding;
        int width = getWidth() - padding * 2 - radius * 2;
        int height = bubbleHeight;
        g.setColor(isSentByUser ? Color.BLUE : Color.GRAY);
        g.fillRoundRect(x, y, width, height, radius, radius);
        g.setColor(Color.WHITE);
        String displayMessage = isSentByUser ? "You: " + message : sender + ": " + message;
        drawWrappedText(g, displayMessage, x + padding, y + padding, width - padding * 2);
    }

    private void drawWrappedText(Graphics g, String text, int x, int y, int width) {
        FontMetrics fontMetrics = g.getFontMetrics();
        int textHeight = fontMetrics.getHeight();
        String[] lines = text.split("<br>");
        for (String line : lines) {
            g.drawString(line, x, y + textHeight);
            y += textHeight;
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(300, bubbleHeight + 2 * 5);
    }
}
