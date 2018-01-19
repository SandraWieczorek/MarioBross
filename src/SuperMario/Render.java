package SuperMario;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Render extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SuperMario.superMario.repaint(g);
    }

    public BufferedImage img;

    public Render() {
        try {
            img = ImageIO.read(getClass().getResource("/SuperMario/Images/Mario.png"));
        } catch (IOException ex) {}


    }
}
//na enumach boolean
//,jak skoczy na murek zeby mógl skoczyc jeszcze raz
