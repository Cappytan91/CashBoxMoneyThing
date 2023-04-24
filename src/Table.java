import java.awt.*;
import java.util.ArrayList;

public class Table {

    private int x, y, width, height;
    private ArrayList<Chair> chairs;

    public Table(int x, int y, int width, int height, int amountOfChairs){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.chairs = new ArrayList<Chair>();
        setUpChairs(amountOfChairs);
    }

    private void setUpChairs(int amountOfChairs) {

        if(amountOfChairs != 0) {

            int angleO = 360 / amountOfChairs;
            int angle = 0;

            for (int i = 0; i < amountOfChairs; i++) {
                chairs.add(new Chair(x + height / 2 + (int) ((width) * Math.cos(Math.toRadians(angle))), y + width / 2 + (int) ((width) * Math.sin(Math.toRadians(angle))), 25, 25));
                angle += angleO;
            }
            chairs.add(new Chair(x + width / 2, y + width / 2, 2, 2));
        }
    }

    public void draw(Graphics g){
        g.drawOval(x, y, width, height);
        for (Chair c: chairs) {
            c.draw(g);
        }
    }

}
