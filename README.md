# Algorithm Benchmarking Project

## 📌 Overview
This project implements and benchmarks **Insertion Sort** (Алдияр) and **Selection Sort** (Saltanat).  
The purpose is to:
- Compare theoretical and empirical performance of the algorithms.
- Collect metrics: execution time, comparisons, swaps, and array accesses.
- Validate correctness using tests and cross-validation with Java built-in sort.

## 🗂 Project Structure
```
src/
 └── main/java
     ├── algorithms/
     │   ├── InsertionSort.java
     │   └── SelectionSort.java
     ├── metrics/
     │   └── PerformanceTracker.java
     └── cli/
         └── BenchmarkRunner.java
 └── test/java
     ├── InsertionSortTest.java
     └── SelectionSortTest.java
docs/
 ├── performance-plots/
 └── performance_plots.png
performance_results.csv
README.md
pom.xml
```

## ⚙️ How to Run
### Requirements
- Java 17+
- Maven 3.9+

### Build & Run
```bash
# Clone repository
git clone <repo_url>
cd <repo_folder>

# Compile project
mvn clean compile

# Run benchmarks
mvn exec:java -Dexec.mainClass="cli.BenchmarkRunner"

# Run tests
mvn test
```

## 📊 Benchmarks
Results are saved into **performance_results.csv** with the following columns:
```
Algorithm,ArraySize,Distribution,Time(ns),Comparisons,Swaps,ArrayAccesses
```

Example:
```
InsertionSort,1000,random,3760000,254284,254287,509570
SelectionSort,1000,random,3771400,499500,992,1002968
```

## 🧪 Testing
- **Unit tests**: Validate correctness on edge cases (empty array, single element, duplicates, sorted, reverse-sorted).
- **Cross-validation**: Compare algorithm outputs with `Arrays.sort()` to ensure correctness.
- **Performance tests**: Run on inputs from 10² to 10⁵ elements, with random/sorted/reverse distributions.

## 📈 Empirical Results
- **Insertion Sort** performs better on small or nearly sorted arrays.
- **Selection Sort** performs consistently, but slower in sorted inputs due to unnecessary comparisons.
- Theoretical vs empirical analysis matches Big-O predictions:
  - Insertion Sort:  
    - Best: Ω(n)  
    - Average/Worst: Θ(n²)  
  - Selection Sort:  
    - Best/Average/Worst: Θ(n²)  

Plots are available in `docs/individual_report_selection.pdf`.

## ✅ Deliverables
- Working implementations of both algorithms.
- Benchmarking framework with CSV export.
- Empirical validation with plots and performance data.
- Detailed analysis report (PDF).
- Unit and integration tests.

---

👤 Authors:  
- **Алдияр** — InsertionSort implementation, analysis, benchmarks.  
- **Saltanat** — SelectionSort implementation, modifications to metrics & runner.
