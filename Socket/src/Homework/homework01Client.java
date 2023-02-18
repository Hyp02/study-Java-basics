package Homework;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * (1)使用字符流的方式，编写一个客户端程序和服务器端程序，
 * (2)客户端发送"name",服务器端接收到后，返回"我是nova ", nova是你自己的名字.
 * (3)客户端发送"hobby",服务器端接收到后，返回"编写java程序"
 * (4)不是这两个问题，回复“你说啥呢"
 **/


public class homework01Client {
    public static void main(String[] args) throws IOException {

        System.out.println("客户端等待连接~");
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入问题~~");
        String question= scanner.next();
        Socket socket = new Socket(InetAddress.getLocalHost(), 6666);
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(outputStream));
        bw.write(question);
        bw.newLine();
        bw.flush();

        InputStream inputStream = socket.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String answer = br.readLine();
        System.out.println(answer);

        br.close();
        socket.close();


    }
}
