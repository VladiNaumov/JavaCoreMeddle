package fi.lahti.unit_8.SingleLinkingList;

public interface GBList extends GBIterable {

    //добовление значения в коллекцию
    void add(String val);

    //удаление значения из коллеции (говорит удалён ли элемент из коллеции или нет т.е. true или false
  boolean remove(String val);

    //возвращает размер коллекции т.е сколько елементов в коллекции сейчас есть
  int size();

    //
   int getString(int val);
}
