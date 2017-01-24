/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 * Given a sorted array, A of n elements, possibly with duplicates, find the index of the first ocurrence
 * 
 * of a number in O(logn) time
 * 
 * @author GeorgeLocal
 */
public class FindFirstOccurenceElementSortedArray {
   
    public static void main (String args[]){
        int array[] = {2,4,6,8,10,12,12,12,14,14,16};        
        System.out.println("Element index: " + FindFirstOccurenceElementSortedArray.binarySearchFirstOcurrence(array, 0, 10, 14));
    }
    
    /**
     * To find the first occurrence of a number we need to check for the following condition:
     * 
     *   mid == low && A[mid] == data || A[mid] == data && A[mid - 1] < data
     * 
     * @return 
     */
    public static int binarySearchFirstOcurrence(int[] array, int low, int high, int data){
        
        if(high >= low){
            int mid = low + (high - low)/2;
            
            if(mid == low && array[mid] == data || array[mid] == data && array[mid - 1] < data){
                return mid;
            }else if(array[mid] >= data){
                //Give preference to the left half of the array
                return binarySearchFirstOcurrence(array, low, mid - 1, data);
            }else{
                return binarySearchFirstOcurrence(array, mid + 1, high, data);
            }            
        }
        
        return -1;
    }
}
