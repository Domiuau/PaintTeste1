import javax.swing.*;
import java.awt.*;

public class Test {
    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Painel painel = new Painel();
        frame.add(painel);










        frame.pack();
        frame.setVisible(true);
    }
}
