package Main;

public class GameManager implements Runnable {
    GamePanel gp;
    GameWindow gw;
    private Thread gameThread;
    private final int fps = 120;
    private final int ups= 200;
    public GameManager() {
        gp = new GamePanel();
        gw = new GameWindow(gp);
        gp.requestFocus();
        startGameThread();
    }

    private void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    public void update() {
        gp.updateGame();
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
