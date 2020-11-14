package fi.lahti.unit_1;

public class Treadmill implements Obstacle {

    private int length;


    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public int getHeingth() {
        return 0;
    }

    @Override
    public int getLength() {
        return length;
    }
}

