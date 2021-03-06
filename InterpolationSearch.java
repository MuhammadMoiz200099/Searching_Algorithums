package Searches;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

import static java.lang.String.format;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */

class InterpolationSearch {

	public int find(int array[], int key) {
		int start = 0, end = (array.length - 1);
	
		while (start <= end && key >= array[start] && key <= array[end]) {
			int pos = start + (((end-start) / (array[end]-array[start]))*(key - array[start]));
			if (array[pos] == key)
				return pos;
			if (array[pos] < key)
				start = pos + 1;
			else
				end = pos - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		Random r = new Random();
		int size = 100;
		int maxElement = 100000;
		int[] integers = IntStream.generate(() -> r.nextInt(maxElement)).limit(size).sorted().toArray();

		Integer shouldBeFound = integers[r.nextInt(size - 1)];

		InterpolationSearch search = new InterpolationSearch();
		int atIndex = search.find(integers, shouldBeFound);

		System.out.println(String.format("Should be found: %d. Found %d at index %d. An array length %d"
				, shouldBeFound, integers[atIndex], atIndex, size));


		int toCheck = Arrays.binarySearch(integers, shouldBeFound);
		System.out.println(format("Found by system method at an index: %d. Is equal: %b", toCheck, toCheck == atIndex));
	}
}

