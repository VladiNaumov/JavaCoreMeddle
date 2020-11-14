package fi.lahti.unit_4.string;

import java.util.Comparator;
import java.util.Objects;
import java.util.TreeMap;

public class R implements Comparator<String> {

    TreeMap<String, Integer> tree = new TreeMap<>();


    public void w(){
        tree.put("VOLVO", 10);
        tree.put("MAZDA", 20);
        tree.put("TAYOTA", 30);
        tree.put("TESLA", 40);
        tree.put("VAZ", 5);
    }

    public void print(){
        System.out.println(tree);
    }


    @Override
    public int compare(String o1, String o2) {
        if(o1.length() > o2.length()){
            return -1;
        }

        else if(o1.length() > o2.length()){
            return 1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        R r = (R) o;
        return Objects.equals(tree, r.tree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tree);
    }

    @Override
    public String toString() {
        return "R{" +
                "tree=" + tree +
                '}';
    }

}
