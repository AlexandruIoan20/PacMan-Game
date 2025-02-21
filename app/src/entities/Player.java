package entities;

public class Player extends Entity  {
    private int player_i;
    private int player_j;
    public Player(int blockValue, int player_i, int player_j) {
        super(blockValue);
        this.player_i = player_i;
        this.player_j = player_j;
    }

    public int getPlayerI () {
        return player_i;
    }

    public int getPlayerJ () {
        return player_j;
    }

    public void setPlayerI(int playerI) {
        this.player_i = playerI;
    }

    public void setPlayerJ(int playerJ) {
        this.player_j = playerJ;
    }

    @Override
    public void move () {
        System.out.println("The player is moving");
    }
}
