/**
 * SortData.java
 *
 * COMP 2231 Assignment 1 Question 2
 * 
 * Class allows for determining the total comparisons completed for 
 * each sorting algorithm and the total execution time of each algorithm  
 */
package assignment_1b;

import java.time.Duration;
import java.time.Instant;

public class SortData
{
    private Instant startTime;//instant for start time
    private Instant endTime;//instant for end time
    
    private boolean isTimerRunning;//checks if timer is running
    private long comparisons;//comparisons recorded
    private int iterations;//number of iterations 
        
    public void startTimer()
    {//records current time as start time
        isTimerRunning = true;
	startTime = Instant.now();
    }//end startTimer
	
    public void stopTimer()
    {//records current time as stop time
        isTimerRunning = false;
        endTime = Instant.now();
    }//end stopTimer
    
    public void comparisons()
    {//comparisons are counted 
        comparisons++;
    }//end comparisons
    
    /**
     * Gets total number of comparisons
     * @return number of comparisons 
     */
    public long getNumberOfComparisons() 
    {
        return comparisons;
    }//end getNumberOfComparisons
	
    /**
     * Gets timer duration
     * @return duration of time executed 
     */
    public Duration getDurationTime()
    {
        if(isTimerRunning) 
        {//if stopTimer not called
            return Duration.between(startTime, Instant.now());//duration difference
	}//end if
        else
        {//if stopTimer called  
            return Duration.between(startTime, endTime);//duration difference
	}//end else
    }//end 

    /**
     * String representation of output     
     * @return number of comparisons and execution time
     */
//    @Override
    public String toString()
    {
        return "Number of Comparisons: " + comparisons + "\n" + 
               "Exectuion Time: " + getDurationTime().toMillis() + " milliseconds";
    }//end toString   
    
}//end SortDataProfile



    