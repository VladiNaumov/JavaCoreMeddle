package fi.lahti.unitLinkList;

public class DuobleLingList {

    // Node -> узел
    private Node next;
    private Node back;

    private void addNext( String val, Node curNext ) {

        if (curNext.next == null) {
         //   curNext.next.takas = curNext;
            curNext.next = new Node(val);
            return;
        }
        addNext( val, curNext.next);
    }

    //добовление значения в коллекцию (вперёд)
    public void addEtana(String val) {
        if (next == null) {
            next = new Node(val);
        } else {
            addNext(val, next);
        }

    }



    @Override
    public String toString() {
        return "DuobleLingList{" +
                "ensi=" + next +
                ", toinen=" + back +
                '}';
    }

    // class Node  -> узел  он без LinkinList существовать не может. Она обслуживает LinkinList
    private static class Node {
         private Node takas; // ссылка на предыдущий элемент элемент
         private String val; // значение
         private Node next; // ссылка на следующий элемент


        /*
        //конструктор для передачи значения и узла
        public Node(Node takas, String val, Node next) {
            this.takas = takas;
            this.val = val;
            this.next = next;

        }

         */

        //конструктор для передачи значения
        public Node(String val) {
            this.takas = null;
            this.val = val;
            this.next = null;
        }


        @Override
        public String toString() {
            return "Node{" +
                    "takas=" + takas +
                    ", val='" + val + '\'' +
                    ", next=" + next +
                    '}';
        }
    }

}


/*
public String toString(){
            return "Node{" + "val=" + val + '\'' + ", next=" + next + '}';
            if(prev == null){
                return "Node{" + "val=" + val + '\'' + ", next=" + next + '}';
            } else return "Node{" + "prev=" + prev.val + '\'' + ", val=" + val + '\'' + ", next=" + next + '}';
        }
 */