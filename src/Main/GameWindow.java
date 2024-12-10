package Main;

import javax.swing.*;

public class GameWindow {
    JFrame gameFrame;
    public GameWindow(GamePanel gp) {
        gameFrame = new JFrame();
        gameFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        gameFrame.setLocationRelativeTo(null);
        gameFrame.add(gp);
        gameFrame.pack();
        gameFrame.setResizable(false);
        gameFrame.setVisible(true);
    }
}
