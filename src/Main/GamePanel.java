package Main;

import Inputs.MouseInputs;
import Inputs.keyBoardInputs;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import static utilz.Constants.PlayerConstants.*;

public class GamePanel extends JPanel {
    public int x=10;
    public int y=10;
    private BufferedImage img;
    private BufferedImage[][]animations;
    private int aniTick,aniIndex,aniSpeed=15;
    private int playerAction=attack3;
    public GamePanel(){
        importImage();
        loadAnimations();
        addKeyListener(new keyBoardInputs(this));
        addMouseListener(new MouseInputs(this));
        setPanelSize();
    }

    private void loadAnimations() {
        animations = new BufferedImage[10][9]; // Assuming there are 6 idle frames
        int frameWidth = 128;  // Width of each animation frame
        int frameHeight = 128; // Height of each animation frame
        for(int j=0;j<animations.length;j++){
            for (int i = 0; i <animations[j].length; i++) {
                animations[j][i] = img.getSubimage(i * frameWidth, j*frameHeight, frameWidth, frameHeight);
            }
        }
    }
    private void updateAnimationTick(){
        aniTick++;
        if(aniTick>=aniSpeed){
            aniTick=0;
            aniIndex++;
            if(aniIndex>=GetSpriteAmount(playerAction)){
                aniIndex=0;
            }
            System.out.println(aniIndex);
        }
    }

    private void setPanelSize(){
        Dimension size = new Dimension(1280, 800);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }
    public void importImage() {
        try (InputStream is = getClass().getResourceAsStream("/Res/Samurai.png")) {
            if (is == null) {
                System.err.println("Image not found: /Idle.png");
                return;
            }
            img = ImageIO.read(is);
        } catch (IOException e) {
            System.err.println("Error reading image: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        updateAnimationTick();
        g.drawImage(animations[playerAction][aniIndex],x,y,128*2,128*2,null);
    }
}
