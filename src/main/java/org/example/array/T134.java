package org.example.array;

/**
 * 加油站
 * 贪心？
 * 从a到b如果到达不了，那么从a到b中任何一个节点都无法到达b点
 * 我们从0开始，直到第一个不能到达的点，说明到达这个点，油是负数，同时记录下此时油一个负了多少
 * 此时从下一个点开始出发，直到下一个不能到达的点，如果此时后面可以直接跑到我们的开始，那么看一下后面剩余的油是否能够补足前面所亏空的油
 * 使得我们断点所缺的油能够补上。
 * @Datetime: 2024/3/7 22:38
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/gas-station/">加油站</a>
 */
public class T134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int begin = 0;
        int nowGas = 0;
        int count = 0;
        int all = 0;
        for (int i = 0; i < gas.length; i++) {
            nowGas = nowGas + gas[i] - cost[i];
            all += gas[i] - cost[i];
            if (nowGas < 0) {
                begin = (i + 1) % gas.length;
                nowGas = 0;
            }
        }
        if (all < 0) {
            return -1;
        }
        return begin;
    }

    public static void main(String[] args) {
        System.out.println(new T134().canCompleteCircuit(new int[]{2,3,3}, new int[]{3,4,4}));
    }
}
