package fi.lahti.unit_1;

public class Person extends AbstractMaster implements Move{


    public Person(String nemi) {
        this.nemi = nemi;
        this.run = 200;
        this.jump = 2;
    }

    @Override
    public String toString() {
        return "Person{" +
                "nemi='" + nemi + '\'' +
                ", run=" + run +
                ", jump=" + jump +
                '}';
    }

    @Override
    public void jumpRun(Obstacle[] masterJumpRuns) {
        for (Obstacle n : masterJumpRuns) {
            if ( n.getLength() > 0 && run >= n.getLength()) {
                System.out.println("Я Person " + nemi + " пробежал " + n.getLength()+ " m");

            }

            if ( n.getHeingth() > 0 && jump >= n.getHeingth()) {
                System.out.println("Я Person " + nemi + " прыгнул " + n.getHeingth()+ " m");
            }

        }
    }

}
