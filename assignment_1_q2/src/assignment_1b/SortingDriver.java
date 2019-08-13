/**
 * SortingDriver.java
 *
 * COMP 2231 Assignment 1 Question 2
 * 
 * Driver tallies the total number of comparisons   
 * and the total execution time of each sort algorithm
 * through three different problems:
 * Random Arrays, Sorted Arrays and Sorted Arrays in Reverse
 */
package assignment_1b;

import java.util.Random;

public class SortingDriver
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
	int iterations = 15,//number of iterations 
            base = 15,//base value for array size
            exponent = 3;//exponent for increasing array size for each iteration
        
	for(int i=0; i<exponent; i++)
        {//each exponent
            int size = (int)Math.pow(base, i+1);//size of array changes from exponent
            System.out.println("-----------OUTPUTS FOR EACH SORT-------------");
            for(int j=0; j<iterations; j++)
            {//outputting data of each sort for the set number of iterations 
                System.out.println("=============================================");
		System.out.println("================RANDOM ARRAY================="); 
                System.out.println("Set: " + (j+1));//iterations
                System.out.println("Size of Array: " + size);
                System.out.println("=============================================");

		Integer[] randomArray = RandomArray(size);//creating random array
				
		SortData randomSelectionSortResult = Sorting.selectionSort(randomArray);//accesses required sort and retrieves data
		System.out.println("---------------Selection Sort----------------");
                System.out.println(randomSelectionSortResult);
                System.out.println("---------------------------------------------");
                
		SortData randomInsertionSortResult = Sorting.insertionSort(randomArray);
		System.out.println("---------------Insertion Sort----------------");
                System.out.println(randomInsertionSortResult);
                System.out.println("---------------------------------------------");
		
                SortData randomBubbleSortResult = Sorting.bubbleSort(randomArray);
		System.out.println("----------------Bubble Sort------------------");
                System.out.println(randomBubbleSortResult);
                System.out.println("---------------------------------------------");
		
                SortData randomQuickSortResult = Sorting.quickSort(randomArray);
		System.out.println("------------------Quick Sort-----------------");
                System.out.println(randomQuickSortResult);
                System.out.println("---------------------------------------------");
		
                SortData randomMergeSortResult = Sorting.mergeSort(randomArray);
		System.out.println("-----------------Merge Sort------------------");
                System.out.println(randomMergeSortResult);
                System.out.println("---------------------------------------------");
            
		System.out.println("=============================================");
		System.out.println("================SORTED ARRAY================="); 
                System.out.println("Set: " + (j+1));
                System.out.println("Size of Array: " + size);
                System.out.println("=============================================");

		Integer[] sortedArray = SortedArray(size);//creating sorted array
		
                SortData orderedSelectionSortResult = Sorting.selectionSort(sortedArray);
		System.out.println("---------------Selection Sort----------------");
                System.out.println(orderedSelectionSortResult);
                System.out.println("---------------------------------------------");
	        
                SortData orderedInsertionSortResult = Sorting.insertionSort(sortedArray);
		System.out.println("---------------Insertion Sort----------------");
                System.out.println(orderedInsertionSortResult);
                System.out.println("---------------------------------------------");
		
                SortData orderedBubbleSortResult = Sorting.bubbleSort(sortedArray);
		System.out.println("----------------Bubble Sort------------------");
                System.out.println(orderedBubbleSortResult);
                System.out.println("---------------------------------------------");
		
                SortData orderedQuickSortResult = Sorting.quickSort(sortedArray);
		System.out.println("------------------Quick Sort-----------------");
                System.out.println(orderedQuickSortResult);
                System.out.println("---------------------------------------------");
                
                SortData orderedMergeSortResult = Sorting.mergeSort(sortedArray);
		System.out.println("-----------------Merge Sort------------------");
                System.out.println(orderedMergeSortResult);
		System.out.println("---------------------------------------------");        
         
		System.out.println("=============================================");
		System.out.println("===========SORTED ARRAY IN REVERSE===========");
                System.out.println("Set: " + (j+1));
                System.out.println("Size of Array: " + size);
                System.out.println("=============================================");

		Integer[] reversedsortedArray = ReversedSortedArray(size);//creating sorted array in reverse

		SortData reversedSortedSelectionSortResult = Sorting.selectionSort(reversedsortedArray); 
		System.out.println("---------------Selection Sort----------------");
                System.out.println(reversedSortedSelectionSortResult);
                System.out.println("---------------------------------------------");
		
                SortData reversedSortedInsertionSortResult = Sorting.insertionSort(reversedsortedArray);
		System.out.println("---------------Insertion Sort----------------");
                System.out.println(reversedSortedInsertionSortResult);
                System.out.println("---------------------------------------------");
		
                SortData reversedSortedBubbleSortResult = Sorting.bubbleSort(reversedsortedArray);
		System.out.println("----------------Bubble Sort------------------");
                System.out.println(reversedSortedBubbleSortResult);
                System.out.println("---------------------------------------------");
		
                SortData reversedSortedQuickSortResult = Sorting.quickSort(reversedsortedArray);
		System.out.println("------------------Quick Sort-----------------");
                System.out.println(reversedSortedQuickSortResult);
                System.out.println("---------------------------------------------");
	
                SortData reversedSortedMergeSortResult = Sorting.mergeSort(reversedsortedArray);
		System.out.println("-----------------Merge Sort------------------");
                System.out.println(reversedSortedMergeSortResult);		
                System.out.println("---------------------------------------------");
            }//end for
        }//end for
    }//end main

    //Allowing for creation of different array types which are required
    private static Integer[] RandomArray(int size)
    {
        Integer[] array = new Integer[size];

        Random range = new Random();//random number generator

        for(int i=0; i<size; i++)
        {
        array[i] = range.nextInt(size*10) + 1;
        }//end for
        
        return array;
    }//end RandomArray 

    private static Integer[] SortedArray(int size)
    {
        Integer[] array = new Integer[size];
		
	for(int i=0; i<size; i++)
        {
        array[i] = i*2;
	}//end for
        return array;
    }//end SortedArray

    private static Integer[] ReversedSortedArray(int size)
    {
        Integer[] array = new Integer[size];
            
        for(int i=(size - 1); i>=0; i--)
        {
        array[(size-1)-i] = i*2;
        }//end for
        return array;
    }//end ReversedSortedArray
    
}//end SortingDriver
