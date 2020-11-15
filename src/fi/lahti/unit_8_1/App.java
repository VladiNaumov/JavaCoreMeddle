package fi.lahti.unit_8_1;

public class App {

    public static void main(String[] args) {
        InterfaveLinkedList list = new MyLinkedList();
        list.add("MASHA");
        list.add("SACHA");
        list.add("GOSHA");

        System.out.println(list);

    }
}
