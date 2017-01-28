/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.ordering;

import java.util.Arrays;

/**
 * Given an array of integers, design an algorithm that moves all non-zero 
 * 
 * integers to the end of the array. Minimize the number of writes or swaps.
 * 
 * @author valgood
 */
public class MoveNonZeroIntegerToEndArray {
   public static void main(String args[]){
        
        MoveNonZeroIntegerToEndArray p = new MoveNonZeroIntegerToEndArray();
        
        int[] array = {2,0,67,0,4,6,43,0,3,7,9,0,6,8,3,0,89,0,0,43,0};
        System.out.println("Array Original: " + Arrays.toString(array));    
        
        p.rearrangeArray(array);
        
        System.out.println("After Rearrange: ");
        for(int j=0;j<array.length;j++)
            System.out.print(array[j] + " ");
   }
   
       /** 
      * We start comparing the first and last element of the array, if the first
      * is not 0 we swap both elements and decrease the last index. If the element
      * is 0 we move the first index.
    */
    public void rearrangeArray(int[] array){
        if(array.length == 0){
            throw new Error("Array Empty");
        }
        
        int current = 0;
        int last = array.length - 1;
        
        while(current <= last){          
            if(array[current] == 0){                
                current++;     
            }else{ //array[equal] > 0
                swap(array, current, last--);
            }
        }
    }

    private void swap(int[] array, int elem1, int elem2) {
        int temp = array[elem1];
        array[elem1] = array[elem2];
        array[elem2] = temp;
        System.out.println("Array Modif: " + Arrays.toString(array));
    }
}
