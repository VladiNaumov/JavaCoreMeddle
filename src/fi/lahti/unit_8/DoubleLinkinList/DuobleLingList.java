package fi.lahti.unit_8.DoubleLinkinList;


public class DuobleLingList {

    private Node first; // Node -> узел


    private void add(Node current, String val) {

        if (current.next == null) {
            current.next = new Node(val);
            return;
        }
        add(current.next, val);
    }

    //добовление значения в коллекцию

    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }

    }

    @Override
    public String toString() {
        return "DuobleLingList{" +
                "first=" + first +
                '}';
    }

    // class Node  -> узел  он без LinkinList существовать не может. Она обслуживает LinkinList
    private static class Node {
        private String val; // значение
         private Node next; // ссылка на следующий элемент


        //конструктор для передачи значения
        public Node(String val) {
            this(val, null); //next
        }

        //конструктор для передачи значения и узла
        public Node(String val, Node next) {
            this.val = val;
            this.next = next;
        }


        public void setNext(Node next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

}
