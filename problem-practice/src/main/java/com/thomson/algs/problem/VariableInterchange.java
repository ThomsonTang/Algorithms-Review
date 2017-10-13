package com.thomson.algs.problem;

/**
 * 不使用中间变量实现两个变量的交换
 *
 * @author Thomson Tang
 */
public class VariableInterchange {
    public static void main(String[] args) {
//        swapWithAdditionAndSubtraction(1, 2);
        swapWithExclusiveOrOperation();
    }

    /**
     * 使用加减法实现交换
     */
    public static void swapWithAdditionAndSubtraction(int a, int b) {
        System.out.println("before: a=" + a + ", b=" + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("after: a=" + a + ", b=" + b);
    }

    /**
     * 使用异或操作实现
     */
    public static void swapWithExclusiveOrOperation() {
        int a = 1;
        int b = 2;
        System.out.println("before: a=" + a + ", b=" + b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("after: a=" + a + ", b=" + b);
    }
}
