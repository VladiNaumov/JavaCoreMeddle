package fi.lahti.unit_8;


// главная Node с каторой мы начинаем работать
public class SingleLinkedList implements GBList {
    private Node first; // Node -> узел
    private int size = 0;


    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node(val);
            return;
        }
        add(current.next, val);
    }



    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }
        size++;
    }


    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            size--;
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    @Override
    public int size() {
//        int i = 0;
//        GBIterator iterator = iterator();
//        while (iterator.hasNext()) {
//            i++;
//        }
//        return i;
        return size;
    }



    @Override
    public int get(int index) {
        return 0;
    }




    @Override
    public GBIterator iterator() {
        return new StraightForwardIterator(first);
    }



    @Override
    public String toString() {
        return "SingleLinkedList{" +
                "first=" + first +
                '}';
    }

    //

    // class Node  -> узел
    private static class Node {
        private String val; // значение
        private Node next; // ссылка на следующий элемент

        public Node(String val) {
            this(val, null);
        }

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


    //итерация (Iterator) - это проход одного элемента
    //class StraightForwardIterator - ?
    public static class StraightForwardIterator implements GBIterator {

        private Node current;

        public StraightForwardIterator(Node current) {
            this.current = current;
        }


        //проверка следующего элемента на наличие в коллекции
        //например в нашей коллекции три элемента то итератор говорит есть ли в коллекции следующий элемен

        @Override
        public boolean hasNext() {
            return current != null;
        }

        //возвращает текущий элемент из коллекции
        @Override
        public String next() {
            String val = current.val;
            current = current.next;
            return val;
        }
    }

}
