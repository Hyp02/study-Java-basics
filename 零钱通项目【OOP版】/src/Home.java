import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Home {
    boolean judge = true;
    Scanner scanner = new Scanner(System.in);
    double money;
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    String show = "----------零钱通明细--------";

    public void gethome() {//获取零钱通菜单方法，打印零钱通主界面
        System.out.println("------------零钱通菜单----------");
        System.out.println("\t\t\t1、零钱通明细");
        System.out.println("\t\t\t2、收益入账");
        System.out.println("\t\t\t3、消费");
        System.out.println("\t\t\t4、退    出");
        System.out.print("请选择：");
    }

}
