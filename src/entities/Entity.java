package entities;

import java.awt.*;
import java.awt.geom.Rectangle2D;

import static Main.GameManager.scale;

public abstract class Entity {

    protected float x, y;
    protected int width, height;
    protected Rectangle hitbox;

    public Entity(float x, float y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        initHitbox();
    }
    protected void drawHitbox(Graphics g) {
        g.setColor(Color.PINK);
        g.drawRect((int)hitbox.x, (int)hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }
    protected void initHitbox() {
        hitbox = new Rectangle((int)x+32, (int)y, width*scale-90, height*scale);
    }
    	protected void updateHitbox() {
		hitbox.x = (int) x+50;
		hitbox.y = (int) y;
	}
    public Rectangle getHitbox() {
        return hitbox;
    }
}
