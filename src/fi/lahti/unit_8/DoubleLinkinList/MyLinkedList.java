package fi.lahti.unit_8.DoubleLinkinList;


import fi.lahti.unit_8.DoubleLinkinList.InterfaceLinkedList;

public class MyLinkedList implements InterfaceLinkedList {
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
}