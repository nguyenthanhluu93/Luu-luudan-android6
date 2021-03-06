package views;

import models.GameObject;
import models.Plane;

import java.awt.*;

/**
 * Created by apple on 10/11/16.
 */
public class GameView extends GameDrawer {

    private Image image;

    public GameView(Image image) {
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void drawImage(Graphics g, GameObject gameObject) {
        g.drawImage(image,
                gameObject.getX(),
                gameObject.getY(),
                gameObject.getWidth(),
                gameObject.getHeight(),
                null);
    }
}
