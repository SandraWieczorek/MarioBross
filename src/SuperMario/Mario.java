package SuperMario;

public class Mario extends SuperMario implements Runnable
{

    @Override
    public void run() {
        while(true){
        render.repaint();
            try
            {
                Thread.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
    }
}
