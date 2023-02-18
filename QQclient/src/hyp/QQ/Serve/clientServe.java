package hyp.QQ.Serve;


import hyp.QQ.function.Message;
import hyp.QQ.function.MessageType;
import hyp.QQ.function.User;
import hyp.QQ.utility.Tool;

import java.awt.*;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;

//用户端服务
public class clientServe {
    static Scanner scan = new Scanner(System.in);
    //因为我们可能在其他方使用User和socket
    //所以将他们设置成属性，方便后续使用
    private static User u = new User();
    private static Socket socket;

    //检查账户
    public boolean checkAccount(String userId, String pwd) {
        u.setUserId(userId);
        u.setPassword(pwd);
        boolean b = false;
        try {
            //将账户对象发送到服务端
            //服务器ip为本机
            socket = new Socket(InetAddress.getLocalHost(), 9999);
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            //接受服务端发送的信息
            ObjectInputStream ois =
                    new ObjectInputStream(socket.getInputStream());
            Message message = (Message) ois.readObject();
            System.out.println("接收到消息" + message.getMessageType());
            //进行对比
            if (message.getMessageType()
                    .equals(MessageType.MESSAGE_LOGIN_SUCCESS)) {//登录成功
                //开启连接服务器的线程

                clientConnectServeThread ccst = new clientConnectServeThread(socket);
                ccstManage.addConnectServe(u.getUserId(), ccst);
                ccst.start();

                b = true;

            } else if (message.getMessageType()
                    .equals(MessageType.AGAIN_LOGIN)) {//重复登录
                System.out.println("您已在线，不可重复登录~~");
                socket.close();
            } else if (message.getMessageType()
                    .equals(MessageType.MESSAGE_LOGIN_FAIL)) {//登录失败
                System.out.println("您的账户或密码有误，请重新登录~~");
                socket.close();

            } else {//如果登录失败.启动不了和服务器的连接
                //将Socket断开
                socket.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return b;
    }

    //获取在线列表
    public static void getOnlineUser() {
        Socket socket = ccstManage.getConnectServe(u.getUserId()).getSocket();
        Message message = new Message();
        message.setMessageType(MessageType.GET_ONLINE_USER);
        message.setSender(u.getUserId());
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //群发消息方法
    public static void informAllUser() {
        //获取当前要群发消息的用户ID
        Socket socket = ccstManage.getConnectServe(u.getUserId()).getSocket();
        Message message = new Message();
        message.setMessageType(MessageType.INFORM_ALL);//发送的是群消息类型
        message.setSender(u.getUserId());//群消息发送者
        System.out.println("输入你要群发的消息内容~");
        message.setContent(scan.next() + "        时间：" + new Date().toString());//发送的内容
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println("请选择： ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    //判断发送时输入的用户id这个用户是否存在
    public static boolean existUser(String friendId){
        boolean b = true;
        String[] onlineUser = ccstManage.onlineUser();
        for (String id : onlineUser) {
            if (!friendId.equals(id)) {
                b = false;
                break;
            }
        }
        return b;
    }

    //私聊消息方法
    public static void privateChat() {

        Socket socket = ccstManage.getConnectServe(u.getUserId()).getSocket();
        Message message = new Message();
        //发送的消息类型
        message.setMessageType(MessageType.PRIVATE_CHAT);
        System.out.println("输入你要私聊的用户ID：");
        String friendId = scan.next();

        //if (existUser(friendId)) {
       do {
           message.setGetter(friendId);//发送给谁
           //发送者
           message.setSender(u.getUserId());
           System.out.println("== 用户  " + friendId + "==");
           try {
               ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
               System.out.println("输入要发送的信息~~");
               message.setContent(scan.next());
               oos.writeObject(message);
               System.out.println("请选择： ");
           } catch (IOException e) {
               e.printStackTrace();
           }
           System.out.println("输入0退出");
       }while(scan.nextInt()!=0);
//        }else{
//            System.out.println("该用户不在线或不存在该用户");
//        }
    }

    //无异常退出方法
    public static void exitSystem() {
        try {
            //以当前用户的Socket将服务端和客户端退出
            socket = ccstManage.getHashMap().get(u.getUserId()).getSocket();
            Message message1 = new Message();
            //给服务器发送一个退出信号
            message1.setMessageType(MessageType.EXIT_SYSTEM);
            message1.setSender(u.getUserId());
            ObjectOutputStream oos = new ObjectOutputStream(clientServe.socket.getOutputStream());
            oos.writeObject(message1);
            System.out.println("退出网络通信系统~~");
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //发送文件方法
    public static void sendFile(String sendFilePath, String saveFilepath, String getterId) {
        Message message = new Message();
        message.setFileSendPath(sendFilePath);
        message.setFileSavePath(saveFilepath);
        message.setSender(u.getUserId());
        message.setGetter(getterId);
        message.setMessageType(MessageType.FILE_SEND);
        FileInputStream fis = null;
        try {

            fis = new FileInputStream(sendFilePath);
            byte[] bytes = new byte[(int) new File(sendFilePath).length()];
            fis.read(bytes);
            message.setFileBytes(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("\n" + "将文件" + sendFilePath + "发送给" + getterId);
        try {
            Socket socket = ccstManage.getHashMap().get(u.getUserId()).getSocket();
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
