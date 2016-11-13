package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by Chihirohaku on 10/25/2016.
 */
public abstract class GameDrawer {
    public abstract void drawImage(Graphics g, GameObject gameObject);
}
