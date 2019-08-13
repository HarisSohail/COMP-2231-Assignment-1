/**
 * Driver.java
 *
 * COMP 2231 Assignment 1 Question 1
 * 
 * Prompts user to input size of array and will create 
 * and populate an array of random integers based on the 
 * size supplied to the constructor
 */
package assignment_1a;

import java.util.Arrays;
import java.util.Scanner;

public class ShellArrayDriver
{    
    /**
     * @param args the command line arguments
     */
    
    private static int size;
    private static int array[];
    
    public static void main(String args[])
    {
        System.out.println("---------------Shell Sort---------------");
        //prompts user to input a value which dicates array length 
        try(Scanner intReader = new Scanner(System.in)) 
        {
            System.out.print("Please Enter Size of Array Then Press <enter>: ");
            size = intReader.nextInt();
        }//end try
        
        array = new int[size];//number inputed is now arrays length 

        for(int i=0; i<size; i++)
        {//set of random numbers from 0 to 49 for each array element
            array[i] = (int)(Math.random()*50);
        }//end for
	
        //Displaying results       
        System.out.println("Array Before Sorting:"); 
        System.out.println(Arrays.toString(array));	    
        
        ShellArray test = new ShellArray();
        test.ShellSort(array, size);
        
        System.out.println("Array After Sorting:");
        System.out.println(Arrays.toString(array));
    }//end main
    
}//end ShellArrayDriver

