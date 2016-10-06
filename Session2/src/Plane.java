import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Created by Chihirohaku on 10/4/2016.
 */
public class Plane {
    private int x;
    private int y;
    private Image image;
    Bullet bullet, bullet2;
    ArrayList<Bullet> listBullet= new ArrayList<>();


    private static final int PLANE_WIDTH = 50;
    private static final int PLANE_HEIGHT = 30;


    public Plane(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

//    public int getX() {
//        return x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public Image getImage() {
//        return image;
//    }

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
            case KeyEvent.VK_LEFT:
                x -= 10;
                break;
            case KeyEvent.VK_DOWN:
                y += 10;
                break;
            case KeyEvent.VK_UP:
                y -= 10;
                break;
            case KeyEvent.VK_SPACE:
                try {
                    bullet = new Bullet(x+PLANE_WIDTH/2, y,  ImageIO.read(new File("resources/bullet.png")));
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                listBullet.add(bullet);
                break;
        }

    }

    public ArrayList<Bullet> getListBullet() {
        return listBullet;
    }

    public void mouseMoved(MouseEvent e) {
        x = e.getX() - PLANE_WIDTH/2;
        y = e.getY() - PLANE_HEIGHT/2;
    }

    public void mouseClicked(MouseEvent e) {
        try {
            bullet = new Bullet(e.getX()-10, e.getY(), ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        listBullet.add(bullet);
        try {
            bullet2 = new Bullet(e.getX()+10, e.getY(), ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        listBullet.add(bullet2);
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, PLANE_WIDTH, PLANE_HEIGHT, null);
    }

}
