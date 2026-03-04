package com.weihnachten.collections;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] zahlen = {1, 2, 7, 4, 5, 6, 7, 8, 9, 10};

        System.out.println("Element 3:" + zahlen[2]);

        for (int z : zahlen) {
            System.out.println("Zahl:" + z);
        }

        for (int i = 0; i < zahlen.length; i++) {
            System.out.println("Element " + i + ":" + zahlen[i]);
        }

        List<Integer> zahl = new ArrayList<>();
        zahl.add(1);
        zahl.add(2);
        zahl.add(3);
        zahl.add(4);
        zahl.add(5);

        for (int z : zahl) {
            System.out.println("Zahl aus ArrayList:" + z);
        }

        zahl.remove(2);

        for (int z : zahl) {
            System.out.println("Zahl aus ArrayList removed:" + z);
        }

        List<Integer> zahl2 = new LinkedList<>();
        zahl2.add(1);
        zahl2.add(2);
        zahl2.add(3);
        zahl2.add(4);
        zahl2.add(5);

        Set<Integer> nixDoppel = new HashSet<>();
        nixDoppel.add(1);
        nixDoppel.add(2);
        nixDoppel.add(3);
        nixDoppel.add(1);


        for(Integer i : nixDoppel) {
            System.out.println("nixDoppel:" + i);
        }

        Set<Integer> tree = new TreeSet<>();
        tree.add(5);
        tree.add(2);
        tree.add(3);
        tree.add(1);
        tree.add(2);

        System.out.println("Tree:" + tree);
        System.out.println("Kleinste Element:" + tree.toArray()[0]);
        System.out.println("Größte Element:" + tree.toArray()[3]);

        Set<String> namen = new TreeSet<>();
        namen.add("Franz");
        namen.add("Bärtram");
        namen.add("Tom");

        System.out.println(namen);

        Set<String> namen2 = new TreeSet<>(Comparator.reverseOrder());
        namen2.addAll(namen);

        System.out.println(namen2);

        Map<String, String> telefonbuch = new HashMap<>();
        telefonbuch.put("Anna", "+4366012345678");
        telefonbuch.put("Max", "+43664789456123");
        telefonbuch.put("Tom", "+431554655844");

        System.out.println(telefonbuch.get("Anna"));
        System.out.println(telefonbuch.get("Max"));

        for(Map.Entry<String, String> entry : telefonbuch.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

        telefonbuch.put("Anna", "+4366033333333");

        System.out.println(telefonbuch.get("Anna"));

        Map<String, String> telefonbuch2 = new TreeMap<>();
        telefonbuch2.put("Anna", "+4366033333333");
        telefonbuch2.put("Max", "+43664789456123");
        telefonbuch2.put("Tom", "+431554655844");

        System.out.println(telefonbuch2.get("Anna")); // langsamer der Einzelzugriff als bei Hashmap

        for(Map.Entry<String, String> entry : telefonbuch2.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }



        Queue<String> queue = new LinkedList<>();
        queue.offer("Drucke A");
        queue.offer("Drucke B");
        queue.offer("Drucke C");

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        Queue<String> queue2 = new ArrayDeque<>();
        queue2.offer("Drucke A");
        queue2.offer("Drucke B");
        queue2.offer("Drucke C");


        //Stack
        Deque<String> queue3 = new ArrayDeque<>();
        queue3.addLast("Drucke A");
        queue3.addLast("Drucke B");
        queue3.addLast("Drucke C");
        System.out.println(queue3.removeLast());
        System.out.println(queue3.removeLast());
        System.out.println(queue3.removeLast());



    }
}
