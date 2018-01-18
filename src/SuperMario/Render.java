package SuperMario;

import javax.swing.*;
import java.awt.*;

public class Render extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SuperMario.superMario.repaint(g);
    }
}