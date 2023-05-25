import javax.swing.*;
import java.awt.*;

public class ASDhadf extends JFrame {

    ASDhadf() {
        Color selectedColor = JColorChooser.showDialog(this, "Selecione uma cor", Color.WHITE);
        System.out.println(selectedColor);
    }

    public static void main(String[] args) {
        new ASDhadf();
    }
}
