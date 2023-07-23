package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ChatPanel extends JPanel {

    private BufferedImage image;

    public ChatPanel() {

        try {
            image = ImageIO.read(new File("Background.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (image != null) {
            g.drawImage(image, 0, 0, null);
        }

    }


}
