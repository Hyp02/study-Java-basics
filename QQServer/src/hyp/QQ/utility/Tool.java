package hyp.QQ.utility;
import java.util.Scanner;

public class Tool {
    public static void main(String[] args) {

    }
    static Scanner scanner = new Scanner(System.in);
    public static String  readString(){
       String next = scanner.next();
       return next;
    }
   public static int readInt(){

        return scanner.nextInt();
   }
   public static String readPwd(){
        String pwd = scanner.next();
       return pwd;
    }
}
