package fi.lahti.unit_1;

public class Robot extends AbstractMaster implements Move{

    public Robot(String model) {
        this.nemi = model;
        this.run = 3000;
        this.jump = 0;
    }


    @Override
    public String toString() {
        return "Robot{" +
                "model='" + nemi + '\'' +
                ", run=" + run +
                ", jump=" + jump +
                '}';
    }

    @Override
    public void jumpRun(Obstacle[] masterJumpRuns) {
        for (Obstacle n : masterJumpRuns) {
            if (n.getLength() > 0 && run >= n.getLength()) {
                System.out.println("Я Robot " + nemi + " пробежал " + n.getLength() + " m");

            }

            if (n.getHeingth() > 0 && jump >= n.getHeingth()) {
                System.out.println("Я Robot " + nemi + " прыгнул " + n.getHeingth() + " m");
            }
        }
    }

}

