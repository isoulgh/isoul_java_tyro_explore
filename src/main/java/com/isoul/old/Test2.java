package com.isoul.old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Test2 {

    public static void main(String[] args) {
        System.out.println("请输入数组的个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        System.out.println("请输入这" + n + "个数：");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        System.out.println("请输入两个数的和：");
        int sum = scanner.nextInt();
        int[] result = Method(data, sum);
        System.out.println("这两个数字是：");
        System.out.println(result[1] + "和" + result[2]);
        if (result[0] > 2) {
            for (int i = 2; i <= result[0] / 2; i++) {
                System.out.println(result[2 * i - 1] + "和" + result[2 * i]);
            }
        }
    }

    static int[] Method(int[] data, int sum) {
        //用哈希表存储数组集合，键表示数字，值表示对应数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //结果数组，0号元素存储结果数组长度，其余存储结果，考虑到结果可能不止一对
        int[] result = new int[11];
        //计算哈希表的键值对，遍历输入数组，若数字对应的值为空，则赋值为1，若不为空，则加1
        for (int i = 0; i < data.length; i++) {
            if ((map.get(data[i])) == null) {
                map.put(data[i], 1);
            } else {
                int num = map.get(data[i]);
                map.put(data[i], num + 1);
            }
        }
        //计算匹配的元素，遍历哈希表，若（sum-当前值）在哈希表中，则将其加入到flag数组中
        int[] flag = new int[data.length];
        int len = 0;
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int num = it.next();
            map.put(num, map.get(num) - 1);
            if (null != map.get(sum - num) && map.get(sum - num) > 0) {
                flag[len] = num;
                len++;
                if (sum == 2 * num) {
                    flag[len] = num;
                    len++;
                }
            }
            map.put(num, map.get(num) + 1);
        }
        //转存结果数组，例如flag中的4,5,6,7存储到result中4,7,5,6,并且result[0]表示数组长度
        result[0] = len;
        if (len != 0) {
            for (int i = 0, j = 1; i < len / 2; i++, j++) {
                result[2 * j - 1] = flag[i];
                result[2 * j] = flag[len - 1 - i];
            }
            return result;
        }
        result[1] = -1;
        result[2] = -1;
        return result;
    }

}
