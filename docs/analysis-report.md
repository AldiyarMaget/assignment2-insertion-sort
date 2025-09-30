# Analysis Report (draft)

## 1. Task and goals
Implement and analyze Insertion Sort (Student A). Provide theoretical complexity and empirical verification, with metrics and a clean git workflow.

## 2. Algorithm overview
### Insertion Sort (STANDARD)
- Best case: O(n) when array already sorted (only n-1 comparisons and no shifts).
- Average case: Θ(n^2) comparisons and shifts for random data.
- Worst case: O(n^2) comparisons and shifts (reverse sorted).

### Insertion Sort (BINARY)
- Uses binary search to find the insertion position -> reduces comparisons to O(n log n) in number of comparisons.
- Shifts (element movements) still Θ(n^2) in worst/average case because we must move elements to make room.

## 3. Metrics collected
- comparisons — number of key comparisons
- shifts — number of element moves (writes)
- arrayAccesses — total logical array reads/writes counted in code
- allocations — explicit new[] allocations performed by algorithm (0 for our in-place implementations)
- time (ms) — elapsed wall-clock time measured by System.nanoTime()

## 4. Experiment plan
Run benchmarks for input sizes: 250, 500, 1000, 2000, 4000, 8000 (adjust as needed).
For each size and input type (random, sorted, reverse, nearly) do R repetitions (e.g., 5) and record metrics.
Plot:
- time vs n (log-log and linear)
- comparisons vs n
- shifts vs n
- compare STANDARD vs BINARY modes and show effect on nearly-sorted arrays.

Notes about JVM benchmarking:
- Use a warm-up phase (several runs) to account for JIT compilation.
- Run each measurement multiple times and take median.

## 5. Interpretation guide
- Expect time and shifts to follow n^2 growth for random data.
- For nearly-sorted arrays, STANDARD insertion sort should be significantly faster (close to linear).
- BINARY mode should reduce comparisons but shifts remain.

## 6. Recommendations & optimizations
- For larger arrays, switch to O(n log n) sorts (MergeSort, TimSort, QuickSort).
- Use insertion sort as a base-case optimizer inside divide-and-conquer sorts for small subarrays (typical threshold 16–32).

## 7. What I did
- Implemented insertion sort with metrics hooks and a CLI runner.
- Added unit tests and project skeleton for Maven.
- Generated sample plots (in docs/performance-plots/) illustrating expected curves.

## 8. Next steps
- When you (student) provide partner's Selection Sort implementation and test criteria, I'll run pair-exchange tests: run SelectionSort implementation and analyze both, then merge reports and produce final PDF.
