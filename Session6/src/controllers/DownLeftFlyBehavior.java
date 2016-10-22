package controllers;

import models.GameConfig;
import models.GameObject;

/**
 * Created by User on 10/20/2016.
 */
public class DownLeftFlyBehavior implements FlyBehavior {

    private int SPEED = 1;
    private int SPEEDX = -3;
    @Override
    public void doFly(GameObject gameObject) {
        if (gameObject.getX() <=0) {
            SPEEDX = -SPEEDX;
        }
        if (gameObject.getX() >= GameConfig.instance.getScreenWidth() - gameObject.getWidth()) {
            SPEEDX = -SPEEDX;
        }
        gameObject.move(SPEEDX, SPEED);

    }
}
