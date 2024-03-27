package lsp.practice;

import java.util.Scanner;

import java.util.*;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class Main {
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static List<List<Integer>> result = new  ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        int root = -1;
        for (int i = 0; i < n - 1; i++) {
            int begin = in.nextInt();
            int end = in.nextInt();
            List<Integer> temp = map.getOrDefault(begin, new ArrayList<>());
            temp.add(end);
            if (root == -1) {
                root = begin;
            }
        }


    }

    public static int dfs(int begin) {
        if (map.get(begin).size() == 0) {
            return -1;
        }
        List<Integer> tempList = new ArrayList<>();
        for (int i = 0; i < map.get(begin).size(); i++) {
            int temp = map.get(begin).get(i);
            int tempDfs = dfs(temp);
            if (tempDfs == -1) {
                if (tempList.size() == 2) {
                    tempList.add(temp);
                } else if (tempList.size() == 0) {
                    tempList.add(temp);
                    tempList.add(begin);
                } else {
                    result.add(tempList);
                    tempList = new ArrayList<>();
                    tempList.add(temp, begin);
                }
            } else if (tempDfs != 0) {
                tempList.add(begin);
                tempList.add(temp);
                tempList.add(tempDfs);
                result.add(tempList);
                tempList = new ArrayList<>();
            }
        }
        if (tempList.size() == 3) {
            result.add(tempList);
            return 0;
        } else {
            return tempList.get(0);
        }
    }
}