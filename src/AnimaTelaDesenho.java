import javax.swing.*;
import java.awt.*;

public class AnimaTelaDesenho extends JFrame {
    private JPanel tela;

    public AnimaTelaDesenho() {
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.BLUE)
            }
        };
    }
}
