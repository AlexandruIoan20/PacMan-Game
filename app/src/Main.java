import game_constants.Constants;

public class Main {
    public static void main(String[] args) {
        GameFrame gameFrame = new GameFrame();

        int squareSize = Constants.SQUARE_SIZE.getValue();
        int N = Constants.N.getValue();

        System.out.println(squareSize);
        System.out.println(N);
    }
}
