/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 * Find the number ocurring odd Number of Times. 
 * 
 * given an array of positive integers, all numbers occurs even number of times except one number which occurs
 * 
 * odd number of times. find the number in O(N) times & constant space. Example: {1,2,3,2,3,1,3} = 3
 * @author GeorgeLocal
 */
public class CheckNumberOccuringOddTimes {
    
    public static void main(String args[]){
        CheckNumberOccuringOddTimes p = new CheckNumberOccuringOddTimes();
        int[] array = {1,2,3,2,1,1,3};
        System.out.println("OddNumber of times: " + p.findOddNumberTimes(array));
    }
    
    /**
     * Do a bitwise XOR of all the elements. We get the number which have odd ocurrences.
     * 
     * This is because A XOR A = 0;
     * 
     * @param array
     * @return 
     */
    public int findOddNumberTimes(int[] array){
        int oddNumber = array[0];
        
        for(int i=1;i<array.length;i++){
            oddNumber^=array[i];
        }
        
        return oddNumber;
    }
}
