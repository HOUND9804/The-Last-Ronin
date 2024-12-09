package Main;

import javax.swing.*;

public class GameWindow {
    JFrame gameFrame;
    public GameWindow(GamePanel gp) {
        gameFrame = new JFrame();
        gameFrame.setSize(400,400);
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.add(gp);
        gameFrame.setVisible(true);
    }
}
