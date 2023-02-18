package hyp.QQ.QQserve;

import hyp.QQ.function.Message;
import hyp.QQ.function.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ServePush extends Thread{

    private ObjectOutputStream oos = null;
    public  ServePush(ObjectOutputStream oos){
        this.oos = oos;
    }
    public void push() {
        Scanner scanner = new Scanner(System.in);
        String informationPush = scanner.next();
        if (informationPush!=null) {
            String[] onlineUser = ManageSCCT.OnlineUser().split(" ");
            for (String id : onlineUser) {
                Socket socket = ManageSCCT.getHm().get(id).getSocket();
                try {
                    oos = new ObjectOutputStream(socket.getOutputStream());
                    Message message1 = new Message();
                    message1.setContent(informationPush);
                    message1.setMessageType(MessageType.SEVER_PUSH);
                    oos.writeObject(message1);

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("推送消息已经发出~~~");
        }
    }

    @Override
    public  void run() {
        push();
    }
}
