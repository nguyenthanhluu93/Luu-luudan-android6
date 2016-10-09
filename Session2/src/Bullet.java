import java.awt.*;

/**
 * Created by Chihirohaku on 10/4/2016.
 */
public class Bullet {

    private int x;
    private int y;
    private int speech;
    private Image image;

    public Bullet(int x, int y, Image image) {
        this.x = x;
        this.y = y;
        this.image = image;
    }

    public void fly() {
        y -= 10;
    }

    public void bullet_enemy_fly() {
        y += 10;
    }

    public void drawImage(Graphics g) {
        g.drawImage(image, x, y, null);
    }

}
//btvn: nhan phim space or nhan chuot => dan bay (1 vien, nhieu vien)