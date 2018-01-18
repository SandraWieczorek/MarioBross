package SuperMario;

import java.awt.*;

public class Mario extends Characters
{
    public Rectangle mariobross;
    public Mario(int x, int y, int width, int height) {
        super(x, y, 20, 20);
        mariobross = new Rectangle(100, 360,20,20);
    }



}
