package com.thomson.algs.string;

/**
 * 实现类似于{@code java.lang.String#indexof()}的功能
 *
 * 即：从一个给定的字符串中查找是否包含另一个给定的字符串
 *
 * @author Thomson Tang
 */
public class StringIndexer {

    public static void main(String[] args) {
        int index = indexof("abcdef", "ab");
        System.out.println("index: " + index);
    }

    public static int indexof(String source, String target) {
        int sourceSize = source.length();
        int targetSize = target.length();

        //首先校验两个参数的合法性
        if ((sourceSize == 0) || (targetSize == 0)) {
            return 0;
        }

        if (targetSize > sourceSize) {
            return -1;
        }

        char[] sourceChars = source.toCharArray();
        char[] targetChars = target.toCharArray();

        //从target的第一个字符开始找
        char first = targetChars[0];
        //定义max来表示target中第一个字符在source中的最大的起始位置，
        //如果找到的起始位置比这个值还要大，那souce中肯定不包含target
        int max = sourceSize - targetSize;
        for (int i = 0; i <= max; i++) {
            //计算出target的第一个字符在source中的位置，也就是i的值
            if (first != sourceChars[i]) {
                for (i = i + 1; i <= max && first != sourceChars[i]; i++) ;
            }

            //first的位置不大于max说明target的字符个数没有超过source中从first所在位置处开始往后算的字符的个数
            //此时至少在个数上保证了匹配的可能性，需要进一步判断剩余的字符本身是否匹配
            if (i <= max) {
                //定义j表示source中和target的第一个字符相同的位置的后一位
                int j = i + 1;
                //size是source中从匹配到的第一个字符开始还要循环比较其他字符的次数，其实就是target的长度
                int size = j + targetSize - 1;
                //依次循环后的字符，看它们是否相同
                for (int k = 1; k < size - 1 && sourceChars[j] == targetChars[k]; j++, k++) ;

                //匹配成功
                if (j == size) {
                    return i;
                }
            }
        }
        return -1;
    }
}
