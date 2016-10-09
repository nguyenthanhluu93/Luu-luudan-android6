package views;

import models.Bullet;

import java.awt.*;

/**
 * Created by Chihirohaku on 10/9/2016.
 */
public class BulletView {

    public BulletView(Image image) {
        this.image = image;
    }

    private Image image;

    public Image getImage() {
        return image;
    }

    public void drawImage(Graphics g, Bullet bullet) {
        g.drawImage(image, bullet.getX(), bullet.getY(), bullet.BULLET_WIDTH, bullet.BULLET_HEIGHT, null);
    }
}
