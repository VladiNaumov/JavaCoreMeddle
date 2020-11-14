package fi.lahti.unit_3.book;
/*

2. Написать простой класс ТелефонныйСправочник, который хранит в себе список фамилий и телефонных номеров. В этот телефонный справочник с помощью метода add() можно добавлять записи.
С помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 */


public class AppsStart {

    public static void main(String[] args) {

        TelephonBook t = new TelephonBook();
        t.add("VoVa","045-2156199" );
        t.add("VoVa","045-0090087" );
        t.add("Ahmed","041-0090087" );
        t.add("Teemu","045-232678" );
        t.add("Ura ","23455645355" );
        t.add("Igor","999" );

        System.out.println(t.get("VoVa"));
        System.out.println(t.get("Teemu"));
        System.out.println(t.get("Igor"));

   //     System.out.println(t.getStreem("VoVa"));





    }
}


