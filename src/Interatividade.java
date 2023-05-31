
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Interatividade extends JFrame{


    private JPanel tela;
    private int px;
    private int py;
    private boolean jogando = true;

    private final int FPS = 1000 / 20; // 50


    public void inicia() {
        long prxAtualizacao = 0;
        while (jogando) {
            if(System.currentTimeMillis() >= prxAtualizacao) {
                this.tela.repaint();
                prxAtualizacao = System.currentTimeMillis() + FPS;
            }
        }
    }

    public Interatividade() {
        super.addKeyListener(new KeyListener() {
            @Override
            //Evento para tecla apertada
            public void keyTyped(KeyEvent e) {

            }
            @Override
            //Evento para tecla liberada
            public void keyReleased(KeyEvent e) {

            }

            @Override
            //Evento para tecla pressionada
            public void keyPressed(KeyEvent e) {
                int tecla = e.getKeyCode();
                switch (tecla) {
                    case KeyEvent.VK_ESCAPE:
                        // Tecla ESC
                        jogando = false;
                       dispose(); // para fechar a janela
                        break;
                    case KeyEvent.VK_UP:
                        // Seta para cima
                        py--;
                        break;
                    case KeyEvent.VK_DOWN:
                        // Seta para baixo
                        py++;
                        break;
                    case KeyEvent.VK_LEFT:
                        // Seta para esquerda
                        px--;
                        break;
                    case KeyEvent.VK_RIGHT:
                        // Seta para direita
                        px++;
                        break;
                }
            }
        });
        tela = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0,
                        tela.getWidth(), tela.getHeight());
                int x = tela.getWidth() / 2 - 20 + px;
                int y = tela.getHeight() / 2 - 20 + py;
                g.setColor(Color.BLUE);
                g.fillRect(x, y, 40, 40);
                g.drawString("Agora eu estou em "
                        + x + "x" + y, 5, 10);
            }
        };
        getContentPane().add(tela);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setVisible(true);
    }
    public static void main(String[] args) {
        Interatividade jogo = new Interatividade();
        jogo.inicia();
    }

}
