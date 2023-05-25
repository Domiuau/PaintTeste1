import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class Painel3 extends JPanel implements MouseListener, MouseMotionListener, KeyListener {

    ArrayList<Line> linhas = new ArrayList<>();
    ArrayList<Rectangle> rectangles = new ArrayList<>();



    ArrayList<FrontDrawLabel> imagesFrontDrawLabel = new ArrayList<>();
    ArrayList<FrontDrawLabel> frontDrawLabels = new ArrayList<>();
    FrontDrawPanel frontDrawPanel;
    Color color;
    Image imagem;
    FrontDrawLabel frontDrawLabelRemove;
    Graphics2D graphics2D;
    boolean selecionar = false;
    Rectangle rectangle;

    int xMouse, yMouse;
    int x1;
    int x2;
    Random random = new Random();


    public Painel3() {
        this.setPreferredSize(new Dimension(1000,600));
        this.setBackground(new Color(164, 121, 121));
        this.setLayout(null);

        frontDrawPanel = new FrontDrawPanel();
        frontDrawPanel.setBackground(new Color(255, 1, 77));
        this.add(frontDrawPanel, Integer.valueOf(0));
        this.add(new FrontDrawPanel(), Integer.valueOf(1));
        this.add(new FrontDrawPanel(), Integer.valueOf(2));
        this.add(new FrontDrawPanel(), Integer.valueOf(3));
        this.add(new FrontDrawPanel(), Integer.valueOf(4));
        this.add(new FrontDrawPanel(), Integer.valueOf(5));
        color = new Color(0, 0, 0, 39);

        this.setFocusable(true);
        // this.requestFocusInWindow();
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        System.out.println(frontDrawPanel.getX() + " fsdfds " + frontDrawPanel.getY());

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                frontDrawPanel.setX(300);
//                frontDrawPanel.setY(300);
                System.out.println(frontDrawPanel.getX() + " fsdfds " + frontDrawPanel.getY());
                //  frontDrawPanel.setLocation(300,300);
                revalidate();
                repaint();
            }
        });
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = frontDrawPanel.getX();
        int y = frontDrawPanel.getY();

        this.setFocusable(true);
        this.requestFocusInWindow();


        //  frontDrawPanel.setBounds(x - 10, y, frontDrawPanel.getWidth(), frontDrawPanel.getHeight());

    }

    @Override
    public void mousePressed(MouseEvent e) {
        linhas.add(new Line(e.getX(), e.getY(), e.getX(), e.getY(), color));
        repaint();

        if (selecionar) {
            rectangle = new Rectangle();
            rectangle.x = e.getX();
            rectangle.y = e.getY();

        }


    }

    @Override
    public void mouseReleased(MouseEvent e) {

        if (selecionar){


            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Robot robot = null;
                    try {
                        robot = new Robot();
                    } catch (Exception exception) {

                    }


                    Image asd = robot.createScreenCapture(new Rectangle(rectangle.x+1, rectangle.y+24, rectangle.width-2, rectangle.height-2));
                    FrontDrawLabel frontDrawLabel = new FrontDrawLabel(rectangle.x, rectangle.y,asd.getWidth(null), asd.getHeight(null), asd);
                    rectangles.add(new Rectangle(rectangle.x, rectangle.y, rectangle.width, rectangle.height));
                    repaint();

                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {

                            fixarTela(null);
                            add(frontDrawLabel);
                            frontDrawLabels.add(frontDrawLabel);
                        }
                    });

                }
            });




//            rectangle.width = 0;
//            rectangle.height = 0;


        } else {
            //fixarTela();
        }




    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    public void mouseDragged(MouseEvent e) {
        //  System.out.println("fora");
        // linhas.add(new Line(linhas.get(linhas.size() - 1).getX2(), linhas.get(linhas.size() - 1).getY2(), e.getX(), e.getY(), color));

        if (selecionar) {



            rectangle.width = e.getX() - rectangle.x;
            rectangle.height = e.getY() - rectangle.y;
            System.out.println("x = " + rectangle.x + " y = " + rectangle.y + " w = " + rectangle.width + " y = " + rectangle.height);
            getGraphics().drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        } else {
            linhas.add(new Line(linhas.get(linhas.size() - 1).getX2(), linhas.get(linhas.size() - 1).getY2(), e.getX(), e.getY(), color));
        }

        repaint();


    }

    @Override
    public void mouseMoved(MouseEvent e) {

//        this.xMouse = e.getX();
//        this.yMouse = e.getY();
//        System.out.println(xMouse +" gdfgdf " + yMouse);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (selecionar)
            g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);



        if (imagem != null) {
            g.drawImage(imagem,0,0,null);

        }













