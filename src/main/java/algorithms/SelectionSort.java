package algorithms;

public class SelectionSort {
    private long comparisons = 0;
    private long swaps = 0;
    private long arrayAccesses = 0;

    public SelectionSort() {}

    public void sort(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        resetMetrics();
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                comparisons++;
                arrayAccesses += 2;
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
                arrayAccesses += 4;
                swaps++;
            }
        }
    }

    public long getComparisons() { return comparisons; }
    public long getSwaps() { return swaps; }
    public long getArrayAccesses() { return arrayAccesses; }
    public void resetMetrics() { comparisons = swaps = arrayAccesses = 0; }
}
