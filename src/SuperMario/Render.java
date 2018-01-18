package SuperMario;

import javax.swing.*;
import java.awt.*;

public class Render extends JPanel {
    private static final long serialVersionUID = 1L;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        SuperMario.superMario.repaint(g);
    }
}