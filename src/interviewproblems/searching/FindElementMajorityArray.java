/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * An element is a majority if it appears  more then n/2 times. Give an algorithm that takes an array 
 * 
 * of n elements as argument and identifies a mejority (if it exist)
 * 
 * @author George
 */
public class FindElementMajorityArray {
   
    public static void main(String args[]){
        int[] array = {4,2,4,4,41,1,1,4,3,};
        System.out.println("Majority Element: " + FindElementMajorityArray.majorityNumOrder(array));
    }
    
    /**
     * Keep track of the number of times an element appear in a hasTable. Then compare is the counter
     * 
     * is greater than n/2 and return that element
     * 
     * @param array
     * @return 
     */
    public static int majorityNum(int[] array){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        int max = array.length /2;
        
        for(int i = 0; i<array.length;i++){
            if(map.containsKey(array[i])){
                int count = map.get(array[i]);
                count++;
                if(count > max){
                    return array[i];
                }                
                map.put(array[i], count);
            }else{
                map.put(array[i], 1);
            }                
        }
        
        return -1;
    }
    
    /**
     * In this solution we sort first then we find the number of times an element repeated and we keep
     * 
     * track of that with a counter.
     * 
     * @param array
     * @return 
     */
    public static int majorityNumOrder(int[] array){

        // O (n log n)
        Arrays.sort(array);
        
        int majNum;
        int count = 0;
        int element = -1;
        
        for(int i=0;i < array.length;i++){

            //if counter is 0 then set the current csndidate to majority num and set the number counter
            // to 1
            if(count == 0){
                element = array[i];
                count  = 1;
            }else if(element == array[i]){
                //Increment the counter, element is the same as the current candidate
                count++;
            }else{
                //Decrement counter and element is different from current candidate
                count--;
            }
        }
        
        return element;
    }
}
