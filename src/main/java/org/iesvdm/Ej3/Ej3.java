package org.iesvdm.Ej3;

import java.util.*;

public class Ej3 {
    public static void main(String[] args) {
        /**
         * Write a program that reads several lines of text
         * consisting only of integers. The integers in each
         * line should be stored in an object of type List
         * (integers are separated by spaces), and this
         * representation of each line should be stored in an
         * object of type HashSet. Then the program should print
         * out the contents of this set using forEach method for
         * the object of type List, and the forEach for the object of type HashSet.
         */

        Scanner scanner = new Scanner(System.in);
        HashSet<List<Integer>> set = new HashSet<>();

        System.out.println("Enter lines of integers:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;

            List<Integer> numbers = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .toList();
            set.add(numbers);
        }

        // Print HashSet contents
        set.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println("---");
        });
    }
}