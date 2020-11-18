package fi.lahti.unit_8.DoubleLinkinList;


public class DuobleLingList {

    private Node first; // Node -> узел


    private void add(Node current, String val) {

        if (current.next == null) {
            current.next = new Node(val);
            current.next.prev = current;
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
        private Node prev;

        //конструктор для передачи значения
        public Node(String val) {
            this.val = val;
            this.next = null;
        }

        public String toString(){

            if(prev == null) return "Node{" + "val=" + val + '\'' + ", next=" + next + '}';
            else return "Node{" + "prev=" + prev.val + '\'' + ", val=" + val + '\'' + ", next=" + next + '}';
        }

    }
}

