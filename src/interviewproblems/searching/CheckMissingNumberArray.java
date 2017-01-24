/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.HashMap;
import java.util.Map;

/**
 * We are given a list of n - 1 integers and these integers are in the range 1 to n.
 * 
 * There are no duplicates in the array. One of the integers is missing in the list.
 * 
 * Give an algorithm to find the missing integer. Example: {1,2,4,6,3,7,8} = Missing 5
 * 
 * @author George
 */
public class CheckMissingNumberArray {
    
    public static void main(String args[]){
        CheckMissingNumberArray p = new CheckMissingNumberArray();
        int[] array = {1,2,4,6,3,7,5,9};
        System.out.println("Missing Value: " + p.missingNumberWithXOR(array));
    }
    
    /**
     * O(N) Time and O(N) space
     * @param array
     * @return 
     */
    public int findMissingNumber(int[] array){
                      
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        
        for(i = 1; i < array.length + 1;i++){
            map.put(i, 0);
        }
        
        for(i = 0; i< array.length;i++){
            if(map.get(array[i]) != null)
               map.put(array[i], map.get(array[i]) + 1);
        }
        
        for(i = 1; i<array.length + 1;i++){
            if(map.get(i) == 0){
                return i;
            }
        }
        
        return -1;
    }
    
    /**
     * Using sumation formula:
     *  1) Give the sum of numbers = n * (n + 1)/2
     *  2) Substract all numbers from sum and you will get the missing number
     * 
     *  O(N) time
     * 
     * PROBLEMS
     *   if the sum is bigger than a int can hold, we will get overflow and not a correct answer
     * 
     * @param array
     * @return 
     */
    public int missingNumberWithSumation(int[] array){
       //we need to increase the length one mre because that's the missing one
       int sum = ((array.length + 1)  * (array.length + 2)) / 2;
       
       for(int i=0; i<array.length;i++){
           sum -= array[i];
       }
       
       if (sum > 0)
          return sum;
       else 
           return -1;
    }
    
    /**
     * 1) XOR all the array elements, let the result of XOR be X
     * 2) XOR all numbers from 1 to n, let XOR be Y
     * 3) XOR of X and Y gives the missing number
     * 
     * O(N)
     * @param array
     * @return 
     */
    public int missingNumberWithXOR(int[] array){
       int i;
       int X = 0;
       int Y = 0, n;
       
       n = array.length;
       
       for(i=0;i < n;i++){
           X^= array[i];
       }
       for(i = 1; i<= n+1;i++){
           Y^=i;
       }
       
       return X^Y;
    }
}
