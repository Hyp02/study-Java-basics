package Homework;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class homework02UDPRecive {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8801);
        byte[] Data = new byte[1024];
        int length = Data.length;
        //接受发送来的问题
        DatagramPacket packet = new DatagramPacket(Data, length);
        System.out.println("等待接收问题~~");
        socket.receive(packet);

        //将发来的问题进行拆包
        int lean = packet.getLength();
        byte[] receiveData= packet.getData();
        String s = new String(receiveData, 0,lean);
        System.out.println(s);
        if(s.equals("四大名著是？")){
            byte[] DataBytes ="四大名著是 《红楼梦》《西游记》《三国演绎》《水浒传》".getBytes();
            int length1 = DataBytes.length;
            DatagramPacket packet1 = new DatagramPacket(DataBytes, length1,
                    InetAddress.getByName("192.168.1.111"), 9995);
            socket.send(packet1);
        }else{
            byte [] dataBytes2 = "what??".getBytes();
            int length2 = dataBytes2.length;
            DatagramPacket packet2 = new DatagramPacket(dataBytes2,length2,
                        InetAddress.getByName("192.168.1.111"),9995);
            socket.send(packet2);
        }
        //将问题答案发送给发送端

        System.out.println("已发送~~");

        socket.close();



    }
}
