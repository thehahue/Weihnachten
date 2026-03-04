package com.weihnachten.collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class Krankenhaus {
    public static void main(String[] args) {
        Queue<Patient> queue1 = new PriorityQueue<>(new Patient.PatientComparator());
        queue1.offer(new Patient("John", 1));
        queue1.offer(new Patient("Mary", 5));
        queue1.offer(new Patient("Jane", 3));

        while (!queue1.isEmpty()) {
            System.out.println(queue1.poll());
        }
    }
}
