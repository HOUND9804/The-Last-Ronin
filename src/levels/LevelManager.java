package levels;

import Main.GameManager;
import utilz.LoadSave;

import java.awt.*;
import java.awt.image.BufferedImage;

import static utilz.LoadSave.level1Atlas;
import static utilz.LoadSave.outsideAtlas;

public class LevelManager {
    private GameManager gameManager;
    private BufferedImage[] levelSprite;
    private Level level1;
    public LevelManager(GameManager gameManager) {
        this.gameManager = gameManager;
        level1=new Level(LoadSave.getLevelData());
        importOutsideSprite();
    }

    private void importOutsideSprite() {
        BufferedImage img = LoadSave.loadAtlas(outsideAtlas);
        int cols = img.getWidth() / GameManager.tileSize;
        int rows = img.getHeight() / GameManager.tileSize;
        int totalSprites = cols * rows;

        levelSprite = new BufferedImage[totalSprites];
        int index = 0;

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < cols; x++) {
                levelSprite[index++] = img.getSubimage(x * GameManager.tileSize, y * GameManager.tileSize, GameManager.tileSize, GameManager.tileSize);
            }
        }
    }


    public void draw(Graphics g) {
        for (int j = 0; j < GameManager.tileInHeight; j++) {
            for (int i = 0; i < GameManager.tileInWidth; i++) {
                int index = level1.getSpriteIndex(j, i);
                if (index >= 0 && index < levelSprite.length && levelSprite[index] != null) {
                    g.drawImage(levelSprite[index], i * GameManager.tileSize, j * GameManager.tileSize, GameManager.tileSize, GameManager.tileSize, null);
                }
            }
        }
    }

    public void update() {

    }
}
