package game_constants;

public enum Constants {
    SQUARE_SIZE(50), N(19);

    private final int value;

    Constants(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}