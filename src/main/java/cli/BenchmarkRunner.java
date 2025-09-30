package cli;
import metrics.PerformanceTracker;
public class BenchmarkRunner {
    public static void main(String[] args) {
        System.out.println("Starting Algorithm Performance Benchmarks...");
        PerformanceTracker.runBenchmarks();
        System.out.println("Benchmarks completed successfully!");
        System.out.println("Check performance_results.csv for detailed metrics.");
    }
}