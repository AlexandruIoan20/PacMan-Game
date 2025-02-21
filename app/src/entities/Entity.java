package entities;

public abstract class Entity extends Block {
    Entity(int blockValue) {
        super(blockValue);
    }

    abstract void move();
}
