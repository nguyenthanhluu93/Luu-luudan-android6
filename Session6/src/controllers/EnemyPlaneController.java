package controllers;

import models.*;
import utils.Utils;
import views.AnimationDrawer;
import views.GameDrawer;
import views.GameView;

import java.awt.*;

/**
 * Created by apple on 10/11/16.
 */
public class EnemyPlaneController extends SingleController implements Contactable {

    private static final int SPEED = 1;

    private ControllerManager butletControllerManager;

    private int count = 0;

    private FlyBehavior flyBehavior;
    private ShootBehavior shootBehavior;

    public EnemyPlaneController(GameObject gameObject, GameDrawer gameDrawer,
                                FlyBehavior flyBehavior,
                                ShootBehavior shootBehavior) {
        super(gameObject, gameDrawer);
        this.flyBehavior = flyBehavior;
        this.shootBehavior = shootBehavior;

        butletControllerManager = new ControllerManager();
        CollisionPool.instance.register(this);
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        butletControllerManager.draw(g);
    }




    @Override
    public void run() {
        // Fly
        // Needs game object
        //gameObject.move(0, SPEED);
        if(flyBehavior != null) {
            this.flyBehavior.doFly(this.gameObject);
        }
        // End Fly


        // Shot
        // Needs: count, butletControllerManager
        count++;
        if (GameConfig.instance.getSeconds(count) > 1) {
            count = 0;
            if (shootBehavior != null) {
                shootBehavior.doShoot(this.gameObject, this.butletControllerManager);
            }
//            EnemyBulletController bulletController = new EnemyBulletController(
//                    new Bullet(gameObject.getMiddleX() - Bullet.BULLET_WIDTH / 2, gameObject.getBottom()),
//                    new GameView(Utils.loadImageFromRes("enemy_bullet.png")
//                    ));
//            butletControllerManager.add(bulletController);
        }
        // End Shot

        butletControllerManager.run();
    }

    @Override
    public void onCollide(Contactable contactable) {
        if(contactable instanceof BulletController) {
            ((BulletController) contactable).destroy();
        }
    }

    public static EnemyPlaneController create(int x, int y, EnemyPlaneType type) {
        String[] arrName = {"enemy_plane_yellow_1.png", "enemy_plane_yellow_2.png", "enemy_plane_yellow_3.png"};

//        Image image = null;

        AnimationDrawer animationDrawer = null;
        FlyBehavior flyBehavior = null;
        ShootBehavior shootBehavior = null;

        if (type == EnemyPlaneType.GRAY) //Gray
        {
//            image = Utils.loadImageFromRes("plane1.png");
            animationDrawer = new AnimationDrawer(arrName);
            flyBehavior = new DownFlyBehavior(1);
            shootBehavior = new DownShootBehavior();
        } else if (type == EnemyPlaneType.RED) // Red
        {
//            image = Utils.loadImageFromRes("plane2.png");
            animationDrawer = new AnimationDrawer(Utils.loadSprite("enemy_plane_yellow.png", 3, 1, 1, 32, 32));
//            flyBehavior = new DownRightFlyBehavior();
            shootBehavior = new FollowShootBehavior();
        }
        else if(type == EnemyPlaneType.YELLOW) {
//            image = Utils.loadImageFromRes("plane3.png");
            flyBehavior = new DownLeftFlyBehavior();
            shootBehavior = new FollowShootBehavior();
        }

        return new EnemyPlaneController(
                new EnemyPlane(x, y),
                animationDrawer,
                flyBehavior,
                shootBehavior);
    }
}
