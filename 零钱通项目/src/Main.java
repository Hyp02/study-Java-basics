import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        String pwd = "";

        String show = "----------零钱通明细--------";
        //收益入账
        Date date = null;
        double money = 0;
        //格式化日期：
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        //消费
        boolean judge = true;
        do {
            System.out.println("------------零钱通菜单----------");
            System.out.println("\t\t\t1、零钱通明细");
            System.out.println("\t\t\t2、收益入账");
            System.out.println("\t\t\t3、消费");
            System.out.println("\t\t\t4、退    出");
            System.out.print("请选择：");
            pwd = scanner.next();
            switch (pwd) {
                case "1":
                    //展示零钱通明细
                    System.out.println(show);
                    break;
                case "2":
                    //收益入账业务逻辑

                    System.out.println("------收益入账------\n");
                    date = new Date();//获取当前日期
                    // System.out.println(sdf.format(date));
                    System.out.print("输入入账金额：");
                    double addmoney = scanner.nextDouble();
                    if (addmoney >= 0) {
                        money += addmoney;//输入增加的钱
                        show += "\n入账：" + "+" + money + "\t\t"
                                + sdf.format(date) + "\t余额" + money;
                    } else {
                        System.out.println("收入不能为负,重新选择");
                        break;
                    }

                    //System.out.println(show + "\n\n");
                    break;
                case "3":
                    System.out.println("------消费------\n");
                    System.out.println("分别输入消费原因和消费金额");
                    Date date1 = new Date();//需要重新获取时间信息，所以再次创建日期对象
                    String why = scanner.next();//消费原因
                    double spend = scanner.nextDouble();//消费金额
                    if (spend <= money) {
                        //余额
                        money -= spend;
                        show += "\n" + why + ":-" + spend +
                                "\t\t" + sdf.format(date1) + "\t\t余额" + money;
                    } else {
                        System.out.println("您的余额不足，请充值");
                        break;
                    }
                    break;
                case "4":
                    System.out.println("确认要退出零钱通吗？输入y确认退出，其他取消选择");
                    char quit = scanner.next().charAt(0);
                    if(quit == 'y'){
                        judge = false;
                        break;
                    }else{
                        break;
                    }
                default:
                    System.out.println("您输入的数组有误");
                    break;
            }
        } while (judge);
        System.out.println("已退出零钱通");
    }
}
