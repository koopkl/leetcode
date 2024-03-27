package org.example.array;

import java.util.Arrays;

/**
 * 插入区间
 * 模拟题 真的很麻烦，没写出来哈哈
 * @Datetime: 2024/3/22 21:55
 * @Author: koopkl
 * @Link: <a href="https://leetcode.cn/problems/insert-interval/description/">插入区间</a>
 */
public class T57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] res = new int[intervals.length + 1][2];
        int index = 0;
        int i = 0;
        while (i < intervals.length) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (newInterval[0] > end && i + 1 < intervals.length && newInterval[1] < intervals[i + 1][0]) {
                res[index++] = intervals[i];
                res[index++] = newInterval;
                i++;
                continue;
            }
            if (newInterval[1] < start && i - 1 > 0 && newInterval[0] > intervals[i - 1][1]) {
                res[index++] = newInterval;
                res[index++] = intervals[i];
                i++;
                continue;
            }
            if (newInterval[1] < start) {
                res[index++] = intervals[i];
                i++;
                continue;
            }
            if (newInterval[0] > end) {
                res[index++] = intervals[i];
                i++;
            } else if (newInterval[0] <= end && newInterval[0] >= start) {
                if (newInterval[1] <= end) {
                    return intervals;
                } else {
                    res[index][0] = start;
                    while (newInterval[1] > end) {
                        i++;
                        if (i == intervals.length) {
                            break;
                        }
                        end = intervals[i][1];
                        start = intervals[i][0];
                    }
                    if (i == intervals.length) {
                        res[index++][1] = end;
                    } else {
                        if (newInterval[1] >= start) {
                            res[index++][1] = end;
                        } else {
                            res[index++][1] = newInterval[1];
                        }
                    }
                }
            } else {
                res[index][0] = newInterval[0];
                if (newInterval[1] <= end) {
                    res[index][1] = end;
                    i++;
                } else {
                    while (newInterval[0] > end) {
                        i++;
                        if (i == intervals.length) {
                            break;
                        }
                        start = intervals[i][0];
                        end = intervals[i][1];
                    }
                    if (i == intervals.length) {
                        res[index++][1] = end;
                    } else {
                        if (newInterval[1] >= start) {
                            res[index++][1] = end;
                        } else {
                            res[index++][1] = newInterval[1];
                        }
                    }
                }
            }
        }

        return Arrays.copyOfRange(res, 0, index);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new T57().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4, 8})));
    }
}
