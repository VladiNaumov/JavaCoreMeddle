package fi.lahti.unit_3.book;

import java.util.*;

public class TelephonBook {

    private Map<String, Set<String>> myBook= new HashMap<>();

    public void add(String nimi, String numerot) {
        if(myBook.containsKey(nimi)){
            myBook.get(nimi).add(numerot);
        }else{
            Set<String>numbers=new HashSet<>();
            numbers.add(numerot);
            myBook.put(nimi, numbers);
        }

   }


   public Set<String> get(String name){

       System.out.println("****  Haetaan myBook: " + name);
        if(myBook.get(name) == null){
            return new HashSet<>();
        }

       return myBook.get(name);

   }
    public void printing(){
         System.out.println("Nyt myBook on ..... " );
        for(Map.Entry<String, Set<String>> entry : myBook.entrySet()){

            System.out.printf("SukuNimi: %s, PuhelinNumerot: %s \n", entry.getValue(), entry.getKey());
        }
    }

 // не работает
    public Set<String> getStreem(String name) {

        System.out.println("****  Haetaan myBook: (SYSTEM .stream(): " + name);

        String value = name;
        String s = "";

        Optional<String> result = myBook.entrySet()
                .stream()
                .filter(entry -> value.equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .findFirst();

        if (result.isPresent()) {
            s = value;
        }

        return myBook.get(s);
    }


}
