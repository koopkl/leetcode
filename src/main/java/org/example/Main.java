package org.example;

import org.example.array.*;

import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] b = {{-5}};
        int[] c = {3,3,3,1,4};
        System.out.println(new T904().totalFruit(c));

    }
}