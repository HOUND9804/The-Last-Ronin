package utilz;

public class Constants {

    public static class PlayerConstants {
        public static final int idle = 0;
        public static final int walk = 1;
        public static final int run = 2;
        public static final int attack1 = 3;
        public static final int attack2 = 4;
        public static final int attack3 = 5;
        public static final int defense = 6;
        public static final int jump = 7;
        public static final int damage = 8;
        public static final int dead = 9;

        public static int GetSpriteAmount(int playerAction) {
            switch (playerAction) {
                case idle, dead: return 6;
                case walk, jump: return 9;
                case run: return 8;
                case attack1, attack3: return 4;
                case attack2: return 5;
                case defense: return 2;
                case damage: return 3;
                default: return 1;
            }
        }
    }

}
