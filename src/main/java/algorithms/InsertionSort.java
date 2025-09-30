package algorithms;

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
            while (j >= 0) {
                comparisons++; // compare a[j] and key
                arrayAccesses++; // read arr[j] for comparison
                if (arr[j] > key) {
                    arr[j + 1] = arr[j];
                    arrayAccesses += 1; // write arr[j+1]
                    swaps++; // shift counted as a swap
                    j--;
                } else {
                    break;
                }
            }
            arr[j + 1] = key;
            arrayAccesses++; // write arr[j+1]
            swaps++; // insertion counted as write
        }
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public void resetMetrics() { comparisons = swaps = arrayAccesses = 0; }
}
