package algorithms;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SelectionSortTest {
    @Test
    void testEmpty() {
        int[] a = {};
        SelectionSort s = new SelectionSort();
        s.sort(a);
        assertArrayEquals(new int[]{}, a);
    }
    @Test
    void testSingle() {
        int[] a = {1};
        SelectionSort s = new SelectionSort();
        s.sort(a);
        assertArrayEquals(new int[]{1}, a);
    }
    @Test
    void testDuplicates() {
        int[] a = {3,1,2,3,3,0};
        SelectionSort s = new SelectionSort();
        s.sort(a);
        assertArrayEquals(new int[]{0,1,2,3,3,3}, a);
    }
}
