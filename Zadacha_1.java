// 1. Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернёет «перевёрнутый» список.

package DZ_4;

import java.util.LinkedList;

public class Zadacha_1 {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        System.out.println("Изначаьный список");
        System.out.println(list);
        LinkedList<String> newList = myNewList(list);
        System.out.println("Перевернутый изначальный список");
        System.out.println(newList);
    }

    public static LinkedList<String> myNewList(LinkedList<String> list) {
        LinkedList<String> newList = new LinkedList<>();
        int lastEl = list.size() - 1;
        for (int i = lastEl; i >= 0; i--) {
            newList.add(list.get(i)) ;

        }
        return newList;
    }
}