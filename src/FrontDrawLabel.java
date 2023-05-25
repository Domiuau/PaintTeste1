import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FrontDrawLabel extends JLabel implements MouseListener, MouseMotionListener, KeyListener {

    int x, y;
    int xMouse, yMouse;
    Image image;

    public FrontDrawLabel(int x, int y, int width, int height, Image image) {
        ;
        // this.setPreferredSize(new Dimension(100,100));

        this.setSize(width,height);
        this.setIcon(new ImageIcon(image));
        this.setLocation(x+20,y-15);
        this.setX(x+20);
        this.setY(y-15);
        this.image = image;
        this.setBorder(BorderFactory.createDashedBorder(Color.BLACK));


        //this.setBackground(Color.blue);



        this.addMouseMotionListener(this);
        this.addMouseListener(this);
        this.addKeyListener(this);


    }



    public void setX(int x) {
        this.x = x;
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
        this.setFocusable(true);
        xMouse = e.getX();
        yMouse = e.getY();

        this.setFocusable(true);
        this.requestFocusInWindow();

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

//        this.setX(xParent);
//        this.setY(yParent);

//        System.out.println("x parent = " + xParent + " y parent = " + yParent);
//        System.out.println("x = " + xMouse + " y = " + yMouse);


//        this.setX(xa);
//        this.setY(ya);
        this.setLocation(xa, ya);

        this.getParent().revalidate();
        this.getParent().repaint();

//        this.getParent().revalidate();
//        this.getParent().repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {

//        xMouse = e.getX();
//        yMouse = e.getY();

    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 's'){



                  // this.setBorder(BorderFactory.createEmptyBorder());


                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(x);
                    System.out.println(y);

//                    final int xq = getLocation().x;
//                    final int yq = getLocation().y;
//
//                    finalX = xq;
//                    finalY = yq;

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    setBorder(null);
                }

            });


                    Test3.painel3.removeFrontDrawLabel(this);


















        }
    }

    @Override
    public void keyPressed(KeyEvent e) {


    }

    @Override
    public void keyReleased(KeyEvent e) {



    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }


}