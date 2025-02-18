package game_constants;

public enum Constants {
    SQUARE_SIZE(30), N(19),
    WALL_VALUE(1),
    EMPTY_VALUE(2),
    POINT_VALUE(3),
    ENEMY_VALUE(4),
    PLAYER_VALUE(5);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}