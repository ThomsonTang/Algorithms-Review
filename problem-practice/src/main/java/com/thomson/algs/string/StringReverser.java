package com.thomson.algs.string;

/**
 * 字符串逆转
 *
 * @author Thomson Tang
 */
public class StringReverser {

    public static void main(String[] args) {
        System.out.println(reverse("tangguike"));
    }

    public static String reverse(String source) {
        if (null == source) {
            throw new IllegalArgumentException("输入参数不能为空！");
        }
        int size = source.length();
        StringBuilder sb = new StringBuilder();
        for (int i = size - 1; i >= 0; i--) {
            char c = source.charAt(i);
            sb.append(c);
        }
        return sb.toString();
    }
}
