package com.thomson.algs.recursion;

/**
 * 斐波那契数列的实现
 *
 * @author Thomson Tang
 */
public class FibonacciSequence {

    //递归法
    public static int fibByRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibByRecursion(n - 1) + fibByRecursion(n - 2);
        }
    }

    //循环法
    public static int fibByLoop(int n) {
        int[] result = new int[n];
        result[0] = result[1] = 1;

        for (int i = 2; i < result.length; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        System.out.println("f(10) = [" + fibByLoop(10) + "]");
        System.out.println("f(10) = [" + fibByRecursion(10) + "]");
    }
}
