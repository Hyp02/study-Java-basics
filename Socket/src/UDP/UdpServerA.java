package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpServerA {
    public static void main(String[] args) throws IOException {
        //创建接收端口，端口号码为 9999
        System.out.println("         联系人B");
        DatagramSocket socket = new DatagramSocket(9999);
        //UDP传输的数据不能超过 64K，
        //创建接收的数据数组
        byte[] data = new byte[1024];
        int length = data.length;
        DatagramPacket packet = new DatagramPacket(data, length);
        System.out.println("A等待接收~~");
        //当有主机向端口为 9999 发送数据时，机会接收到数据
        //如果没有发送时，程序就会阻塞在这里，一直等待~~
        socket.receive(packet);

        //收到数据包时，将收到的数据包进行拆包
        //新建一个存放收到的数据包中的数据的字节数组
        //存放数组
        int dataLength = packet.getLength();
        byte[] saveData = packet.getData();
        String s = new String(saveData, 0,dataLength);
        System.out.println(s);
        //A发送
        byte[] sentData = "好的，明天见~~".getBytes();
        DatagramPacket packet1 = new DatagramPacket(sentData, sentData.length,
                InetAddress.getByName("192.168.1.104"), 9998);
        socket.send(packet1);
        System.out.println("A发送已退出~~~");


        //关闭资源
        socket.close();
    }
}
