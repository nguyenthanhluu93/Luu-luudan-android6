package controllers;

import models.GameObject;

/**
 * Created by User on 10/21/2016.
 */
public class FlyFollowShootBehavior implements FlyBehavior {

    int dx;
    int dy;
    int SPEED = 3;
    int SPEEDX, SPEEDY;

    @Override
    public void doFly(GameObject gameObject) {
        dx = PlaneController.planeController2.getGameObject().getX() - gameObject.getX();
        dy = PlaneController.planeController2.getGameObject().getY() - gameObject.getY();

        double ratio = SPEED / Math.sqrt(dx*dx + dy*dy);
        SPEEDX = (int) (dx*ratio);

        gameObject.move(SPEEDX, SPEED);
    }
}
