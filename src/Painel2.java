import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

public class Painel2 extends JPanel implements MouseMotionListener {

    Random random;
    Graphics gr;
    public Painel2() {
        this.addMouseMotionListener(this);
        this.setBackground(Color.pink);
        random = new Random();
    }

    int x,y;

    @Override
    public void mouseDragged(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.gr = g;
    }


    @Override
    public void repaint() {
       super.repaint();


        gr.setColor(Color.red);
        gr.fillRect(x,y,5,5);
    }
}
