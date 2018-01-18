package SuperMario;

public class Characters {
    private int x,y;
    private int width,height;

    ///getters///
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    ///setters///

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    ///constructor///
    public Characters(int x,int y,int width,int height)
    {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }
}
