/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.Arrays;

/**
 * Given a sorted array of n integers that has been rotated an unknown number of times, give a O(logn)
 * 
 * algorithm that finds an element in the array
 * 
 * Example: Find 5 in array {15,16,19,20,25,1,3,4,5,7,10,14}
 * Output: 8 (the index of 5 in the array)
 * 
 * @author George
 */
public class FindElementInArrayRotatedSeveralTimes {
    
    public static void main (String args[]){
        int[] array = {15,16,19,20,25,1,3,4,5,7,10,14};
        System.out.println("Element index: " + FindElementInArrayRotatedSeveralTimes.search(array, 5));
    }
    
    public static int search(int[] array, int data){
        int left = 0;
        int right = array.length - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(array[mid] == data){
                return mid;
            }
            
            if(array[left] < array[mid]){
                if(array[left] <= data && data < array[mid]){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }else if(array[left] > array[mid]){
                if(array[mid] < data && data <= array[right]){
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }else{
                //skip duplicate one array[start] == array[mid]
                left++;
            }
        }
        
        return -1;
    }
}
