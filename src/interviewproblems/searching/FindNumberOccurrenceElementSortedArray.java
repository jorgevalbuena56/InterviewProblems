/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 * Given a sorted array of n elements, possibly with duplicates, find the number of occurrences of
 * 
 * a number 
 * 
 * @author George
 */
public class FindNumberOccurrenceElementSortedArray {
    
    public static void main(String[] args){
        int array[] = {2,4,6,8,10,12,12,12,14,14,16};        
        System.out.println("Element index: " + FindNumberOccurrenceElementSortedArray.FindNumberOccurrenceElementSortedArray(array, 0, 10, 14));
       
    }
    
    /**
     * Find first occurrence of data and call its index as firstOccurrence
     * Find last occurrence of data and call its index as lastOccurrence
     * Return lastOccurrence - firstOccurrence + 1
     * 
     * @param array
     * @return 
     */
    public static int FindNumberOccurrenceElementSortedArray(int[] array, int low, int high, int data){
        return binarySearchLastOcurrence(array, low, high, data) - binarySearchFirstOcurrence(array, low, high, data) + 1;
    }
    
        /**
     * To find the first occurrence of a number we need to check for the following condition:
     * 
     *   mid == low && A[mid] == data || A[mid] == data && A[mid - 1] < data
     * 
     * @return 
     */
    private static int binarySearchFirstOcurrence(int[] array, int low, int high, int data){
        
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
