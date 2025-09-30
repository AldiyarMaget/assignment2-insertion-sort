package metrics;
import algorithms.InsertionSort;
import algorithms.SelectionSort;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class PerformanceTracker {
    public static int[] generateRandomArray(int size) {
        Random random = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(10000);
        }
        return arr;
    }

    public static int[] generateSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static int[] generateReverseSortedArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
        }
        return arr;
    }

    public static void runBenchmarks() {
        int[] sizes = {100, 1000, 10000, 100000};
        String[] distributions = {"random", "sorted", "reverse_sorted"};
        try (FileWriter writer = new FileWriter("performance_results.csv")) {
            writer.write("Algorithm,ArraySize,Distribution,Time(ns),Comparisons,Swaps,ArrayAccesses\n");
            for (int size : sizes) {
                if (size > 10000) continue;
                for (String distribution : distributions) {
                    int[] arr = createArray(size, distribution);

                    int[] arrCopy = arr.clone();
                    InsertionSort insertionSort = new InsertionSort();
                    long startTime = System.nanoTime();
                    insertionSort.sort(arrCopy);
                    long endTime = System.nanoTime();
                    writer.write(String.format("\"InsertionSort,%d,%s,%d,%d,%d,%d\\n",
                            size, distribution, (endTime - startTime),
                            insertionSort.getComparisons(), insertionSort.getSwaps(),
                            insertionSort.getArrayAccesses()));

                    arrCopy = arr.clone();
                    SelectionSort selectionSort = new SelectionSort();
                    startTime = System.nanoTime();
                    selectionSort.sort(arrCopy);
                    endTime = System.nanoTime();

                    writer.write(String.format("SelectionSort,%d,%s,%d,%d,%d,%d\n",
                            size, distribution, (endTime - startTime),
                            selectionSort.getComparisons(), selectionSort.getSwaps(),
                            selectionSort.getArrayAccesses()));
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    private static int[] createArray(int size, String distribution) {
        switch (distribution) {
            case "sorted":
                return generateSortedArray(size);
            case "reverse_sorted":
                return generateReverseSortedArray(size);
            case "random":
            default:
                return generateRandomArray(size);
        }
    }
    public static void main(String[] args) {
        runBenchmarks();
        System.out.println("Benchmarks completed. Results saved to performance_results.csv");
    }
}
