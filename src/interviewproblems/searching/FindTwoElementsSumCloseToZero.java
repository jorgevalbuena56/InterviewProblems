/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.Arrays;

/**
 * Given an array with both positive and negative numbers, find the two elements such that their sum is
 * 
 * closest to zero. For the below array, algorithm should give -80 and -85 . Example: 1,60,-10,70,-80,-85
 * 
 * @author GeorgeLocal
 */
public class FindTwoElementsSumCloseToZero {

    public static void main(String args[]) {
        findSumCloseZero(new int[]{1, 60, -10, 70, 85});
    }

    /**
     * Use sorting
     * 
     *  1) Sort all the elements of the given input array
     * 
     *  2) Maintain two indexes, one at the begining (i=0) and other at the ending (j=n-1). Also, maintain
     *     two variable to keep track of smallest positive sum closest to zero and smallest negative sum
     *     closest to zero.
     * 
     *  3) While i < j
     *    
     *    a) If the current pair sum is > zero and < positiveClosest then update the positiveClosest and
     *       decrement j
     *    
     *    b) if the current pair sum is < zero and > negetiveClosest then update the negativeClosest and
     *       increment i
     * 
     *    c) Else, print the pair.
     * 
     * @param array
     * @return 
     */
    public static void findSumCloseZero(int[] array) {

        Arrays.sort(array);
        //int[] tmp1 = new int[2];

        System.out.println(Arrays.toString(array));
        
       int i = 0;
       int j = array.length-1;
       int lessPositive = Integer.MAX_VALUE;
       int lessNegative = Integer.MIN_VALUE;
       int jmin=0;
       int imin=0;
       int jmax=0;
       int imax=0;
       while(i<j){
           int sum = array[i] + array[j];
           if(sum > 0){
               if(sum < lessPositive){
                   lessPositive = sum;
                   jmax=j;
                   imax=i;
               }
               j--;
           }else if (sum < 0){
               if(sum > lessNegative){
                   lessNegative = sum;
                   jmin=j;
                   imin=i;
               }
               i++;
           }
       }
       
        System.out.println(lessPositive > Math.abs(lessNegative) ? "sum "+array[imin]+" "+array[jmin]:
                "sum "+array[imax]+" "+array[jmax]);

        //return tmp1;

    }
}
