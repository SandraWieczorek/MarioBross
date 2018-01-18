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
//na enumach boolean
//zeby mario nei wychodizl poza plansze,jak skoczy na murek zeby mógl skoczyc jeszcze raz
