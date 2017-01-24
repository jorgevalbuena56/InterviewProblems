/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Given an array of n numbers, give an algorithm for finding the element which appears maximum number
 * 
 * of times in the array
 * 
 * @author GeorgeLocal
 */
public class CheckMaximumRepetitionElementArray {
    
    public static void main(String args[]){
        CheckMaximumRepetitionElementArray p = new CheckMaximumRepetitionElementArray();
        //int[] array = {3,2,1,0,4,5};
        int[] array = {2,2,6,3,6,6,3};
        System.out.println("MaxRepeted: " + p.maxRepetitions(array));
        System.out.println("MaxRepeted: " + p.maxRepetitionsAddMethod(array));
    }
    
    public int maxRepetitions(int[] array){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i;
        
        for(i = 0; i < array.length;i++){
            map.put(array[i], 0);
        }
        
        for(i=0;i<array.length;i++){
            map.put(array[i], map.get(array[i]) + 1);
        }

        int max = 1;
        int element = -1;
        
        for(i=0; i<array.length;i++){
            if(map.get(array[i]) > max){
                max = map.get(array[i]);
                element = array[i];
            }
        }
        return element;
    }
    
    /**
     * In the first scan, add the value of n. That means for each occurence of an element add the array
     * 
     * size to that element. In the second scan, check the element value by dividing it with n and return
     * 
     * the element whichever gives the maximun value
     * 
     * PROBLEMS WITH THE SOLUTION
     * 
     *   1) THIS SOLUTION DOES NOT WORK IF THE GIVEN ARRAY IS READ ONLY
     *   2) THIS SOLUTION WILL WORK ONLY IF ALL ARRAY ELEMENTS ARE POSITIVE
     *   3) IF THE ELEMENT RANGE IS NOT IN 0 TO N-1 THEN IT MAY GIVE EXCEPTIONS
     *   4) IF THE REPEATED ELEMENT IS EXACTLY N IT DOES NOT WORK
     * O(N) TIME AND O(1) SPACE
     * 
     * @param array 
     */
    public int maxRepetitionsAddMethod(int[] array){
       int i = 0;
       int max = 1;
       int maxIndex = 0;
       int n = array.length;
       
       for(i = 0; i < n; i++){
           array[array[i]%n] += n;
       }
       
       for(i = 0; i < n; i++){
           if(array[i]/n > max){
               max = array[i] / n;
               maxIndex = i;
           }
       }
       
       return maxIndex;
    }
}
