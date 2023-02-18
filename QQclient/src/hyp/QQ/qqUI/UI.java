package hyp.QQ.qqUI;

import hyp.QQ.Serve.clientServe;
import hyp.QQ.utility.Tool;

public class UI {
    boolean loop = true;//控制是否显示菜单
    String key ="";//接收用户选择功能
    //将clientServe设置成属性，方便调用其中的相关方法
    clientServe clientServe = new clientServe();
    public void window() {

        while (loop) {
            System.out.println("=======网络通信系统======");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 9 退出系统");
            System.out.print("请输入：  ");
            key = Tool.readString();
            switch (key) {
                case "1":
                    System.out.println("=======用户登录========");
                    System.out.print("用户名： ");
                    String userId = Tool.readString();
                    System.out.println();
                    System.out.print("密码： ");
                    String  pwd = Tool.readPwd();
                    //检查账户
                    if (clientServe.checkAccount(userId,pwd)) {
                        System.out.println("登录成功");
                        QQ_interface.tow(userId);
                        loop = false;
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
        System.out.println("已退出网络通信系统");
        System.exit(0);


    }
}
