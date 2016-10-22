package models;

/**
 * Created by Chihirohaku on 10/22/2016.
 */
public class Gift extends GameObject {

    private static int GIFT_WIDTH = 30;
    private static int GIFT_HEIGHT = 30;

    public Gift(int x, int y) {
        super(x, y, GIFT_WIDTH, GIFT_HEIGHT);
    }
}
