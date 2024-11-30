package org.iesvdm.Ej5;

import java.util.*;
import java.util.stream.Collectors;

public class Ej5 {
    public static void main(String[] args) {
        /**
         * Write a modified version of your answer to question 3
         * or 4 where each line of integers is stored in an object
         * of type Set, and the representation of each line is stored
         * in an object of type List. Compare what is printed at the
         * end with what is printed in the answers to question 3 and
         * 4 when some integers are duplicated on a line and when
         * some lines are identical to other lines.
         */

        Scanner scanner = new Scanner(System.in);
        List<Set<Integer>> list = new ArrayList<>();

        System.out.println("Enter lines of integers:");
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (line.isEmpty()) break;

            Set<Integer> numbers = Arrays.stream(line.split("\\s+"))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
            list.add(numbers);
        }

        // Print contents
        list.forEach(set -> {
            set.forEach(System.out::println);
            System.out.println("---");
        });
    }
}