package com.isoul.old;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Test1 {

    public static void main(String[] args) {
        System.out.println("请输入数组的个数：");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        System.out.println("请输入这" + n + "个数：");
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }
        int[] result = Method(data);
        System.out.print("多重集S的众数是：");
        for (int i = 2; i < result[1] + 2; i++) {
            System.out.print(result[i] + ",");
        }
        System.out.println("其重数是" + result[0]);
    }

    static int[] Method(int[] data) {
        //用哈希表存储数组集合，键表示数字，值表示对应数字出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        //结果数组，0号元素存储重数，1号元素存储众数的个数，其余存储众数
        int[] result = new int[5];
        int max = -1;
        //计算哈希表的键值对，遍历输入数组，若数字对应的值为空，则赋值为1，若不为空，则加1
        for (int i = 0; i < data.length; i++) {
            if ((map.get(data[i])) == null) {
                map.put(data[i], 1);
            } else {
                int num = map.get(data[i]);
                map.put(data[i], num + 1);
            }
        }
        //计算重数，遍历哈希表，得出最大的值
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int num = it.next();
            if (map.get(num) > max) {
                max = map.get(num);
            }
        }
        //根据重数遍历哈希表，得出众数，存储到结果数组中，考虑到可能有多个众数
        it = map.keySet().iterator();
        int i = 2;
        while (it.hasNext()) {
            int num = it.next();
            if (map.get(num) == max) {
                result[i] = num;
                i++;
            }
        }
        result[0] = max;
        result[1] = i-2;
        return  result;
    }

}
