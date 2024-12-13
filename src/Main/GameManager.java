package Main;

import entities.Player;
import levels.LevelManager;

import java.awt.*;

public class GameManager implements Runnable {
    GamePanel gp;
    GameWindow gw;
    private Thread gameThread;
    private final int fps = 120;
    private final int ups= 200;

    public static final int tileInWidth=45;
    public static final int tileInHeight=20;
    public final int entitywidth=128;
    public final int entityheight=128;
    public static final int scale=1;
    public static final int tileSize=32;
    public int width=tileInWidth*scale*tileSize;
    public int height=tileInHeight*scale*tileSize;

    public Player player;
    public LevelManager levelManager;
    public GameManager() {
        initClasses();
        gp = new GamePanel(this);
        gw = new GameWindow(gp);
        gp.requestFocus();
        startGameThread();
    }
    private void initClasses() {
        player=new Player(1*tileSize,11*tileSize,entitywidth,entityheight);
        levelManager=new LevelManager(this);
    }
    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        player.update();
        levelManager.update();
    }
    public void render(Graphics g) {
        levelManager.draw(g);
        player.render(g);
    }
    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / fps;
        double timePerUpdate = 1000000000.0 / ups;

        long previousTime = System.nanoTime();

        long lastCheck=System.currentTimeMillis();
        int frames = 0;
        int updates = 0;

        double deltaU =0;
        double deltaF =0;

        while (true) {
            long currentTime=System.nanoTime();

            deltaU += (currentTime-previousTime)/timePerUpdate;
            deltaF += (currentTime-previousTime)/timePerFrame;

            previousTime = currentTime;

            if(deltaU>=1){
                update();
                updates++;
                deltaU--;

            }
            if(deltaF>=1){
                gp.repaint();
                frames++;
                deltaF--;
            }
            if(System.currentTimeMillis()- lastCheck >= 1000) {
                lastCheck=System.currentTimeMillis();
                System.out.println("FPS: "+frames+"ups: "+updates);
                frames=0;
                updates=0;
            }
            try {
                Thread.sleep(1);  // Prevent busy-waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
