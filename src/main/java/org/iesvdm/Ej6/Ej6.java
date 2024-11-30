package org.iesvdm.Ej6;

import java.util.*;

public class Ej6 {

    public static List<Integer> findLongestList(HashSet<List<Integer>> set) {
        return set.stream()
                .reduce((a, b) -> a.size() > b.size() ? a : b)
                .orElse(Collections.emptyList());
    }

    public static void main(String[] args) {
        /**
         * Write your own static method that will take a HashSet
         * object and return from it the List object within it
         * that is the longest using the reduce method of corresponding
         * stream. If the HashSet is empty, it should return an empty
         * List object. Use this method with the HashSet object
         * created in the answer to question 3.
         */

        HashSet<List<Integer>> set = new HashSet<>();
        set.add(Arrays.asList(1, 2, 3));
        set.add(Arrays.asList(4, 5));
        set.add(Arrays.asList(6, 7, 8, 9));

        List<Integer> longest = findLongestList(set);
        System.out.println("Longest List: " + longest);
    }
}