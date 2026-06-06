import java.util.Random;

public class SortingAlgorithmsTester {
	
	//--------------------------------------------------------
    // Summary: Entry point of the program to test all sorting algorithms.
    // It generates arrays of different types and sizes and tests each sorting algorithm.
    //--------------------------------------------------------
    public static void main(String[] args) {
        int[] sizes = {100, 1000, 5000, 10000}; // Array sizes to test
        boolean orderFlag = false; // false for ascending, true for descending
        int repetitions = 5; // Number of runs to take median time

        for (int size : sizes) {
            Integer[] ascendingArray = generateAscendingArray(size);
            Integer[] descendingArray = generateDescendingArray(size);
            Integer[] randomArray = generateRandomArray(size);

            testSortingAlgorithm("Insertion Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
            testSortingAlgorithm("Selection Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
            testSortingAlgorithm("Shell Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
            testSortingAlgorithm("Merge Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
            testSortingAlgorithm("Quick Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
            testSortingAlgorithm("Bucket Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
            testSortingAlgorithm("Custom Sort", ascendingArray, descendingArray, randomArray, repetitions, orderFlag);
        }
    }

    //--------------------------------------------------------
    // Summary: Tests a specific sorting algorithm with all array types and prints runtime.
    // Precondition: Arrays should be initialized. Algorithm name must match the switch-case.
    // Postcondition: Prints runtime for ascending, descending, and random arrays.
    //--------------------------------------------------------
    private static void testSortingAlgorithm(String algorithm, Integer[] asc, Integer[] desc, Integer[] rand, int repetitions, boolean orderFlag) {
        System.out.println("Testing " + algorithm);
        
        long ascTime = getMedianTime(algorithm, asc.clone(), repetitions, orderFlag);
        long descTime = getMedianTime(algorithm, desc.clone(), repetitions, orderFlag);
        long randTime = getMedianTime(algorithm, rand.clone(), repetitions, orderFlag);
        
        System.out.println(algorithm + " (Ascending): " + ascTime + " ms");
        System.out.println(algorithm + " (Descending): " + descTime + " ms");
        System.out.println(algorithm + " (Random): " + randTime + " ms");
        System.out.println();
    }
    
    //--------------------------------------------------------
    // Summary: Measures the median runtime of a sorting algorithm over multiple runs.
    // Precondition: Algorithm name must match one in the switch statement.
    // Postcondition: Returns the median runtime in milliseconds.
    //--------------------------------------------------------
    private static long getMedianTime(String algorithm, Integer[] array, int repetitions, boolean orderFlag) {
        long[] times = new long[repetitions];
        int[] comparisons = new int[1];
        int[] swaps = new int[1];
        
        for (int i = 0; i < repetitions; i++) {
            Integer[] copy = array.clone();
            long start = System.currentTimeMillis();
            
            switch (algorithm) {
                case "Insertion Sort": SortingAlgorithms.insertionSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
                case "Selection Sort": SortingAlgorithms.selectionSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
                case "Shell Sort": SortingAlgorithms.shellSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
                case "Merge Sort": SortingAlgorithms.mergeSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
                case "Quick Sort": SortingAlgorithms.quickSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
                case "Bucket Sort": SortingAlgorithms.bucketSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
                case "Custom Sort": SortingAlgorithms.yourOwnCustomSort(copy, 0, copy.length - 1, comparisons, swaps, orderFlag); break;
            }
            
            long end = System.currentTimeMillis();
            times[i] = end - start;
        }
        
        return getMedian(times);
    }
    
    //--------------------------------------------------------
    // Summary: Returns the median value from an array of longs.
    // Precondition: Array must be filled with valid long values.
    // Postcondition: Returns the middle element after sorting.
    //--------------------------------------------------------
    private static long getMedian(long[] times) {
        java.util.Arrays.sort(times);
        return times[times.length / 2];
    }
    
    //--------------------------------------------------------
    // Summary: Generates an ascending array of integers from 0 to size - 1.
    //--------------------------------------------------------
    private static Integer[] generateAscendingArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }
    
    //--------------------------------------------------------
    // Summary: Generates a descending array of integers from size to 1.
    //--------------------------------------------------------
    private static Integer[] generateDescendingArray(int size) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = size - i;
        }
        return array;
    }
    
    //--------------------------------------------------------
    // Summary: Generates an array of random integers.
    //--------------------------------------------------------
    private static Integer[] generateRandomArray(int size) {
        Integer[] array = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size * 10);
        }
        return array;
    }
}
