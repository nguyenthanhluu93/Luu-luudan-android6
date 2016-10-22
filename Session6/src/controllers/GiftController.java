package controllers;

import models.GameConfig;
import models.GameObject;
import models.Gift;
import utils.Utils;
import views.GameView;

import java.awt.*;

/**
 * Created by Chihirohaku on 10/22/2016.
 */
public class GiftController extends SingleController implements Contactable {

    private static final int SPEED = 1;

    private GiftController(GameObject gameObject, GameView gameView) {
        super(gameObject, gameView);
        CollisionPool.instance.register(this);
    }

    @Override
    public void run() {
        super.run();
        gameObject.move(0, SPEED);
    }

    @Override
    public void onCollide(Contactable contactable) {
        if (contactable instanceof PlaneController) {
            this.destroy();
            ((PlaneController) contactable).powerUp();
        }

    }

    public final static GiftController giftController = new GiftController(
            new Gift(GameConfig.instance.getScreenWidth()/2, 0),
            new GameView(Utils.loadImageFromRes("power-up.png"))
    );
}
