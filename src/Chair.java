import java.awt.*;

public class Chair {

    private int x, y, width, height;

    public Chair(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(Graphics g){
        g.drawOval(x - width / 2, y - height / 2, width, height);
    }

}
