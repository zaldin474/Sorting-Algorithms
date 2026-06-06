//----------------------------------------------------- 
// Title: SortingAlgorithms Class
// Author: ZEINEDDIN K A ZIDAN
// ID:99621968516
// Section: 01
// Assignment: 02
// Description: This class implements multiple sorting algorithms.
//----------------------------------------------------- 
public class SortingAlgorithms {
    
    // Insertion Sort
    public static <T extends Comparable<T>> void insertionSort(T[] array, int lowIndex, int highIndex, int[] comparisons, int[] swaps, boolean orderFlag) {
    	for (int i = lowIndex + 1; i <= highIndex; i++) {
    		
    		T key = array[i];
    		int j = i - 1;
    		
    		//ternary operator working as an if else statement. 
    		//if orderFlag is true, use descending order array array[j].compareTo(key)) < 0
    		//if orderFlag is false, use ascending order array array[j].compareTo(key) > 0
    			while ( j >= lowIndex && (orderFlag ? array[j].compareTo(key) < 0 : array[j].compareTo(key) > 0) ){
    				
    				array[j+1] = array[j];
    				comparisons[0]++;
    				swaps[0]++;
    				j--;
    			}
    			array[j+1] = key;
    			swaps[0]++;
    	}
    	
    }
    
    // Selection Sort
    public static <T extends Comparable<T>> void selectionSort(T[] array, int lowIndex, int highIndex, int[] comparisons, int[] swaps, boolean orderFlag) {
    	for(int i = lowIndex; i < highIndex; i++) {
    		
    		int selected = i;
    			
    		for(int j = i+1; j <= highIndex;j++) {
    			
    		comparisons[0]++;
    		
    		if(orderFlag ? array[j].compareTo(array[selected]) > 0 : array[j].compareTo(array[selected]) < 0) {
    			selected = j; 	}
    		
    			}
    		
    		if (selected != i ) {
    			T temp = array[i];
    			array[i] = array[selected];
    			array[selected] = temp;
    			swaps[0]++;
    		}
    		
    	}
    	
    }
    
