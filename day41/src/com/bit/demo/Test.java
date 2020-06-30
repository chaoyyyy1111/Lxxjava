package com.bit.demo;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < str1.length(); i++) {
            if(!str2.contains(str1.charAt(i)+"")) {
                sb.append(str1.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
    public static void main1(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        if(n % 8 == 6 || n % 8 == 4 || n % 8 == 2) {
            System.out.println(n/8 + 1);
        } else if(n % 8 == 0) {
            System.out.println(n/8);
        } else {
            System.out.println(-1);
        }
    }
}
