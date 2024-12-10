package Inputs;

import Main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
                System.out.println("W");
                gamePanel.y+=2;
                break;
            case KeyEvent.VK_A:
                System.out.println("A");
                gamePanel.x-=2;
                break;
            case KeyEvent.VK_S:
                System.out.println("S");
                gamePanel.y-=2;
                break;
            case KeyEvent.VK_D:
                gamePanel.x+=2;
                System.out.println("D");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
