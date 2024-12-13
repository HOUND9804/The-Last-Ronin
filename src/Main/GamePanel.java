package Main;

import Inputs.MouseInputs;
import Inputs.keyBoardInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public GameManager gm;
    public GamePanel(GameManager gm) {
        this.gm = gm;
        addKeyListener(new keyBoardInputs(this));
        addMouseListener(new MouseInputs(this));
        setFocusable(true);
        requestFocusInWindow();
        setPanelSize();
    }


    private void setPanelSize(){
        Dimension size = new Dimension(gm.width, gm.height);
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        gm.render(g);
    }


}
