package controllers;

import models.EnemyBullet;
import models.GameObject;
import utils.Utils;
import views.GameView;

/**
 * Created by User on 10/21/2016.
 */
public class FollowShootBehavior implements ShootBehavior {

    @Override
    public void doShoot(GameObject gameObject, ControllerManager bulletControllerManager) {
        EnemyBulletController enemyBulletController = new EnemyBulletController(
                new EnemyBullet(gameObject.getX(), gameObject.getY()),
                new GameView(Utils.loadImageFromRes("enemy_bullet.png")),
                new FlyFollowShootBehavior()
        );

        bulletControllerManager.add(enemyBulletController);
    }
}
