package org.iesvdm.Ej2;

import java.util.*;

public class Ej2 {
    public static void main(String[] args) {
        /**
         * Write two programs, each of which reads in some words all
         * on one line, stores them in an object referred to by a
         * variable of type Set and then prints them out, each word on
         * a separate line, using the for-each method. In one program
         * the object should be of actual type HashSet, in the other of actual type TreeSet.
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter words (space-separated):");
        String[] words = scanner.nextLine().split(" ");

        // HashSet
        Set<String> hashSet = new HashSet<>(Arrays.asList(words));
        System.out.println("\nHashSet:");
        for (String word : hashSet) {
            System.out.println(word);
        }

        // TreeSet
        Set<String> treeSet = new TreeSet<>(Arrays.asList(words));
        System.out.println("\nTreeSet:");
        for (String word : treeSet) {
            System.out.println(word);
        }
    }
}