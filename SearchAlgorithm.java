package Searches;

/**
 *
 *
 * @author Muhammad Moiz
 *
 */
public interface SearchAlgorithm {

    <T extends Comparable<T>> int find(T array[], T key);

}
