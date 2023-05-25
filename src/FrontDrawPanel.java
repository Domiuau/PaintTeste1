import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import java.util.concurrent.Executor;

public class FrontDrawPanel extends JLayeredPane implements MouseListener, MouseMotionListener {

    int x, y;
    int xMouse, yMouse;

    public FrontDrawPanel() {
        ;
       // this.setPreferredSize(new Dimension(100,100));

        this.setSize(200,200);
        this.setLocation(0,300);
        this.setX(0);
        this.setY(300);
        this.setBackground(Color.blue);
        this.setVisible(true);
        this.setOpaque(true);





        this.addMouseMotionListener(this);
        this.addMouseListener(this);


        this.setBorder(BorderFactory.createDashedBorder(Color.BLACK));



    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("dentro");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        xMouse = e.getX();
        yMouse = e.getY();
        System.out.println("x = " + xMouse + " y = " + yMouse);
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

    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Mouse arrastado no painel de dentro!");
        //System.out.println(e.getX() + " dfgdf " + e.getX() );
        int xParent = (int) getParent().getMousePosition().getX();
        int yParent = (int) getParent().getMousePosition().getY();

        int xa = xParent - xMouse;
        int ya = yParent - yMouse;

//        System.out.println("x parent = " + xParent + " y parent = " + yParent);
//        System.out.println("x = " + xMouse + " y = " + yMouse);


        this.setX(xa);
        this.setY(ya);
        this.setLocation(xa, ya);

        this.getParent().revalidate();
        this.getParent().repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //System.out.println("x = " + e.getX() + " y = " + e.getY());
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y);
    }



    }
