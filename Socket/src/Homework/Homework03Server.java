package Homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.*;

public class Homework03Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端等待接收~~");
        DatagramSocket socket = new DatagramSocket(9996);
        //接收数据
        byte[] data = new byte[1024];
        int length = data.length;
        DatagramPacket packet = new DatagramPacket(data, length);
        socket.receive(packet);
        System.out.println("收到问题~~~");
        //将文件拆包加入数组
        byte[] nameData = packet.getData();
        int length1 = packet.getLength();
        String name = new String(nameData, 0, length1);
        //要搜索的音乐文件
        String musicFilepath = "D:\\"+name+".txt";
        File file = new File(musicFilepath);
        String music="";
        //文件存在的话
        if(file.exists()){
             music = musicFilepath;
        }else{
             music = "D:\\mm.txt";
        }

        FileInputStream ips = new FileInputStream(music);
        //将文件读取到数组中
        byte[] bytes = new byte[1024];
        while ((ips.read(bytes))!=-1){
        }
        int length2 = bytes.length;
        //将文件打包   发送到
        DatagramPacket packet1 = new DatagramPacket(bytes,length2 ,
                InetAddress.getByName("192.168.1.111"), 8809);
        socket.send(packet1);
        System.out.println("已将文件发送~~");
        //关闭流
        ips.close();
        socket.close();



    }
}
