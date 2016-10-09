package controllers;

import models.Bullet;
import models.Plane;
import views.BulletView;
import views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Created by Chihirohaku on 10/9/2016.
 */
public class BulletController {

    private Bullet bullet;
    private BulletView bulletView;

    private int dx;
    private int dy;
    private static final int SPEED = 10;

    public BulletController(Bullet bullet, BulletView bulletView) {
        this.bullet = bullet;
        this.bulletView = bulletView;
    }

    public void run() {
        // update model
        bullet.fly();
    }

    public void draw(Graphics g) {
        bulletView.drawImage(g, bullet);
    }

}
