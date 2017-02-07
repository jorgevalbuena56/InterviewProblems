/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewproblems;

/*
 * 'Dot Product on Sprase Matrices'
 *
 * O(n) time and space complexity for multuply not including sorting where 'n'
 * is number of used entries in sparse matrices A or B. Actual matrix
 * dimensions are irrelevant (square, 1-d array, etc.) and have no effect on
 * the algorithm or running time.
 *
 * If input arrays are not sorted then running time extends to O(nlogn) where,
 * again, 'n' is the number of elements in the sparse array irrespective of the
 * matrix dimensions.
 */

import java.util.Arrays;
import java.util.Comparator;

public class Value {
    public int val, x, y;

    public Value(int x, int y, int val)
    {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    public String toString()
    {
        return ("(" + x + ", " + y + ") = " + val);
    }
}

public class CrossProductSparseMatrix {
    private class ComparatorA implements Comparator<Value>
    {
        public int compare(Value a, Value b)
        {
            if (a.y < b.y)
                return -1;
            else if (a.y == b.y && a.x == b.x)
                return 0;
            else if (a.y == b.y && a.x < b.x)
                return -1;
            else
                return 1;
        }
    }

    private class ComparatorB implements Comparator<Value>
    {
        public int compare(Value a, Value b)
        {
            if (a.x < b.x)
                return -1;
            else if (a.x == b.x && a.y == b.y)
                return 0;
            else if (a.x == b.x && a.y < b.y)
                return -1;
            else
                return 1;
        }
    }

    private int compareIndexAB(Value a, Value b)
    {
        if (a.y < b.x)
            return -1;
        else if (a.y == b.x && a.x == b.y)
            return 0;
        else if (a.y == b.x && a.x < b.y)
            return -1;
        else
            return 1;
    }

    public Value[] compute(Value[] A, Value[] B)
    {
        Arrays.sort(A, new ComparatorA());
        Arrays.sort(B, new ComparatorB());

        int max = A.length < B.length ? A.length : B.length;

        Value[] C = new Value[max];
        int sum;
        int c = 0;
        int b = 0;
        boolean nonzero = false; // For empty empty return handling

        for (int a = 0; a < A.length; a++) {
            while (b < B.length && compareIndexAB(A[a], B[b]) > 0) {
                b++;
            }

            if (b >= B.length)
                break;

            if (compareIndexAB(A[a], B[b]) == 0) {
                nonzero = true;
                int prod = A[a].val * B[b].val;

                if (C[c] == null)
                    C[c] = new Value(A[a].y, 0, prod);
                else if (C[c].x == A[a].y)
                    C[c].val += prod;
                else
                    C[++c] = new Value(A[a].y, 0, prod);
            }
        }

        if (!nonzero)
            return new Value[0];

        Value[] resizeC = new Value[c+1];
        for (int i = 0; i <= c; i++)
            resizeC[i] = C[i];

        return resizeC;
    }

    public static void main(String[] args)
    {
        Value[] matrixA = {
            new Value(45, 1000000, 1),
            new Value(46, 1000000, 2),
            new Value(47, 1000000, 3),
            new Value(48, 1000000, 4),
            new Value(1234, 123, 5),
        };

        Value[] matrixB = {
            new Value(1000000, 45, 1),
            new Value(1000000, 46, 2),
            new Value(1000000, 47, 3),
            new Value(1000000, 48, 4),
            new Value(789, 5678, 5),
        };

        DotProduct dp = new DotProduct();
        Value[] matrixC = dp.compute(matrixA, matrixB);

        for (int i = 0; i < matrixC.length; i++)
            System.out.println(matrixC[i]);
    }
}
