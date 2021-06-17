package com.isoul.lc;

/**
 * @author isoul
 * @date 2021/6/16 21:39
 * @note Copyright (c) 2021 isoul. All rights reserved.
 */
public class lc877 {

//    public boolean stoneGame(int[] piles) {
//        int left = 0;
//        int right = piles.length - 1;
//        int[] ylks = new int[piles.length / 2];
//        int[] l = new int[piles.length / 2];
//        int i = 0;
//
//        while (left < right) {
//            if (ifchooseleft(piles, left, right)) {
//                ylks[i] = piles[left];
//                left++;
//                if (ifchooseleft(piles, left, right)) {
//                    l[i] = piles[left];
//                    left++;
//                } else {
//                    l[i] = piles[right];
//                    right--;
//                }
//            } else {
//                ylks[i] = piles[right];
//                right--;
//                if (ifchooseleft(piles, left, right) || left == right) {
//                    l[i] = piles[left];
//                    left++;
//                } else {
//                    l[i] = piles[right];
//                    right--;
//                }
//            }
//            i++;
//        }
//
//        int sum1 = 0;
//        int sum2 = 0;
//        for (int ylk : ylks) {
//            sum1 += ylk;
//        }
//        for (int i2 = 0; i2 < ylks.length; i2++) {
//            sum2 += l[i2];
//        }
//
//        return sum1 > sum2;
//    }
//
//    public boolean ifchooseleft(int[] piles, int left, int right) {
//
//        int i = 0;
//        while (left < right) {
//            if (piles[left] > piles[right]) {
//                left++;
//                return true;
//            } else if (piles[left + i] < piles[right - i]) {
//                return false;
//            }
//            i++;
//        }
//
//
//        return false;
//    }


//    官解
    public boolean stoneGame(int[] piles) {
        int length = piles.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] > 0;
    }


    public static class demo {
        public static void main(String[] args) {
            int[] piles = {3, 2, 10, 4};
            lc877 test = new lc877();
            boolean result = test.stoneGame(piles);
            System.out.println(result);
        }
    }

}
