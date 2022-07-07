package com.thomson.algs4th.fundamentals;

/**
 * 类说明
 *
 * @author Thomson Tang
 * @version Created: 09/03/2017.
 */
public class ThreeSum {
    /**
     * count triples that sum to 0.
     */
    public static int count(int[] sources) {
        int size = sources.length;
        int count = 0;

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                for (int k = j + 1; k < size; k++) {
                    int sum = sources[i] + sources[j] + sources[k];
                    if (sum == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
