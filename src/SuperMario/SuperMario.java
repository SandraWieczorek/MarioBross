package SuperMario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

public class SuperMario implements ActionListener,MouseListener, KeyListener {
    public static SuperMario superMario;
    public int xposition;
    public Render render;
    public final int Window_WIDTH = 800;
    public final int Window_HEIGHT = 500;
    public final int speed = 5;
    public int xScene1 = -50;
    public int xScene2 = 750;
    public  int dx;
    public Rectangle Mario,Scene;
    public  int ticks, yMotion,score;
    public boolean gameOver , started, nextround,delete ;
    public BufferedImage image;
    public BufferedImage image2;
    public BufferedImage image3;
    public boolean up,down,jump,anotherjump;

    public int  level;
    public Narrows narrow;
    public enum State
    {
        JUMP,
        DELETE,
        GAMEOVER,
        STARTED
    }
    public SuperMario()
    {
        State state;
        JFrame jframe =new JFrame();
        Timer timer = new Timer(20,this);
        render = new Render();
        dx=1;
        anotherjump = false;
        xposition = -1;
        narrow = new Narrows();
       // Scene = new Rectangle(0 ,0,Window_WIDTH,Window_HEIGHT);
       // Mario mario = new Mario(100,360,20,20);
        Mario = new Rectangle(Window_WIDTH/2-300, Window_HEIGHT,20,20);
        up = true;
        down = false;
        jump = false;
        delete = false;
        jframe.add(render);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(Window_WIDTH, Window_HEIGHT);

        jframe.setTitle("Super Mario Bross");
        jframe.setLocationRelativeTo(null);
        jframe.setAlwaysOnTop(true);
        jframe.setResizable(false);
        jframe.setContentPane(render);
        jframe.setVisible(true);


        jframe.setFocusable(true);
        jframe.requestFocusInWindow();
        jframe.addKeyListener(this);

        narrow.addNarrows(true);
        level = 1;
        timer.start();

    }
    public void deplacementScene()
    {
        if(this.xposition >= 0) {
            System.out.println("dupa");
            this.xposition += this.dx;
            this.xScene1 -= this.dx;
            this.xScene2 -= this.dx;
        }

        if(this.xScene1 == -800){ this.xScene1 = 800;}
        else if(this.xScene2 == -800){this.xScene2 = 800;}
        else if(this.xScene1 == 800) {this.xScene1 = -800;}
        else if(this.xScene2 == 800){ this.xScene2 = -800;}
    }
    public static void main(String[] args)
    {
        superMario = new SuperMario();
    }

    public void repaint2(Graphics g)
    {

    }
    public void repaint(Graphics g)
    {

          this.deplacementScene();
            g.setColor(Color.BLUE);
            g.fillRect(0,0,800,500);
             g.fillRect(0,0,800,500);

            g.setColor(Color.orange);
            g.fillRect(0, 500 -120,800,120);
           // g.fillRect(this.xScene2, 500 -120,800,120);

            g.setColor(Color.green);
            g.fillRect(0, 500 -120,800,20);
            //g.fillRect(this.xScene2, 500 -120,800,20);
            g.setColor(Color.red);
            g.fillRect(Mario.x,Mario.y,Mario.width,Mario.height);

       narrow.paintNarrows(g);

        g.setColor(Color.white);
        g.setFont(new Font("Arial",3,20));
        if(!started)
        {
            g.drawString("Play",100, Window_HEIGHT /2 -100);
        }
        if(gameOver && score!=5)
        {
            g.drawString("Game Over!",100, Window_HEIGHT /2 - 50);
        }
        if(!gameOver && started)
        {
            g.drawString(String.valueOf("Level"),0,50);
            g.drawString(String.valueOf(level),Window_WIDTH/4-25,50);
            g.drawString(String.valueOf("Speed"),0,130);
            g.drawString(String.valueOf(speed),Window_WIDTH/4-25,130);
            g.drawString(String.valueOf("Score"),0,90);
            g.drawString(String.valueOf(score),Window_WIDTH/4-25,90);
        }
    }

    public void GoLeft()
    {
        if(!gameOver)
        {
           Mario.x -= 2*speed;
        }
    }
    public void GoRight()
    {
        if(!gameOver)
        {
           //if(xposition == -1)
          Mario.x +=2*speed;

        }
    }
    public void GoUp()
    {
        if(!gameOver)
        {
            if (yMotion > 0)
            {
                yMotion = 0;
            }
            yMotion = -speed;
            up = false;
            // if(Mario.y <0) up=false;
        }
    }
    public void HittingWalls()
    {
        yMotion = 0;
        yMotion = speed;
        down = true;
        up = true;
        System.out.println("3");
        jump = true;
      //  delete = true;
    }
    public void MarioFalling()
    {
        up =  true;
        down = true;
        yMotion = 0;
        jump = false;
        yMotion =speed;
        anotherjump =false;
        System.out.println("2");

    }
    public void JumpingOnBlock()
    {

        yMotion = speed;
        yMotion = 0;
        up = true;
        down = true;
        System.out.println("1");
        jump = true;
        anotherjump=true;
    }
    public void HittingLowerEdge()
    {
        yMotion = 0;
        yMotion = speed;
        down = true;
        up = true;
        System.out.println("3");
        jump = true;
        delete = true;
    }
    public void MoveMario() {
        for (Rectangle column : narrow.narrows) {

            if (Mario.y < column.y && Mario.x > column.x-20 && Mario.x < column.x + 40 && !jump) {
                Mario.y = column.y - 20;
                JumpingOnBlock();

            }
            if ( (Mario.x < column.x  || Mario.x > column.x + 60) && jump)
            {
                MarioFalling();
            }
            else if (Mario.y <= column.y + 30 && Mario.x > column.x && Mario.x < column.x  && !jump) {
                HittingLowerEdge();
                System.out.println(narrow.narrows.size());

            }

        }
            if (delete == true) {
                narrow.narrows.remove(0);
                delete = false;
            }
            Mario.y += yMotion;
    }

    public void Limitations()
    {
        if ( Mario.y > Window_HEIGHT -140 && anotherjump == false)
        {
            Mario.y = Window_HEIGHT -140;
            yMotion = 0;
        }
        if ( Mario.y > Window_HEIGHT -140 && anotherjump == true)
        {
            yMotion = speed;

           if( Mario.y == Window_HEIGHT -260)  yMotion = 0;
           // yMotion = 0;
        }


        if(Mario.x > 773) Mario.x =773;
        if(Mario.x < 0) Mario.x = 0;
        if(Mario.y <= 150)
        {
            yMotion = speed;
            up = true;
        }

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (started) {
          //  Thread mariothread = new Thread(new Mario());
            // mariothread.start();
           // System.out.println("ok");
            Limitations();
            MoveMario();
        }

            render.repaint();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP)
        {
            GoUp();
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT)
        {
            GoRight();
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT)
        {
            GoLeft();
        }
        if(e.getKeyCode() == KeyEvent.VK_ENTER)
        {
            if(!started)
            {
                started = true;
            }
            if(gameOver)
            {
                Mario = new Rectangle(Window_WIDTH/3, Window_HEIGHT /3,20,20);
                narrow.narrows.clear();
                yMotion = 0;
                score = 0;
                narrow.addNarrows(true);
                gameOver = false;
            }

        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
      // this.dx = 0;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
