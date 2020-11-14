package fi.lahti.unit_3.set;

/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся). Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
   Посчитать сколько раз встречается каждое слово.
 */

import java.util.*;

public class AppSet {

    public static void main(String[] args) {

        List<String> kaupungit = Arrays.asList("Riihimäki", "Helsinki", "Lahti", "Oulu", "Turku", "Tampere",
                "Vaasa", "Pori", "Tampere", "Moskov", "Pietari", "Rovaniemi", "Levi", "Pasila");

        System.out.println("Исходный список:");

        for(String k : kaupungit){
            System.out.println(k);
        }

        System.out.println("\nСводка:");

        Map<String, Integer> wordsCount = new HashMap<>();
        for (String s : kaupungit) {
            wordsCount.put(s, wordsCount.getOrDefault(s, 0) + 1);
        }

        for (Map.Entry<String, Integer> e : wordsCount.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }

        System.out.println("\nБез повторов: ");

        Set<String> unique = new HashSet<>(kaupungit);

        for(String k : unique){
            System.out.println(k);
        }
   }

}
