import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Chihirohaku on 10/8/2016.
 */
public class Enemy {

    private static final int ENEMY_WIDTH = 50;
    private static final int ENEMY_HEIGHT = 30;
    private int x;
    private int y;
    private Image image;

    ArrayList<Bullet> listBullet = new ArrayList<>();
    Bullet bullet;

    public Enemy(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public ArrayList<Bullet> getListBullet() {
        return listBullet;
    }

    public void move() {
        y += 1;
    }

    public void createBullet() {
        try {
            bullet = new Bullet(x + ENEMY_WIDTH/2, y+ENEMY_HEIGHT, ImageIO.read(new File("resources/bullet.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        listBullet.add(bullet);
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, ENEMY_WIDTH, ENEMY_HEIGHT, null);

    }

}
