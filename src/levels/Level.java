package levels;

public class Level {
    public int[][]levelData;
    public Level(int [][] levelData){
        this.levelData = levelData;
    }
    public int getSpriteIndex(int x,int y){
        return levelData[x][y];
    }
}
