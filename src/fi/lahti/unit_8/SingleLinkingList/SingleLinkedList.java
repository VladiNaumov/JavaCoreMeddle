package fi.lahti.unit_8.SingleLinkingList;


// главная Node с каторой мы начинаем работать
public class SingleLinkedList implements GBList {
    private Node first; // Node -> узел
    private int size = 0; // второй способ подсчёта элементов в LinkedList
    private int w;


    private void add(Node current, String val) {
        if (current.next == null) {
            current.next = new Node(val);
            return;
        }
        add(current.next, val);
    }


    //добовление значения в коллекцию
    @Override
    public void add(String val) {
        if (first == null) {
            first = new Node(val);
        } else {
            add(first, val);
        }
        size++; //относится ко второму способу подсчёта элементов в LinkedList
    }




    //удаление значения из коллеции (говорит удалён ли элемент из коллеции или нет т.е. true или false
    @Override
    public boolean remove(String val) {
        if (first.val.equals(val)) {
            first = first.next;
            size--; //относится ко второму способу подсчёта элементов в LinkedList
            return true;
        }

        Node prev = first;
        Node current = first.next;
        while(current != null) {
            if (current.val.equals(val)) {
                prev.setNext(current.next);
                size--; //относится ко второму способу подсчёта элементов в LinkedList
                return true;
            }
            prev = current;
            current = current.next;
        }

        return false;
    }

    //возвращает размер коллекции т.е подсчитывает елементов в коллекции сейчас есть
    @Override
    public int size() {
        return size; //относится ко второму способу подсчёта элементов в LinkedList
    }



    @Override
    public int getString(int s) {
        GBIterator iterator = iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            w++;
            if(w == s) {
                System.out.println("ЗАПРОШЕННЫЙ ЭЛЕМЕНТ: " + next);
                break;
            }
        }
        return w;

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



    // class Node  -> узел  он без LinkinList существовать не может. Она обслуживает LinkinList
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
    //class StraightForwardIterator - реалезован для работы итератора

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
