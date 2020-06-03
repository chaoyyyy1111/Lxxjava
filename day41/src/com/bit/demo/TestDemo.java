package com.bit.demo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TestDemo {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Set<String> set = new HashSet<>();
        while(scan.hasNextLine()) {
            String str = scan.nextLine();
            if(str.isEmpty()) {
               break;
            }
            String[] strs = str.split(" ");
            for (String s :strs) {
                set.add(s);
            }

        }
        System.out.println(set.size());
    }
}
