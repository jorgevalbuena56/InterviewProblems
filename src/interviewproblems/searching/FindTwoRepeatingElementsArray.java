/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems.searching;

/**
 *
 * Given an array with size, all elements of the array are in range 1 to n and also all elements occur
 * 
 * only once except two numbers which occur twice. Find those two repeating numbers.
 * 
 * For example: if the array is {4,2,4,5,2,3,1} with size = 7 and n = 5. This input has n + 2 = 7
 * 
 * elements with all elements occurring once except 2 and 4 which occur twice. So the output should be
 * 
 * 4 and 2.
 * 
 * @author GeorgeLocal
 */
public class FindTwoRepeatingElementsArray {
    
    public static void main(String args[]){
        
        FindTwoRepeatingElementsArray p = new FindTwoRepeatingElementsArray();
        int[] array = {1,2,4,4,2,6};
        
        p.printRepeatedElementsXOR(array);
    }
    
    /**
     * Use count array. This solution is like using a hash table. For simplicity we can use array for
     * 
     * storing the counts. Traverse the array once and keep track of count of all elements in the array 
     * 
     * using a temp array tmp[] of size n (index based 0 means substract -1). When we see an element 
     * 
     * whose count is already set, print it as duplicate.
     * 
     * @param array 
     */
    public void printRepeatedElements(int[] array){
   
        int[] tmp = new int[array.length - 1];
        
        for(int i=0; i < array.length - 1; i++){
            tmp[i] = 0;
        }
        
        for(int j=0; j < array.length; j++){
            tmp[array[j]]++;
            if(tmp[array[j]] == 2){
                System.out.println("Repeated: " + array[j]);
            }
        }
        
    }
    
    /**
     * Let the repeating numbers be X and Y. if we XOR all elements in the array and also all integers from
     * 
     * 1 to n, then the result will X XOR Y. the 1's in binary representation of X XOR Y correspond to the
     * 
     * different bits between X and Y. if the kth but of X XOR Y 1, we can XOR all the elements in the array
     * 
     * and also all integers from 1 to n, whose kth bits are 1. The result will be one of X and Y.
     * 
     * @param array 
     */
    public void printRepeatedElementsXOR(int[] array){
       int XOR = array[0];
       int size = array.length;
       int i = 0;
       int right_most_set_bit_no;
       int X = 0;
       int Y = 0;
       
       // COMPUTE XOR OF ALL ELEMENTS IN array[]
       for(i=0; i < size; i++){
           XOR^= array[i];
       }
       // COMPUTE XOR OF ALL ELEMENTS [1,2,3,...n]
       for(i = 1;i<=array.length + 1;i++ ){
           XOR^= i;
       }
       
       //GET THE RIGHTMOST SET BIT IN right_most_set_bit_no
       right_most_set_bit_no = XOR &~(XOR - 1);
       
       //Now divide elements in two sets by comparing rightmost set
       for(i = 0; i< size; i++){
           if((array[i] & right_most_set_bit_no) == 1){
               X = X^array[i];    //XOR of first set in array[]
           }else{
               Y = Y^array[i];   //XOR of second set in array[]
           }
       }

       for(i = 1; i<= array.length - 1; i++){
           if((i & right_most_set_bit_no) == 1){
               X = X^i;    //XOR of first set in array[] and [1,2,3....n]
           }else{
               Y = Y^i;   //XOR of second set in array[] and [1,2,3....n]
           }
       }
       
        System.out.println("Values X: " + X + " and Y: " + Y);
    }
}
