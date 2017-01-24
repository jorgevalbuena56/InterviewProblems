/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/**
 * Write a function that takes an array A and an index i into A, and rearranges the elements such that
 * all elements less than A[i] appear first, followed by elements equal to A[i], followed by elements
 * greater than A[i]. Your algorithm should have O(1) space complexity and O(|A|) time complexity
 * 
 * @author George
 */
public class RearrangeArrayBasedOnIndexPivot {
    
    public static void main(String args[]){
        
        RearrangeArrayBasedOnIndexPivot p = new RearrangeArrayBasedOnIndexPivot();
        
        int[] array = {2,5,67,43,4,6,43,89,3,7,9,43,6,8,3,43,89,23,56,43,98};
        
        p.rearrangeArray(array, 7);
        
        System.out.println("After Rearrange: ");
        for(int j=0;j<array.length;j++)
            System.out.print(array[j] + " ");
    }

    /** 
      * Keep the following invariants during partitioning: 
      * bottom group: array[0: smaller - 1]
      * middle group: array[smaller : equal - 1]
      * unclassified group: array[equal : larger]
      * top group: array[larger + 1 : array.size() - 1]
    */
    public void rearrangeArray(int[] array, int index){
        if(array.length == 0){
            throw new Error("Array Empty");
        }
        
        int pivot = array[index];
        
        int smaller = 0;
        int equal = 0;
        int larger = array.length - 1;
        
        //while there is any unclassified element
        while(equal <= larger){
            //array[equal] is the incoming unclassified element
            if(array[equal] < pivot){
                swap(array, smaller++, equal++);
            }else if(array[equal] == pivot){
                ++equal;
            }else{ //array[equal] > pivot
                swap(array, equal, larger--);
            }
        }
    }

    private void swap(int[] array, int elem1, int elem2) {
        int temp = array[elem1];
        array[elem1] = array[elem2];
        array[elem2] = temp;
    }
}
