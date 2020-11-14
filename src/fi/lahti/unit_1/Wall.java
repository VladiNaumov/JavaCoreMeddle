package fi.lahti.unit_1;

public class Wall implements Obstacle {

    private int heingth;

    public Wall(int heingth) {
        this.heingth = heingth;
    }

    @Override
    public int getHeingth() {
        return heingth;
    }

    @Override
    public int getLength() {
        return 0;
    }

}
