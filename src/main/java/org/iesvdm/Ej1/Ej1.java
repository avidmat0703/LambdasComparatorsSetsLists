package org.iesvdm.Ej1;

import java.util.*;

public class Ej1 {
    public static void main(String[] args) {
        /**
         * Write a lambda to define a Comparator which compares two integers
         * according to their closeness to an integer given externally and
         * caught in the closure of the lambda. For example, if the integer
         * given is 25, then 22 should be greater than 30 according to the
         * Comparator object because 22 is closer to 25 (3 difference) than
         * 30 (5 difference). Demonstrate using this to sort an ArrayList
         * using Java’s built-in sort method, and to construct a TreeSet
         * ordered by a Comparator of this type, and by a stream using its built-in sort method.
         */

        int target = 25;

        Comparator<Integer> closenessComparator = (a, b) -> {
            int diffA = Math.abs(a - target);
            int diffB = Math.abs(b - target);
            return Integer.compare(diffA, diffB);
        };

        // ArrayList
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 30, 22, 40, 18));
        numbers.sort(closenessComparator);
        System.out.println("Sorted List: " + numbers);

        // TreeSet ordered by Comparator
        TreeSet<Integer> treeSet = new TreeSet<>(closenessComparator);
        treeSet.addAll(numbers);
        System.out.println("TreeSet: " + treeSet);

        // Stream sorting
        List<Integer> sortedStream = numbers.stream()
                .sorted(closenessComparator)
                .toList();
        System.out.println("Stream Sorted List: " + sortedStream);
    }
}