import java.util.Date;

public class Function extends Home {//功能类，实现零钱通主要功能

    public void myshow() {//零钱通实现明细方法
        //展示零钱通明细
        System.out.println(show);
    }

    public void addmoney() {//入账功能实现方法
        //收益入账业务逻辑
        System.out.println("------收益入账------\n");
        date = new Date();//获取当前日期
        // System.out.println(sdf.format(date));
        System.out.print("输入入账金额：");

        double addmoney = scanner.nextDouble();
        if (addmoney >= 0) {
            money += addmoney;//输入增加的钱
            //将入账信息拼接
            show += "\n入账：" + "+" + addmoney + "\t"
                    + sdf.format(date) + "\t余额" + money;

        } else {
            System.out.println("收入不能为负,重新选择");
        }
    }

    public void spend() {//消费功能实现方法
        System.out.println("------消费------\n");
        System.out.println("分别输入消费原因和消费金额");
        Date date1 = new Date();//需要重新获取时间信息，所以再次创建日期对象
        String why = scanner.next();//消费原因
        double spend = scanner.nextDouble();//消费金额
        if (spend <= money) {
            //余额
            money -= spend;
            //将消费信息拼接
            show += "\n" + why + ":-" + spend +
                    "\t" + sdf.format(date1) + "\t余额" + money;

        } else {
            System.out.println("您的余额不足，请充值");
        }
    }

    public boolean quit() {//退出实现方法，将boolean类型的judge 改成false用来退出循环
        System.out.println("确认退出吗，确认请输入y，取消输入n");
        char c = scanner.next().charAt(0);
        if (c == 'y' || c == 'Y') {
            judge = false;
        } else if (c == 'n' || c == 'N') {
            judge = true;
        } else {
            System.out.println("输入有误");
        }
        return judge;
    }
}
