import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int a[];
        a = new int[5];

    }
}

//数组 线性搜索
class arrayMax {
    public static void main(String[] args) {
        int array[] = {4, 5, 2, 78, 6};
        int maxid = 0;
        int maxsum = array[maxid];
        for (int i = 1; i < array.length; i++) {
            if (maxsum < array[i]) {
                maxsum = array[i];
                maxid = i;//每次循环将大于上一个值得索引赋值给maxid
                //最终得到的maxid就是最大的那个数所在的数组索引
            }
        }
        System.out.println("最大值是" + array[maxid]);//输出那个maxid所在的数
    }
}

//数组反转
class unarray {
    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        // int []array2 = new int[array1.length];
        for (int i = array1.length - 1; i >= 0; i--) {//将数组的索引倒序输出
            System.out.print(array1[i] + " ");
        }
    }
}

//数组值交换
class unarray2 {
    public static void main(String[] args) {
        int t = 0;
        int[] array = {1, 2, 3, 4, 5, 6};
        for (int i = 0; i < array.length / 2; i++) {//i循环到则组数的中间就好
            t = array[(array.length) - 1 - i];//将两个数交换
            array[(array.length) - 1 - i] = array[i];
            array[i] = t;
        }
        for (int j = 0; j < array.length; j++) {
            System.out.print(+array[j] + " ");
        }
    }
}

//数组动态扩容
class addarray {
    public static void main(String[] arg) {
        int[] arr1 = {1, 2, 3};
        char ch;
        //int cnt = arr1.length-1;//控制给对应数组赋值
        Scanner myscanner = new Scanner(System.in);
        do {
            int[] arr2 = new int[arr1.length + 1];//开辟新空间，每次循环比arr1多1个空间
            for (int j = 0; j < arr2.length - 1; j++) {
                arr2[j] = arr1[j];//将之前就有的数拷贝到arr2
                System.out.print(arr2[j] + " ");//输出原有数据
            }
            //扩容
            System.out.println("\n输入需要扩容的数字");
            arr2[arr1.length] = myscanner.nextInt();
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + " ");
            }
            System.out.println("是否继续扩容");
            ch = myscanner.next().charAt(0);
            arr1 = arr2;//第62行需要new新的数组空间，将之前的旧空间替换成每一次循环生成的新空间。
            //  cnt++;
        } while (ch == 'y');
        System.out.println("已经退出程序");
    }
}

class preparr {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        int[] arr1 = {1, 2, 3, 4, 5};

        char ch;
        do {
            int[] arr2 = new int[arr1.length - 1];
            for (int i = 0; i < arr1.length - 1; i++) {
                arr2[i] = arr1[i];
            }
            System.out.println("=======缩减后的值========");
            for (int i = 0; i < arr2.length; i++) {
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
            //  System.out.println("arr2.length=="+arr2.length);

            System.out.print("输入y继续缩减");
            if (arr2.length == 0) {
                System.out.println("不能再缩减了");
                break;
            }
            ch = myscanner.next().charAt(0);
            arr1 = arr2;
        } while (ch == 'y');
    }
}

/*用数组输出
 * 1
 * 2 2
 * 3 3 3
 * 、、、、
 * 这样了类型的数据*/
