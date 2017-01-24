/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of n numbers, give an algorithm for finding the first element in the array which is 
 * 
 * repeated. For example, in the array, A = {3,2,1,2,2,3} the first repeated number is 3 (not 2). That
 * 
 * means, we need to return the first element among the repeated elements.
 * 
 * @author George
 */
public class CheckFirstElementRepeatedArray {
    
    public static void main(String args[]){
        
        CheckFirstElementRepeatedArray p = new CheckFirstElementRepeatedArray();
        int[] array = {3,2,1,2,2,3};
        System.out.println("First Repeated: " + p.firstRepeated(array));
    }
    
    /**
     * We use a hashmap and for every element we store its position inside the array. If the element is
     * 
     * encounter again, we just negate the value in the hashtable indicating that we have seen the element
     * 
     * two times. After processing the complete input array, scan the hashtable and return the highest 
     * 
     * negative indexed value from it.
     * 
     * if the element is repeated more than 2 times, just skip the element if is already negative
     * 
     * 
     * 
     * @param array
     * @return 
     */
    public int firstRepeated(int[] array){
               Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        
        for(i = 0; i < array.length;i++){
            map.put(array[i], 0);
        }
        
        /**
         * Insert in the map the index + 1 of each element.
         * 
         * If the index stored is greater than 0, means this element appeared before, now we store it's
         * new index negated else it's the first time (equals 0) we store the index + 1.
         * 
         * if the value is less than 0 means it has apreared more than 1, we skip it.
         */
        for(i=0;i<array.length;i++){
            
            if(map.get(array[i]) > 0){
                map.put(array[i], - i);
            }else if(map.get(array[i]) == 0){                
                  map.put(array[i], i+1);
            }            
        }
        
        int min = 0;    
        int element = -1;
        
        for(i=0; i<map.size();i++){
            if(map.get(array[i]) < min){
                min = map.get(array[i]);                                
                element = array[i];
            }
        }
        return element;
    }
}
