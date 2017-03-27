package com.jude.util;

/**
 * Created by Jude on 3/27/17.
 */

public class KMPTool {

    public static int[] getKMPArray(String pattern){
        int[] next = new int[pattern.length()];

        int j = 0;
        int k = -1;
        int len = pattern.length();
        next[0] = -1;

        while (j < len - 1) {
            if (k == -1 || pattern.charAt(k) == pattern.charAt(j)) {

                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }


}
