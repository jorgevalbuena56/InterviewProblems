/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A[X] + A[Y] + A[Z] = K
 * @author GeorgeLocal
 */
public class FindThreeElementSumEqualsK {
    
    public static void main(String args[]){

        int[] array = {1,5,2,7,4};
        System.out.println("Result: " + Arrays.toString(FindThreeElementSumEqualsK.threeSumKSet(array, 0)));
    }
    
    /**
     * Since our objective is to find three indexes of the array whose sum is K. Let us say those indexes
     * 
     * are X, Y and Z. That means, A[X] + A[Y] + A[Z] = K. What we need is, for each element of the input array A[X],
     * 
     * check whether K - (A[Y] + A[Z]) also exist in input array. NOw, let us simplify that searching with has table.
     * 
     *   1) Before starting the searching, insert all possible sums with pairs of elements into the hashtable
     *   2) For each element of the input array, insert into the hash table. Let us say the current element
     *      is A[X].
     *   2) Before proceeding to the next element we check whether K - (A{Y} + A[Z]) also exist in the hash table or not
     *   3) Existence of such number indicates that we are able to find the indexes
     *   4) Otherwise proceed to the next input element
     * 
     *   TIME COMPLEXITY O(N2) 
     *   SPACE O(N)
     * 
     * @param array
     * @param K
     * @return 
     */
    public static  int[] threeSumKSet(int array[], int K){
           if(array.length < 3) return null;
           int[] res = new int[3];           
           
           Set<Integer> set = new HashSet<Integer>();
    
           for(int i = 0;i < array.length; i++){
               int s1 = K - array[i];
               
               for(int j=0;j<i;j++){
                   int s2 = s1 - array[j];
                   if(set.contains(s2)){                    
                       res[0] = array[i];
                       res[1] = array[j];     
                       res[2] = s2;
                    }
               }
            set.add(array[i]);
           }
           
           return res;
    }
}
