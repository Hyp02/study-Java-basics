package hyp.QQ.Serve;

import hyp.QQ.function.Message;
import hyp.QQ.function.MessageType;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Set;

public class clientConnectServeThread extends Thread {
    private Socket socket;

    public clientConnectServeThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        //在后台一直和服务器连接
        while (true) {
            try {
                //一直读取服务器回送的消息
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message message = (Message) ois.readObject();
                if (message.getMessageType().equals(MessageType.SEVER_PUSH)){
                    System.out.println("=====服务器消息推送=====");
                    System.out.println("服务器对大家说："+message.getContent());
                }
                if (message.getMessageType().equals(MessageType.GET_ONLINE_USER)) {
                    String[] onlineUserList = message.getContent().split(" ");
                    System.out.println("======从" + message.getGetter() + "得到在线用户列表=======");
                    for (int i = 0; i < onlineUserList.length; i++) {
                        System.out.println("用户： " + onlineUserList[i]);
                    }
                } else if (message.getMessageType().equals(MessageType.INFORM_ALL)) {
                    System.out.println("=======群消息=======");
                    String content = message.getContent();
                    System.out.println("发送者：" + message.getSender() + "\n"
                            + "内容：" + content + "\n\n");

                }else if(message.getMessageType().equals(MessageType.PRIVATE_CHAT)){
                    //接收私聊消息 ，
                    System.out.println("======私聊=======");
                    String sender = message.getSender();
                    String getter = message.getGetter();
                    String content = message.getContent();
                    System.out.println("\n"+sender+"对"+getter+"说"+content);


                }else if (message.getMessageType().equals(MessageType.FILE_SEND)){
                    System.out.println("=====文件发送=====");
                    Socket socket = ccstManage.getHashMap().get(message.getGetter()).getSocket();
                    byte[] fileBytes = message.getFileBytes();
                    String savePath=message.getFileSavePath();
                    FileOutputStream fos = new FileOutputStream(savePath);
                    fos.write(fileBytes);
                    fos.close();
                    System.out.println("\n"+message.getSender()+"发来文件已将文件保存至");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }finally {

            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}
