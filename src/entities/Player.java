package entities;
import utilz.LoadSave;
import java.awt.*;
import java.awt.image.BufferedImage;

import static Main.GameManager.scale;
import static Main.GameManager.tileSize;
import static utilz.Constants.PlayerConstants.*;
import static utilz.LoadSave.playerAltas;

public class Player extends Entity {
    private BufferedImage img;
    private BufferedImage[][] animations;
    private int aniTick, aniIndex, aniSpeed = 30;
    private int playerAction = idle;
    public boolean isJump, isDown, isLeft, isRight, isRunning, isDefending, isAttacking1,isAttacking2,isAttacking3, isDamaged, isDead;
    private int health = 100; // Default player health
    private float speed = 1; // Regular walking speed
    private int direction = 1; // 1 for facing right, -1 for facing left
    private float velocityY = 0; // Vertical velocity for jumping
    private final float JUMP_STRENGTH = -2; // Jump strength
    private final float GROUND_Y = 11*tileSize;

    public Player(float x, float y, int width,int height) {
        super(x, y, width, height);
        loadAnimations();
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void update() {
        checkLife();
        updatePos();
        updateHitbox();
        updateAnimationTick();
        setAnimation();
    }

    public void render(Graphics g) {
        BufferedImage frame = animations[playerAction][aniIndex];
        if (direction == -1) {
            g.drawImage(frame, (int) x + 128, (int) y, -width*scale, height*scale, null);
        } else {
            g.drawImage(frame, (int) x, (int) y, width*scale, height*scale, null);
        }
        drawHitbox(g);
    }

    private void setAnimation() {
        int start=playerAction;
        if (isDead) {
            playerAction = dead;
        } else if(isAttacking1){
            playerAction=attack1;
        } else if(isAttacking2){
            playerAction=attack2;
        } else if(isAttacking3){
            playerAction=attack3;
        }else if (isDamaged) {
            playerAction = damage;
        } else if (isDefending) {
            playerAction = defense;
        } else if (isJump) {
            playerAction = jump;
        } else if (isRunning) {
            playerAction = run;
        } else if (isLeft || isRight) {
            playerAction = walk;
        } else {
            playerAction = idle;
        }
        if(start!=playerAction) {
            resetAni();
        }
    }

    private void resetAni() {
        aniIndex = 0;
        aniTick=0;
    }

    private void updatePos() {
        if(isRunning){
            speed=3;
        }
        else{
            speed=1;
        }
        if (isLeft) {
            x -= speed;
        }
        if (isRight) {
            x += speed;
        }
        if (isJump) {
            velocityY = JUMP_STRENGTH;
            if(aniIndex>1&&aniIndex<=GetSpriteAmount(jump)/2){
                y+=velocityY;
            }
            else{
                y-=velocityY;
                if(y>GROUND_Y){
                    y=GROUND_Y;
                }
            }
        }
    }

    private void updateAnimationTick() {
        aniTick++;
        if (aniTick >= aniSpeed) {
            aniTick = 0;
            aniIndex++;
            if (aniIndex >= GetSpriteAmount(playerAction)) {
                aniIndex = 0;
                if (isAttacking1) {
                    isAttacking1=false;
                }
                if(isAttacking2){
                    isAttacking2=false;
                }
                if(isAttacking3){
                    isAttacking3=false;
                }
                if(isJump){
                    isJump=false;
                }
            }
        }
    }

    private void loadAnimations() {
            img= LoadSave.loadAtlas(playerAltas);
            animations = new BufferedImage[10][9]; // Adjust rows/columns based on sprite sheet
            for (int j = 0; j < animations.length; j++) {
                for (int i = 0; i < animations[j].length; i++) {
                    animations[j][i] = img.getSubimage(i * (int)width, j * (int)height, (int)width,(int)height);
                }
            }
    }

    public void setJump(boolean jump) {
        this.isJump = jump;
    }

    public void setDown(boolean down) {
        this.isDown = down;
    }

    public void setLeft(boolean left) {
        this.isLeft = left;
    }

    public void setRight(boolean right) {
        this.isRight = right;
    }

    public void setRunning(boolean running) {
        this.isRunning = running;
    }

    public void setDefending(boolean defending) {
        this.isDefending = defending;
    }

    public void setAttacking1(boolean attacking) {
        this.isAttacking1 = attacking;
    }
    public void setAttacking2(boolean attacking) {
        this.isAttacking2 = attacking;
    }
    public void setAttacking3(boolean attacking) {
        this.isAttacking3 = attacking;
        health-=20;
    }
    public void checkLife(){
        if(health<=0){
            isDead=true;
        }
    }
    public void setDamaged() {
       isDamaged = true;
    }

}
