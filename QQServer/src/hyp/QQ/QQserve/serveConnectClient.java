package hyp.QQ.QQserve;

import hyp.QQ.function.Message;
import hyp.QQ.function.MessageType;
import hyp.QQ.function.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Set;

public class serveConnectClient {
    ServerSocket serverSocket = null;
    Socket socket = null;

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public static HashMap<String, User> getValidUser() {
        return VALID_USER;
    }

    public static void setValidUser(HashMap<String, User> validUser) {
        VALID_USER = validUser;
    }

    private static HashMap<String, User> VALID_USER = new HashMap<>();

    static {//静态代码块，类加载时运行里面的逻辑
        //模仿服务器中的合法用户
        VALID_USER.put("1", new User("1", "123"));
        VALID_USER.put("2", new User("2", "123"));
        VALID_USER.put("3", new User("3", "123"));
        VALID_USER.put("4", new User("4", "123"));
    }
    //是否重复登录
    public boolean againLogin(String userId) {
        boolean judge = true;
        for (int i = 0; i < ManageSCCT.getHm().size(); i++) {
            Set<String> keySet = ManageSCCT.getHm().keySet();
            for (String key : keySet) {
                if (key.equals(userId)) {
                    judge = false;
                    break;
                }
            }
        }
        return judge;
    }

    //用户是否合法的判断方法
    public boolean check_VALID_USER(String userId, String pwd) {
        User user = VALID_USER.get(userId);
        if (user == null) {//如果集合中没有这个用户，说明用户不合法
            return false;
        }
        if (!user.getPassword().equals(pwd)) {
            return false;
        }
        return true;
    }

    public void connectServe() {

        try {
            int userNum = 0;
            System.out.println("客户端等待连接~");
            serverSocket = new ServerSocket(9999);
            while (true) {
                socket = serverSocket.accept();
                System.out.println("客户端已经有人连接~~第" + (++userNum) + "位用户");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                User u = (User) ois.readObject();
                System.out.println("收到账户消息");

                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
                Message message = new Message();
                //判断客户端传入的密码和账户正确性
                System.out.println("开始比对");
                System.out.println("密码：" + u.getPassword() + " 账户：" + u.getUserId());
                //加入防止重复登录的检查，检查线程集合中是否出现过重复的userId
                if (againLogin(u.getUserId())) {

                    if (check_VALID_USER(u.getUserId(), u.getPassword())) {//检查是否是合法用户
                        //登录成功，发送成功的标志给客户端，让他能连接服务器
                        message.setMessageType(MessageType.MESSAGE_LOGIN_SUCCESS);
                        System.out.println("密码和账户输入正确，允许连接~");
                        oos.writeObject(message);
                        //连接成功，启动连接线程
                        serveConnectClientThread sCCT = new serveConnectClientThread(socket, u.getUserId());
                        sCCT.start();

                        // 将服务器连接客户端的线程添加进集合中进行管理
                        // （两个线程的运行不受影响，在开启线程的同时，下面的逻辑会继续运行）
                        ManageSCCT.addServeConnectClientThread(u.getUserId(), sCCT);

                    } else {//密码或者账户不正确
                        message.setMessageType(MessageType.MESSAGE_LOGIN_FAIL);
                        System.out.println("密码或账户错误，禁止连接~");
                        System.out.println("密码：" + u.getPassword() + " 账户：" + u.getUserId());
                        oos.writeObject(message);
                        socket.close();
                    }
                    System.out.println("对比完成  " + message.getMessageType() + "\n\n");
                }else {
                    message.setMessageType(MessageType.AGAIN_LOGIN);
                    System.out.println("尝试重复登录~");
                    oos.writeObject(message);
                }
            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}