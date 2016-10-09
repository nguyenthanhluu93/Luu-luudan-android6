import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Chihirohaku on 10/2/2016.
 */
public class GameWindow extends Frame implements Runnable {


    private static final int BACKGROUND_WIDTH = 800;
    private static final int BACKGROUND_HEIGHT = 600;
    Image background;
    Image backBufferImage;

    Plane plane;
    Plane plane2;

    Enemy enemy;
//    ArrayList<Enemy> listEnemy = new ArrayList<>();

    private int planeX = 350;
    private int planeY = 250;
    private int planeX2 = 400;
    private int planeY2 = 300;

    public GameWindow() {

        backBufferImage = new BufferedImage(BACKGROUND_WIDTH, BACKGROUND_HEIGHT, BufferedImage.TYPE_INT_ARGB);


        try {
            plane = new Plane(planeX, planeY, ImageIO.read(new File("resources/plane3.png")));
            plane2 = new Plane(planeX2, planeY2, ImageIO.read(new File("resources/plane4.png")));
            Random rd = new Random();

            enemy = new Enemy(rd.nextInt(BACKGROUND_WIDTH), 0, ImageIO.read(new File("resources/enemy_plane_white_2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }

        this.setVisible(true);
        this.setSize(BACKGROUND_WIDTH, BACKGROUND_HEIGHT);

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
                plane.keyPressed(e);
//                bullet.keyPressed(e);
            }

            public void keyReleased(KeyEvent e) {

            }
        });

        this.addMouseMotionListener(new MouseMotionListener() {
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged");
            }

            public void mouseMoved(MouseEvent e) {
                plane2.mouseMoved(e);
            }
        });

        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                plane2.mouseClicked(e);
                System.out.println("mouseClicked");

            }

            @Override
            public void mousePressed(MouseEvent e) {

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
        });

        try {
            background = ImageIO.read(new File("resources/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        repaint();

    }

    public void paint(Graphics g) {
        super.paint(g);

    }

    public void update(Graphics g) {

        Graphics backBufferGraphics = backBufferImage.getGraphics();

        backBufferGraphics.drawImage(background, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
        plane.drawImage(backBufferGraphics);
        plane2.drawImage(backBufferGraphics);
        for (int i =0; i< plane.getListBullet().size(); i++) {
            plane.getListBullet().get(i).drawImage(backBufferGraphics);
        }
        for (int i =0; i < plane2.getListBullet().size(); i++) {
            plane2.getListBullet().get(i).drawImage(backBufferGraphics);
        }
        enemy.drawImage(backBufferGraphics);
        enemy.move();
        for (int i=0; i<enemy.getListBullet().size(); i++) {
            enemy.getListBullet().get(i).drawImage(backBufferGraphics);
            enemy.getListBullet().get(i).bullet_enemy_fly();
        }
        g.drawImage(backBufferImage, 0, 0, BACKGROUND_WIDTH, BACKGROUND_HEIGHT, null);
    }
    int count = 0;
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);
                for (int i = 0; i < plane.getListBullet().size(); i++) {
                    plane.getListBullet().get(i).fly();
                }
                for (int i = 0; i < plane2.getListBullet().size(); i++) {
                    plane2.getListBullet().get(i).fly();
                }

                    count++;
                    if (count > 30) {
                        count =0;
                        enemy.createBullet();
                        for (int i=0; i< enemy.getListBullet().size(); i++) {
                            enemy.getListBullet().get(i).bullet_enemy_fly();
                        }

                }


                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
