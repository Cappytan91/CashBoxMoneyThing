import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Table {

    private int x, y, width, height;
    private ArrayList<Chair> chairs;
    public boolean heyo;

    public Table(int x, int y, int width, int height, int amountOfChairs){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.chairs = new ArrayList<Chair>();
        this.heyo = false;
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

    public boolean coliding(MouseEvent evt){
        double xDiff = evt.getX() - (x + width/2);
        double yDiff = evt.getY() - (y + width/2);

        double distance = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));

        return distance < (1 + width/2);
    }

    public void draw(Graphics g){
        if(heyo){
            g.setColor(Color.GREEN);
            g.fillOval(x,y,width,height);
        }
        g.setColor(Color.BLACK);

        g.drawOval(x, y, width, height);
        for (Chair c: chairs) {
            c.draw(g);
        }
    }

    public ArrayList<Chair> getChairs() {
        return chairs;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
}
