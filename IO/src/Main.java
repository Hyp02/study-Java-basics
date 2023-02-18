import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner scan = new Scanner(System.in);
                //在此输入您的代码...
                String s = scan.next();
            char[] chars = s.toCharArray();
            int[] a = new int[26];
            for (int i = 0; i < chars.length; i++) {
                a[chars[i]-97]++;
            }
            int max =a[0];
            int num=0;
            for (int i = 1; i < a.length; i++) {
                if(a[i]>max){
                    max=a[i];
                    num =i;
                }
            }
            System.out.println((char) (num+97));
            System.out.println(max);
        }
    }
class yhsanjiao{
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
            for (int k = yanghsj.length; k > i ; k--) {
                System.out.print(" ");
            }
            for (int j = 0; j < yanghsj[i].length; j++) {
                System.out.print(yanghsj[i][j] + " ");
            }
            System.out.print("\n");
        }
    }
}
