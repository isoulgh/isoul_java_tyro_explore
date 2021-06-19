package com.isoul.lc;

/**
 * @author isoul
 * @date 2021/6/18 15:24
 * @note Copyright (c) 2021 isoul. All rights reserved.
 */
public class lc483 {

    public String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
//        因为没有直接计算自定义对数的，所以用loge/loge的方式计算
//        k>=2，所以先计算m的最大值，下面从最大值慢慢减小，遍历计算
//        计算对数的整数部分，k<n^(1/m)<k+1，即k的值
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }

    public static class demo {
        public static void main(String[] args) {
            System.out.println(new lc483().smallestGoodBase("33"));
        }
    }

}
