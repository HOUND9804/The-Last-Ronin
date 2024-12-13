package utilz;

import Main.GameManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class LoadSave {
    public static final String playerAltas="/Res/Samurai.png";
    public static final String level1Atlas="/Res/level2.png";
    public static final String outsideAtlas= "/Res/ground2.png";

    public static BufferedImage loadAtlas(String fileName) {
        BufferedImage img = null;
        try (InputStream is = LoadSave.class.getResourceAsStream(fileName)) {
            img = ImageIO.read(is);

        } catch (IOException e) {
            System.err.println("Error loading animations: " + e.getMessage());
            e.printStackTrace();
        }
        return img;
    }
    public static int[][] getLevelData() {
        int[][] lvlData = new int[GameManager.tileInHeight][GameManager.tileInWidth];
        BufferedImage img = loadAtlas(level1Atlas);
        for (int j = 0; j < img.getHeight(); j++)
            for (int i = 0; i < img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();
                if (value >= 5)
                    value = 0;
                lvlData[j][i] = value;
            }
        return lvlData;
    }
}
