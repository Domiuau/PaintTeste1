import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Test2 extends JFrame implements MouseMotionListener, MouseListener {

    int x,y,x1,x2;
    Painel2 painel2;


    Test2(){
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(155, 215, 135));
        this.setVisible(true);
        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        painel2 = new Painel2();
        painel2.setPreferredSize(new Dimension(300,300));
        painel2.setBackground(Color.blue);
        this.add(painel2);



    }

    public static void main(String[] args) {

        Test2 test2 = new Test2();




    }

    @Override
    public void mouseClicked(MouseEvent e) {


    }

    @Override
    public void mousePressed(MouseEvent e) {
        x1 = e.getX();
        x2 = e.getY();

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


            x = e.getX();
            y = e.getY();

            repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

    @Override
    public void repaint(long time, int x, int y, int width, int height) {
        super.repaint(time, x, y, width, height);
    }

    @Override
    public void repaint() {
        //super.repaint();
        Graphics2D g = (Graphics2D) getGraphics();
        g.setStroke(new BasicStroke(5));
        g.setColor(Color.yellow);
        g.drawLine(x,y,x1,x2);
        x1 = x;
        x2 = y;


    }
}
