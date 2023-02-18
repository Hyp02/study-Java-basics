import java.util.Scanner;

public class Main {
    static int cnt = 0;
    public static void method() {


        try {
            int n;
            cnt++;
            System.out.println("请输入一个整数");
            Scanner scan = new Scanner(System.in);
            n = scan.nextInt();

            System.out.println("您输入的数是" + n);
        } catch (Exception e) {
            System.out.println("您输入的不是整数，重新输入");
           method();//递归
        }
        finally{//不管是否有异常都会执行，调用几次就会输出几次，
            //在程序的最后输出，用DegBug方式查看怎样运行
            System.out.println("finally被执行"+ (cnt));//递归形式输出
        }
        System.out.println("递归中cnt = "+cnt);
    }
    public static void main(String[] args) {
        // write your code here
        method();
    }
}
class T{

    public static void main(String[] args) {
        d(5);
    }
    public static void d(int i){
        if(i>0){
            d(i-1);
        }
        System.out.println(i);
    }

}

