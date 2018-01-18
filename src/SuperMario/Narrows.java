package SuperMario;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Narrows {
    public ArrayList<Rectangle> narrows;
    public final int WIDTH = 800;
    public final int HEIGHT = 500;
    public Random rand;
    public Narrows()
    {
        rand = new Random();
        narrows= new ArrayList<Rectangle>();

    }
    public void addNarrows(boolean start)
    {

        int width = 20+rand.nextInt(100);
        int height = 20+rand.nextInt(100);
       // int space = 20 +rand.nextInt(100)
        int size = 3;
        if(start)
        {
            for(int i=0;i <size;i++)
            {
                narrows.add(new Rectangle(WIDTH / 3 - width+100, HEIGHT/2, 40, 30));
                width-=20;
            }
        }
        else
        {
            narrows.add(new Rectangle(narrows.get(narrows.size()-1).x + 600,HEIGHT - height - 120, 40, 40));

        }

    }

    public void paintNarrows(Graphics g)
    {   for(Rectangle narrow : narrows) {
        g.setColor(Color.orange.darker());
        g.fillRect(narrow.x, narrow.y, narrow.width, narrow.height);
    }

    }

}
