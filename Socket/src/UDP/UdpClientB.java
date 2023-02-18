package UDP;

import java.io.IOException;
import java.net.*;

public class UdpClientB {
    public static void main(String[] args) throws IOException {
        //创建一个发送端的端口，端口号为 9998
        System.out.println("         联系人A");
        DatagramSocket socket = new DatagramSocket( 9998);
        //创建一个发送数据的字节数组，将要发送的数据存到这个字节数组中，
        byte [] sendData = "hello，明天吃火锅".getBytes();
        int length = sendData.length;
        //将数据封装到 pack中，并且将数据发送到ip为"192.168.1.104"
        //端口号为9999的端口中
        DatagramPacket packet = new DatagramPacket(sendData, length,
                InetAddress.getByName("192.168.1.104"), 9999);
        //将这个数据包发送
        socket.send(packet);
        System.out.println("B发送已退出~~");
        //B开始接收
        byte[]  Data = new byte[1024];
        DatagramPacket packet1 = new DatagramPacket(Data, Data.length);
        System.out.println("B等待接收~~");
        socket.receive(packet1);
        //将B接受得到的数据包进行拆包
        int saveLength= packet1.getLength();
        byte [] saveData = packet1.getData();
        String s = new String(saveData);
        System.out.println(s);
        System.out.println("B接收退出~~~");
        //关闭资源
        socket.close();
    }
}
