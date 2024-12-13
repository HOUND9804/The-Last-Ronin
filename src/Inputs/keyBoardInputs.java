package Inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static utilz.Constants.PlayerConstants.*;

public class keyBoardInputs implements KeyListener {
    private GamePanel gamePanel;

    public keyBoardInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                gamePanel.gm.player.setJump(true);
                break;

            case KeyEvent.VK_A:
                gamePanel.gm.player.setLeft(true);
                gamePanel.gm.player.setDirection(-1);
                break;

            case KeyEvent.VK_S:
                gamePanel.gm.player.setDown(true);
                break;

            case KeyEvent.VK_D:
                gamePanel.gm.player.setRight(true);
                gamePanel.gm.player.setDirection(1);
                break;

            case KeyEvent.VK_SHIFT:
                if (gamePanel.gm.player.isRight||gamePanel.gm.player.isLeft) {
                    gamePanel.gm.player.setRunning(true);
                }
                break;

            case KeyEvent.VK_CONTROL:
                gamePanel.gm.player.setAttacking3(true);
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_A: gamePanel.gm.player.setLeft(false); break;
            case KeyEvent.VK_S: gamePanel.gm.player.setDown(false); break;
            case KeyEvent.VK_D: gamePanel.gm.player.setRight(false); break;
            case KeyEvent.VK_SHIFT: gamePanel.gm.player.setRunning(false); break;
        }
    }

}
