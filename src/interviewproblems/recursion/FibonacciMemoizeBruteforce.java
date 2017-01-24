/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interviewproblems.recursion;

/**
 *
 * @author 984325
 */
public class FibonacciMemoizeBruteforce {

    /**
     * @param args the command line arguments
     */
    int cntCalls = 0;
    
    public static void main(String[] args) {
        // TODO code application logic here
        FibonacciMemoizeBruteforce al = new FibonacciMemoizeBruteforce();
        int n = 30;
        int f[] = new int[n+1];
        System.out.println("f(30) = " + al.fibonacci(f, n));
        System.out.println("Recursive calls made: " + al.cntCalls);
    }
    
        public int fibonacci(int f[], int n) {
        cntCalls ++;
        if(n == 0){
            f[n] = 0;
        }else if(n == 1) {
            f[n] = 1;
        }else{
            if (f[n-1] == 0)
                fibonacci(f, n-1);
            if (f[n-2] == 0)
                fibonacci(f, n-2);
            
            f[n] = f[n-2] + f[n-1];
        }
        
        return f[n];
    }
}
