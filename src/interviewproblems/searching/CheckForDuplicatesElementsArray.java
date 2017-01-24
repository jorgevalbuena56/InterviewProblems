/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n numbers, give an algorithm for checking whether there are any duplicate elements
 * 
 * in the array or not
 * 
 * @author George
 */
public class CheckForDuplicatesElementsArray {
    
    public static void main(String args[]){
        //int[] array = {3,2,1,2,2,3};
        int[] array = {3,2,1,5,4,5};
        
        CheckForDuplicatesElementsArray p = new CheckForDuplicatesElementsArray();
        System.out.println("IsDuplicated: " + p.checkDuplicates(array));
        System.out.println("IsDuplicated: " + p.checkDuplicatesNegationMethod(array));
    }
    
    /**
     * O(N) TIME AND O(N) SPACE
     * 
     * @param array
     * @return 
     */
    public boolean checkDuplicates(int[] array){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        
        for(i = 0; i < array.length;i++){
            map.put(array[i], 0);
        }
        
        for(i=0;i<array.length;i++){
            map.put(array[i], map.get(array[i]) + 1);
            if(map.get(array[i]) > 1){
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * Let us assume that the arrya elemetns are positive numbers and also all the elements in the range
     * 
     * 0 to n-1 where n is the length of the array.For each element arrya[i], go to the array element whose
     * 
     * index is arrya[i]. That means select array[array[i]] and mark - array[array[i]] (NEGATE the VALUE)
     * 
     * Continue this process until we encounter the element whose value is already negated. If one such
     * 
     * element exist then we say duplicate elements exist in the given array.
     * 
     * PROBLEMS WITH THE SOLUTION
     * 
     *   1) THIS SOLUTION DOES NOT WORK IF THE GIVEN ARRAY IS READ ONLY
     *   2) THIS SOLUTION WILL WORK ONLY IF ALL ARRAY ELEMENTS ARE POSITIVE
     *   3) IF THE ELEMENT RANGE IS NOT IN 0 TO N-1 THEN IT MAY GIVE EXCEPTIONS
     * 
     * O(N) TIME AND O(1) SPACE
     * 
     * @param array
     * @return 
     */
    public boolean checkDuplicatesNegationMethod(int[] array){
        for(int i=0; i < array.length; i++){
            if(array[Math.abs(array[i])] < 0){
                return true;
            }else{
                array[Math.abs(array[i])] = - array[Math.abs(array[i])];
            }
        }
        
        return false;
    }
}
