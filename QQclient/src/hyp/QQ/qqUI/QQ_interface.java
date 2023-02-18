package hyp.QQ.qqUI;

import hyp.QQ.Serve.clientServe;
import hyp.QQ.utility.Tool;
import hyp.QQ.Serve.ccstManage;

public class QQ_interface {
    //二级界面
    public static void tow(String user) {
        boolean loop = true;
        String key1 = "";
        while (loop) {
            System.out.println("=======欢迎" + user + "登录=======");
            System.out.println("\t\t1 显示在线用户列表 ");
            System.out.println("\t\t2 群发消息");
            System.out.println("\t\t3 私聊消息");
            System.out.println("\t\t4 发送文件");
            System.out.println("\t\t9 退出系统");
            System.out.println("请输入： ");
            String key = Tool.readString();
            switch (key) {
                case "1":
                    clientServe.getOnlineUser();
                    break;
                case "2":
                    clientServe.informAllUser();
                    break;
                case "3":
                    System.out.println("=======私聊窗口======");
                    System.out.println("\t\t回车发送");
                    clientServe.privateChat();
                    break;
                case "4":
                    System.out.println("输入要发送的文件（M://mmmm.xxx）");
                    String file = Tool.readString();
                    System.out.println("输入接收者的用户Id");
                    String getterId = Tool.readString();
                   // if (clientServe.existUser(getterId)) {
                        System.out.println("输入保存到对方电脑的路径（M://mmmm.xxx）");
                        String saveFilePath = Tool.readString();
                        clientServe.sendFile(file, saveFilePath, getterId);
//                    } else {
//                        System.out.println("该用户不在线或不存在该用户");
//                    }
                    break;
                case "9":
                    loop = false;
                    //关闭对应服务器
                    clientServe.exitSystem();
                    break;
                default:
                    break;
            }

        }
    }
    //三级界面
    //四级界面
    //…………
}
