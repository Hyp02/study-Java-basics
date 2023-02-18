package Homework;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class Homework03Client {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(8809);
        System.out.println("亲输入一个音乐名");
        Scanner scan = new Scanner(System.in);
        String MusicName = scan.next();
        //将问题打包发送
        byte[] data = MusicName.getBytes();
        int dataLength = data.length;
        DatagramPacket packet = new DatagramPacket(data, dataLength,
                InetAddress.getByName("192.168.1.111"),9996);
        socket.send(packet);
        System.out.println("音乐名已发送~~");
        //接受从客户端口发送的音乐数据  打包
        byte[] musicData = new byte[1024];
        int length = musicData.length;
        DatagramPacket packet1 = new DatagramPacket(musicData, length);
        socket.receive(packet1);
        //将数据拆包加入字节数组中
        byte[] downloadMusic= new byte[1024];
        downloadMusic= packet1.getData();
        int dataLength1 = packet1.getLength();
        //将数据保存到E盘
        String filepath = "E:\\music.txt";
        FileOutputStream fos = new FileOutputStream(filepath);
        fos.write(downloadMusic);

        fos.close();
        socket.close();





    }
}
