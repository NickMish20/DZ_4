package DZ_4;
// 2. Реализуйте очередь с помощью LinkedList со следующими методами:
// • enqueue() — помещает элемент в конец очереди,
// • dequeue() — возвращает первый элемент из очереди и удаляет его,
// • first() — возвращает первый элемент из очереди, не удаляя.


import java.util.LinkedList;

public class Zadacha_2 {


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        
        System.out.println("Изначаьный список:");
        System.out.println(list);
        String el = "f";
        enqueue(list, el);
        System.out.printf("Изначаьный список с добавленным элементом %s в конце: \n", el);
        System.out.println(list);
        
        String el1 = dequeue(list);
        System.out.println("Первый элемент, который удаляем из списка:");
        System.out.println(el1);
        System.out.printf("Изначаьный список с удаенным первым элементом %s: \n", el1);
        System.out.println(list);
        
        String el2 = first(list);
        System.out.println("Первый элемент в списке:");
        System.out.println(el2);
    }
    
    public static void enqueue(LinkedList<String> list, String el) {
        // list.addLast(el);
        list.add(list.size(), el);
    }
    public static String dequeue( LinkedList<String> list) {
        // System.out.println(list.pollFirst());
        String el = list.get(0);
        list.remove(0);
        return el;
    }
    public static String first(LinkedList<String> list) {
        String el = list.get(0);
        return el;
    }
    
}