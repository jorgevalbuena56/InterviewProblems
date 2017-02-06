/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 * Given an array of positive integers and a target total of X, find if there
 * exists a contiguous subarray with sum = X
 *
 * [1, 3, 5, 18] X = 8 Output: True 
 *               X = 9 Output: True 
 *               X = 10 Output: False 
 *               X = 40 Output: False
 *
 * Since the numbers are a positive we should be able to do this with a window
 * function.
 *
 * We move the right side as long as we don't make the sum too large, otherwise
 * we move the left one.
 *
 * Complexity O(N) time, O(1) space.
 *
 * @author valgood
 */
public class FindContiguousSubArraySumEqualsK {

    public static void main(String args[]) {
        int arr[] = {1,3,5,18};
        System.out.println("Result is: " + sumsToX(arr, 40));
    }

    private static boolean sumsToX(int[] arr, int target) {
        int start = 0, end = 0, sum = 0;
        while (end < arr.length) {
            if (sum + arr[end] <= target) {
                sum += arr[end++];
            } else {
                sum -= arr[start++];
            }
            if (sum == target) {
                return true;
            }
            if (end < start) {
                end = start;
                sum = 0;
            }
        }
        return false;
    }
}
