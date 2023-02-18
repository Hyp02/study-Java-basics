//练习代码
import java.util.*;//
import java.util.Scanner;
public class Main{

    public static void main(String[] args) {
        // write your code here
        System.out.println("书名作者价格销量\t\n三国罗贯中111000\t");
    }
}
class hello{
    public static void main(String[] args) {
        System.out.println("nihao 韩永鹏");
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                sum += i;
                System.out.println(" i= " + i);
            }
        }
        System.out.println("sum=" + sum);
    }
}
class endis1 {
    public static void main(String[] args) {
        int i;
        int j;
        int Sum = 0;
        for (i = 10; i <= 30; i++) {
            for (j = 10; j <= 30; j++) {
                for (j = 10; j <= 30; j++) {
                    if ((i * j) % 10 == 1) {
                        Sum = i * j;
                        System.out.println(i + "*" + j + "=" + Sum);
                    }
                }

            }
        }
    }
}
class Switchcase{
    public static void main(String[] args){
        int number = 2;
        switch (number)
        {
            case 1: System.out.println("你好 韩永鹏");
            case 2: System.out.println("number=" + number);
        }
        int a=0;
        int sum;
        sum = (a > 10? a += 10:a++);
        System.out.println("a" + a);
    }

}
class sushu{
    public static void main(String[] args){
        int i,j;
        int a=1;
        System.out.println("primes have");
        for(i = 2;i <= 100; i++){
            for(j = 2; j < i; j++){
                if(i % j==0) {
                    a = 0;
                }
            }
            if(a == 1){
                System.out.println( i);
            }
            a=1;
        }
    }
}

class in{
    public static void main(String[] args){
        Scanner myScanner = new Scanner(System.in);
        System.out.println("输入年龄");
        int ags = myScanner.nextInt();
        System.out.println("输入名字");
        String name = myScanner.next();
        System.out.println("年龄是" + ags+"名字是" + name);


    }
}
class parse{
    public static void main(String[] args){
        int i = 10;
        String str = i + "";
        System.out.println(str);
        String str2 = "198.65";
        double d = Double.parseDouble(str2);
        System.out.println(d);
    }
}
class year{
    public static void main(String[] args){
        Scanner myscanner = new Scanner(System.in);
        int year;
        int n,i;
        int end;
        n = myscanner.nextInt();
        end = myscanner.nextInt();
        for( i = n; i <= end; i++){
            if(i % 4 ==0 && i % 100 !=0 ){
                System.out.println(i+"是闰年");
            }else{
                System.out.println(i+"不是闰年");
            }
        }
    }
}
class lianxi{
    public static void main(String[] args){
        Scanner  scanf = new Scanner(System.in);
        double sum;
        sum = scanf.nextDouble();
        System.out.println(sum);
    }
}
class if01{
    public static void main(String[] args){
        Scanner scanf = new Scanner(System.in);
        int x;
        x = scanf.nextInt();
        if (x < 60){
            System.out.println("不及格");
        } else if (x <= 80 ){
            System.out.println("一般");
        } else if (x <= 99){
            System.out.println("信用优秀");
        } else if(x == 100) {
            System.out.println("信用极好");
        }else {
            System.out.println("超出范围" +
                    "从新输入");
        }
    }
}
class lianxi02{
    public  static void main(String[] args){
        float gen;
        char xingbie;
        Scanner scanf = new Scanner(System.in);
        System.out.println("输入");
        xingbie = scanf.next().charAt(0);
        gen = scanf.nextFloat();

        if (gen >= 8.0 ){
            System.out.println("进入"
                    +xingbie+"子组决赛");
        } else {
            System.out.println("淘汰");
        }

    }
}
class home{
    public static void main(String[] args){
        char ch;
        int cnt=0;
        int cnt1=0;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            ch = scanner.next().charAt(0);
            if (ch == '*') {
                break;
            }
            if ((int) (ch) >= 65 && (int) (ch) <= 122) {
                cnt++;
            }
            if ((int)(ch) >= 48 && (int)(ch) <= 57){
                cnt1++;
            }
        }
        System.out.println("字母有" + cnt + "数字有" + cnt1);
    }
}
class pingjun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num;
        System.out.println("请输入要计算的数的个数");
        num = scanner.nextInt();
        int sum, allsum = 0;
        int i, n = 0;
        System.out.println("循环输入要输入的数字");
        for (i = 0; i < num; i++) {
            sum = scanner.nextInt();
            if (sum % 2 != 0) {
                allsum += sum;
                n++;
            }
        }
        System.out.println("其中偶数的平均数是" + (float) allsum / n);
    }

}
//键盘输入字符串
//引入 import Java.util.*;
class string {
    public static void main(String[] args){
        String st;
        int i;
        Scanner intscanner = new Scanner (System.in);
        i = intscanner.nextInt();
        Scanner scanner =new  Scanner(System.in);
        int a = 1;
        while(a <= i ){
            st = scanner.nextLine();
            System.out.println(a + st);
            a++;
            if(i == 10){
                break;
            }

        }

    }
}
class forlianxi {//打印 end 之内所有 beishu 的倍数的数
    public  static void main(String[] args){
        int i;
        int sum = 0;
        int cnt = 0;
        int start = 1, end = 100;
        int beishu = 9;//倍数
        for(i = start; i <= end; i++){
            if(i % beishu == 0){
                System.out.println(i);
                sum += i;
                cnt++;
            }
        }
        System.out.println("个数有" +cnt + "总和为" +sum);
    }
}
class sumis5 {//打印start和end 之间结果是 结果的数

