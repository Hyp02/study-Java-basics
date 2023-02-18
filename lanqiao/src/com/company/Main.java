package com.company;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
        String i = scan.next();
        BigDecimal s = new BigDecimal(i);
        BigDecimal adds = new BigDecimal("1");
        while (true) {
            StringBuffer sb = new StringBuffer(s.toString());
            if ((s.toString()).equals(sb.reverse())) {
                System.out.println(s.toString());
                break;
            } else {
                s.add(adds);
            }
        }
    }
}

//蓝桥杯，回文日期
class A {
    public static void main(String[] args) {
        // write your code here
        Scanner scan = new Scanner(System.in);
//        long time1 = System.currentTimeMillis();
        //输入一个会文日期
        String i = scan.next();
        String Y = i.substring(0, 4);
        String M = i.substring(4, 6);
        String D = i.substring(6, 8);
        int yy = Integer.parseInt(Y);
        int mm = Integer.parseInt(M);
        System.out.println(mm);
        int dd = Integer.parseInt(D);
        while (true) {
            //大月
            if ((mm == 1 || mm == 3 || mm == 5 || mm == 7 || mm == 8 || mm == 10 || mm == 12)) {
                if (dd < 31) {//不到月底，加天数
                    dd++;
                } else {//到月底
                    dd = 1;//将日初始化；
                    mm++;//新月
                    if (mm > 12) {//到月底且是年底
                        mm = 1;//月初始化
                        yy++;//年加一
                    }
                }
            }
            //如果小月
            if (mm == 4 || mm == 6 || mm == 9 || mm == 11) {
                //如果日期不到月底
                if (dd < 30) {
                    dd++;//天加一
                } else {//到月底
                    mm++;//月加一
                    dd = 1;//天初始化
                }
            }
            //如果是闰年2月
            if (mm == 2 && ((yy % 4 == 0) && (yy % 100) != 0)) {
                if (dd < 29) {//不到月底
                    dd++;
                } else {//月底
                    dd = 1;//天初始化
                    mm++;//月份加一
                }
            }//平年2月
            if (mm == 2 && (((yy % 1000) % 4 != 0))) {
                if (dd < 28) {//不到月底
                    dd++;//添加一
                } else {
                    dd = 1;//天初始化
                    mm++;//月份加一
                }
            }
            String ymd;
            if (mm < 10 && dd < 10) {
                ymd = yy + "" + "0" + mm + "" + "0" + dd;
            } else if (mm < 10 && dd >= 10) {
                ymd = yy + "" + "0" + mm + "" + dd + "";
            } else if (mm >= 10 && dd < 10) {
                ymd = yy + "" + mm + "" + "0" + dd + "";
            } else {
                ymd = yy + "" + mm + "" + dd + "";
            }
            if (A.check(ymd)) {

                break;


            }
        }
//        long time2 = System.currentTimeMillis();
//        System.out.println(time2-time1);
    }

    //检查是否是回文数字
    public static boolean check(String data) {
        boolean judge = false;
        StringBuffer sb = new StringBuffer(data);
        //如果是回文相等
        if ((sb.toString()).equals((sb.reverse()).toString())) {
            judge = true;
            System.out.println(sb);

        }
        return judge;
    }


}

class B {
    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        for (int i = 1; i <= 365000; i++) {
            if (i == 365000) {
                System.out.println("stop");
            }
        }
        long time2 = System.currentTimeMillis();
        System.out.println(time2 - time1);
    }
}

class C {
    public static void main(String[] args) {
        int num;
        int N;
        int s = 0;
        int g = 0;
        int b = 0;
        int q =0;
        for (int i = 1000; i < 10000 ; i++) {

            if (i < 10000) {
                num = 3;
                q = (int) (((i / 1000)) * Math.pow(16, num));
                b = (int) (((i / 100)%10) * Math.pow(16, num-2));
                s = (int) (((i / 10)%10) * Math.pow(16, num - 2));
                g = (int) ((i % 10) * Math.pow(16, num - 3));

            }
            N = g + s+b+q;
            if (N % i == 0) {
                System.out.println(i);
            }
        }
    }
}
class E{
    public static void main(String[] args) {
        boolean b =true;
        int num=0;
        int[] ints = new int[306];
        for (int i = 2; i <=2022; i++) {
            for (int j = 2; j <i ; j++) {
                if(i%j==0){
                    b=false;
                }
            }
            if(b){
                num++;
                System.out.println(i);
            }
            b=true;
        }

    }
}
class F{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double t = scan.nextInt();
        double c = scan.nextInt();
        double s = scan.nextInt();
        double V = c/t;
        double S = (s-c);
        double T = S/V;
        if( (T-(int)T)!=0.0){
            T= T+1;
            System.out.println((int)T);
        }else{
            System.out.println((int)T);
        }

//        System.out.println(t);
//        System.out.println(c);
//        System.out.println(s);


    }
}
