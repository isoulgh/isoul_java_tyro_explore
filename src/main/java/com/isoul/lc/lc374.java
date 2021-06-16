package com.isoul.lc;

public class lc374 {

    static int guessNumber(int n) {
        int left = 1, right = n;
        int mid = mid = left + (right - left) / 2;
        int result = guess(mid);
        while (result != 0) {
            if (result == -1) {
                right = mid;
            }
            if (result == 1) {
                left = mid + 1;
            }
            mid = left + (right - left) / 2;
            result = guess(mid);
        }
        return mid;
    }

    static int guess(int num) {
        int result = 6;
        if (num > result)
            return -1;
        if (num < result)
            return 1;
        if (num == result)
            return 0;
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(guessNumber(10));
    }
}
