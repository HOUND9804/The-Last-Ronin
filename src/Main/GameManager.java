package Main;

public class GameManager {
    public GameManager(){
        GamePanel gp=new GamePanel();
        GameWindow gw=new GameWindow(gp);
        gp.requestFocus();
    }
}
