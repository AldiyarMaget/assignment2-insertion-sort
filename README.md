# assignment2-insertion-sort

Student A implementation: **Insertion Sort** (Java, OpenJDK 23)

## What is included
- `src/main/java/algorithms/InsertionSort.java` - insertion sort implementation with STANDARD and BINARY modes and metrics hooks.
- `src/main/java/metrics/PerformanceTracker.java` - tracks comparisons, shifts, array accesses, allocations, time.
- `src/main/java/cli/BenchmarkRunner.java` - simple CLI to run benchmarks for different input types.
- `src/test/java/algorithms/InsertionSortTest.java` - JUnit 5 tests (empty, single, duplicates, binary mode).
- `docs/analysis-report.md` - theoretical analysis, experiment plan, and interpretation guide.
- `docs/performance-plots/` - sample plots (generated heuristically) and example CSV.
- `README.md` (this file) and `pom.xml`.

## Java / Build
Requires OpenJDK 23 (you specified: openjdk 23.0.1). Build with Maven:

```
mvn -v
mvn test
mvn package
```

Run benchmark example:
```
java -cp target/classes:target/test-classes assignment2-insertion-sort.jar cli.BenchmarkRunner --size 1000 --type random --mode standard --reps 3
```

(Or use `mvn exec:java` if you add the exec plugin.)

## CLI options
--size N
--type random|sorted|reverse|nearly
--mode standard|binary
--reps R
--seed S

## Branch strategy (suggested commands)
Create branches:
```
git checkout -b feature/algorithm
git add .
git commit -m "Add insertion sort implementation"
git checkout -b feature/metrics
git commit -m "Add performance tracker"
git checkout -b feature/testing
git commit -m "Add unit tests"
git checkout main
git merge --no-ff feature/algorithm
git tag v0.1
```

## Notes & Limitations
- This project contains the implementation and tests, but running JVM benchmarks in a repeatable way requires running the CLI on your machine (JVM warmup, stable CPUs).
- The tracker counts *logical* allocations (explicit `new` in code) and provides a heuristic for memory via runtime measurement (not implemented in tracker due to portability).
- I generated sample plots in docs/performance-plots/ to illustrate expected behavior (O(n^2) vs nearly-sorted improvement).

If you want, I can now:
- try to run Java benchmarks here (if JDK & Maven present),
- or produce a ready-to-submit zip of the repository (already prepared).
