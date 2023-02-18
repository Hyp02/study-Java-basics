package StringBuffer;

import javax.swing.*;
import java.util.Scanner;

public class practice {
    public static void main(String[] args) {
        Product.scanf();
        Product.show();

    }
}

/**
 * 输入商品价格，以三个数为间隔插入逗号分隔
 * 要判断价格是否存在小数，因为小数部分不用分隔
 */

class Product {
    private static String name;
    static Scanner scanner = new Scanner(System.in);
    static StringBuffer money;
    static int judge = 0;

    public static void scanf() {
        System.out.println("请输入商品名称");
        name = scanner.next();
        System.out.println("请输入商品价格");
        money = new StringBuffer(scanner.next());
        int a = 3;//插入逗号的位置（从索引为三的地方开始）
        /*
        先判断价格中是否有小数点，采取不同的插入方法
         */
        for (int i = 0; i < money.length(); i++) {
            if (money.charAt(i) == '.') {
                judge = 1;
            }
        }
        /*
        将“ ， ”插入价格中
        分两种情况 一种是有小数点的 一种是没有小数点的
         */
        if (judge == 1) {//有小数点的
            for (int i = money.lastIndexOf(".") - 3; i > 0; i -= 3) {
                money = money.insert(i, ",");
            }
        } else {//没有小数点的
            while (a < money.length()) {
                money = money.insert(a, ",");
                a = a + 3 + 1;//插入的位置
            }
        }
    }

    public static void show() {
        System.out.println("商品名称： " + name);
        System.out.println("商品价格： " + money);
    }
}