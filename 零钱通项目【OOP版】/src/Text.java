import java.util.Scanner;

public class Text extends Function {//测试类，
    Scanner scanner = new Scanner(System.in);

    Home home = new Home();//创建home对象
    ///Function fun = new Function();
    String num = "";

    public void choose() {//使用方法将Switch封装

        do {
            home.gethome();//调用打印零钱通的主页面的方法
            num = scanner.next();
            switch (num) {
                case "1":
                    //因为继承了Function类所以可以用super直接调用父类方法
                    super.myshow();
                    break;
                case "2":
                    //因为继承了Function类所以可以用super直接调用父类方法
                    super.addmoney();
                    break;
                case "3":
                    //因为继承了Function类所以可以用super直接调用父类方法
                    super.spend();
                    break;
                case "4":
                    //因为继承了Function类所以可以用super直接调用父类方法
                    super.quit();
                    break;
                default:
                    System.out.println("输入的序号有误");
                    break;
            }

        } while (judge);
        System.out.println("已退出零钱通");
    }
}

