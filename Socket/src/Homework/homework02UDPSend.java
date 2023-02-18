package Homework;

import java.io.IOException;
import java.net.*;
import java.util.Scanner;
//        (1)编写一个接收端A，和一个发送端B，使用UDP协议完成(2)接收端在8888端口等待接收数据(receive)
//        (3)发送端向接收端发送数据“四大名著是哪些"
//        (4)接收端接收到发送端发送的问题后，返回“四大名著是<<红楼梦>
//        ·.."，否则返回
//        what?
//        (5)接收端和发送端程序退出

public class homework02UDPSend {
    public static void main(String[] args) throws IOException {
        System.out.println("亲请您输入问题~~");
        Scanner scanner = new Scanner(System.in);
        String question = scanner.next();

        DatagramSocket socket = new DatagramSocket(9995);
        byte[] questionArr =question.getBytes();
        int lean = questionArr.length;
        DatagramPacket packet = new DatagramPacket(questionArr, lean,
                        InetAddress.getByName("192.168.1.111"), 8801);
        socket.send(packet);
        System.out.println("问题已经发送~~");


        byte[] DataBytes = new byte[1024];
        int length = DataBytes.length;
        DatagramPacket packet1 = new DatagramPacket(DataBytes, length);
        socket.receive(packet1);

        byte[] showData= packet1.getData();
        int dataLength = packet1.getLength();
        String s = new String(showData, 0,dataLength);
        System.out.println(s);

        socket.close();

    }
}
