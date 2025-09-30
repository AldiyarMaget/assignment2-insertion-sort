package algorithms;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {
    private InsertionSort sorter;
    @BeforeEach
    public void setUp() {
        sorter = new InsertionSort();
    }
    @Test
    void testEmptyArray() {
        int[] arr = {};
        sorter.sort(arr);
        assertArrayEquals(new int[]{}, arr);
        assertEquals(0, sorter.getComparisons));

    }
    @Test
    void testSingleElementArray() {
        int[] arr = {1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1}, arr);
    }
    @Test
    void testSortedArray() {
        int[] arr = {1,2,3,4,5};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1,2,3,4,5}, arr);
    }
    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }
    @Test
    void testArrayWithDuplicates() {
        int[] arr = {2, 3, 1, 2, 4};
        sorter.sort(arr);
        assertArrayEquals(new int[]{1, 2, 2, 3, 4}, arr);
    }
    @Test
    void testRandomArray() {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sorter.sort(arr);
        assertArrayEquals(new int[]{11, 12, 22, 25, 34, 64, 90}, arr);
    }
}

