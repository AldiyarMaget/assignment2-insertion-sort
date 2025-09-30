package algorithms;

/**
 * Instance-based InsertionSort compatible with partner's PerformanceTracker/BenchmarkRunner.
 * API expected by PerformanceTracker:
 *   InsertionSort insertionSort = new InsertionSort();
 *   insertionSort.sort(arr);
 *   insertionSort.getComparisons(), getSwaps(), getArrayAccesses()
 *
 * Metrics semantics:
 * - comparisons: number of key comparisons (a[j] > key checks)
 * - swaps: counted as element writes that move values (shifts + final insertion counted as a write)
 * - arrayAccesses: rough count of array reads+writes performed by algorithm
 */
public class InsertionSort {
    private int[] arr;
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;

    public InsertionSort() {}

    public void sort(int[] input) {
        if (input == null) return;
        this.arr = input;
        resetMetrics();
        if (arr.length <= 1) return;

        final int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            arrayAccesses++; // read arr[i]
            int j = i - 1;
            // shift elements greater than key
            while (j >= 0) {
                comparisons++; // compare a[j] and key
                arrayAccesses++; // read arr[j] for comparison
                if (arr[j] > key) {
                    // move arr[j] to arr[j+1]
                    arr[j + 1] = arr[j];
                    arrayAccesses += 1; // write arr[j+1] (arr[j] read already counted)
                    swaps++; // count this movement as a 'swap' (shift)
                    j--;
                } else {
                    break;
                }
            }
            // place key at its position
            arr[j + 1] = key;
            arrayAccesses++; // write arr[j+1]
            swaps++; // count insertion as a write
        }
    }

    public long getComparisons() {
        return comparisons;
    }

    public long getSwaps() {
        return swaps;
    }

    public long getArrayAccesses() {
        return arrayAccesses;
    }

    public void resetMetrics() {
        comparisons = 0;
        swaps = 0;
        arrayAccesses = 0;
    }
}
