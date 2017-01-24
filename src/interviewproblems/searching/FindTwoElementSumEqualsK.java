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
 * Given an array of n elements, Find two elements in the array such that their sum is equal 
 * 
 * to a given element k. A[X] + A[Y] = K
 * 
 * @author George
 */
public class FindTwoElementSumEqualsK {
    
    public static void main(String args[]){
        FindTwoElementSumEqualsK p = new FindTwoElementSumEqualsK();
        int[] array = {2,5,3,2,6,8};
        //p.twoSumK(array, 7);
        int res[] = p.twoSumKHashTable(array, 5);
        if(res.length > 0)
        System.out.println("Items: X:" + res[0] + " -Y: " + res[1]);
    }
    
    /**
     * Let us assume that we have sorted the given array. This operation takes O(N LOG N). On the sorted
     * 
     * array, maintain indices loIndex = 0 and hiIndex = n-1 and compute A[loIndex] + A[hiIndex].
     * 
     * If the sum equals K, then we are done with the solution. If the sum is less than k, decrement hiIndex
     * 
     * If the sum is greater than K, increment loIndex.
     * 
     * TIME COMPLEXITIY IS O(N LOG N). If the given array is already sorted then the complexity is O(N)
     * 
     * SPACE COMPLEXITY O(1)
     * 
     * @param array
     * @param k 
     */
    public void twoSumK(int array[], int k){
        
        int i,j, temp;
        
       Arrays.sort(array);
       
       for(i = 0, j = array.length - 1; i<j;){
           temp = array[i] + array[j];
           if(temp == k){
               System.out.println("Items Found, i:" + array[i] + " j: " + array[j]);
               return;
           }else{
               if(temp < k){
                   i = i + 1;
               }else{
                   j = j - 1;
               }
           }
       }       
    }
    
    /**
     * Since our objective is to find two indexes of the array whose sum is K. Let us say those indexes
     * 
     * are X and Y. That means, A[X] + A[Y] = K. What we need is, for each element of the input array A[X],
     * 
     * check whether K - A[X] also exist in input array. NOw, let us simplify that searching with has table.
     * 
     *   1) For each element of the input array, insert into the hash table. Let us say the current element
     *      is A[X].
     *   2) Before proceeding to the next element we check whether K - A{X} also exist in the hash table or not
     *   3) Existence of such number indicates that we are able to find the indexes
     *   4) Otherwise proceed to the next input element
     * 
     *   TIME COMPLEXITY O(N) 
     *   SPACE O(N)
     * 
     * @param array
     * @param K
     * @return 
     */
    public int[] twoSumKHashTable(int array[], int K){
           if(array.length < 2) return null;
           int[] res = new int[2];
           
           Set<Integer> set = new HashSet<Integer>();
    
           for(int i = 0;i < array.length; i++){
                int s1 = K - array[i];
                
               if(set.contains(s1)){
                   res[0] = s1;
                   res[1] = array[i];
               }
               
               set.add(array[i]);
           }
           
           return res;
    }
}
