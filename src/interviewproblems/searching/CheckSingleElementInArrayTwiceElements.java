/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 *
 * Given an array of integers, every element appears twice except for one. Find that single element
 * 
 * @author George
 */
public class CheckSingleElementInArrayTwiceElements {
   
    public static void main(String args[]){
       CheckSingleElementInArrayTwiceElements p = new CheckSingleElementInArrayTwiceElements();
       int[] array = {1,2,3,4,5,1,2,4,5};
       System.out.println("Not Repeated: " + p.singleMissingNumber(array));
   } 
   
    /**
     * Do a bitwise XOR of all elements. We get the number which has only one occurence
     * 
     * @param array
     * @return single element that is not repeated
     */
   public int singleMissingNumber(int[] array){
       int missingNum = array[0];
       
       for(int i = 1; i < array.length;i++){
           missingNum^=array[i];
       }
       
       return missingNum;
   } 
}
