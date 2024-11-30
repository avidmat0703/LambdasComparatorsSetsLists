package org.iesvdm.Ej9;

import java.util.*;

public class Ej9 {
    public static void main(String[] args) {
        /**
         * Modify the first Comparator object of question 7 so that if
         * two lists are of the same length, the one with the greater
         * sum is considered greater than the other one and vice versa.
         * Modify the second Comparator object of question 7 so that if
         * two lists have the same sum, the longer one is considered
         * greater than the other one. Use these Comparators in a modified version of question 8.
         */

        // Comparator for length, breaking ties with the sum
        Comparator<List<Integer>> byLengthThenSum = (a, b) -> {
            int lengthCompare = Integer.compare(a.size(), b.size());
            if (lengthCompare == 0) {
                int sumA = a.stream().mapToInt(Integer::intValue).sum();
                int sumB = b.stream().mapToInt(Integer::intValue).sum();
                return Integer.compare(sumA, sumB);
            }
            return lengthCompare;
        };

        // Comparator for sum, breaking ties with length
        Comparator<List<Integer>> bySumThenLength = (a, b) -> {
            int sumCompare = Integer.compare(
                    a.stream().mapToInt(Integer::intValue).sum(),
                    b.stream().mapToInt(Integer::intValue).sum());
            if (sumCompare == 0) {
                return Integer.compare(a.size(), b.size());
            }
            return sumCompare;
        };

        // Sample HashSet of lists
        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(10, 20));
        set.add(Arrays.asList(5, 5, 5));

        // TreeSet ordered by length, then sum
        TreeSet<List<Integer>> treeSetLengthSum = new TreeSet<>(byLengthThenSum);
        treeSetLengthSum.addAll(set);
        System.out.println("TreeSet ordered by length then sum: " + treeSetLengthSum);

        // TreeSet ordered by sum, then length
        TreeSet<List<Integer>> treeSetSumLength = new TreeSet<>(bySumThenLength);
        treeSetSumLength.addAll(set);
        System.out.println("TreeSet ordered by sum then length: " + treeSetSumLength);
    }
}