package com.bit.demo;


import java.util.Scanner;

public class TestMain {
    public static int fibonacci(int n) {
        int f1 = 0;
        int f2 = 1;
        int f3 = 1;
        if(n == 0) {
            return 0;
        }
        while(n - 2 > 0) {
            f1 = f2;
            f2 = f3;
            f3 = f1 + f2;
            n--;
        }
        return f3;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int min = Math.abs(fibonacci(0)-n);
        for (int i = 0; i < n; i++) {
            if(min > Math.abs(fibonacci(i)-n))
            min = Math.abs(fibonacci(i)-n);
        }
        System.out.println(min);
    }

}

