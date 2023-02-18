package hyp.QQ.QQserve;
import hyp.QQ.function.Message;
import hyp.QQ.function.MessageType;
import hyp.QQ.function.User;


import java.io.IOException;
import java.io.ObjectInputStream;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class serveConnectClientThread extends Thread {
    private Socket socket;//维护一个与客户端连接的Socket
    private String userId;//用来区分与谁的连接

    public serveConnectClientThread(Socket socket, String userId) {
        this.socket = socket;
        this.userId = userId;
    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {



            try {
                System.out.println("====请输入要推送的消息===");
                ObjectOutputStream oos = null;
                //登录成功后，只要发现是离线用户登录，将集合中的信息发给这个人
                //要放在对象输入流的前面，不然只有客户端给服务端发消息的时候，
                // 离线消息才能发送到指定账户，
                String[] leaveUser = ManageLSCCT.leaveUser().split(" ");
                HashMap<String, Message> leaveMap = ManageLSCCT.getHm();
                for (String id:leaveUser) {
                    //发现登录者是离线者，
                    if (userId.equals(id)){
                        Socket socket = ManageSCCT.getHm().get(id).getSocket();
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(leaveMap.get(id));
                        break;
                    }
                }
                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();

                ServePush servePush = new ServePush(oos);
                servePush.start();

                //客户端发来查看在线用户列表请求
                if (message.getMessageType().equals(MessageType.RET_ONLINE_USER)) {
                    //请求通过
                    //向客户端发送onlineUser名单
                    System.out.println(message.getSender() + "查看在线用户");
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    String onlineUser = ManageSCCT.OnlineUser();
                    Message message2 = new Message();
                    message2.setMessageType(MessageType.RET_ONLINE_USER);
                    message2.setContent(onlineUser);
                    message2.setGetter("serve");
                    oos.writeObject(message2);
                } else if (message.getMessageType().equals(MessageType.INFORM_ALL)) {
                    System.out.println(message.getSender() + "群发");
                    HashMap<String, serveConnectClientThread> hm = ManageSCCT.getHm();
                    String[] OnlineUserArr = ManageSCCT.OnlineUser().split(" ");
                    System.out.println("当前在线人数："+OnlineUserArr.length);
                   // Message message1 = new Message();
                    for (String s : OnlineUserArr) {//循环给每个人发送
                        if (!s.equals(message.getSender())) {//不能给自己发
                            //取出每一个在线用户
                            Socket socket = hm.get(s).getSocket();
                            //将在线用户的连接通道打通
                            oos = new ObjectOutputStream(socket.getOutputStream());
                            oos.writeObject(message);
                            System.out.println("服务器收到并发送~");

                        }else{
                            System.out.println(" 发送者 "+s);
                        }
                    }
                }else if (message.getMessageType().equals(MessageType.PRIVATE_CHAT)) {
                    boolean b = true;
                    String userId = message.getGetter();//接收者
                    //将要接收者的Socket取出；
                    String[] onlineUser = ManageSCCT.OnlineUser().split(" ");
                    for (String user : onlineUser){
                        //只要在线
                        if (userId.equals(user)){
                            b = false;
                            break;
                        }
                    }
                    //如果接收者在线
                    if (!b){
                        Socket socket = ManageSCCT.getHm().get(userId).getSocket();
                        //发送给接收者
                        oos = new ObjectOutputStream(socket.getOutputStream());
                        oos.writeObject(message);
                        break;

                    } else {//是离线用户时
                        //将这个人的id和要发送的消息加到离线管理集合中
                        ManageLSCCT.addLCCST(userId,message);
                        System.out.println(message.getSender()+"给"
                                    +message.getGetter()+"的离线留言");
                    }

                } else if(message.getMessageType().equals(MessageType.EXIT_SYSTEM)){
                    String[] onlineUser = ManageSCCT.OnlineUser().split(" ");
                    for (String user : onlineUser){
                        //找出要退出呢个用户的id
                        if(message.getSender().equals(user)){
                            //将该用户的Socket关闭
                            ManageSCCT.getHm().get(user).getSocket().close();
                            //在集合中删除这个用户
                            ManageSCCT.getHm().remove(user);
                            System.out.println(user+"用户以下线"+"\n ");
                            break;
                        }
                    }
                    break;
                }else if(message.getMessageType().equals(MessageType.FILE_SEND)){
                    Socket socket = ManageSCCT.getHm().get(message.getGetter()).getSocket();
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    oos.writeObject(message);
                }
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
            }
        }
    }
}
