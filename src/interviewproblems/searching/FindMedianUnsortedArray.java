/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.Arrays;

/**
 * Find the median of an usorted array. Have to do better than O(n log n) time.
 * 
 * E.g Given [2, 6, 1] return 2
 *     Given [2,6,1,4] return 3 which is the sume of the two elements in the 
 *     middle over 2.
 * 
 * We go with quick select which on average takes O(n) time. 
 * The quick select is similar to a binary quick sort which partially sorts 
 * the given array.
 * 
 * On average the performance of the program above is O(n). However it can 
 * get to O(n^2) in the worst case.
 * 
 * @author valgood
 */
public class FindMedianUnsortedArray {
    
    public static void main(String[] args) {
        int arr[] = {2,6,1};
        int arr2[] = {2,6,1, 4};
        
        int len = arr2.length;
        if(len % 2 == 1) {
            System.out.println("Median is: " + topK(arr2, len / 2));
        } else {
            System.out.println("Median is: " + (topK(arr2, len / 2 - 1)+ topK(arr2, len / 2)) * .5);
        }        
    }
    
    private static int topK(int[] a, int k) {
        int left = 0;
        int right = a.length - 1;
        //while in the range between left and right
        while (left <= right) {
            //pick pivot as the first element on the left side
            int pivot = a[left];
            //subindex in left + 1
            int i = left + 1;
            int j = right;
            //while sub array inxed are in range
            while (i <= j) {
                //if the current element on the left index is on the left side 
                //of the pivot, then its position is fine, move on
                if (a[i] <= pivot) {
                    i++;
                //if te current element on the right index is on the right side 
                //of the pivot, then its position is fine, decrease sub index on
                //the right side
                } else if (a[j] > pivot) {
                    j--;
                //element is not following the correct order, swap, move 
                //subindexes    
                } else {
                    swap(a, i, j);
                    i++;
                    j--;
                }
            }            
            //if we have the amount of k value in the array, then we have the 
            //pivot in the middle
            if (j == k) {
                System.out.println("Array is" + Arrays.toString(a));
                System.out.println("k is " + k);
                return pivot;
            //if we have less than the amount of element needed, move left index    
            } else if (j < k) {
                left = i;
            //if we have more elements, swap left with subndex right and 
            //decrease the right index    
            } else {
                swap(a, left, j);
                right = j - 1;
            }            
        }        
        return a[right];
    }
    
    private static void swap(int[] array, int a, int b) {
        int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
}
