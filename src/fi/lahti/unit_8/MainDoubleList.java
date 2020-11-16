package fi.lahti.unit_8;

import fi.lahti.unit_8.DoubleLinkinList.InterfaceDoubleLinkinList;
import fi.lahti.unit_8.DoubleLinkinList.MyDoubleLinkinList;


public class MainDoubleList {

    public static void main(String[] args) {

        InterfaceDoubleLinkinList doub = new MyDoubleLinkinList();
        doub.add("MASHA");
        doub.add("DASHA");
        doub.add("GOSHA");

        System.out.println(doub);
    }
}
