package org.iesvdm.Ej8;

import java.util.*;

public class Ej8 {
    public static void main(String[] args) {
        /**
         * Modify your answer to question 3 to store the set of lists of integers
         * as a TreeSet object with an ordering given by the second Comparator
         * object of question 7. Then also store the set of lists of integers as
         * a TreeSet object with an ordering given by the first Comparator
         * object of question 7. Compare the results.
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

        // TreeSet ordered by length
        TreeSet<List<Integer>> treeSetByLength = new TreeSet<>(byLength);
        treeSetByLength.addAll(set);
        System.out.println("TreeSet ordered by length: " + treeSetByLength);

        // TreeSet ordered by sum of elements
        TreeSet<List<Integer>> treeSetBySum = new TreeSet<>(bySum);
        treeSetBySum.addAll(set);
        System.out.println("TreeSet ordered by sum: " + treeSetBySum);
    }
}