package Searches;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

import static java.lang.String.format;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */

public class IterativeTernarySearch implements SearchAlgorithm {


    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int left = 0;
        int right = array.length - 1;

         while (right > left) {

            int leftCmp =  array[left].compareTo(key);
            int rightCmp =  array[right].compareTo(key);
            if (leftCmp == 0) return left;
            if (rightCmp == 0) return right;

            int leftThird = left + (right - left) / 3 + 1;
            int rightThird = right - (right - left) / 3 - 1;


            if (array[leftThird].compareTo(key) <= 0) {
                left = leftThird;
            } else {
                right = rightThird;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        Random r = new Random();
        int size = 100;
        int maxElement = 100000;
        Integer[] integers = Stream.generate(() -> r.nextInt(maxElement))
                .limit(size)
                .sorted()
                .toArray(Integer[]::new);

        Integer shouldBeFound = integers[r.nextInt(size - 1)];

        IterativeTernarySearch search = new IterativeTernarySearch();
        int atIndex = search.find(integers, shouldBeFound);

        System.out.println(format("Should be found: %d. Found %d at index %d. An array length %d",
                shouldBeFound, integers[atIndex], atIndex, size));

        int toCheck = Arrays.binarySearch(integers, shouldBeFound);
        System.out.println(format("Found by system method at an index: %d. Is equal: %b",
                toCheck, toCheck == atIndex));

    }


}
