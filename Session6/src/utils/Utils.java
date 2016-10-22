package utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by apple on 10/9/16.
 */
public class Utils {
    /* Utilities */
    public static BufferedImage loadImage(String url) {
        BufferedImage returnImage = null; // empty
        try {
            returnImage = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return returnImage;
    }

    public static BufferedImage loadImageFromRes(String url) {
        return loadImage("resources/" + url);
    }

    public static BufferedImage rotateImage(BufferedImage src, double degrees) {
        double radians = Math.toRadians(degrees);

        int srcWidth = src.getWidth();
        int srcHeight = src.getHeight();

        double sin = Math.abs(Math.sin(radians));
        double cos = Math.abs(Math.cos(radians));
        int newWidth = (int) Math.floor(srcWidth * cos + srcHeight * sin);
        int newHeight = (int) Math.floor(srcHeight * cos + srcWidth * sin);

        BufferedImage result = new BufferedImage(newWidth, newHeight,
                BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = result.createGraphics();
        g.translate((newWidth - srcWidth) / 2, (newHeight - srcHeight) / 2);
        g.rotate(radians, srcWidth / 2, srcHeight / 2);
        g.drawRenderedImage(src, null);

        return result;
    }
}
