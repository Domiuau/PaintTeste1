import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Line2D;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;

public class Painel extends JPanel implements MouseListener, MouseMotionListener {

    int x,y;
    int a = 1;
    private ArrayList<MyShapes> shapes;
    Random random = new Random();




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

    public Painel() {

        this.setPreferredSize(new Dimension(1920,1080));
        this.setBackground(new Color(152, 48, 48));
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        shapes = new ArrayList<>();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                super.componentResized(e);
                a = 1;
                repaint();
            }
        });
    }





    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        System.out.println("Pressionado");

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        System.out.println("Soltado");
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        System.out.println("Em cima");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        System.out.println("Fora");
    }

    @Override
    public void mouseDragged(MouseEvent e) {

        this.x = e.getX();
        this.y = e.getY();
        repaint();
        //adicionarShape(new MyShapes(x, y, new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256))));


    }

    @Override
    public void mouseMoved(MouseEvent e) {

        System.out.println("x=" + e.getX() + " y=" + e.getY());
    }



    @Override
    public void paint(Graphics g) {

        if (a < 3){
            System.out.println("aaaaaa");
            super.paintComponent(g);
            a++;
        } else {
            System.out.println(a);
        }

        g.setColor(Color.blue);
        //g.fillRect(0,0,1920,1080);
        g.setColor(Color.cyan);
                g.fillOval(x,y, 5, 5);
            }



//        for (MyShapes shape : shapes) {
//            g.setColor(shape.getColor());
            // desenhe a forma novamente usando os dados armazenados na classe Shape
           // g.drawLine(shape.getX(), shape.getY(), 5, 5);

//        }


    public void adicionarShape(MyShapes shape) {
//        shapes.add(shape);
//        repaint(); // redesenha o painel
    }


}
