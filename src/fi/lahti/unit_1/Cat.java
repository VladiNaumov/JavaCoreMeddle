package fi.lahti.unit_1;

public class Cat extends AbstractMaster implements Move{


    public Cat(String nemi) {
        this.nemi = nemi;
        this.run = 100;
        this.jump = 3;
    }


    @Override
    public String toString() {
        return "Cat{" +
                "nemi='" + nemi + '\'' +
                ", run=" + run +
                ", jump=" + jump +
                '}';
    }

    @Override
    public void jumpRun(Obstacle[] masterJumpRuns) {
        for (Obstacle n : masterJumpRuns) {
            if (n.getLength() > 0 && run >= n.getLength()) {
                System.out.println("Я Cat " + nemi + " пробежал " + n.getLength()+ " m");

            }

            if (n.getHeingth() > 0 && jump >= n.getHeingth()) {
                System.out.println("Я Cat " + nemi + " прыгнул " + n.getHeingth()+ " m");
            }
        }
    }


}