//        for (FrontDrawLabel fdl:
//                imagesFrontDrawLabel) {
//            g.drawImage(fdl.getImage(),fdl.finalX,fdl.finalY,null);
//        }

//        if (frontDrawLabelRemove != null){
//            //fixarTela();
//            //g.drawImage(imagem,0,0,null);
//            g.drawImage(frontDrawLabelRemove.getImage(),frontDrawLabelRemove.finalX, frontDrawLabelRemove.finalY,null);
//            System.out.println(frontDrawLabelRemove.getX() + " dgdfgdf "+frontDrawLabelRemove.getY());
//
//            //frontDrawLabelRemove = null;
//        }









        Graphics2D graphics2D = (Graphics2D) g;
        graphics2D.setStroke(new BasicStroke(7));

        for (Line linha :
                linhas) {
            Line line = linha;
            g.setColor(linha.getColor());
            try {
              //  g.drawLine(line.getX(), line.getY(), line.getX2(), line.getY2());
                graphics2D.drawLine(line.getX(), line.getY(), line.getX2(), line.getY2());
            } catch (Exception e) {

            }






        }

        for (Rectangle rectangle:
                rectangles) {
            g.setColor(Color.white);
            g.fillRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }














        graphics2D = (Graphics2D) g.create();



        // this.paintComponents(graphics2D);


    }

    public void removeFrontDrawLabel(FrontDrawLabel frontDrawLabel){



        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                frontDrawLabels.remove(frontDrawLabel);

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        fixarTela(null);
                        repaint();

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                remove(frontDrawLabel);
                            }
                        });

                    }
                });

            }
        });


//                Thread a = new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        // frontDrawPanel.setBorder(null);
//
//                    }
//                });
//                a.start();






    }


    @Override
    public int getX() {
        return xMouse;
    }

    public void setX(int x) {
        this.xMouse = x;
    }

    @Override
    public int getY() {
        return yMouse;
    }

    public void setY(int y) {
        this.yMouse = y;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyChar() == 'u') {
            linhas.clear();
            repaint();
            //imagem = capturarImagem();
        }

        if (e.getKeyChar() == 'i') {
            System.out.println("i");
            //getGraphics().copyArea(0,0,300,300,500,500);

            // Graphics graphics = image.getGraphics();
            // ImageIcon imageIcon = new ImageIcon("src/zxc.png");



            //this.getGraphics().fillRect(600,600,400,400);
            // this.getGraphics().drawImage(new ImageIcon("src/zxc.png").getImage(),500,500,null);

            // Copie a área desejada para a imagem
            //this.getGraphics().drawImage(,700,700,null);


        }

        if (e.getKeyChar() == '1') {
            selecionar = true;
        }

        if (e.getKeyChar() == '2') {
            selecionar = false;
        }

        if (e.getKeyChar() == '9'){
            for (FrontDrawLabel fdl:
                    frontDrawLabels) {
                fdl.setVisible(false);
            }
        }

        if (e.getKeyChar() == '0'){

            //fixarTela();







//
//
//            Robot robot = null;
//            try {
//                robot = new Robot();
//            } catch (AWTException ex) {
//                throw new RuntimeException(ex);
//            }
//
//            BufferedImage screenImage = robot.createScreenCapture(new Rectangle(0, 0, this.getWidth(), this.getHeight()));
//            BufferedImage croppedImage = screenImage.getSubimage(this.getX(), this.getY(), this.getWidth(), this.getHeight());
//            Image asd = croppedImage;




//            getGraphics().drawImage(asd,0,0,null);
//            repaint();
        }

        if (e.getKeyChar() == '3'){
            //this.getGraphics().drawImage(imagem,0,0,null);
            System.out.println(linhas.size());
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
        repaint();
    }

    public Image getImagem() {
        return imagem;
    }

    public void setImagem(Image imagem) {
        this.imagem = imagem;
    }

    void fixarTela(FrontDrawLabel frontDrawLabel){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                for (FrontDrawLabel fdl:
                        frontDrawLabels) {
                    fdl.setVisible(false);
                }


                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        Robot robot = null;

                        try {
                            robot = new Robot();
                        } catch (Exception exception) {

                        }

                        imagem = robot.createScreenCapture(new Rectangle((int) getLocationOnScreen().getX(), (int) getLocationOnScreen().getY(), (int) getSize().getWidth(), (int) getSize().getHeight()));
                        linhas.clear();
                        rectangles.clear();



                        for (FrontDrawLabel fdl:
                                frontDrawLabels) {
                            fdl.setVisible(true);
                        }
                    }
                });
            }
        });


























       // repaint();



    }






    }


