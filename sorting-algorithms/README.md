# Sorting Algorithms Benchmark

A Java implementation and comparison of multiple classic sorting algorithms, with performance tracking.

## Algorithms Implemented
- Insertion Sort
- Merge Sort
- Quick Sort

## Features
- Generic implementation using Java Comparables (`<T extends Comparable<T>>`)
- Tracks number of comparisons and swaps per sort
- Supports both ascending and descending order via `orderFlag`
- Includes a tester class for benchmarking

## Concepts Demonstrated
- Generic programming
- Algorithm analysis (comparisons & swaps tracking)
- Divide and conquer (Merge Sort, Quick Sort)

## How to Run
```
javac src/*.java -d bin/
java -cp bin SortingAlgorithmsTester
```
