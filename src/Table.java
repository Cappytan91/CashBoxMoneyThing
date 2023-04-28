import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Table {

    private int x, y, width, height;
    private ArrayList<Chair> chairs;
    public boolean heyo;
    private Graphics g;
    enum typeOfTable{
        CIRCLE,
        SQUARE
    };
    typeOfTable type;

    public Table(int x, int y, int width, int height, int amountOfChairs, typeOfTable type){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.chairs = new ArrayList<Chair>();
        this.heyo = false;
        this.type = type;
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

    public void updateChairs(int amountOfChairs){
        chairs.clear();
        setUpChairs(amountOfChairs);
    }

    public boolean coliding(MouseEvent evt){
        double xDiff = evt.getX() - (x + width/2);
        double yDiff = evt.getY() - (y + width/2);

        double distance = Math.sqrt((Math.pow(xDiff, 2) + Math.pow(yDiff, 2)));

        return distance < (1 + width/2);
    }

    public void draw(Graphics g){
        if(heyo && type == typeOfTable.CIRCLE){
            g.setColor(Color.GREEN);
            g.fillOval(x,y,width,height);
        } else if (heyo && type == typeOfTable.SQUARE) {
            g.setColor(Color.GREEN);
            g.fillRect(x, y, width, height);
        }
        g.setColor(Color.BLACK);

        if(type == typeOfTable.CIRCLE)
            g.drawOval(x, y, width, height);
        else if (type == typeOfTable.SQUARE) {
            g.drawRect(x, y, width, height);
        }
        for (Chair c: chairs) {
            c.draw(g);
        }
    }

    public void update(int x, int y, int amountOfChairs){
        this.x = x;
        this.y = y;

        chairs.clear();
        setUpChairs(amountOfChairs);

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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
