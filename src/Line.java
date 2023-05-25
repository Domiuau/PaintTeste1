import java.awt.*;

public class Line {

    final int x, y, x2, y2;
    final Color color;



    public Color getColor() {
        return color;
    }


    public Line(int x, int y, int x2, int y2, Color color) {
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }


    public int getX2() {
        return x2;
    }

    public int getY2() {
        return y2;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

