/**
 * ShellArray.java
 *
 * COMP 2231 Assignment 1 Question 1
 * 
 * Allows for an array to be populated by random integers 
 * based on a size supplied to the constructor
 * and computes Shell sort method
 */
package assignment_1a;

import java.util.Arrays;

public class ShellArray 
{
    /**
     * Sorts the specified array of objects using 
     * the Shell Sort algorithm.
     * 
     * @param array
     * @param size
     */
    public void ShellSort(int array[], int size)
    {        
        System.out.println("Array Being Sorted: ");
        int gap = size/2;
    	while(gap > 0)
        { 
            boolean swapflag = true;
            while(swapflag == true) 
            {
                swapflag = false;
		for(int i=0; i<(size-gap); i++)
                {
                    if(array[i] > array[i+gap])
                    {
                        swap(array, i, i+gap);
                        swapflag = true;
                    }//end if
		}//end for
            }//end while
            gap = gap/2;
            //outputs the results of each swap completed
            System.out.println(Arrays.toString(array));
        }//end while
    }//end ShellSort

    /**
     * Swaps to elements in an array. Used by various sorting algorithms.
     */
    private void swap(int array[], int index1, int index2)
    {
	int temp = array[index1];
	array[index1] = array[index2];
	array[index2] = temp;
    }//end swap
    
}//end ShellSort Class
