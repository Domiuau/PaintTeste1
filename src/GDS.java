import javax.swing.*;
import java.awt.*;

public class GDS extends JFrame {

    GDS(){
        Color a = JColorChooser.showDialog(this,"sdfdfsdfs",Color.BLACK);
        System.out.println(a);
    }

    public static void main(String[] args) {
        new GDS();
    }
}
