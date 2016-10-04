import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Created by Chihirohaku on 10/2/2016.
 */
public class GameWindow extends Frame {

    Image background;
    Image plane1, plane2;
    private int planeX1 = 350;
    private int planeY1 = 450;
    private int planeX2 = 400;
    private int planeY2 = 300;

    public GameWindow() {
        this.setVisible(true);
        this.setSize(800, 600);

        this.addWindowListener(new WindowListener() {
            public void windowOpened(WindowEvent e) {

            }

            public void windowClosing(WindowEvent e) {
                System.exit(0);

            }

            public void windowClosed(WindowEvent e) {

            }

            public void windowIconified(WindowEvent e) {

            }

            public void windowDeiconified(WindowEvent e) {

            }

            public void windowActivated(WindowEvent e) {

            }

            public void windowDeactivated(WindowEvent e) {

            }
        });
        this.addKeyListener(new KeyListener() {
            public void keyTyped(KeyEvent e) {

            }

            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_RIGHT:
                        planeX1 += 10;
                        repaint();
                        break;
                    case KeyEvent.VK_LEFT:
                        planeX1 -= 10;
                        repaint();
                        break;
                    case KeyEvent.VK_DOWN:
                        planeY1 +=10;
                        repaint();
                        break;
                    case KeyEvent.VK_UP:
                        planeY1 -= 10;
                        repaint();
                        break;
                }

            }

            public void keyReleased(KeyEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged");
            }

            public void mouseMoved(MouseEvent e) {

                planeX2 = e.getX();
                planeY2 = e.getY();
                System.out.println("mouseMoved: " + e.getX() + ": " + e.getY());
                repaint();
            }
        });

        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane1 = ImageIO.read(new File("resources/plane3.png"));
            plane2 = ImageIO.read(new File("resources/plane4.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();

    }

    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(background, 0, 0, 800, 600, null);
        g.drawImage(plane1, planeX1, planeY1, null);
        g.drawImage(plane2, planeX2, planeY2, null);
    }
}
