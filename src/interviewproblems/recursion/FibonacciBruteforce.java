/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewproblems.recursion;

/**
 *
 * @author George
 */
public class FibonacciBruteforce {

    /**
     * @param args the command line arguments
     */
    int cntCalls = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        FibonacciBruteforce al = new FibonacciBruteforce();
        System.out.println("Fn(30) = " + al.fibonacci(30));
        System.out.println("Recursive calls made: " + al.cntCalls);
    }
    
    public int fibonacci(int n) {
        cntCalls ++;
        if(n == 0){
            return 0;
        }else if(n == 1) {
            return 1;
        }else
            return (fibonacci(n - 2) + fibonacci(n - 1)); 
    }
}
