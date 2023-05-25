import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class AAA extends JFrame {
    private JPanel parentPanel;
    private JPanel childPanel;

    public AAA() {
        setTitle("Exemplo de Movimento de JPanel");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(800, 600));

        parentPanel = new JPanel(null);
        parentPanel.setBackground(Color.LIGHT_GRAY);

        childPanel = new JPanel();
        childPanel.setBackground(Color.BLUE);
        childPanel.setSize(100, 100);

        parentPanel.add(childPanel);

        // Adiciona o listener de movimento do mouse ao JPanel pai
        parentPanel.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX() - childPanel.getWidth() / 2;
                int y = e.getY() - childPanel.getHeight() / 2;

                childPanel.setLocation(x, y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                // Não é necessário implementar nada aqui, mas a interface requer essa implementação
            }
        });

        getContentPane().add(parentPanel);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new AAA());
    }
}