    public static void main(String[] args) {
        int i, j;
        // int sum = 0;
        int start = 0, end = 5;//开始值和结束值
        int jieguo = 5;//最终需要等于的数
        for (i = start; i <= end;i++){
            for (j = start; j <= end; j++) {
                if (i + j == jieguo) {
                    //  sum = i+j;
                    System.out.println(i + "+" + j + "=" + (int) (i + j));
                    //sum=0;
                }
            }
        }
    }
}
class Dowhile{
    public static void main(String[] args){
        int start = 0;
        int end = 100;
        int sum = 0;
        do{
            start++;
            System.out.println(start);
            sum += start;

        }while(start < end);
        System.out.println(sum);
    }

}
class sanjiao {
    public static void main(String[] args) {
        int i;
        int n = 5;//行数
        int j;
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println("\n");
        }
    }
}
class sanjiao2 {
    public static void main(String[] args) {
        int i;
        int n = 5;//行数
        int j,l;
        for (i = 1; i <= n; i++) {
            for(l=n-i;l>=1;l--){//或者是 for(l=1;l<=i-1;l++)打印的空格个数是：总层数-当前层数=空格个数！
                System.out.print(" ");
            }
            for (j = 1; j <= 2*i-1; j++) {
                if(j == 1||j==2*i-1||i==n){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }

            }
            System.out.print("\n");
        }
    }
}
class sanjiao3 {
    public static void main(String[] args) {
        int i;
        int n = 5;//行数
        int j, l;
        for (i = 1; i <= n; i++) {
            for (l = n - i; l >= 1; l--) {//或者是 for(l=1;l<=i-1;l++)打印的空格个数是：总层数-当前层数=空格个数！
                System.out.print(" ");
            }
            for (j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            System.out.print("\n");
        }
    }
}
//两个字符串比较是否相同
class equals1{
    public static void main(String[] args){
        String conststr = "韩永鹏";
        String str;
        Scanner myscanner = new Scanner(System.in);
        str = myscanner.next();
        System.out.println(conststr.equals(str));
    }
}
class sxhnum {// 水仙花数

    public static void main(String[] args) {
        int i, j, k;
        for (i = 1; i <= 9; i++) {
            for (j = 1; j <= 9; j++) {
                for (k = 1; k <= 9; k++) {
                    if (i * i * i +
                            j * j * j + k * k * k == i * 100 + j * 10 + k) {
                        System.out.print(i);
                        System.out.print(j);
                        System.out.println(k);
                    }
                }
            }
        }
    }
}
//判断水仙花数
class sxhnum2{
    public  static void main(String[] args){
        int num;
        Scanner myscanner = new Scanner(System.in);
        num = myscanner.nextInt();//输入要判断的数字
        int sum1 = num %10;//个位
        int sum2 =(num/10)%10;//十位
        int sum3 = (num/100);//百位
        if(sum3 * sum3 * sum3 + sum2 *
                sum2 * sum2 + sum1*sum1*sum1 == num){
            System.out.println("是水仙花数");
        }else{
            System.out.println("不是水仙花数");
        }
    }
}
class Chpaixv{
    public static void main(String[] args){
        int t;
        int i, j;
        int [] arr =  {12,454,11,45784,4};
        int manid = 0;//假设最小的数的索引是0
        for(i = 0;i < arr.length;i++ ){
            for(j = i+1;j <arr.length;j++){
                if(arr[j] < arr[manid]){//碰到比假设的最小的还小的话就把最小的的那个索引赋给manid
                    manid = j;
                }
            }
            //最小的找出来以后交换
            t = arr[i];
            arr[i] = arr[manid];
            arr[manid] = t;
        }
        //输出
        for(int k = 0;k < arr.length;k++){
            System.out.print(arr[k] + " ");
        }
    }
}
// 1:无需package
// 2: 类名必须Main, 不可修改

class H {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int []arr = new int [26];
        String str = scan.nextLine();
        for(int i =0;i< str.length();i++){

            arr[(str.charAt(i)-97)]++;
            //System.out.println(str.charAt(i));
        }
        int Max = arr[0];
        int Maxnum = 0;
        for(int i=0;i< arr.length-1;i++){
            if(arr[i+1]>Max){
                Max = arr[i+1];
                Maxnum = i+1;
            }

        }
        char ch = (char)(Maxnum+97);
        System.out.println(ch+"\n"+Max);
        //在此输入您的代码...
        scan.close();
    }
}
class BB{
    public static void main(String[] args) {
        int[] arr = {1} ;
        int Max = arr[0];
        int Maxnum  =0;
        for(int i=0;i<arr.length-1;i++){
            if(arr[i+1]>Max){
                Max = arr[i+1];
                Maxnum = i+1;
            }

        }
        System.out.println(Max+" "+Maxnum);
    }
}
