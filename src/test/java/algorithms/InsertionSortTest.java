package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {
    @Test
    void testEmpty() {
        int[] a = {};
        InsertionSort s = new InsertionSort();
        s.sort(a);
        assertArrayEquals(new int[]{}, a);
    }
    @Test
    void testSingle() {
        int[] a = {1};
        InsertionSort s = new InsertionSort();
        s.sort(a);
        assertArrayEquals(new int[]{1}, a);
    }
    @Test
    void testDuplicates() {
        int[] a = {3,1,2,3,3,0};
        InsertionSort s = new InsertionSort();
        s.sort(a);
        assertArrayEquals(new int[]{0,1,2,3,3,3}, a);
    }
}