    // Shell Sort
    public static <T extends Comparable<T>> void shellSort(T[] array, int lowIndex, int highIndex, int[] comparisons, int[] swaps, boolean orderFlag) {
    	 int gap = (highIndex - lowIndex)/2;
    	 
    	 while (gap > 0) {
    		 
    		 for (int i = lowIndex + gap; i <= highIndex; i++) {
    			 T temp = array[i];
    			 int j = i;
    			 
    			 while (j >= lowIndex + gap && (orderFlag ? array[j - gap].compareTo(temp) < 0 : array[j- gap].compareTo(temp) > 0 ) ) {
    				 array[j] = array[j-gap];
    				 comparisons[0]++;
    				 swaps[0]++;
    				 j -= gap;
    			 }
    			 array[j] = temp;
    			 swaps[0]++;
    		 }
    		 gap /= 2;
    	 }
    }
    
    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] array, int lowIndex, int highIndex, int[] comparisons, int[] swaps, boolean orderFlag) {
    	if (lowIndex < highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            mergeSort(array, lowIndex, mid, comparisons, swaps, orderFlag);
            mergeSort(array, mid + 1, highIndex, comparisons, swaps, orderFlag);
            merge(array, lowIndex, mid, highIndex, comparisons, swaps, orderFlag);
        }
    	}
    
    		private static <T extends Comparable<T>> void merge(T[] array, int low, int mid, int high, int[] comparisons, int[] swaps, boolean orderFlag) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;
        T[] left = (T[]) new Comparable[leftSize];
        T[] right = (T[]) new Comparable[rightSize];
        System.arraycopy(array, low, left, 0, leftSize);
        System.arraycopy(array, mid + 1, right, 0, rightSize);
        int i = 0, j = 0, k = low;
        while (i < leftSize && j < rightSize) {
            comparisons[0]++;
            if (orderFlag ? left[i].compareTo(right[j]) > 0 : left[i].compareTo(right[j]) < 0) {
                array[k++] = left[i++];
            } else {
                array[k++] = right[j++];
            }
            swaps[0]++;
        }
        while (i < leftSize) {
            array[k++] = left[i++];
            swaps[0]++;
        }
        while (j < rightSize) {
            array[k++] = right[j++];
            swaps[0]++;
        }
    }
    		
    		//quick sort 
    		public static <T extends Comparable<T>> void quickSort(T[] array, int low, int high, int[] comparisons, int[] swaps, boolean orderFlag) {
    		    while (low < high) {  // Tail recursion elimination
    		        // Median-of-three pivot selection
    		        int pivotIndex = medianOfThree(array, low, high, comparisons);
    		        T pivot = array[pivotIndex];

    		        // Partition the array
    		        int partitionIndex = partition(array, low, high, pivot, comparisons, swaps, orderFlag);

    		        // Recur on the smaller partition first to optimize recursion depth
    		        if (partitionIndex - low < high - partitionIndex) {
    		            quickSort(array, low, partitionIndex - 1, comparisons, swaps, orderFlag);
    		            low = partitionIndex + 1;  // Tail call elimination
    		        } else {
    		            quickSort(array, partitionIndex + 1, high, comparisons, swaps, orderFlag);
    		            high = partitionIndex - 1;  // Tail call elimination
    		        }
    		    }
    		}

    		// Median-of-three pivot selection
    		private static <T extends Comparable<T>> int medianOfThree(T[] array, int low, int high, int[] comparisons) {
    		    int mid = low + (high - low) / 2;

    		    comparisons[0] += 2;
    		    if (array[mid].compareTo(array[low]) < 0) {
    		        swap(array, mid, low);
    		    }
    		    comparisons[0] += 2;
    		    if (array[high].compareTo(array[mid]) < 0) {
    		        swap(array, high, mid);
    		    }
    		    comparisons[0] += 2;
    		    if (array[mid].compareTo(array[low]) < 0) {
    		        swap(array, mid, low);
    		    }

    		    return mid;  // Return index of median value
    		}

    		
    		// Swap method
    		private static <T> void swap(T[] array, int i, int j) {
    		    T temp = array[i];
    		    array[i] = array[j];
    		    array[j] = temp;
    		}

    		
    		
   
    		//Bucket sort
    		public static <T extends Comparable<T>> void bucketSort(T[] array, int lowIndex, int highIndex, int[] comparisons, int[] swaps, boolean orderFlag) {
    		    if (highIndex <= lowIndex) return;

    		    // Find min and max values in the array
    		    T minValue = array[lowIndex];
    		    T maxValue = array[lowIndex];
    		    for (int i = lowIndex + 1; i <= highIndex; i++) {
    		        comparisons[0]++;
    		        if (array[i].compareTo(minValue) < 0) {
    		            minValue = array[i];
    		        }
    		        comparisons[0]++;
    		        if (array[i].compareTo(maxValue) > 0) {
    		            maxValue = array[i];
    		        }
    		    }

    		    // Create buckets (linked list array)
    		    int bucketCount = highIndex - lowIndex + 1;
    		    Node<T>[] buckets = (Node<T>[]) new Node[bucketCount];

    		    // Distribute elements into buckets
    		    for (int i = lowIndex; i <= highIndex; i++) {
    		        int bucketIndex = (array[i].compareTo(minValue) * (bucketCount - 1)) / (maxValue.compareTo(minValue));
    		        if (bucketIndex >= bucketCount) {
    		            bucketIndex = bucketCount - 1;
    		        }

    		        // Insert into linked list bucket
    		        buckets[bucketIndex] = insertSorted(buckets[bucketIndex], array[i], comparisons, swaps, orderFlag);
    		    }

    		    // Merge buckets back into the original array
    		    int index = lowIndex;
    		    for (Node<T> bucket : buckets) {
    		        while (bucket != null) {
    		            array[index++] = bucket.value;
    		            bucket = bucket.next;
    		        }
    		    }
    		}

    		// Linked List Node for Buckets
    		private static class Node<T> {
    		    T value;
    		    Node<T> next;
    		    Node(T value) { this.value = value; }
    		}

    		// Insert in sorted order into linked list bucket
    		private static <T extends Comparable<T>> Node<T> insertSorted(Node<T> head, T value, int[] comparisons, int[] swaps, boolean orderFlag) {
    		    Node<T> newNode = new Node<>(value);
    		    
    		    if (head == null || (orderFlag ? value.compareTo(head.value) > 0 : value.compareTo(head.value) < 0)) {
    		        newNode.next = head;
    		        return newNode;
    		    }
    		    
    		    Node<T> current = head;
    		    while (current.next != null && (orderFlag ? current.next.value.compareTo(value) > 0 : current.next.value.compareTo(value) < 0)) {
    		        comparisons[0]++;
    		        current = current.next;
    		    }
    		    
    		    newNode.next = current.next;
    		    current.next = newNode;
    		    swaps[0]++;
    		    return head;
    		}

    
    
    
    
    // Custom Sort (Improved Hybrid QuickSort with Median-of-Three & Insertion Sort)
