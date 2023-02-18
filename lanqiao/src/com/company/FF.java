package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class FF {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //String[] strings = new String[i];
        ArrayList<String> strings = new ArrayList<>();
        int i = scanner.nextInt();
        System.out.println();
        for (int j = 0; j < i; j++) {
            String next = scanner.next();
            strings.add(next);
        }
        for (int j = 0; j < strings.size(); j++) {
            for (int k = j + 1; k < strings.size(); k++) {
                if (strings.get(j).equals(strings.get(k))) {
                    strings.remove(k);
                }
            }
        }
        for (int j = 0; j < strings.size(); j++) {
            String s = strings.get(j);
            System.out.println(s);
        }
    }
}

class R {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String next = scan.next();
        int length = next.length();
        StringBuffer sb = new StringBuffer(next);
        sb.reverse();
        StringBuffer bs = new StringBuffer(next);
        bs.append(sb);
        ArrayList<Object> o = new ArrayList<>();
        for (int i = 0; i < bs.length(); i++) {
            o.add(bs.substring(i, i + 1));
        }
        System.out.println();
        //System.out.println(bs);
        int a = o.size()-1;
        int b = o.size();
        int c = a/2;
        int L = bs.length();
        for (int i = 0; i < o.size(); i++) {
           if(c-i==0){
               break;
           }
            String o1 = (String)o.get(c+1);
            String o2 = (String)o.get(a-i);
            if(o2.equals(o1)){
                o.remove(o2);
            }

        }
        for (int i = 0; i < o.size(); i++) {
            String s = (String)o.get(i);
            System.out.print(s);
        }
    }
}