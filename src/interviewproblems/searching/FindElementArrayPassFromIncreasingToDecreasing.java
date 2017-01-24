/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 * Let's assume that we have an array sorted that starts with negative numbers and ends with positive
 * 
 * numbers [such functions are called monotonically increasing function]. In this array find the starting 
 * 
 * index of the positive numbers. Assume that we know the length of the input array. Design a O(logn)
 * 
 * algorithm.
 * 
 * @author George
 */
public class FindElementArrayPassFromIncreasingToDecreasing {
   
    public static void main(String args[]){
        System.out.println("Element: " + (FindElementArrayPassFromIncreasingToDecreasing.search(new int[]{5,6,7,8,4,3,2})));
    }
    
    /**
     * Using a variant of Binary search
     * 
     * @param array
     * @return 
     */
    public static int search(int[] array){
       int mid;
       int first = 0;
       int last = array.length - 1;
       
       while(first <= last){
           //if the current array has 1 size
           if(first == last){
               return array[first];
               //if the current array has size 2
           }else if(first == last -1){
               return Math.max(array[first], array[last]);
               //if the current array has size 3 or more
           }else{
               mid = first + (last - first)/2;
               if(array[mid - 1] < array[mid] && array[mid] > array[mid + 1]){
                   return array[mid];
               }else if(array[mid - 1] < array[mid] && array[mid] < array[mid + 1]){
                   first = mid + 1;
               }else if(array[mid - 1] > array[mid] && array[mid] > array[mid + 1]){
                   last = mid - 1;
               }else{
                   return Integer.MIN_VALUE;
               }
           }
       }
       
       return Integer.MIN_VALUE;
    }
}
