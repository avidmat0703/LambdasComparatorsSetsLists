package org.iesvdm.Ej7;

import java.util.*;

public class Ej7 {
    public static void main(String[] args) {
        /**
         * Write lambda code for a Comparator object that orders List objects
         * in order of their length. Then write code for a Comparator object
         * that orders List objects in the order of the sum of their integers
         * (the sum is all the integers in the list added together, you can
         * use stream to obtain this sum). Use these Comparator objects and
         * the two-argument method max from Java’s class Collections to find the
         * longest list and the list which adds up to the most from the set of
         * lists from a HashSet object, for example as created in question 3.
         * Also create a version of the previous code using stream comparing,
         * sorted and max functions of the API stream.
         */

        // Comparator for list length
        Comparator<List<Integer>> byLength = (a, b) -> Integer.compare(a.size(), b.size());

        // Comparator for sum of list elements
        Comparator<List<Integer>> bySum = (a, b) -> {
            int sumA = a.stream().mapToInt(Integer::intValue).sum();
            int sumB = b.stream().mapToInt(Integer::intValue).sum();
            return Integer.compare(sumA, sumB);
        };

        // Sample HashSet of lists
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(10, 20));
        set.add(Arrays.asList(5, 5, 5));

        // Find the longest list using the max method
        List<Integer> longestList = Collections.max(new ArrayList<>(set), byLength);
        System.out.println("Longest List: " + longestList);

        // Find list with the largest sum using the max method
        List<Integer> maxSumList = Collections.max(new ArrayList<>(set), bySum);
        System.out.println("List with the largest sum: " + maxSumList);

        // Using Streams to find the longest list
        List<Integer> longestStream = set.stream()
                .max(byLength)
                .orElse(Collections.emptyList());
        System.out.println("Longest List using Stream: " + longestStream);

        // Using Streams to find list with the largest sum
        List<Integer> maxSumStream = set.stream()
                .max(bySum)
                .orElse(Collections.emptyList());
        System.out.println("List with the largest sum using Stream: " + maxSumStream);
    }
}