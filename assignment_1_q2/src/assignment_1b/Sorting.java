/**
 * Sorting.java
 *
 * COMP 2231 Assignment 1 Question 2
 * 
 * Modifying the sorts listed in Chapter 18 by adding code to 
 * each to tally the total number of comparisons and total 
 * execution time of each algorithm   
 */
package assignment_1b;

public class Sorting 
{
    /**
     * Sorts the specified array of integers using the selection
     * sort algorithm.
     *
     * @param <T>
     * @param data the array to be sorted
     * @return 
     */
    public static <T extends Comparable<T>> 
        SortData selectionSort(T[] data)
    {
        SortData set = new SortData();
        set.startTimer();
	
        int min;
   	T temp;

        for(int index = 0; index < data.length - 1; index++)
        {
            min = index;
            for(int scan = index + 1; scan < data.length; scan++)
            {
                set.comparisons();
                
                if(data[scan].compareTo(data[min]) < 0)
                    min = scan;
            }//end for
            swap(data, min, index);
        }//end for
	set.stopTimer();
        return set;	
    }//end selectionSort
         
    /**
     * Swaps to elements in an array. Used by various sorting algorithms.
     *
     * @param data the array in which the elements are swapped
     * @param index1 the index of the first element to be swapped
     * @param index2 the index of the second element to be swapped
     */    
    private static <T extends Comparable<T>> 
        void swap(T[] data, int index1, int index2)
    {
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }//end swap

    /**
     * Sorts the specified array of objects using an insertion
     * sort algorithm.
     *
     * @param <T>
     * @param data the array to be sorted
     * @return 
     */
    public static <T extends Comparable<T>> 
        SortData insertionSort(T[] data)
    {
	SortData set = new SortData();
	set.startTimer();

	for(int index = 1; index < data.length; index++)
        {
            T key = data[index];
            int position = index;

            set.comparisons();
            
            //shift larger values to the right
            while(position > 0 && data[position - 1].compareTo(key) > 0) 
            {
		data[position] = data[position - 1];
		position--;
            }//end while
            data[position] = key;
	}//end for
	set.stopTimer();
	return set;
    }//end insertionsort

    /**
     * Sorts the specified array of objects using a bubble sort
     * algorithm.
     * 
     * @param <T>
     * @param data the array to be sorted
     * @return 
     */    
    public static <T extends Comparable<T>> 
        SortData bubbleSort(T[] data)
    {
        SortData set = new SortData();
        set.startTimer();
        
        int position, scan;
        T temp;
	
        for(position = data.length - 1; position >= 0; position--)
        {
            for(scan = 0; scan <= position - 1; scan++)
            {
		set.comparisons();
                
                if(data[scan].compareTo(data[scan + 1]) > 0)
                    swap(data, scan, scan + 1);
            }//end for
	}//end for
	set.stopTimer();
	return set;
    }//end bubblesort

    /**
     * Sorts the specified array of objects using the quick sort algorithm.
     *
     * @param <T>
     * @param data the array to be sorted
     * @return 
     */        
    public static <T extends Comparable<T>> 
        SortData quickSort(T[] data) 
    {
	SortData set = new SortData();
	set.startTimer();
		
        quickSort(data, 0, data.length - 1, set);
	
        set.stopTimer();
	return set;
    }//end quickSort

    /**
     * Recursively sorts a range of objects in the specified array using the
     * quick sort algorithm.
     *
     * @param data the array to be sorted
     * @param min the minimum index in the range to be sorted
     * @param max the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>> 
        void quickSort(T[] data, int min, int max, SortData set)
    {
        set.comparisons();
        
        if(min < max) 
        {
            // create partitions
            int indexofpartition = partition(data, min, max, set);

            // sort the left partition (lower values)
            quickSort(data, min, indexofpartition - 1, set);

            // sort the right partition (higher values)
            quickSort(data, indexofpartition + 1, max, set);
        }//end if
    }//end quickSort

    /**
     * Used by the quick sort algorithm to find the partition.
     *
     * @param data the array to be sorted
     * @param min the minimum index in the range to be sorted
     * @param max the maximum index in the range to be sorted
     */
    private static <T extends Comparable<T>> 
        int partition(T[] data, int min, int max, SortData set) 
    {
	T partitionelement;
	int left, right;
	int middle = (min + max) / 2;

	// use the middle data value as the partition element
        partitionelement = data[middle];
	// move it out of the way for now
	swap(data, middle, min);

	left = min;
	right = max;

	while (left < right)
        {
            set.comparisons();
            
            // search for an element that is > the partition element
            while (left < right && data[left].compareTo(partitionelement) <= 0)
                left++;

            set.comparisons();
			
            // search for an element that is < the partition element
            while (data[right].compareTo(partitionelement) > 0)
                right--;

            // swap the elements
            if (left < right)
            swap(data, left, right);
	}//end while

	// move the partition element into place
	swap(data, min, right);

	return right;
    }//end partition
        
    /**
     * Sorts the specified array of objects using the merge sort
     * algorithm.
     *
     * @param <T>
     * @param data the array to be sorted
     * @return 
     */
    public static <T extends Comparable<T>> 
        SortData mergeSort(T[] data) 
    {
	SortData set = new SortData();
	set.startTimer();
	
        mergeSort(data, 0, data.length - 1, set);
	
        set.stopTimer();
	return set;
    }//end mergeSort

    /**
     * Recursively sorts a range of objects in the specified array using the
     * merge sort algorithm.
     *
     * @param data the array to be sorted
     * @param min the index of the first element
     * @param max the index of the last element
     */
    private static <T extends Comparable<T>> 
        void mergeSort(T[] data, int min, int max, SortData set)
    {
        set.comparisons();
        if (min < max)
        {
            int mid = (min + max) / 2;	
            mergeSort(data, min, mid, set);
            mergeSort(data, mid + 1, max, set);
            merge(data, min, mid, max, set);
        }//end if
    }//end mergeSort

    /**
     * Merges two sorted subarrays of the specified array.
     *
     * @param data the array to be sorted
     * @param first the beginning index of the first subarray
     * @param mid the ending index for the first subarray
     * @param last the ending index of the second subarray
     */	
    @SuppressWarnings("unchecked")
    private static <T extends Comparable<T>> 
        void merge(T[] data, int first, int mid, int last, SortData set) 
    {
	T[] temp = (T[])(new Comparable[data.length]);

	int first1 = first, last1 = mid; // endpoints of first subarray
	int first2 = mid + 1, last2 = last; // endpoints of second subarray
	int index = first1; // next index open in temp array

	// Copy smaller item from each subarray into temp until one
	// of the subarrays is exhausted
	while(first1 <= last1 && first2 <= last2) 
        {
            set.comparisons();
            
            if(data[first1].compareTo(data[first2]) < 0) 
            {
		temp[index] = data[first1];
                    first1++;
            }//end if
            else 
            {
                temp[index] = data[first2];
		first2++;
            }//end else
            index++;
        }//end while

	// Copy remaining elements from first subarray, if any
	while (first1 <= last1) 
        {
            temp[index] = data[first1];
            first1++;
            index++;
	}//end while

	// Copy remaining elements from second subarray, if any
	while (first2 <= last2) 
        {
            temp[index] = data[first2];
            first2++;
            index++;
	}//end while

	// Copy merged data into original array
	for (index = first; index <= last; index++)
            data[index] = temp[index];
    }//end merge   
        
}//end Sorting


