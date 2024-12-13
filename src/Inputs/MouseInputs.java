package Inputs;

import Main.GamePanel;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static utilz.Constants.PlayerConstants.*;

public class MouseInputs implements MouseListener {
    private GamePanel gamePanel;
    public MouseInputs(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON1:

                if (e.isShiftDown()) {
                    gamePanel.gm.player.setAttacking2(true);
                }

                else if (e.isControlDown()) {
                    gamePanel.gm.player.setAttacking3(true);
                }

                else {
                    gamePanel.gm.player.setAttacking1(true);
                }
                  break;
        }
    }



    @Override
    public void mousePressed(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON3:  // Left click for defense
                gamePanel.gm.player.setDefending(true);
                break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        switch (e.getButton()) {
            case MouseEvent.BUTTON3:
                gamePanel.gm.player.setDefending(false);
                break;
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
