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
        while (left <= right) {
            int pivot = a[left];
            int i = left + 1;
            int j = right;
            while (i <= j) {
                if (a[i] <= pivot) {
                    i++;
                } else if (a[j] > pivot) {
                    j--;
                } else {
                    swap(a, i, j);
                    i++;
                    j--;
                }
            }            
            if (j == k) {
                System.out.println("Array is" + Arrays.toString(a));
                System.out.println("k is " + k);
                return pivot;
            } else if (j < k) {
                left = i;
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
