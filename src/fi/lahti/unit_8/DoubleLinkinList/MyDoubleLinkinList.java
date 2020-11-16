package fi.lahti.unit_8.DoubleLinkinList;

import fi.lahti.unit_8.DoubleLinkinList.InterfaceDoubleLinkinList;

public class MyDoubleLinkinList implements InterfaceDoubleLinkinList {
    private Node first;


    //рекурсионный метод (вместо цикла while)
    private void add(Node current, String val) {
        // проверка на null
        if (current.next == null) {
            //  Создаём объект = new Node(val);
            current.next = new Node(val);
            return;
        }
        // вызывает сам себя (рекурсия)
        add(current.next, val);
    }

    @Override
    public void add(String val) {
        // если у первого элемента значению null
        if (first == null) {
            first = new Node(val);
        } else {
            //если у первого элемента уже есть значение, то вызываем метод -> add(first, val);
            add(first, val);
        }
    }

    @Override
    public String toString() {
        return "MyLinkedList{" +
                "first=" + first +
                '}';
    }

    // class Node  -> узел  он без LinkinList существовать не может. Она обслуживает LinkinList
    private static class Node {
        private Node back; // ссылка на прошлый элемент
        private String val; // значение
        private Node next; // ссылка на следующий элемент


        public Node(String val) {
            this(null, val, null);
        }

        public Node(Node back, String val, Node next) {
            this.val = val;
            this.next = next;
            this.back = back;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "back=" + back +
                    ", val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }
}
