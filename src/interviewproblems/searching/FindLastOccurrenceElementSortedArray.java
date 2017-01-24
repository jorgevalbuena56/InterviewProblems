/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 * Given a sorted array, A of n elements, possibly with duplicates, find the index of the last occurrence
 * 
 * of a number in O(logn) time
 * 
 * @author George
 */
public class FindLastOccurrenceElementSortedArray {
    
    public static void main(String args[]){

        int array[] = {2,4,6,8,10,12,12,12,14,14,16};        
        System.out.println("Element index: " + FindLastOccurrenceElementSortedArray.binarySearchLastOcurrence(array, 0, 10, 12));

    }
    
   /**
     * To find the last occurrence of a number we need to check for the following condition:
     * 
     *   mid == high && A[mid] == data || A[mid] == data && A[mid + 1] > data
     * 
     * @return 
     */
    public static int binarySearchLastOcurrence(int[] array, int low, int high, int data){
        
        if(high >= low){
            int mid = low + (high - low)/2;
            
            if(mid == high && array[mid] == data || array[mid] == data && array[mid + 1] > data){
                return mid;
            }else if(array[mid] <= data){
                //Give preference to the right half of the array
                return binarySearchLastOcurrence(array, mid + 1, high, data);
            }else{
                return binarySearchLastOcurrence(array, low, mid - 1, data);
            }            
        }
        
        return -1;
    }
}
