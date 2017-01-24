/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array A of n elements. find three elements i, j, and k in the array such that
 * 
 * A[i]2 + A[j]2 = A[k]2
 * 
 * @author George
 */
public class FindSquareSumElementsEqualsK {
    
    public static void main(String args[]){
        FindSquareSumElementsEqualsK p = new FindSquareSumElementsEqualsK();
        int[] array = {3,4,16,7,36,5};
        p.findSquareEqualsK(array, 5);
        System.out.println(Arrays.toString(p.findSquareEqualsK(array, 5)));
    }
    
    /**
     * A[X]2 + A[Y]2 = A[K]2
     * 
     * We can rearrange the formula in this way:
     * 
     * A[X]2 = A[k]2 - A[Y]2
     * 
     * @param array
     * @param k
     * @return 
     */
    public int[] findSquareEqualsK(int[] array, int k){
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int i = 0;
        
        for(i=0; i< array.length; i++){
            map.put(array[i], array[i]*array[i]);
        }
        
        int k_square = array[k] * array[k];
        //I2+J2=K2
        //J=sqrt(I2-K2);
        for(i=0; i<array.length;i++){
            int squaredI = array[i]*array[i];
            int normalJ =(int) Math.sqrt(Math.abs(squaredI-k_square));
            if(map.get(normalJ)!=null){
                return new int[]{array[i],normalJ};
            }
        }
        
        return null;
    }
}
