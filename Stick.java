import java.awt.*;

public class Stick {
    public static final int MOVE_LEVEL = 10;
    public static final int SIZE = 15;
    private int x;
    private int y;
    private int bodyWidth;
    private int bodyHeight;
    public Stick(int x, int y, int bodyWidth, int bodyHeight) {
        this.x = x;
        this.y = y;
        this.bodyWidth = bodyWidth;
        this.bodyHeight = bodyHeight;
    }
    public void moveRight(){
        this.x += MOVE_LEVEL;
    }
    public void moveLeft(){this.x -= MOVE_LEVEL;}
    public void moveDown(){
        this.y += MOVE_LEVEL;
    }
    public void moveUp(){
        this.y -= MOVE_LEVEL;
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(this.x,this.y,this.bodyWidth,this.bodyHeight);

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBodyWidth() {
        return bodyWidth;
    }

    public void setBodyWidth(int bodyWidth) {
        this.bodyWidth = bodyWidth;
    }

    public int getBodyHeight() {
        return bodyHeight;
    }

    public void setBodyHeight(int bodyHeight) {
        this.bodyHeight = bodyHeight;
    }
}


