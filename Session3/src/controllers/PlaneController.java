package controllers;

import models.Bullet;
import models.Plane;
import utils.Utils;
import views.BulletView;
import views.PlaneView;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.Vector;

/**
 * Created by Chihirohaku on 10/9/2016.
 */
public class PlaneController {

    private Plane plane;
    private PlaneView planeView;

    private int dx;
    private int dy;
    private static final int SPEED = 10;
    private Vector<BulletController> bulletControllerVector;

    public PlaneController(Plane plane, PlaneView planeView) {
        this.plane = plane;
        this.planeView = planeView;
        bulletControllerVector = new Vector<>();
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
                System.out.println("Key right");
                dx = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                dx =- SPEED;
                break;
            case KeyEvent.VK_UP:
                dy =- SPEED;
                break;
            case KeyEvent.VK_DOWN:
                dy = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                BulletController bulletController = new BulletController(
                        new Bullet(plane.getMiddleX(), plane.getY()),
                        new BulletView(Utils.loadImageFromRes("bullet.png"))
                );
                bulletControllerVector.add(bulletController);
                break;
        }
    }

    public void mouseClicked(MouseEvent e) {
        BulletController bulletController = new BulletController(
                new Bullet(plane.getMiddleX(), plane.getY()),
                new BulletView(Utils.loadImageFromRes("bullet.png"))
        );
        bulletControllerVector.add(bulletController);

    }

    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased");
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_LEFT:
                dx = 0;
                break;
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                dy = 0;
                break;
        }
    }


    public void run() {
        // update model
        plane.move(dx, dy);
        for (BulletController bulletController : bulletControllerVector) {
            bulletController.run();
        }
    }

    public void draw(Graphics g) {
        planeView.drawImage(g, plane);
        for (BulletController bulletController : bulletControllerVector) {
            bulletController.draw(g);
        }
    }

    public void mouseMoved(MouseEvent e) {
        plane.moveTo(e.getX() - (plane.PLANE_WIDTH / 2), e.getY() - (plane.PLANE_HEIGHT / 2));
    }
}