class arraytow {
    public static void main(String[] args) {
        int arr[][];//先声明arr是一个二维数组
        arr = new int[3][];//固定行数
        for (int i = 0; i < arr.length; i++) {//二维数组行数的循环
            //循环创建二维数组中每一个一维数组的空间
            arr[i] = new int[i + 1];
            //给每一个一维数组中赋值
            for (int j = 0; j < arr[i].length; j++) {//一维数组每个下标的循环
                arr[i][j] = i + 1;
            }
        }
        //打印
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

//杨辉三角
class yhsanjiao {
    public static void main(String[] args) {
        int[][] yanghsj;
        int num;
        Scanner myscanner = new Scanner(System.in);
        System.out.println("请输入想要打印杨辉三角的层数：n");
        num = myscanner.nextInt();
        yanghsj = new int[num][];
        for (int i = 0; i < yanghsj.length; i++) {
            yanghsj[i] = new int[i + 1];
            for (int j = 0; j < yanghsj[i].length; j++) {

                if (j == 0 || j == yanghsj[i].length - 1) {
                    yanghsj[i][j] = 1;
                } else {
                    yanghsj[i][j] = yanghsj[i - 1][j] + yanghsj[i - 1][j - 1];
                }
            }
        }
        //输出：
        for (int i = 0; i < yanghsj.length; i++) {
            for (int k = yanghsj.length; k > i + 1; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < yanghsj[i].length; j++) {
                System.out.print(yanghsj[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}

//插入数字并且升序
class addsarr {
    public static void main(String[] args) {
        char ch;
        Scanner mygetchar = new Scanner(System.in);
        Scanner myscanner = new Scanner(System.in);
        //先插入
        int[] arr1 = {53, 7646, 324, 24};
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println("是否需要扩容");
        ch = mygetchar.next().charAt(0);
        if (ch == 'y') {
            do {
                int[] arr2 = new int[arr1.length + 1];

                for (int i = 0; i < arr2.length - 1; i++) {
                    arr2[i] = arr1[i];
                    System.out.print(arr2[i] + " ");
                }
                //输入要扩容的值
                System.out.println("输入扩容的值");
                arr2[arr1.length] = myscanner.nextInt();
                //循环输出扩容后的值
                //并且运用冒泡排序进行升序排列
                int t;
                for (int j = 0; j < arr2.length; j++) {
                    for (int i = 0; i < arr2.length - 1 - j; i++) {
                        if (arr2[i] > arr2[i + 1]) {
                            t = arr2[i];
                            arr2[i] = arr2[i + 1];
                            arr2[i + 1] = t;
                        }
                    }
                }
                for (int i = 0; i < arr2.length; i++) {
                    System.out.print(arr2[i] + " ");
                }

                System.out.println("是否继续扩容");

                ch = mygetchar.next().charAt(0);
                arr1 = arr2;

            } while (ch == 'y');

        }
        System.out.println("已经退出程序");


    }
}

//冒泡排序
class mpPaiXv {
    public static void main(String[] args) {
        int[] arr2 = {43, 5634, 42, 66, 24};
//        int t;
//        for (int j = 0; j < arr2.length;j++ ){
//            for(int i = arr2.length-1-j;i > 0 ;i--){
//                if(arr2[i] > arr2[i-1]){
//                    t = arr2[i];
//                    arr2[i] = arr2[i-1];
//                    arr2[i-1] = t ;
//                }
//            }
//        }
//        for (int i = 0;i < arr2.length;i++){
//            System.out.print(arr2[i]+" ");
//        }
        int t;
        for (int j = 0; j < arr2.length; j++) {
            for (int i = 0; i < arr2.length - 1 - j; i++) {

                if (arr2[i] > arr2[i + 1]) {
                    t = arr2[i];
                    arr2[i] = arr2[i + 1];
                    arr2[i + 1] = t;
                }
            }
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }

    }
}

//二分查找
class twofind {
    public static void main(String[] args) {
        Scanner myscanner = new Scanner(System.in);
        int[] arr = {1, 2, 3, 4, 5, 445, 4353, 345435, 34543};
        int beg = 0, end = arr.length;
        System.out.println("请输入需要查找的数字，你将得到这个数字所在的位置");
        int sum = myscanner.nextInt();

        int mod = (beg + end) / 2;
        if (twofind.judge(arr, sum)) {
            while (sum != arr[mod]) {
                if (sum > arr[mod]) {
                    beg = mod;//缩小查找范围（往后缩小）
                }
                if (sum < arr[mod]) {
                    end = mod;//缩小查找范围（往前缩小）
                }
                mod = (beg + end) / 2;
            }
            int cnt = mod + 1;
            System.out.println("你要查找的数字是" + sum
                    + "它在第" + cnt + "个");
        }
    }

    public static boolean judge(int[] arr, int sum) {
        //判断是否存在
        for (int i = 0; i < arr.length; i++) {
            if (sum == arr[i]) {
                return true;
            }
        }
        System.out.println("你要查找的数不存在");
        return false;
    }
    @Test
    public void test(){
        String str1 = "hello";
        String str2 = "he" + new String("llo");
        System.err.println(str1 == str2);
    }
}
//class Solution {
//    public String replaceSpace(String s) {
//        for(int i =0;i<s.length();i++){
//            if(s.charAt(i) == ' '){
//                s.charAt(i)='2';
//            }
//        }
//        return s;
//    }

//}