public static <T extends Comparable<T>> void yourOwnCustomSort(T[] array, int lowIndex, int highIndex, int[] comparisons, int[] swaps, boolean orderFlag) {
    // Use insertion sort for small partitions
    if (highIndex - lowIndex <= 5) {
        insertionSort(array, lowIndex, highIndex, comparisons, swaps, orderFlag);
        return;
    }

    // Choose pivot using median-of-three
    int pivotIndex = medianOfThree(array, lowIndex, highIndex, comparisons, swaps);
    T pivot = array[pivotIndex];

    // Move pivot to the end before partitioning
    swap(array, pivotIndex, highIndex, swaps);

    // Partitioning
    int partitionIndex = partition(array, lowIndex, highIndex, pivot, comparisons, swaps, orderFlag);

    // Recursively sort partitions
    yourOwnCustomSort(array, lowIndex, partitionIndex - 1, comparisons, swaps, orderFlag);
    yourOwnCustomSort(array, partitionIndex + 1, highIndex, comparisons, swaps, orderFlag);
}

//Median-of-Three Pivot Selection
//--------------------------------------------------------
//Summary: Selects the median value among the first, middle, and last elements
//        to use as a pivot for partitioning in QuickSort.
//Precondition: array is non-empty and indices are within bounds.
//Postcondition: Ensures median value is chosen as pivot and partially sorted.
//--------------------------------------------------------
private static <T extends Comparable<T>> int medianOfThree(T[] array, int low, int high, int[] comparisons, int[] swaps) {
    int mid = low + (high - low) / 2;

    if (array[mid].compareTo(array[low]) < 0) {
        swap(array, low, mid, swaps);
    }
    if (array[high].compareTo(array[low]) < 0) {
        swap(array, low, high, swaps);
    }
    if (array[high].compareTo(array[mid]) < 0) {
        swap(array, mid, high, swaps);
    }

    return mid; // Return the median element index
}

//Partitioning Method
//--------------------------------------------------------
//Summary: Partitions the array based on the pivot.
//Precondition: Pivot must be passed explicitly; array must be valid.
//Postcondition: Returns the index where pivot ends up. Left side contains smaller
//             elements (based on orderFlag), right side contains larger ones.
//--------------------------------------------------------
private static <T extends Comparable<T>> int partition(T[] array, int low, int high, T pivot, int[] comparisons, int[] swaps, boolean orderFlag) {
    int i = low, j = high - 1;

    while (true) {
        while (i < high && (orderFlag ? array[i].compareTo(pivot) > 0 : array[i].compareTo(pivot) < 0)) {
            comparisons[0]++;
            i++;
        }
        while (j > low && (orderFlag ? array[j].compareTo(pivot) < 0 : array[j].compareTo(pivot) > 0)) {
            comparisons[0]++;
            j--;
        }
        if (i >= j) break;

        swap(array, i, j, swaps);
        i++;
        j--;
    }

    // Move pivot to correct position
    swap(array, i, high, swaps);
    return i;
}

//Swap Utility
//--------------------------------------------------------
//Summary: Swaps two elements in the array and increments the swap counter.
//Precondition: Indices i and j must be within array bounds.
//Postcondition: Elements at i and j are exchanged.
//--------------------------------------------------------
private static <T> void swap(T[] array, int i, int j, int[] swaps) {
    T temp = array[i];
    array[i] = array[j];
    array[j] = temp;
    swaps[0]++;
}

    
}

