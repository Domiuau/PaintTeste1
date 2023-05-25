import javax.swing.*;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;

public class Test3 extends JFrame {

    static Painel3 painel3;



    Test3(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        painel3 = new Painel3();
        this.getContentPane().add(painel3);
        this.setVisible(true);
        addWindowStateListener(new WindowStateListener() {
            @Override
            public void windowStateChanged(WindowEvent e) {

            }
        });

    }

    public static void main(String[] args) {
     Test3 test3 = new Test3();




    }
}
