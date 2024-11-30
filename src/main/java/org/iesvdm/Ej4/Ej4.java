package org.iesvdm.Ej4;

import java.util.*;

public class Ej4 {
    public static void main(String[] args) {
        /**
         * Modify your answer to question 3 so that it can read any
         * lines of text, but only stores what represents integers.
         * For example, the line "37 ok 150 43 end" would lead to 37,
         * 150 and 43 being stored, filtering elements out in each
         * line List using stream and the filter method.
         */

        Scanner scanner = new Scanner(System.in);
        HashSet<List<Integer>> set = new HashSet<>();

        System.out.println("Enter lines of mixed text:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;

            List<Integer> numbers = Arrays.stream(line.split("\\s+"))
                    .filter(s -> s.matches("\\d+"))
                    .map(Integer::parseInt)
                    .toList();
            set.add(numbers);
        }

        // Print filtered HashSet contents
        set.forEach(list -> {
            list.forEach(System.out::println);
            System.out.println("---");
        });
    }
}