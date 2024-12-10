package Main;

public class GameManager implements Runnable {
    GamePanel gp;
    GameWindow gw;
    private Thread gameThread;
    private final int fps = 120;

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

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / fps;  // 120 FPS
        long lastTime = System.nanoTime();
        long now;
        while (true) {
            now = System.nanoTime();
            if (now - lastTime >= timePerFrame) {
                gp.repaint();
                lastTime = now;
            }
            try {
                Thread.sleep(1);  // Prevent busy-waiting
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
