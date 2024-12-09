package Main;

import Inputs.MouseInputs;
import Inputs.keyBoardInputs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class GamePanel extends JPanel {
    public GamePanel(){
        addKeyListener(new keyBoardInputs());
        addMouseListener(new MouseInputs());
    }

    public void paint(Graphics g){
        super.paint(g);

    }
}
